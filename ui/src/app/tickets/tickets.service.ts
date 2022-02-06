import { Injectable} from '@angular/core';
import { Ticket, TicketDTO } from '../models/ticket';
import { catchError, tap } from 'rxjs/operators';
import {MessageService} from "../messages/message.service";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import { Observable, of} from "rxjs";


@Injectable({
  providedIn: 'root',
})
export class TicketsService {
  private ticketsUrl = 'http://localhost:8080/ticket';
  tickets: Ticket[] = []
  ticket: Ticket = {} as Ticket;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient,
    private messagesService: MessageService
  ) { }


  /** GET users from the server */
  getTickets(): Observable<Ticket[]> {
    return this.http.get<Ticket[]>(`${this.ticketsUrl}/list`)
      .pipe(
        tap(_ => this.log('fetched users')),
        catchError(this.handleError<Ticket[]>('getTickets', []))
      );
  }

  /** GET ticket by id. Will 404 if id not found */
  getTicket(id: number): Observable<Ticket> {
    const url = `${this.ticketsUrl}/details/${id}`;
    return this.http.get<Ticket>(url).pipe(
      tap(_ => this.log(`fetched ticket id=${id}`)),
      catchError(this.handleError<Ticket>(`getTicket id=${id}`))
    );
  }

  /** PUT: update the ticket on the server */
  updateTicket(ticket: Ticket): Observable<any> {
    return this.http.put(this.ticketsUrl, ticket, this.httpOptions).pipe(
      tap(_ => this.log(`updated ticket id=${ticket.ticketId}`)),
      catchError(this.handleError<any>('updateTicket'))
    );
  }

  /** POST: add a new ticket to the server */
  addTicket(ticket: Ticket): Observable<Ticket> {
    return this.http.post<Ticket>(`${this.ticketsUrl}/add`, ticket, this.httpOptions).pipe(
      tap((newTicket: Ticket) => this.log(`Added ticket ${ticket.ticketId} + ${ticket.title}`)),
      catchError(this.handleError<Ticket>('addTicket'))
    );
  }

  /** DELETE: delete the ticket from the server */
  deleteTicket(ticket: Ticket): Observable<Ticket> {
    return this.http.get<Ticket>(`${this.ticketsUrl}/delete/${ticket.ticketId}`, this.httpOptions).pipe(
      tap(_ => this.log(`deleted ticket id=${ticket.ticketId}`)),
      catchError(this.handleError<Ticket>('deleteTicket'))
    );
  }

  /* GET users whose name contains search term */
  searchTickets(term: string): Observable<Ticket[]> {
    if (!term.trim()) {
      // if not search term, return empty ticket array.
      return of([]);
    }
    return this.http.get<Ticket[]>(`${this.ticketsUrl}?name=${term}`).pipe(
      tap(x => x.length ?
        this.log(`found users matching "${term}"`) :
        this.log(`no users matching "${term}"`)),
      catchError(this.handleError<Ticket[]>('searchTickets', []))
    );
  }

  private log(message: string) {
    this.messagesService.add(`TicketService: ${message}`);
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   *
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for ticket consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }


}

import { Injectable} from '@angular/core';
import { User, UserDTO } from '../models/user';
import { catchError, tap } from 'rxjs/operators';
import {MessageService} from "../messages/message.service";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import { Observable, of} from "rxjs";
import axios from "axios";


@Injectable({
  providedIn: 'root',
})
export class UsersService {
  private usersUrl = 'http://localhost:8080/user';
  users: User[] = []
  user: User = {} as User;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient,
    private messagesService: MessageService
  ) { }


  /** GET users from the server */
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.usersUrl}/list`)
      .pipe(
        tap(_ => this.log('fetched users')),
        catchError(this.handleError<User[]>('getUsers', []))
      );
  }

  getClientsAndEmployees(): Observable<UserDTO[]> {
    return this.http.get<UserDTO[]>(`${this.usersUrl}/autocomplete`)
      .pipe(
        tap(_ => this.log('fetched users')),
        catchError(this.handleError<UserDTO[]>('getUsers', []))
      );
  }

  /** GET user by id. Will 404 if id not found */
  getUser(id: number): Observable<any> {
    const url = `${this.usersUrl}/details/${id}`;
    return this.http.get<any>(url).pipe(
      tap(_ => this.log(`fetched user id=${id}`)),
      catchError(this.handleError<any>(`getUser id=${id}`))
    );
  }

  /** PUT: update the user on the server */
  updateUser(user: User): Observable<any> {
    return this.http.put(this.usersUrl, user, this.httpOptions).pipe(
      tap(_ => this.log(`updated user id=${user.userId}`)),
      catchError(this.handleError<any>('updateUser'))
    );
  }

  /** POST: add a new user to the server */
  addUser(user: User): Observable<User> {
    return this.http.post<User>(`${this.usersUrl}/add`, user, this.httpOptions).pipe(
      tap((newUser: User) => this.log(`Added user ${user.name} + ${user.surname}`)),
      catchError(this.handleError<User>('addUser'))
    );
  }

  /** DELETE: delete the user from the server */
  deleteUser(user: User): Observable<User> {
    return this.http.get<User>(`${this.usersUrl}/delete/${user.userId}`, this.httpOptions).pipe(
      tap(_ => this.log(`deleted user id=${user.userId}`)),
      catchError(this.handleError<User>('deleteUser'))
    );
  }

  /* GET users whose name contains search term */
  searchUsers(term: string): Observable<User[]> {
    if (!term.trim()) {
      // if not search term, return empty user array.
      return of([]);
    }
    return this.http.get<User[]>(`${this.usersUrl}?name=${term}`).pipe(
      tap(x => x.length ?
        this.log(`found users matching "${term}"`) :
        this.log(`no users matching "${term}"`)),
      catchError(this.handleError<User[]>('searchUsers', []))
    );
  }

  private log(message: string) {
    this.messagesService.add(`UserService: ${message}`);
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

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}

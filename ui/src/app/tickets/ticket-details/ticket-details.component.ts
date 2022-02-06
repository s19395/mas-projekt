import { AfterViewInit, Component, OnChanges, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Ticket } from '../../models/ticket';
import { User } from '../../models/user';
import { ActivatedRoute } from '@angular/router';
import { UsersService } from '../../users/users.service';
import { TicketsService } from '../tickets.service';
import { Location } from '@angular/common';
import { Note } from '../../models/note';
import { NotesService } from '../../notes/notes.service';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-user-details',
  templateUrl: './ticket-details.component.html',
  styleUrls: ['./ticket-details.component.scss']
})
export class TicketDetailsComponent implements AfterViewInit {
  @ViewChild(MatSort)
  sort: MatSort;

  ticket: Ticket | undefined;
  accesories: any[]  = [];
  assets: any[] = [];
  tickets: Ticket[] = [];
  note: Note = new Note();
  notes: Note[] = [];
  noteDataSource = new MatTableDataSource();
  displayedColumns: string[] = ['id', 'title', 'content', 'createdAt'];

  submitted = false;

  constructor(
    private route: ActivatedRoute,
    private userService: UsersService,
    private ticketsService: TicketsService,
    private notesService: NotesService,
    private location: Location
  ) {
  }

  ngAfterViewInit(): void {
    this.getTicket();
    this.noteDataSource.sort = this.sort;
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.noteDataSource.filter = filterValue.trim().toLowerCase();
  }


  getTicket(): void {
    const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    this.ticketsService.getTicket(id)
      .subscribe(data => {
        this.ticket = data;
        this.notes = data.notes;
        this.noteDataSource.data = data.notes;
      });

  }

  save(): void {
    if (this.ticket) {
      this.notesService.updateNote(this.note)
        .subscribe(() => this.goBack());
    }
  }

  goBack(): void {
    this.location.back();
  }

  delete(note: Note): void {
    this.notesService.deleteNote(note).subscribe();
    this.notes = this.notes.filter(h => h !== note);
    this.noteDataSource.data = this.notes;
  }

  onSubmit(): void {
    this.submitted = true;
    this.note.ticketId = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    this.notesService.addNote(this.note).subscribe();
  }
}

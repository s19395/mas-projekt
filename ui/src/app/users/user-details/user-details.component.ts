import {Component, Input, OnInit, ViewEncapsulation } from '@angular/core';
import {User} from "../../models/user";
import {ActivatedRoute} from "@angular/router";
import {UsersService} from "../users.service";
import { Location } from '@angular/common';
import { MatTableDataSource } from '@angular/material/table';
import { Ticket } from '../../models/ticket';
import { TicketsService } from '../../tickets/tickets.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.scss']
})
export class UserDetailsComponent implements OnInit {
  user: User | undefined;
  accesories: any[]  = [];
  assets: any[] = [];
  tickets: Ticket[] = [];
  ticketDataSource = new MatTableDataSource();
  displayedColumns: string[] = ['id', 'title', 'description', 'ticketStatus', 'createdAt'];

  constructor(
    private route: ActivatedRoute,
    private userService: UsersService,
    private ticketsService: TicketsService,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.getUser();
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.ticketDataSource.filter = filterValue.trim().toLowerCase();
  }


  getUser(): void {
    const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    this.userService.getUser(id)
      .subscribe(data => {
        this.user = data;
        this.accesories = data.assets;
        this.tickets = data.tickets;
        this.ticketDataSource.data = data.tickets;
      });
  }

  save(): void {
    if (this.user) {
      this.userService.updateUser(this.user)
        .subscribe(() => this.goBack());
    }
  }

  goBack(): void {
    this.location.back();
  }

  delete(ticket: Ticket): void {
    this.ticketsService.deleteTicket(ticket).subscribe();
    this.tickets = this.tickets.filter(h => h !== ticket);
    this.ticketDataSource.data = this.tickets;
  }
}

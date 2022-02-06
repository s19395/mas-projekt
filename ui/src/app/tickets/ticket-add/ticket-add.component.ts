import { Component, OnInit } from '@angular/core';
import { Ticket, TicketDTO } from '../../models/ticket';
import {ActivatedRoute, Router} from "@angular/router";
import {TicketsService} from "../tickets.service";
import { UserDTO } from '../../models/user';
import { map, Observable, startWith } from 'rxjs';
import { FormControl } from '@angular/forms';
import { UsersService } from '../../users/users.service';
import { MatOption } from '@angular/material/core';

@Component({
  selector: 'app-ticket-add',
  templateUrl: './ticket-add.component.html',
  styleUrls: ['./ticket-add.component.scss']
})
export class TicketAddComponent implements OnInit {
  employeeControl = new FormControl();
  customerControl = new FormControl();
  tickets: Ticket[] = []
  ticket: Ticket = new Ticket();

  users: UserDTO[] = [];

  employees: UserDTO[] = [];
  customers: UserDTO[] = [];

  filteredEmployeeOptions: Observable<UserDTO[]> | undefined;
  filteredCustomerOptions: Observable<UserDTO[]> | undefined;

  submitted = false;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private ticketService: TicketsService,
    private usersService: UsersService
  ) {
    this.getUsers();
  }

  ngOnInit(): void {

    this.filteredEmployeeOptions = this.employeeControl.valueChanges.pipe(
      startWith(''),
      map(value => (typeof value === 'string' ? value : value.name)),
      map(name => (name ? this._filter(name) : this.employees.slice())),
    );

    this.filteredCustomerOptions = this.customerControl.valueChanges.pipe(
      startWith(''),
      map(value => (typeof value === 'string' ? value : value.name)),
      map(name => (name ? this._filter(name) : this.customers.slice())),
    );
  }

  onSubmit(): void {
    this.submitted = true;
    this.ticketService.addTicket(this.ticket).subscribe();
  }

  gotoItemList() {
    this.router.navigate(['/tickets']);
  }

  displayFn(user: UserDTO): string {
    return user && user.name ? `${user.name} ${user.surname}` : '';
  }

  private _filter(name: string): UserDTO[] {
    const filterValue = name.toLowerCase();

    return this.users.filter(option =>
      option.name.toLowerCase().includes(filterValue) ||
      option.surname.toLowerCase().includes(filterValue)
    );
  }

  getUsers(): void {
    this.usersService.getClientsAndEmployees()
      .subscribe((users: any[]) => {
          this.users = users;
        }
      );
  }
}

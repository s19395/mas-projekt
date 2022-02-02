import { Component, OnInit } from '@angular/core';
import {User} from "../models/user";
import {UsersService} from "./users.service";
import {Observable, of} from "rxjs";
import {MessageService} from "../messages/message.service";
import axios from "axios";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {
  users: User[] = []
  displayedColumns: string[] = ['id', 'name', 'surname', 'email'];
  dataSource = new MatTableDataSource(this.users);

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  constructor(
    private usersService: UsersService
  ) { }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers(): void {
    this.usersService.getUsers()
      .subscribe((users: User[]) => {
          this.users = users;
          this.dataSource.data = users;
        }
      );
  }

  add(name: string): void {
    name = name.trim();
    if (!name) { return; }
    this.usersService.addUser({ name } as User)
      .subscribe(user => {
        this.users.push(user);
      });
  }

  delete(user: User): void {
    this.users = this.users.filter(h => h !== user);
    this.usersService.deleteUser(user.id).subscribe();
  }



}

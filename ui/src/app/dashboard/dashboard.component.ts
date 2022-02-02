import { Component, OnInit } from '@angular/core';
import {UsersService} from "../users/users.service";
import {User} from "../models/user";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  users: User[] = [];

  constructor(private userService: UsersService) { }

  ngOnInit(): void {
  }

  getHeroes(): void {
    this.userService.getUsers()
      .subscribe(users => this.users = users.slice(1, 5));
  }

}

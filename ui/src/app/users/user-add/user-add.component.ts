import { Component, OnInit } from '@angular/core';
import {User} from "../../models/user";
import {ActivatedRoute, Router} from "@angular/router";
import {UsersService} from "../users.service";

@Component({
  selector: 'app-user-add',
  templateUrl: './user-add.component.html',
  styleUrls: ['./user-add.component.scss']
})
export class UserAddComponent implements OnInit {
  users: User[] = []
  user: User = new User();
  submitted = false;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private userService: UsersService,
  ) {

  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.submitted = true;
    this.userService.addUser(this.user).subscribe();
    // this.gotoItemList();
  }

  gotoItemList() {
    this.router.navigate(['/users']);
  }
}

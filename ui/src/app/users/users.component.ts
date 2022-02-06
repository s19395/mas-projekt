import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {User} from "../models/user";
import {UsersService} from "./users.service";
import {MatTableDataSource} from "@angular/material/table";
import {MatSort} from "@angular/material/sort";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements AfterViewInit {
  @ViewChild(MatSort)
  sort: MatSort;

  users: any[] = []
  displayedColumns: string[] = ['id', 'name', 'surname', 'email', 'phoneNumber', 'actions'];
  dataSource = new MatTableDataSource(this.users);

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  constructor(
    private usersService: UsersService
  ) {
  }

  ngAfterViewInit() {
    this.getUsers();
    this.dataSource.sort = this.sort;
  }

  getUsers(): void {
    this.usersService.getUsers()
      .subscribe((users: any[]) => {
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
        this.dataSource.data.push(user);
      });
  }

  delete(user: User): void {
    this.usersService.deleteUser(user).subscribe();
    this.users = this.users.filter(h => h !== user);
    this.dataSource.data = this.users;
  }
}

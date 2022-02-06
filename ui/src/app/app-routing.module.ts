import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {UsersComponent} from "./users/users.component";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {UserDetailsComponent} from "./users/user-details/user-details.component";
import {UserAddComponent} from "./users/user-add/user-add.component";
import { TicketsComponent } from './tickets/tickets.component';
import { TicketAddComponent } from './tickets/ticket-add/ticket-add.component';
import { TicketDetailsComponent } from './tickets/ticket-details/ticket-details.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'users/details/:id', component: UserDetailsComponent },
  { path: 'users', component: UsersComponent },
  { path: 'users/add', component: UserAddComponent},
  { path: 'tickets', component: TicketsComponent },
  { path: 'tickets/add', component: TicketAddComponent},
  { path: 'tickets/details/:id', component: TicketDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

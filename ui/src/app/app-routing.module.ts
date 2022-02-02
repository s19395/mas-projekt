import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {UsersComponent} from "./users/users.component";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {UserDetailsComponent} from "./users/user-details/user-details.component";
import {UserAddComponent} from "./users/user-add/user-add.component";

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'detail/:id', component: UserDetailsComponent },
  { path: 'users', component: UsersComponent },
  { path: 'users/add', component: UserAddComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

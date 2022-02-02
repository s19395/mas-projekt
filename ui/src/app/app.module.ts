import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatListModule, MatNavList} from "@angular/material/list";
import {MatToolbarModule} from "@angular/material/toolbar";
import { UsersComponent } from './users/users.component';
import {FormsModule} from "@angular/forms";
import { UserDetailsComponent } from './users/user-details/user-details.component';
import { MessagesComponent } from './messages/messages.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UserSearchComponent } from './users/user-search/user-search.component';
import {MatIconModule} from "@angular/material/icon";
import {MatSliderModule} from "@angular/material/slider";
import {MatExpansionModule} from "@angular/material/expansion";
import {MatTableModule} from "@angular/material/table";
import {MatFormFieldModule, MatLabel} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatTableFilterModule} from "mat-table-filter";
import {MatSnackBarModule} from "@angular/material/snack-bar";

const modules = [
  BrowserModule,
  AppRoutingModule,
  BrowserAnimationsModule,
  HttpClientModule,
  MatSidenavModule,
  MatListModule,
  MatToolbarModule,
  FormsModule,
  MatIconModule,
  MatSliderModule,
  MatExpansionModule,
  MatTableModule,
  MatFormFieldModule,
  MatInputModule,
  MatTableFilterModule,
  MatSnackBarModule
];

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    UserDetailsComponent,
    MessagesComponent,
    DashboardComponent,
    UserSearchComponent
  ],
  imports: [...modules],
  exports: [...modules],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

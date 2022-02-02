import {Component, Input, OnInit} from '@angular/core';
import {MessageService} from "./message.service";
import {MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition} from "@angular/material/snack-bar";

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.scss']
})
export class MessagesComponent implements OnInit {
  horizontalPosition: MatSnackBarHorizontalPosition = 'start';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';

  constructor(
    public messageService: MessageService,
    private _snackBar: MatSnackBar
  ) {}

  openOneSnackBar(message:string) {
    this._snackBar.open(message, 'Dismiss', {
      duration: 3 * 1000,
      panelClass: "snack-bar",
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
    });
  }

  ngOnInit(): void {
  }
}

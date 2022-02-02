import {Component, Injectable} from '@angular/core';
import {MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition} from "@angular/material/snack-bar";

@Injectable({
  providedIn: 'root',
})
export class MessageService {
  messages: string[] = [];
  horizontalPosition: MatSnackBarHorizontalPosition = 'center';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';


  constructor(private _snackBar: MatSnackBar) {
  }

  add(message: string) {
    this.messages.push(message);
    this.openOneSnackBar(message);
  }

  openOneSnackBar(message:string) {
    this._snackBar.open(message, 'Dismiss', {
      duration: 3 * 1000,
      panelClass: ['snackbar'],
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
    });
  }

  clear() {
    this.messages = [];
  }
}

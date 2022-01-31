import { Component } from '@angular/core';
import axios from "axios";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  url: string = '/';
  itemsUrl: string = '';

  constructor(private http: HttpClient) {
    this.getResponse();
  }

  public async getResponse() {
    axios.get('http://localhost:8080/greeting/', {
      headers: {'crossDomain': true}
    })
      .then(function (response) {
        // handle success
        console.log(response);
      })
      .catch(function (error) {
        // handle error
        console.log(error);
      })
      .then(function () {
        // always executed
      });
  }

}

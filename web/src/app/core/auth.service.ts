import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {BehaviorSubject, Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loggedin: Subject<boolean> = new BehaviorSubject<boolean>(false);

  constructor(private http:HttpClient) { }

  login(params: {username:string, password:string}) {
    return this.http.post<string>(`${environment.backendUrl}/login`, params, {responseType: "text" as "json"}).subscribe(token => {
      this.loggedin.next(true);
      localStorage.setItem('token', token);
    });
  }

}

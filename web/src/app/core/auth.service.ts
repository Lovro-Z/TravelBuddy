import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {BehaviorSubject, Observable, Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loggedIn: Subject<boolean> = new BehaviorSubject<boolean>(false);

  constructor(private http:HttpClient) { }

  login(params: {username:string, password:string}) {
    this.http.post<string>(`/login`, params, {responseType: "text" as "json"}).subscribe(token => {
      this.loggedIn.next(true);
      localStorage.setItem('token', token);
    });
  }

  isLoggedIn(): Observable<boolean> {
    return this.loggedIn.asObservable();
  }

  register(params: any) {
    this.http.post<string>('/register', params).subscribe( () => {
      console.log("User registered");
    })
  }

}

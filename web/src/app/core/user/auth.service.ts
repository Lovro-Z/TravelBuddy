import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {BehaviorSubject, Observable, Subject} from "rxjs";
import {tap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private currentUserSubject$: Subject<any> = new BehaviorSubject<any>(null);
  currentUser$: Observable<any> = this.currentUserSubject$.asObservable();

  constructor(private http:HttpClient) { }

  login(params: {username:string, password:string}): Observable<string> {
    return this.http.post<string>(`/login`, params, {responseType: "text" as "json"}).pipe(tap(token => {
      localStorage.setItem('token', token);
      const userData = JSON.parse(window.atob(localStorage.getItem('token').split('.')[1]));
      this.currentUserSubject$.next(userData)}));
  }

  register(params: any): Observable<string> {
    return this.http.post<string>('/register', params);
  }
}

export function getHttpHeaders() {
  return new HttpHeaders( {
    'Authorization': 'Bearer ' + localStorage.getItem('token')
  });
}

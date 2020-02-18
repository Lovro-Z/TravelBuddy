import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, Observable, Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loggedInSubject$: Subject<boolean> = new BehaviorSubject<boolean>(false);
  loggedIn$: Observable<boolean> = this.loggedInSubject$.asObservable();
  private registerSuccessSubject$: Subject<void> = new Subject<void>();
  private error$: Subject<string> = new BehaviorSubject<string>(null);

  constructor(private http:HttpClient) { }

  login(params: {username:string, password:string}) {
    this.http.post<string>(`/login`, params, {responseType: "text" as "json"}).subscribe(token => {
      this.loggedInSubject$.next(true);
      localStorage.setItem('token', token);
    }, error => {
      this.error$.next(error.error$);
    })
  }

  get errorMessage$(): Observable<string> {
    return this.error$.asObservable();
  }

  get registerSuccess$(): Observable<void> {
    return this.registerSuccessSubject$.asObservable();
  }

  register(params: any) {
    this.http.post<string>('/register', params).subscribe( () => {
      this.registerSuccessSubject$.next();
    }, error => {
      this.error$.next(error.error$.message);
    })
  }

}

import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable, Subject} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Travel} from "./travel.dto";
import {getHttpHeaders} from "../user/auth.service";

@Injectable({
  providedIn: 'root'
})
export class TravelService {

  private error$: Subject<string> = new BehaviorSubject<string>(null);

  constructor(private http:HttpClient) { }

  getTravels():Observable<Travel[]> {
    return this.http.get<Travel[]>('/travels');
  }

  createTravel(params: any) {
    let headers = getHttpHeaders();
    this.http.post<string>('/travels', params, {headers}).subscribe( () => {

    }, error => {
      this.error$.next(error.error);
    })
  }
}

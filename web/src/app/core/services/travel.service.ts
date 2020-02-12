import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Travel} from "../../common/dto/travel.dto";

@Injectable({
  providedIn: 'root'
})
export class TravelService {

  constructor(private http:HttpClient) { }

  getTravels():Observable<Travel[]> {
    return this.http.get<Travel[]>('/travels');
  }
}

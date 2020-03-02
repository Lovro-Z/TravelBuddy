import { Component, OnInit } from '@angular/core';
import {Travel} from "../../core/travel/travel.dto";
import {TravelService} from "../../core/travel/travel.service";

@Component({
  selector: 'app-travels',
  templateUrl: './travels.component.html',
  styleUrls: ['./travels.component.css']
})
export class TravelsComponent implements OnInit {
  travels: Travel[];

  constructor(private travelService:TravelService) { }

  ngOnInit() {
    this.travelService.getTravels().subscribe( travels => {
      this.travels = travels;
    })
  }

}

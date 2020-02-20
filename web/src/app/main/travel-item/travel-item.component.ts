import {Component, Input, OnInit} from '@angular/core';
import {Travel} from "../../common/dto/travel.dto";

@Component({
  selector: 'app-travel-item',
  templateUrl: './travel-item.component.html',
  styleUrls: ['./travel-item.component.css']
})
export class TravelItemComponent implements OnInit {

  @Input() travel:Travel;

  constructor() { }

  ngOnInit() {
  }

}

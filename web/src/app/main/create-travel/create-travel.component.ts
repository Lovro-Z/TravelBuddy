import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {TranslateService} from "@ngx-translate/core";
import {TravelService} from "../../core/travel/travel.service";

@Component({
  selector: 'app-create-travel',
  templateUrl: './create-travel.component.html',
  styleUrls: ['./create-travel.component.css']
})
export class CreateTravelComponent implements OnInit {

  travelForm = new FormGroup( {
    title: new FormControl('', Validators.required),
    date: new FormControl(null, Validators.required),
    duration: new FormControl(null, Validators.required),
    price: new FormControl(null, Validators.required),
    description: new FormControl('', Validators.required)
  });

  constructor(private travelService: TravelService, private translate: TranslateService) { }

  ngOnInit() {
  }

  createTravel() {
    this.travelService.createTravel(this.travelForm.value);
  }

}

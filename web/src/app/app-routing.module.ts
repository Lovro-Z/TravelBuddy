import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {TravelsComponent} from "./main/travels/travels.component";
import {CreateTravelComponent} from "./main/create-travel/create-travel.component";


const routes: Routes = [
  {
    path: '', component: TravelsComponent
  },
  {
    path: 'new-travel', component: CreateTravelComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

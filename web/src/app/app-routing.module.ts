import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TravelsComponent} from "./main/travels/travels.component";


const routes: Routes = [
  {
    path: '', component: TravelsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

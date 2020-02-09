import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {AuthService} from "../../core/auth.service";

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  showModal: boolean = false;
  isLoggedIn: boolean = false;

  loginForm = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  });

  constructor(private auth: AuthService) { }

  login() {
    this.auth.login(this.loginForm.value)
    this.isLoggedIn = true;
    this.showModal = false;
  }

  logout() {
    localStorage.clear();
    this.isLoggedIn = false;
  }

  ngOnInit() {
  }

}

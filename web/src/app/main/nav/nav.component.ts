import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../core/auth.service";

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  showModal: boolean = false;
  isLoggedIn: boolean = false;
  registerModal: boolean = false;

  loginForm = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  });

  registerForm = new FormGroup( {
    username: new FormControl('', Validators.required),
    email: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
    phoneNumber: new FormControl('', Validators.required),
  });

  constructor(private auth: AuthService) { }

  login() {
    this.auth.login(this.loginForm.value);
    this.isLoggedIn = true;
    this.showModal = false;
  }

  register() {
    this.auth.register(this.registerForm.value);
    this.registerModal = false;
    this.registerForm.reset();
  }

  logout() {
    localStorage.clear();
    this.isLoggedIn = false;
  }

  ngOnInit() {
  }

}

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
  closeAlert: boolean = true;

  loginForm = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  });

  registerForm = new FormGroup( {
    username: new FormControl('', Validators.required),
    email: new FormControl('', Validators.email),
    password: new FormControl('', Validators.required),
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
    phoneNumber: new FormControl('', Validators.required),
  });

  constructor(private auth: AuthService) { }

  login() {
    if(this.loginForm.valid) {
      this.auth.login(this.loginForm.value);
      this.loginForm.reset();
    } else {
      this.showAlert();
      console.log('Invalid username/password');
    }
  }

  register() {
    if(this.registerForm.valid) {
      this.auth.register(this.registerForm.value);
      this.registerModal = false;
      this.registerForm.reset();
    } else {
      this.showAlert();
      console.log('Invalid form');
    }
  }

  switchModal():boolean {
    this.registerModal = !this.registerModal;
    this.closeAlert = true;
    return this.registerModal;
  }

  showAlert() {
    this.closeAlert = false;
    setTimeout(() => {
      this.closeAlert = true;
    }, 3000);
  }

  logout() {
    localStorage.clear();
    this.isLoggedIn = false;
  }

  loginModal() {
    this.showModal = true;
    this.registerModal = false;
  }

  ngOnInit() {
    this.auth.isLoggedIn().subscribe(param => {
      if(param){
        this.isLoggedIn = true;
        this.showModal = false;
      }
    });
  }
}

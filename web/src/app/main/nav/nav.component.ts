import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../core/auth.service";
import {TranslateService} from "@ngx-translate/core";

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
  errorMessage: string;

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

  constructor(private auth: AuthService, private translate: TranslateService) { }

  ngOnInit() {
    this.auth.registerSuccess$.subscribe(() => {
      this.registerModal = false;
      this.registerForm.reset();
    });

    this.auth.errorMessage$.subscribe(value => {
      if (value) {
        this.errorMessage = value;
        this.closeAlert = false;
      }
    });

    this.auth.loggedIn$.subscribe(param => {
      if(param){
        this.isLoggedIn = true;
        this.showModal = false;
      }
    });
  }

  login() {
    this.auth.login(this.loginForm.value);
    this.loginForm.reset();
  }

  register() {
    this.auth.register(this.registerForm.value);
  }

  switchModal():boolean {
    this.registerModal = !this.registerModal;
    this.closeAlert = true;
    return this.registerModal;
  }

  logout() {
    localStorage.clear();
    this.isLoggedIn = false;
  }

  loginModal() {
    this.showModal = true;
    this.registerModal = false;
  }

  useLanguage(language: string) {
    this.translate.use(language);
  }
}

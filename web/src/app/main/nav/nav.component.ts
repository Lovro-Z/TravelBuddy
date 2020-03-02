import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../core/user/auth.service";
import {TranslateService} from "@ngx-translate/core";

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  showModal: boolean = false;
  registerModal: boolean = false;
  closeAlert: boolean = true;
  errorMessage: string;
  currentLang: string = 'en';
  currentUser: any;

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

  get isAdmin() {
    return this.currentUser.auth === 'ADMIN';
  }

  ngOnInit() {
    this.auth.currentUser$.subscribe( user => {
      this.currentUser = user;
      if(user) {
        this.showModal = false;
      }
    })
  }

  login() {
    this.auth.login(this.loginForm.value).subscribe(
      () => {},
      error => {
        this.errorMessage = error.error;
        this.closeAlert = false;
      });
    this.loginForm.reset();
  }

  register() {
    this.auth.register(this.registerForm.value).subscribe(() => {
      this.registerModal = false;
      this.registerForm.reset();
    }, error => {
      this.errorMessage = error.error;
      this.closeAlert = false;
    });
  }

  switchModal():boolean {
    this.registerModal = !this.registerModal;
    this.closeAlert = true;
    return this.registerModal;
  }

  logout() {
    localStorage.clear();
    this.closeAlert = true;
    this.currentUser = null;
  }

  loginModal() {
    this.showModal = true;
    this.registerModal = false;
  }

  useLanguage(language: string) {
    this.translate.use(language);
    this.currentLang = language;
  }

  isCurrentLang(language: string) {
    return this.currentLang === language;
  }
}

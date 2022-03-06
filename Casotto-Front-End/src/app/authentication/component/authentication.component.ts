import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from '../service/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.scss']
})
export class AuthenticationComponent implements OnInit {

  
  private _login: boolean;

  private _register: boolean;

  private _loginForm : FormGroup;


  constructor(private authenticationService : AuthenticationService, 
              private formBuilder : FormBuilder,
              private router: Router) { 
    this._login = true;
    this._register = false;
    this._loginForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
  });
  }

  public getCsrfToken():void{
     this.authenticationService.getCsrfToken().subscribe();
  }


  get loginForm() { return this._loginForm; }

  public onLogin(){
    this.authenticationService
      .login(this.loginForm.get('email')?.value,this.loginForm.get('password')?.value)
      .subscribe(() => this.localStorageSave());
  }

  public get login():boolean{
    return this._login;
  }

  public get register():boolean{
    return this._register;
  }

  public showLogin(){
    this._login = true;
    this._register = false;
  }

  public showRegister(){
    this._login = false;
    this._register = true;
  }

  private localStorageSave(){
    this.authenticationService
    .getRuolo()
    .subscribe(ruolo=> {sessionStorage.setItem("ruolo", ruolo);
                        this.router.navigate([''])})
  }

  ngOnInit(): void {
    this.getCsrfToken();
  }

}

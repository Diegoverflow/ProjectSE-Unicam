import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.scss']
})
export class AuthenticationComponent implements OnInit {

  
  private _login: boolean;

  private _register: boolean;

  private _loginForm : FormGroup;


  constructor(private authenticationService : AuthenticationService, private formBuilder : FormBuilder) { 
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
    this.authenticationService.login(this.loginForm.get('email')?.value,this.loginForm.get('password')?.value).subscribe();
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


  ngOnInit(): void {
    this.getCsrfToken();
  }

}

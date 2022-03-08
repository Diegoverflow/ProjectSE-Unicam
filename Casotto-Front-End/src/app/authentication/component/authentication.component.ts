import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from '../service/authentication.service';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { EMPTY, of } from 'rxjs';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.scss']
})
export class AuthenticationComponent implements OnInit {

  private _login: boolean;

  private _register: boolean;

  private _loginForm: FormGroup;


  constructor(private authenticationService: AuthenticationService,
    private formBuilder: FormBuilder,
    private router: Router) {
    this._login = true;
    this._register = false;
    this._loginForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  public getCsrfToken(): void {
    this.authenticationService.getCsrfToken().subscribe();
  }


  get loginForm() { return this._loginForm; }

  public onLogin(): void {
    this.authenticationService.login(this.loginForm.get('email')!.value, this.loginForm.get('password')!.value)
      .subscribe({
        complete: () => { this.authenticationService.getRuolo().subscribe(r => this.redirect(r)) },
        error: () => alert('ritenta il login')
      })
  }

  public get login(): boolean {
    return this._login;
  }

  public get register(): boolean {
    return this._register;
  }

  public showLogin() {
    this._login = true;
    this._register = false;
  }

  public showRegister() {
    this._login = false;
    this._register = true;
  }

  private redirect(ruolo: string) {
    console.log(ruolo === 'GESTORE');
    if (ruolo === 'GESTORE')
      this.router.navigate(['/gestore-home']);
    if (ruolo === 'CLIENTE')
      this.router.navigate(['/cliente-home']);
    if (ruolo === 'ADDETTO_BAR')
      this.router.navigate(['/addetto-bar-home']);
    if (ruolo === 'CASSIERE')
      this.router.navigate(['/cassiere-home']);
  }

  ngOnInit(): void {
    this.getCsrfToken();
    this.authenticationService.checkToken().subscribe({
      complete: () => this.authenticationService.getRuolo().subscribe(r => this.redirect(r)),
      error: () => {return EMPTY }
    })
  }

}

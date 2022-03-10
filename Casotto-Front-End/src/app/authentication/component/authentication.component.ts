import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from '../service/authentication.service';
import { Router } from '@angular/router';
import { lastValueFrom } from 'rxjs';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.scss']
})

export class AuthenticationComponent implements OnInit {

  private _login: boolean;

  private _register: boolean;

  private _loginForm: FormGroup;

  private _registerForm: FormGroup;


  constructor(private authenticationService: AuthenticationService,
    private formBuilder: FormBuilder,
    private router: Router) {
    this._login = true;
    this._register = false;
    this._loginForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
    this._registerForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required],
      nome: ['', Validators.required],
      cognome: ['', Validators.required],
      cellulare: ['', Validators.required]
    })
  }

  public getCsrfToken(): void {
    this.authenticationService.getCsrfToken().subscribe();
  }


  get loginForm() { return this._loginForm }

  get registerForm() { return this._registerForm }

  public onLogin(): void {
    this.authenticationService.login(this.loginForm.get('email')!.value, this.loginForm.get('password')!.value)
      .subscribe({
        next: r => this.redirect(r),
        error: () => alert('ritenta il login')
      })
  }

  public onRegister(): void {
    this.authenticationService.register(this.registerForm.value).subscribe(
      () => this.showLogin());
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
    if (ruolo === 'GESTORE')
      this.router.navigate(['/gestore-home']);
    if (ruolo === 'CLIENTE')
      this.router.navigate(['/cliente-home']);
    if (ruolo === 'ADDETTO_BAR')
      this.router.navigate(['/addetto-bar-home']);
    if (ruolo === 'CASSIERE')
      this.router.navigate(['/cassiere-home']);
  }

  ngOnInit() {
    this.getCsrfToken();
    let ruolo = this.authenticationService.getRuoloFromStorage();
    if (ruolo !== null)
      this.redirect(ruolo);
  }
}

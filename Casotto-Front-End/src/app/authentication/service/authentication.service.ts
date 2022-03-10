import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Utente } from 'src/app/model/user';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private apiServerUrl: string = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getCsrfToken(): Observable<string> {
    return this.http.get<string>(`${this.apiServerUrl}/login`, { withCredentials: true });
  }

  public login(email: string, password: string): Observable<string> {
    let observable = this.http.post<string>(`${this.apiServerUrl}/login`, { email, password }, { withCredentials: true })
    observable.subscribe(r => this.saveRuolo(r));
    return observable
  }

  public register(utente: Utente) {
    return this.http.post<Utente>(`${this.apiServerUrl}/utenti`, utente, { withCredentials: true })
  }

  public getRuolo(): Observable<string> {
    return this.http.get<string>(`${this.apiServerUrl}/utenti/ruolo`, { withCredentials: true });
  }

  public saveRuolo(ruolo: string): void {
    sessionStorage.setItem('ruolo',ruolo);
  }

  public getRuoloFromStorage(): string | null {
    return sessionStorage.getItem('ruolo');
  }

  public checkToken(): Observable<boolean> {
    return this.http.get<boolean>(`${this.apiServerUrl}/check-token`, { withCredentials: true });
  }

}

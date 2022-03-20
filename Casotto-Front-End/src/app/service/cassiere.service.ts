import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Vendita } from '../model/vendita';

@Injectable({
  providedIn: 'root'
})
export class CassiereService {

  private url: string = environment.apiBaseUrl + '/vendite';

  constructor(private http: HttpClient) { }

  public getVenditeDaPagare(email: string): Observable<Vendita[]> {
    return this.http.get<Vendita[]>(`${this.url}/utente/${email}/da-pagare`, { withCredentials: true });
  }

  public saldaVendita(vendita: Vendita): Observable<Vendita> {
    return this.http.patch<Vendita>(`${this.url}/${vendita.id}/true`, null, { withCredentials: true })
  }
}

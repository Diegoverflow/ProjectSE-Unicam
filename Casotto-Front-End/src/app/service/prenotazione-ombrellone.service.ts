import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { FasciaOraria } from '../model/fascia-oraria';
import { PrenotazioneOmbrellone } from '../model/prenotazione-ombrellone';
import { RigaCatalogoOmbrellone } from '../model/riga-catalogo-ombrellone';

@Injectable({
  providedIn: 'root'
})
export class PrenotazioneOmbrelloneService {

  private urlPrenotazioniOmbrelloni: string = environment.apiBaseUrl + '/prenotazioni/ombrelloni';

  constructor(private http: HttpClient) { }

  getOmbrelloniLiberi(data: Date, fasciaOraria: FasciaOraria): Observable<RigaCatalogoOmbrellone[]> {
    return this.http.get<RigaCatalogoOmbrellone[]>(`${this.urlPrenotazioniOmbrelloni}/disponibili`,
      {
        params: { data: `${data}`, fasciaOraria: `${fasciaOraria}` },
        withCredentials: true
      })
  }

  prenotaOmbrellone(prenotazione: PrenotazioneOmbrellone): Observable<PrenotazioneOmbrellone> {
    return this.http.post<PrenotazioneOmbrellone>(
      `${this.urlPrenotazioniOmbrelloni}`,
      prenotazione,
      { withCredentials: true })
  }

  getPrenotazioniOmbrelloniLoggedUser() {
    return this.http.get<PrenotazioneOmbrellone[]>(this.urlPrenotazioniOmbrelloni + '/loggedUser', { withCredentials: true });
  }

}

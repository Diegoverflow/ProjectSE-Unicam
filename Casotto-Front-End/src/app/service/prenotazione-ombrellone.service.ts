import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { FasciaOraria } from '../model/fascia-oraria';
import { PrenotazioneOmbrellone } from '../model/prenotazione-ombrellone';
import { RigaCatalogoBar } from '../model/riga-catalogo-bar';
import { RigaCatalogoOmbrellone } from '../model/riga-catalogo-ombrellone';

@Injectable({
  providedIn: 'root'
})
export class PrenotazioneOmbrelloneService {

  private urlOrdinazioniBar: string = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  getOmbrelloniLiberi(data: Date, fasciaOraria: FasciaOraria): Observable<RigaCatalogoOmbrellone[]> {
    return this.http.get<RigaCatalogoOmbrellone[]>(`${this.urlOrdinazioniBar}/prenotazioni/ombrelloni/disponibili`,
      {
        params: { data: `${data}`, fasciaOraria: `${fasciaOraria}` },
        withCredentials: true
      })
  }

  prenotaOmbrellone(prenotazione: PrenotazioneOmbrellone): Observable<PrenotazioneOmbrellone> {
    return this.http.post<PrenotazioneOmbrellone>(
      `${this.urlOrdinazioniBar}/prenotazioni/ombrelloni`,
      prenotazione,
      { withCredentials: true })
  }

}

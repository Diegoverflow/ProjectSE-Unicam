import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RigaCatalogoAttivita } from '../model/riga-catalogo-attivita';

@Injectable({
  providedIn: 'root'
})
export class RigheAttivitaService {

  private apiServerUrl: string = '//localhost:8080/catalogo/attivita';

  //private urlPrenotazioniAttivita: string = '//localhost:8080/prenotazioni/attivita';

  constructor(private http: HttpClient) { }

  getRighe(): Observable<RigaCatalogoAttivita[]> {
    return this.http.get<RigaCatalogoAttivita[]>(this.apiServerUrl + '/all', { withCredentials: true });
  }

  /*getRigheAttivitaDisponibili(): Observable<RigaCatalogoAttivita[]> {
    return this.http.get<RigaCatalogoAttivita[]>(this.urlPrenotazioniAttivita + '/disponibili', { withCredentials: true });
  }*/

  addRiga(riga: RigaCatalogoAttivita): Observable<RigaCatalogoAttivita> {
    return this.http.post<RigaCatalogoAttivita>(this.apiServerUrl, riga, { withCredentials: true });
  }

  removeRiga(idRiga: string): Observable<unknown> {
    const url = `${this.apiServerUrl}/${idRiga}`;
    return this.http.delete(url, { withCredentials: true })
  }

  /*prenotaAttivita(riga: RigaCatalogoAttivita) {
    this.http.post(this.urlPrenotazioniAttivita, riga, { withCredentials: true }).subscribe();
  }*/

  askConfirm(verb: string, pastVerb: string, article: string, object: string, option: string): boolean {
    if (confirm("Sei sicuro di voler" + " " + verb + " " + article + " " + object + " " + option + " ?")) {
      window.alert(object + " " + pastVerb + " con successo");
      return true;
    }
    window.alert(object + " non " + pastVerb);
    return false;
  }

}

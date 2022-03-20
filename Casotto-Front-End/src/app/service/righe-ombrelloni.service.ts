import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RigaCatalogoOmbrellone } from '../model/riga-catalogo-ombrellone';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RigheOmbrelloniService {

  private apiServerUrl: string = '//localhost:8080/catalogo/ombrelloni';

  constructor(private http: HttpClient) { }

  getRighe(): Observable<RigaCatalogoOmbrellone[]> {
    return this.http.get<RigaCatalogoOmbrellone[]>(this.apiServerUrl + '/all', { withCredentials: true });
  }

  addRiga(riga: RigaCatalogoOmbrellone): Observable<RigaCatalogoOmbrellone> {
    return this.http.post<RigaCatalogoOmbrellone>(this.apiServerUrl, riga, { withCredentials: true })
  }

  removeRiga(idRiga: string): Observable<unknown> {
    const url = `${this.apiServerUrl}/${idRiga}`;
    return this.http.delete(url, { withCredentials: true })
  }

  askConfirm(verb: string, pastVerb: string, article: string, object: string, option: string): boolean {
    if (confirm("Sei sicuro di voler" + " " + verb + " " + article + " " + object + " " + option + " ?")) {
      window.alert(object + " " + pastVerb + " con successo");
      return true;
    }
    window.alert(object + " non " + pastVerb);
    return false;
  }

}

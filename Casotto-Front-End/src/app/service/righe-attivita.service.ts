import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { RigaCatalogoAttivita } from '../model/riga-catalogo-attivita';

@Injectable({
  providedIn: 'root'
})
export class RigheAttivitaService {

  private apiServerUrl: string = environment.apiBaseUrl + '/catalogo/attivita';

  constructor(private http: HttpClient) { }

  getRighe(): Observable<RigaCatalogoAttivita[]> {
    return this.http.get<RigaCatalogoAttivita[]>(this.apiServerUrl + '/all', { withCredentials: true });
  }

  addRiga(riga: RigaCatalogoAttivita): Observable<RigaCatalogoAttivita> {
    return this.http.post<RigaCatalogoAttivita>(this.apiServerUrl, riga, { withCredentials: true });
  }

  removeRiga(idRiga: string): Observable<unknown> {
    const url = `${this.apiServerUrl}/${idRiga}`;
    return this.http.delete(url, { withCredentials: true })
  }

}

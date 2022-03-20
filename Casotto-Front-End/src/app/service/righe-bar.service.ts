import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { RigaCatalogoBar } from '../model/riga-catalogo-bar';

@Injectable({
  providedIn: 'root'
})
export class RigheBarService {

  private apiServerUrl: string = environment.apiBaseUrl + '/catalogo/bar';

  constructor(private http: HttpClient) { }

  getRighe(): Observable<RigaCatalogoBar[]> {
    return this.http.get<RigaCatalogoBar[]>(this.apiServerUrl + '/all', { withCredentials: true });
  }

  addRiga(riga: RigaCatalogoBar): Observable<RigaCatalogoBar> {
    return this.http.post<RigaCatalogoBar>(this.apiServerUrl, riga, { withCredentials: true })
  }

  removeRiga(idRiga: string): Observable<unknown> {
    const url = `${this.apiServerUrl}/${idRiga}`;
    return this.http.delete(url, { withCredentials: true })
  }

}

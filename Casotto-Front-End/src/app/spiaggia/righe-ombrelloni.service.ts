import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RigaCatalogoOmbrelloni } from './riga-catalogo-ombrelloni';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RigheOmbrelloniService {

  private apiServerUrl: string = '//localhost:8080/catalogo/ombrelloni';

  constructor(private http : HttpClient) { }

  getRighe() : Observable<RigaCatalogoOmbrelloni[]> {
    return this.http.get<RigaCatalogoOmbrelloni[]>(this.apiServerUrl+ '/all', { withCredentials: true });
  }

  addRiga(riga : RigaCatalogoOmbrelloni) : Observable<RigaCatalogoOmbrelloni>{
    return this.http.post<RigaCatalogoOmbrelloni>(this.apiServerUrl, riga, {withCredentials : true})
  }

  removeRiga(idRiga : string) : Observable<unknown>{
    const url = `${this.apiServerUrl}/${idRiga}`;
    return this.http.delete(url, {withCredentials : true})
  }

}

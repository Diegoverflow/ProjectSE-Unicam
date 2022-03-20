import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RigaCatalogoBar } from '../model/riga-catalogo-bar';

@Injectable({
  providedIn: 'root'
})
export class RigheBarService {

  private apiServerUrl: string = '//localhost:8080/catalogo/bar';

  constructor(private http : HttpClient) { }

  getRighe() : Observable<RigaCatalogoBar[]> {
    return this.http.get<RigaCatalogoBar[]>(this.apiServerUrl+ '/all', { withCredentials: true });
  }

  addRiga(riga : RigaCatalogoBar) : Observable<RigaCatalogoBar>{
    return this.http.post<RigaCatalogoBar>(this.apiServerUrl, riga, {withCredentials : true})
  }

  removeRiga(idRiga : string) : Observable<unknown>{
    const url = `${this.apiServerUrl}/${idRiga}`;
    return this.http.delete(url, {withCredentials : true})
  }

  askConfirm(s0: string, s1: string): boolean {
    if (confirm("Sei sicuro di voler " + s0 + " l' ordinazione selezionata?")) {
      window.alert("Articolo Bar" + s1 + " con successo");
      return true;
    }
    window.alert("Nessun Articolo Bar " + s1);
    return false;
  }

}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';
import { RIGHEATTIVITA } from './mock-righeAttivita';
import { RigaCatalogoAttivita } from './riga-catalogo-attivita';

@Injectable({
  providedIn: 'root'
})
export class RigheAttivitaService {

  private apiServerUrl:string = '//localhost:8080/catalogo/attivita';

  constructor(private http : HttpClient) { }

  getRighe(): Observable<RigaCatalogoAttivita[]> {
    return this.http.get<RigaCatalogoAttivita[]>(this.apiServerUrl+'/all',{withCredentials:true});
  }

  addRiga(riga: RigaCatalogoAttivita){
    this.http.post<RigaCatalogoAttivita>(this.apiServerUrl, riga,{withCredentials:true}).subscribe();
  }

  removeRiga(riga: RigaCatalogoAttivita){
    RIGHEATTIVITA.splice(RIGHEATTIVITA.indexOf(riga), 1);
    console.log('riga attivita rimossa')
  }
  
}

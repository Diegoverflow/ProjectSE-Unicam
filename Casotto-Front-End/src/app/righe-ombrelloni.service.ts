import { Injectable } from '@angular/core';
import { RigaCatalogoOmbrellone } from './riga-catalogo-ombrellone';
import { Observable, of } from 'rxjs';
import { RIGHEOMBRELLONI } from './mock-righeombrelloni';

@Injectable({
  providedIn: 'root'
})
export class RigheOmbrelloniService {

  getRighe(): Observable<RigaCatalogoOmbrellone[]>{
    const righe = of( RIGHEOMBRELLONI);
    return righe;
  }

  addRiga(riga: RigaCatalogoOmbrellone){
    RIGHEOMBRELLONI.push(riga);
    console.log("riga dell'ombrellone "+riga.ombrellone.codiceSpiaggia+" aggiunta");
  }

  removeRiga(riga: RigaCatalogoOmbrellone){
    RIGHEOMBRELLONI.splice(RIGHEOMBRELLONI.indexOf(riga), 1);
    console.log("riga dell'ombrellone "+riga.ombrellone.codiceSpiaggia+" rimossa");
  }

  constructor() { }
}

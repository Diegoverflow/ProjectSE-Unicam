import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { RIGHEATTIVITA } from './mock-righeAttivita';
import { RigaCatalogoAttivita } from './riga-catalogo-attivita';

@Injectable({
  providedIn: 'root'
})
export class RigheAttivitaService {

  constructor() { }

  getRighe(): Observable<RigaCatalogoAttivita[]> {
    const righe = of(RIGHEATTIVITA);
    return righe;
  }

  addRiga(riga: RigaCatalogoAttivita){
    RIGHEATTIVITA.push(riga);
    console.log('riga attivita aggiunta')
  }

  removeRiga(riga: RigaCatalogoAttivita){
    RIGHEATTIVITA.splice(RIGHEATTIVITA.indexOf(riga), 1);
    console.log('riga attivita rimossa')
  }
  
}

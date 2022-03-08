import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { RIGHEBAR } from './mock-righebar';
import { RigaCatalogoBar } from './riga-catalogo-bar';

@Injectable({
  providedIn: 'root'
})
export class RigheBarService {

  constructor() { }

  getRighe(): Observable<RigaCatalogoBar[]>{
    const righe = of(RIGHEBAR);
    return righe;
  }

  addRiga(riga: RigaCatalogoBar){
    RIGHEBAR.push(riga);
    console.log('riga bar aggiunta')
  }

  removeRiga(riga: RigaCatalogoBar){
    RIGHEBAR.splice(RIGHEBAR.indexOf(riga), 1);
    console.log('riga bar rimossa')
  }
}

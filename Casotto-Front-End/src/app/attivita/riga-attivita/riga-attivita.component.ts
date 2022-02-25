import { Component, OnInit } from '@angular/core';
import { RIGHEATTIVITA } from '../mock-righeAttivita';
import { RigaCatalogoAttivita } from '../riga-catalogo-attivita';
import { RigheAttivitaService } from '../righe-attivita.service';

import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-riga-attivita',
  templateUrl: './riga-attivita.component.html',
  styleUrls: ['./riga-attivita.component.scss']
})
export class RigaAttiviaComponent implements OnInit {

  title: string = 'Catalogo Attivita'

  private _righeCatalogoAttivita: RigaCatalogoAttivita[] = RIGHEATTIVITA

  constructor(private righeAttivitaService: RigheAttivitaService,
              private route: ActivatedRoute,  
              private location: Location,     
              private router: Router) {}

  get righeCatalogoAttivita() { return this._righeCatalogoAttivita }

  ngOnInit(): void {
    this.righeAttivitaService.getRighe().
      subscribe(righe => this._righeCatalogoAttivita = righe)
  }

  eliminaRiga(riga: RigaCatalogoAttivita){
    this.righeAttivitaService.removeRiga(riga)
  }

}

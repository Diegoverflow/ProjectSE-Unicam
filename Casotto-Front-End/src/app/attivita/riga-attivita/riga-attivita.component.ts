import { Component, OnInit } from '@angular/core';
import { RigaCatalogoAttivita } from '../riga-catalogo-attivita';
import { RigheAttivitaService } from '../righe-attivita.service';

import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-riga-attivita',
  templateUrl: './riga-attivita.component.html',
  styleUrls: ['./riga-attivita.component.scss']
})
export class RigaAttiviaComponent implements OnInit {

  //FIXME: risolvere nella miglior maniera
  public righe?: RigaCatalogoAttivita[];

  title: string = 'Catalogo Attivita'

  constructor(private righeAttivitaService: RigheAttivitaService,
              private route: ActivatedRoute,  
              private location: Location,     
              private router: Router) {
  }

  public getRigheAttivita():void{ 

    this.righeAttivitaService.getRighe().subscribe(r => {this.righe = r; /*console.log(this.righe[1]);console.log(r)*/});
  }

  public rigaAttivitaAggiunta(rigaAggiunta : RigaCatalogoAttivita){
    this.righe?.push(rigaAggiunta)
  }

  ngOnInit(): void {
    this.getRigheAttivita();
  }

  eliminaRiga(riga: RigaCatalogoAttivita){
    this.righeAttivitaService.removeRiga(riga)
  }

}

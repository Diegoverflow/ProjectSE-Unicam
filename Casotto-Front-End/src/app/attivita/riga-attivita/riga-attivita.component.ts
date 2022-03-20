import { Component, OnInit } from '@angular/core';
import { RigaCatalogoAttivita } from 'src/app/model/riga-catalogo-attivita';
import { RigheAttivitaService } from 'src/app/service/righe-attivita.service';

import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-riga-attivita',
  templateUrl: './riga-attivita.component.html',
  styleUrls: ['./riga-attivita.component.scss']
})
export class RigaAttiviaComponent implements OnInit {

  //FIXME: risolvere nella miglior maniera
  public righe?: RigaCatalogoAttivita[];
  //public righe?: Observable<RigaCatalogoAttivita[]>;

  constructor(private righeAttivitaService: RigheAttivitaService,
    private route: ActivatedRoute,
    private location: Location,
    private router: Router) {
  }

  public getRigheAttivita(): void {
    this.righeAttivitaService.getRighe().subscribe(r => { this.righe = r });
    //this.righe =this.righeAttivitaService.getRighe()
  }

  public rigaAttivitaAggiunta(rigaAggiunta: RigaCatalogoAttivita) {
    this.righe?.push(rigaAggiunta)
    //this.righe?.subscribe(righe => righe.push(rigaAggiunta))//
  }

  eliminaRiga(riga: RigaCatalogoAttivita) {
    if (this.righeAttivitaService.askConfirm("eliminare", "eliminata", "l'", "Attività", "selezionata"))
      this.righeAttivitaService.removeRiga(riga.id).subscribe(() => this.getRigheAttivita())
    //this.righeAttivitaService.removeRiga(riga.id)
    //  .subscribe(rigaRimossa => {this.righe?.subscribe(righe => righe.filter(r => r ==rigaRimossa as RigaCatalogoAttivita ))})
  }

  ngOnInit(): void {
    this.getRigheAttivita();
  }

}

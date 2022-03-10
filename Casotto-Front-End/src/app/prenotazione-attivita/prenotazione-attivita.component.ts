import { Component, OnInit } from '@angular/core';
import { RigaCatalogoAttivita } from '../attivita/riga-catalogo-attivita';
import { RigheAttivitaService } from '../attivita/righe-attivita.service';

@Component({
  selector: 'app-prenotazione-attivita',
  templateUrl: './prenotazione-attivita.component.html',
  styleUrls: ['./prenotazione-attivita.component.scss']
})
export class PrenotazioneAttivitaComponent implements OnInit {

  righeAttivita: RigaCatalogoAttivita[] = new Array();

  constructor(private attivitaService: RigheAttivitaService) {
  }

  ngOnInit(): void {
    this.getRigheCatalogoAttivita();
  }

  getRigheCatalogoAttivita() {
    this.attivitaService.getRigheAttivitaDisponibili().subscribe(r => {
      this.righeAttivita = r;
    })
  }

  prenotaAttivita(rigaAttivita : RigaCatalogoAttivita) {
      this.attivitaService.prenotaAttivita(rigaAttivita);
  }


}

import { Component, OnInit } from '@angular/core';
import { PrenotazioneAttivitaService } from '../attivita/prenotazione-attivita.service';
import { RigaCatalogoAttivita } from '../attivita/riga-catalogo-attivita';

@Component({
  selector: 'app-prenotazione-attivita',
  templateUrl: './prenotazione-attivita.component.html',
  styleUrls: ['./prenotazione-attivita.component.scss']
})
export class PrenotazioneAttivitaComponent implements OnInit {

  righeAttivita: RigaCatalogoAttivita[] = new Array();

  constructor(private attivitaService: PrenotazioneAttivitaService) {
  }

  ngOnInit(): void {
    this.getRigheCatalogoAttivita();
  }

  getRigheCatalogoAttivita() {
    this.attivitaService.getRigheAttivitaDisponibili().subscribe(r => {
      this.righeAttivita = r;
    })
  }

  prenotaAttivita(r: RigaCatalogoAttivita) {
    this.attivitaService.prenotaAttivita(r);
  }


}

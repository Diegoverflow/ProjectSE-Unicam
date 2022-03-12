import { Component, OnInit } from '@angular/core';
import { last, lastValueFrom } from 'rxjs';
import { PrenotazioneAttivitaService } from './prenotazione-attivita.service';
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

  async prenotaAttivita(r: RigaCatalogoAttivita) {
    if (this.askConfirm(r.valore.nome))
      await lastValueFrom(this.attivitaService.prenotaAttivita(r)).then(() => {
        this.getRigheCatalogoAttivita();
      })
  }

  askConfirm(nomeAttivita: string): boolean {
    if (confirm("Sei sicuro di voler prenotare l' attività " + "' " + nomeAttivita + " '" + " ?")) {
      window.alert("Attività prenotata con successo");
      return true;
    }
    else {
      window.alert("Nessuna attività prenotata");
      return false;
    }
  }

}

import { Component, OnInit } from '@angular/core';
import { last, lastValueFrom } from 'rxjs';
import { PrenotazioneAttivitaService } from '../service/prenotazione-attivita.service';
import { RigaCatalogoAttivita } from '../model/riga-catalogo-attivita';
import { AskConfirmService } from '../service/ask-confirm.service';

@Component({
  selector: 'app-prenotazione-attivita',
  templateUrl: './prenotazione-attivita.component.html',
  styleUrls: ['./prenotazione-attivita.component.scss']
})
export class PrenotazioneAttivitaComponent implements OnInit {

  righeAttivita: RigaCatalogoAttivita[] = new Array();

  constructor(private attivitaService: PrenotazioneAttivitaService, private askService: AskConfirmService) {
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
    if (this.askService.askConfirm("prenotare", "prenotata", "l'", "attività: " + r.valore.nome, "selezionata"))
      await lastValueFrom(this.attivitaService.prenotaAttivita(r)).then(() => {
        this.getRigheCatalogoAttivita();
      })
  }

}

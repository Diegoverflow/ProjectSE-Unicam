import { Component, OnInit } from '@angular/core';
import { PrenotazioneAttivita } from 'src/app/model/prenotazione-attivita';
import { PrenotazioneAttivitaService } from 'src/app/service/prenotazione-attivita.service';

@Component({
  selector: 'app-le-mie-prenotazioni-attivita',
  templateUrl: './le-mie-prenotazioni-attivita.component.html',
  styleUrls: ['./le-mie-prenotazioni-attivita.component.scss']
})
export class LeMiePrenotazioniAttivitaComponent implements OnInit {

  storicoPrenotazioni: PrenotazioneAttivita[] = new Array();

  constructor(private prenotazioniAttivitaService: PrenotazioneAttivitaService) { }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {
    this.getStoricoPrenotazioniAttivita();
  }
  getStoricoPrenotazioniAttivita() {
    this.prenotazioniAttivitaService.getPrenotazioniAttivitaLoggedUser().subscribe(o => {
      this.storicoPrenotazioni = o;
    })
  }

}

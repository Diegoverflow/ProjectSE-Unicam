import { AfterViewInit, Component, OnInit } from '@angular/core';
import { PrenotazioneOmbrellone } from 'src/app/model/prenotazione-ombrellone';
import { PrenotazioneOmbrelloneService } from 'src/app/service/prenotazione-ombrellone.service';

@Component({
  selector: 'app-le-mie-prenotazioni-ombrelloni',
  templateUrl: './le-mie-prenotazioni-ombrelloni.component.html',
  styleUrls: ['./le-mie-prenotazioni-ombrelloni.component.scss']
})
export class LeMiePrenotazioniOmbrelloniComponent implements OnInit, AfterViewInit {

  storicoPrenotazioni: PrenotazioneOmbrellone[] = new Array();

  constructor(private prenotazioniOmbrelloniService: PrenotazioneOmbrelloneService) { }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {
    this.getStoricoPrenotazioniOmbrelloni();
  }
  getStoricoPrenotazioniOmbrelloni() {
    this.prenotazioniOmbrelloniService.getPrenotazioniOmbrelloniLoggedUser().subscribe(o => {
      this.storicoPrenotazioni = o;
    })
  }



}

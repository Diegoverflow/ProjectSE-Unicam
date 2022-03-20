import { Component, OnInit } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { OrdinazioneBar } from 'src/app/model/ordinazione-bar';
import { StatusOrdinazioneBar } from 'src/app/model/status-ordinazione';
import { AddettoBarService } from 'src/app/service/addetto-bar.service';
import { AskConfirmService } from 'src/app/service/ask-confirm.service';

@Component({
  selector: 'app-addetto-bar-ordinazioni',
  templateUrl: './addetto-bar-ordinazioni.component.html',
  styleUrls: ['./addetto-bar-ordinazioni.component.scss']
})
export class AddettoBarOrdinazioniComponent implements OnInit {

  ordinazioniBar: OrdinazioneBar[] = new Array();

  selectedStatus: StatusOrdinazioneBar;

  statusButtons: string[] = new Array();
  selectedButton: string = "";

  statuses: StatusOrdinazioneBar[] = new Array();

  constructor(private addettoService: AddettoBarService, private askService: AskConfirmService) {
    this.selectedStatus = StatusOrdinazioneBar.DA_PRENDERE_IN_CARICO;
  }

  ngOnInit(): void {
    this.initializeStatuses();
  }

  selectStatus(s: string) {
    let i = 0;
    switch (s) {
      case this.statusButtons[0]:
        i = 0;
        break;
      case this.statusButtons[1]:
        i = 1;
        break;
      case this.statusButtons[2]:
        i = 2;
        break;
    }
    this.selectedStatus = this.statuses[i];
    this.selectedButton = this.statusButtons[i];
    this.getOrdinazioniByStatus(this.selectedStatus);
  }

  initializeStatuses() {
    for (var s in StatusOrdinazioneBar)
      this.statuses.push(<StatusOrdinazioneBar>s);
    this.statusButtons = ["Da Prendere In Carico", "Prese In Carico", "Consegnate"];
    this.selectedButton = this.statusButtons[0];
    this.getOrdinazioniByStatus(this.selectedStatus);
  }

  getOrdinazioniByStatus(s: StatusOrdinazioneBar) {
    this.addettoService.getAllOrdinazioniBy(s).subscribe(o => {
      this.ordinazioniBar = o;
    })
  }

  async prendiInCarico(o: OrdinazioneBar) {
    if (this.askService.askConfirm("prendere in carico", "presa in carico", "l'", "Ordinazione Bar", "selezionata"))
      await lastValueFrom(this.addettoService.prendiInCarico(o.id)).then(() => {
        this.getOrdinazioniByStatus(StatusOrdinazioneBar.DA_PRENDERE_IN_CARICO);
      })
  }

  async consegna(o: OrdinazioneBar) {
    if (this.askService.askConfirm("consegnare", "consegnata", "l'", "Ordinazione Bar", "selezionata"))
      await lastValueFrom(this.addettoService.consegna(o.id)).then(() => {
        this.getOrdinazioniByStatus(StatusOrdinazioneBar.PRESO_IN_CARICO);
      })
  }

}

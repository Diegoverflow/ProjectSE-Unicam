import { Component, OnInit } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { OrdinazioneBar } from '../model/ordinazione-bar';
import { StatusOrdinazioneBar } from '../model/status-ordinazione';
import { AddettoBarService } from '../service/addetto-bar.service';

@Component({
  selector: 'app-addetto-bar-home',
  templateUrl: './addetto-bar-home.component.html',
  styleUrls: ['./addetto-bar-home.component.scss']
})
export class AddettoBarHomeComponent implements OnInit {

  ordinazioniBar: OrdinazioneBar[] = new Array();

  selectedStatus: StatusOrdinazioneBar;

  statusButtons: string[] = new Array();
  selectedButton: string = "";

  statuses: StatusOrdinazioneBar[] = new Array();

  constructor(private addettoService: AddettoBarService) {

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
    this.statusButtons = ["Da prendere in carico", "Prese in carico", "Consegnate"];
    this.selectedButton = this.statusButtons[0];
    this.getOrdinazioniByStatus(this.selectedStatus);
  }

  getOrdinazioniByStatus(s: StatusOrdinazioneBar) {
    this.addettoService.getAllOrdinazioniBy(s).subscribe(o => {
      this.ordinazioniBar = o;
    })
  }

  // TODO: serve solo al gestore misa
  // async eliminaOrdinazione(o: OrdinazioneBar) {
  //   if (this.askConfirm("eliminare", "eliminata"))
  //     await lastValueFrom(this.addettoService.removeOrdinazione(o.id)).then(() => {
  //       this.getOrdinazioniByStatus(this.selectedStatus);
  //     })
  // }

  async prendiInCarico(o: OrdinazioneBar) {
    if (this.askConfirm("prendere in carico", "presa in carico"))
      await lastValueFrom(this.addettoService.prendiInCarico(o.id)).then(() => {
        this.getOrdinazioniByStatus(StatusOrdinazioneBar.DA_PRENDERE_IN_CARICO);
      })
  }

  async consegna(o: OrdinazioneBar) {
    if (this.askConfirm("consegnare", "conegnata"))
      await lastValueFrom(this.addettoService.consegna(o.id)).then(() => {
        this.getOrdinazioniByStatus(StatusOrdinazioneBar.CONSEGNATO);
      })
  }

  private askConfirm(s0: string, s1: string): boolean {
    if (confirm("Sei sicuro di voler " + s0 + " l' ordinazione selezionata?")) {
      window.alert("Ordinazione " + s1 + " con successo");
      return true;
    }
    window.alert("Nessuna ordinazione " + s1);
    return false;
  }

}

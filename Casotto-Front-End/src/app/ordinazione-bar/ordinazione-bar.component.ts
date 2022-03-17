import { Component, OnInit } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { RigaCatalogoBar } from '../model/riga-catalogo-bar';
import { RigaCatalogoOmbrellone } from '../model/riga-catalogo-ombrellone';
import { TipoArticoloBar } from '../model/tipo-articolo-bar';
import { OrdinazioneBarService } from '../service/ordinazione-bar.service';
import { RigheOmbrelloniService } from '../spiaggia/righe-ombrelloni.service';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-ordinazione-bar',
  templateUrl: './ordinazione-bar.component.html',
  styleUrls: ['./ordinazione-bar.component.scss']
})
export class OrdinazioneBarComponent implements OnInit {

  righeBar: RigaCatalogoBar[] = new Array();

  menuButton: boolean = false;

  // Per filtrare gli articoli in base alla voce selezionata nella view
  ArticoloBartypes: TipoArticoloBar[] = new Array();
  selectedMenuVoice?: TipoArticoloBar;

  // Per visualizzare voci menu nella view
  menuVoices: string[] = new Array();
  voiceTextMenu?: string;

  umbrellas: RigaCatalogoOmbrellone[] = new Array();
  selectedUmbrella: string;

  isOrdinaEnabled: boolean;

  constructor(private barService: OrdinazioneBarService, private oService: RigheOmbrelloniService, private modalService: NgbModal) {
    this.selectedUmbrella = "";
    this.isOrdinaEnabled = false;
  }

  ngOnInit(): void {
    this.getRigheCatalogoBar();
    this.initializeMenuVoices();
    this.initializeUmbrellas();
  }

  initializeUmbrellas() {
    this.oService.getRighe().subscribe((u) => {
      this.umbrellas = u;
    });
  }

  showMenu() {
    this.menuButton = !this.menuButton;
  }

  getRigheCatalogoBar() {
    this.barService.getRigheBarDisponibili().subscribe(r => {
      this.righeBar = r;
    })
  }

  async ordinaDalBar(r: RigaCatalogoBar, codiceSpiaggia: string) {
    if (this.askConfirm(r.valore.nome))
      await lastValueFrom(this.barService.ordina(r, codiceSpiaggia)).then(() => {
        this.getRigheCatalogoBar();
      })
  }

  askConfirm(nomeArticolo: string): boolean {
    if (confirm("Sei sicuro di voler ordinare:  " + "' " + nomeArticolo + " '" + " da consegnare all' ombrellone ' " + this.selectedUmbrella + " '?")) {
      window.alert("Ordinazione effettuata con successo");
      return true;
    }
    else {
      window.alert("Nessun' ordinazione effettuata");
      return false;
    }
  }

  initializeMenuVoices() {
    for (var t in TipoArticoloBar) {
      this.ArticoloBartypes.push(<TipoArticoloBar>t);
    }
    this.menuVoices = ["BEVANDE", "PIZZE", "PRIMI PIATTI", "SECONDI PIATTI", "DOLCI", "PANINI"];
    this.selectedMenuVoice = this.ArticoloBartypes[0];
    this.voiceTextMenu = this.menuVoices[0];
  }

  selectMenuVoice(t: string) {
    let i = 0;
    switch (t) {
      case this.menuVoices[0]:
        i = 0;
        break;
      case this.menuVoices[1]:
        i = 1;
        break;
      case this.menuVoices[2]:
        i = 2;
        break;
      case this.menuVoices[3]:
        i = 3;
        break;
      case this.menuVoices[4]:
        i = 4;
        break;
      case this.menuVoices[5]:
        i = 5
        break;
    }
    this.selectedMenuVoice = this.ArticoloBartypes[i];
    this.voiceTextMenu = this.menuVoices[i];
  }

  selectUmbrella(codiceSpiaggia: string) {
    this.selectedUmbrella = codiceSpiaggia;
    this.isOrdinaEnabled = true;
  }

  // Funzione per aprire popup selezione ombrelloni
  openUmbrellaSelection(content: any) {
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then(() => {
      this.disableButtonOnClosingPopup();
    }, () => {
      this.disableButtonOnClosingPopup();
    });
  }

  private disableButtonOnClosingPopup() {
    this.isOrdinaEnabled = false;
  }

}

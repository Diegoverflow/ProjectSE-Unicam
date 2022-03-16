import { Component, OnInit } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { RigaCatalogoBar } from '../model/riga-catalogo-bar';
import { TipoArticoloBar } from '../model/tipo-articolo-bar';
import { OrdinazioneBarService } from '../service/ordinazione-bar.service';

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

  constructor(private barService: OrdinazioneBarService) {
  }

  ngOnInit(): void {
    this.getRigheCatalogoBar();
    this.initializeMenuVoices();
  }

  showMenu() {
    this.menuButton = !this.menuButton;
  }


  getRigheCatalogoBar() {
    this.barService.getRigheBarDisponibili().subscribe(r => {
      this.righeBar = r;
    })
  }

  async ordinaDalBar(r: RigaCatalogoBar) {
    if (this.askConfirm(r.valore.nome))
      await lastValueFrom(this.barService.ordina(r)).then(() => {
        this.getRigheCatalogoBar();
      })
  }

  askConfirm(nomeArticolo: string): boolean {
    if (confirm("Sei sicuro di voler ordinare:  " + "' " + nomeArticolo + " '" + " ?")) {
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
    switch (t) {
      case this.menuVoices[0]:
        this.selectedMenuVoice = this.ArticoloBartypes[0];
        this.voiceTextMenu = this.menuVoices[0];
        break;
      case this.menuVoices[1]:
        this.selectedMenuVoice = this.ArticoloBartypes[1];
        this.voiceTextMenu = this.menuVoices[1];
        break;
      case this.menuVoices[2]:
        this.selectedMenuVoice = this.ArticoloBartypes[2];
        this.voiceTextMenu = this.menuVoices[2];
        break;
      case this.menuVoices[3]:
        this.selectedMenuVoice = this.ArticoloBartypes[3];
        this.voiceTextMenu = this.menuVoices[3];
        break;
      case this.menuVoices[4]:
        this.selectedMenuVoice = this.ArticoloBartypes[4];
        this.voiceTextMenu = this.menuVoices[4];
        break;
      case this.menuVoices[5]:
        this.selectedMenuVoice = this.ArticoloBartypes[5];
        this.voiceTextMenu = this.menuVoices[5];
        break;
    }
  }

}

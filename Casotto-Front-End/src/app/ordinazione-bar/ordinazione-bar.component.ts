import { Component, OnInit } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { OrdinazioneBar } from '../model/ordinazione-bar';
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

  menuVoices: TipoArticoloBar[] = new Array();

  selectedMenuVoice: TipoArticoloBar;

  constructor(private barService: OrdinazioneBarService) {
    this.selectedMenuVoice = TipoArticoloBar.BEVANDA;
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
    for (var t in TipoArticoloBar)
      this.menuVoices.push(<TipoArticoloBar>t);
  }

  selectMenuVoice(t: string) {
    switch (t) {
      case this.menuVoices[0]:
        this.selectedMenuVoice = this.menuVoices[0];
        break;
      case this.menuVoices[1]:
        this.selectedMenuVoice = this.menuVoices[1];
        break;
    }
  }


}

import { Component, OnInit } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { RigaCatalogoBar } from '../model/riga-catalogo-bar';
import { CatalogoBarService } from './catalogo-bar.service';

@Component({
  selector: 'app-ordinazione-bar',
  templateUrl: './ordinazione-bar.component.html',
  styleUrls: ['./ordinazione-bar.component.scss']
})
export class OrdinazioneBarComponent implements OnInit {

  righeBar: RigaCatalogoBar[] = new Array();

  menuButton: boolean = false;

  constructor(private barService: CatalogoBarService) { }

  ngOnInit(): void {
    this.getRigheCatalogoBar();
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

}

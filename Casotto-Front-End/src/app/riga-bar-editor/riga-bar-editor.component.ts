import { Component, OnInit } from '@angular/core';
import { ArticoloBar } from '../articolo';
import { RigaCatalogoBar } from '../riga-catalogo-bar';
import { RigheBarService } from '../righe-bar.service';

@Component({
  selector: 'app-riga-bar-editor',
  templateUrl: './riga-bar-editor.component.html',
  styleUrls: ['./riga-bar-editor.component.scss']
})
export class RigaBarEditorComponent implements OnInit {

  articoloDaAggiungere: ArticoloBar = new ArticoloBar('nome articolo', 'descrizione');

  nuovaRiga: RigaCatalogoBar = new RigaCatalogoBar(this.articoloDaAggiungere, 1.5, 20)

  save() {
    let rigaDaAggiungere = new RigaCatalogoBar(new ArticoloBar
                                                  (this.articoloDaAggiungere.nome, 
                                                   this.articoloDaAggiungere.descrizione),
                                               this.nuovaRiga.prezzo, this.nuovaRiga.quantita)
    this._righeBarService.addRiga(rigaDaAggiungere)
  }

  constructor(private _righeBarService: RigheBarService) { }

  ngOnInit(): void {
  }

}

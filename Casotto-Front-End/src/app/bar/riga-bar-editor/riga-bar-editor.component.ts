import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { TipoArticoloBar } from 'src/app/model/tipo-articolo-bar';
import { RigaCatalogoBar } from '../../model/riga-catalogo-bar';
import { RigheBarService } from '../righe-bar.service';

@Component({
  selector: 'app-riga-bar-editor',
  templateUrl: './riga-bar-editor.component.html',
  styleUrls: ['./riga-bar-editor.component.scss']
})
export class RigaBarEditorComponent implements OnInit {

  title: string = "Aggiungi Un Articolo Bar al Catalogo Bar";

  @Output() rigaAggiunta = new EventEmitter<RigaCatalogoBar>();

  tipiArticoli: TipoArticoloBar[] = new Array();

  constructor(private righeBarService: RigheBarService) { }

  ngOnInit(): void {
    this.initializeTipi();
  }
  initializeTipi() {
    for (var t in TipoArticoloBar)
      this.tipiArticoli.push(<TipoArticoloBar>t);
  }

  rigaForm = new FormGroup({
    valore: new FormGroup({
      nome: new FormControl(''),
      descrizione: new FormControl(''),
      tipoArticoloBar: new FormControl(TipoArticoloBar.BEVANDA)
    }),
    quantita: new FormControl(1),
    prezzo: new FormControl(1),
  })

  save() {
    if (this.righeBarService.askConfirm("salvare", "salvato", "l'", "Articolo Bar", "selezionato"))
      this.righeBarService.addRiga(this.rigaForm.value)
        .subscribe(rigaConId => this.rigaAggiunta.emit(rigaConId))
  }


}

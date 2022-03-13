import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { RigaCatalogoBar } from '../riga-catalogo-bar';
import { RigheBarService } from '../righe-bar.service';

@Component({
  selector: 'app-riga-bar-editor',
  templateUrl: './riga-bar-editor.component.html',
  styleUrls: ['./riga-bar-editor.component.scss']
})
export class RigaBarEditorComponent implements OnInit {

  title: string = 'Editor riga catalogo bar';

  @Output() rigaAggiunta = new EventEmitter<RigaCatalogoBar>();

  rigaForm = new FormGroup({
    valore : new FormGroup({
      nome : new FormControl('nome articolo'),
      descrizione : new FormControl('descrizione')
    }),
    quantita : new FormControl(20),
    prezzo : new FormControl(0)
  })

  save(){
    this.righeBarService.addRiga(this.rigaForm.value)
      .subscribe(rigaConId => this.rigaAggiunta.emit(rigaConId))
  }

  constructor(private righeBarService : RigheBarService) { }

  ngOnInit(): void {
  }

}

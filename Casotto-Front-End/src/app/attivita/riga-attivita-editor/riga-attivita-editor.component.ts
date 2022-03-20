import { Component, EventEmitter, Output, OnInit } from '@angular/core';
import { RigheAttivitaService } from 'src/app/service/righe-attivita.service';
import { FormControl, FormGroup } from '@angular/forms';
import { RigaCatalogoAttivita } from 'src/app/model/riga-catalogo-attivita';

@Component({
  selector: 'app-riga-attivita-editor',
  templateUrl: './riga-attivita-editor.component.html',
  styleUrls: ['./riga-attivita-editor.component.scss']
})
export class RigaAttivitaEditorComponent implements OnInit {

  @Output() rigaAggiunta = new EventEmitter<RigaCatalogoAttivita>();

  //TODO: validators
  rigaForm = new FormGroup({
    valore: new FormGroup({
      nome: new FormControl(''),
      dataOrarioInizio: new FormControl(new Date().toISOString().substring(0, 10)),
      dataOrarioFine: new FormControl(new Date().toISOString().substring(0, 10)),
      descrizione: new FormControl('')
    }),
    postiTotali: new FormControl(10),
    postiOccupati: new FormControl(0),
    prezzo: new FormControl(0)
  })

  save() {
    if (this.righeAttivitaService.askConfirm("salvare", "salvata", "l'", "Attività", "selezionata"))
      this.righeAttivitaService.addRiga(this.rigaForm.value)
        .subscribe(rigaConId => this.rigaAggiunta.emit(rigaConId))
  }

  constructor(private righeAttivitaService: RigheAttivitaService) { }

  ngOnInit(): void {
  }

}

import { Component, EventEmitter, Output, OnInit } from '@angular/core';
import { Attivita } from '../attivita';
import { RigaCatalogoAttivita } from '../riga-catalogo-attivita';
import { RigheAttivitaService } from '../righe-attivita.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-riga-attivita-editor',
  templateUrl: './riga-attivita-editor.component.html',
  styleUrls: ['./riga-attivita-editor.component.scss']
})
export class RigaAttivitaEditorComponent implements OnInit {

  title: string = 'Editor riga catalogo attivita'

  @Output() rigaAggiunta = new EventEmitter<RigaAttivitaEditorComponent>();

  //TODO: validators
  rigaForm = new FormGroup({
    valore : new FormGroup({
      nome: new FormControl('nome attivita'),
      dataOrarioInizio: new FormControl(new Date().toISOString().substring(0,10)),
      dataOrarioFine: new FormControl(new Date().toISOString().substring(0,10)),
      descrizione: new FormControl('descrizione')
    }),
    postiTotali: new FormControl(10),
    postiOccupati: new FormControl(0),
    prezzo: new FormControl(0)
  })

  save(){
    this.righeAttivitaService.addRiga(this.rigaForm.value)
    this.rigaAggiunta.emit(this.rigaForm.value)
  }
  

  constructor(private righeAttivitaService: RigheAttivitaService) { }

  ngOnInit(): void {
  }

}

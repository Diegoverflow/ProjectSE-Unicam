import { Component, OnInit } from '@angular/core';
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
  

  _defaultNome: string = 'inserisci nome';
  _defaultDataInizio: number = Date.now();
  _defaultDataFine: number = Date.now();
  _defaultDescrizione: string = 'inserisci descrizione';
  _defaultPostiTotali: number = 10;
  _defaultPostiOccupati: number = 0;
  _defaultPrezzo: number = 15;

  _nuovaAttivita: Attivita = {
    nome: this._defaultNome,
    dataInizio: new Date(this._defaultDataInizio),
    dataFine: new Date(this._defaultDataFine),
    descrizione: this._defaultDescrizione
  }

  _nuovaRiga: RigaCatalogoAttivita = {
    valore: this._nuovaAttivita,
    numPostiTot: this._defaultPostiTotali,
    numPostiOccupati: this._defaultPostiOccupati,
    prezzo: this._defaultPrezzo
  }

  /*setToDefault(){
    this._nuovaAttivita = new Attivita(this._defaultNome, 
                                            new Date(this._defaultDataInizio), 
                                            new Date(this._defaultDataFine),
                                            this._defaultDescrizione);
    this._nuovaRiga = new RigaCatalogoAttivita(this._nuovaAttivita, 
                                                                this._defaultPostiTotali, 
                                                                this._defaultPostiOccupati, 
                                                                this._defaultPrezzo)
  }*/

  /*
  save() {
    let rigaDaAggiungere: RigaCatalogoAttivita =
    {
      valore: {
        nome: this._nuovaAttivita.nome,
        dataInizio: this._nuovaAttivita.dataInizio,
        dataFine: this._nuovaAttivita.dataFine,
        descrizione: this._defaultDescrizione
      },
      numPostiTot: this._nuovaRiga.numPostiTot,
      numPostiOccupati: this._nuovaRiga.numPostiOccupati,
      prezzo: this._nuovaRiga.prezzo
    }
    this.righeAttivitaService.addRiga(rigaDaAggiungere)
  }*/

  save(){
    this.righeAttivitaService.addRiga(this.rigaForm.value)
  }

  constructor(private righeAttivitaService: RigheAttivitaService) { }

  ngOnInit(): void {
  }

}

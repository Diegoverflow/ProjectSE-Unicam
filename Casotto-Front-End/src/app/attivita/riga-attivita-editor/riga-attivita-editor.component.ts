import { Component, OnInit } from '@angular/core';
import { Attivita } from '../attivita';
import { RigaCatalogoAttivita } from '../riga-catalogo-attivita';
import { RigheAttivitaService } from '../righe-attivita.service';

@Component({
  selector: 'app-riga-attivita-editor',
  templateUrl: './riga-attivita-editor.component.html',
  styleUrls: ['./riga-attivita-editor.component.scss']
})
export class RigaAttivitaEditorComponent implements OnInit {

  title: string = 'Editor riga catalogo attivita'

  _defaultNome: string = 'inserisci nome';
  _defaultDataInizio: number = Date.now();
  _defaultDataFine: number = Date.now();
  _defaultDescrizione: string = 'inserisci descrizione';
  _defaultPostiTotali: number = 10;
  _defaultPostiOccupati: number = 0;
  _defaultPrezzo: number = 15;

  _nuovaAttivita: Attivita = new Attivita(this._defaultNome, 
                                          new Date(this._defaultDataInizio), 
                                          new Date(this._defaultDataFine),
                                          this._defaultDescrizione)

  _nuovaRiga: RigaCatalogoAttivita = new RigaCatalogoAttivita(this._nuovaAttivita, 
                                                              this._defaultPostiTotali, 
                                                              this._defaultPostiOccupati, 
                                                              this._defaultPrezzo)

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

  save(){ 
    let rigaDaAggiungere = new RigaCatalogoAttivita(
      new Attivita(this._nuovaAttivita.nome, 
                   this._nuovaAttivita.dataInizio, 
                   this._nuovaAttivita.dataFine,
                   this._defaultDescrizione),
      this._nuovaRiga.numPostiTot, this._nuovaRiga.numPostiOccupati, this._nuovaRiga.prezzo);
      this.righeAttivitaService.addRiga(rigaDaAggiungere)
  }

  constructor(private righeAttivitaService: RigheAttivitaService) {}

  ngOnInit(): void {
  }

}

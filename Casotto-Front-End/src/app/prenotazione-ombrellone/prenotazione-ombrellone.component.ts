import { DatePipe, formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { FasciaOraria } from '../model/fascia-oraria';
import { PrenotazioneOmbrellone } from '../model/prenotazione-ombrellone';
import { RigaCatalogoBar } from '../model/riga-catalogo-bar';
import { RigaCatalogoOmbrellone } from '../model/riga-catalogo-ombrellone';
import { PrenotazioneOmbrelloneService } from '../service/prenotazione-ombrellone.service';

@Component({
  selector: 'app-prenotazione-ombrellone',
  templateUrl: './prenotazione-ombrellone.component.html',
  styleUrls: ['./prenotazione-ombrellone.component.scss']
})
export class PrenotazioneOmbrelloneComponent implements OnInit {

  private _righeOmbrellone !: RigaCatalogoOmbrellone[];

  private _dataFasciaOraria!: FormGroup;

  private _fascieOrarie !: FasciaOraria[];

  private _minDate !: Date;

  constructor(private prenotazioneOmbrelloniservice: PrenotazioneOmbrelloneService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this._minDate = new Date();
    this._fascieOrarie = [FasciaOraria.GIORNATA_INTERA, FasciaOraria.MATTINO, FasciaOraria.POMERIGGIO];
    this.righeOmbrellone = [];
    this._dataFasciaOraria = this.formBuilder.group({
      datePicker: new Date(),
      fasciaOraria: FasciaOraria.GIORNATA_INTERA
    })
  }

get minDate(){
  return this._minDate;
}

  get fascieOrarie() {
    return this._fascieOrarie;
  }

  get dataFasciaOraria() {
    return this._dataFasciaOraria;
  }

  get righeOmbrellone() {
    return this._righeOmbrellone
  }

  set righeOmbrellone(righeOmbrellone: RigaCatalogoOmbrellone[]) {
    this._righeOmbrellone = righeOmbrellone;
  }

  getOmbrelloniLiberi() {
    this.prenotazioneOmbrelloniservice.getOmbrelloniLiberi(
      this.dataFasciaOraria.get('datePicker')?.value.toISOString().substring(0,10), this.dataFasciaOraria.get('fasciaOraria')?.value)
      .subscribe(r => this.righeOmbrellone = r)
  }

  prenotaOmbrellone(r: RigaCatalogoOmbrellone) {
    let prenotazione: PrenotazioneOmbrellone = {
      fasciaOraria: this.dataFasciaOraria.get('fasciaOraria')?.value,
      ombrellone: r.valore,
      dataPrenotazione : this.dataFasciaOraria.get('datePicker')?.value.toISOString().substring(0,10),
      vendita : {costo:r.prezzoOmbrellone}
    }

    this.prenotazioneOmbrelloniservice.prenotaOmbrellone(prenotazione).subscribe()
  }

}

import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { FasciaOraria } from '../model/fascia-oraria';
import { PrenotazioneOmbrellone } from '../model/prenotazione-ombrellone';
import { RigaCatalogoOmbrellone } from '../model/riga-catalogo-ombrellone';
import { PrenotazioneOmbrelloneService } from '../service/prenotazione-ombrellone.service';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { AuthenticationService } from '../service/authentication.service';
import { Utente } from '../model/user';

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

  private _isTableVisible !: boolean;

  private _isFormVisible !: boolean;

  private _isAlertVisible !: boolean;

  private _isPrenotaEnabled: boolean;

  private _isResult !: boolean | null;

  private _loggedUser !: Utente | null;

  private _showAlertSuccessResult !: boolean;

  constructor(private prenotazioneOmbrelloniservice: PrenotazioneOmbrelloneService,
    private formBuilder: FormBuilder,
    private cdr: ChangeDetectorRef,
    private modalService: NgbModal,
    private aService: AuthenticationService) {
    this._isPrenotaEnabled = false;
    this._isAlertVisible = false;
    this._isResult = false;
    this._showAlertSuccessResult = false;
  }

  ngOnInit(): void {
    this._isFormVisible = true;
    this._isTableVisible = false;
    this._minDate = new Date();
    this._fascieOrarie = [FasciaOraria.GIORNATA_INTERA, FasciaOraria.MATTINO, FasciaOraria.POMERIGGIO];
    this.righeOmbrellone = [];
    this._dataFasciaOraria = this.formBuilder.group({
      datePicker: new Date(),
      fasciaOraria: FasciaOraria.GIORNATA_INTERA
    })
    this.getLoggedUser();
  }

  get isFormVisible() {
    return this._isFormVisible;
  }

  get isTableVisible() {
    return this._isTableVisible;
  }

  get minDate() {
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

  get isTableEmpty() {
    return this._isTableVisible;
  }

  get isPrenotaEnabled() {
    return this._isPrenotaEnabled;
  }

  get isResult() {
    return this._isResult;
  }

  getNomeLoggedUser(): string {
    return this._loggedUser!.nome;
  }

  private getLoggedUser() {
    this.aService.getUtente().subscribe(utente => {
      this._loggedUser = utente;
    });
  }

  get showAlertSuccessResult() {
    return this._showAlertSuccessResult;
  }

  get isAlertVisible() {
    return this._isAlertVisible;
  }

  set righeOmbrellone(righeOmbrellone: RigaCatalogoOmbrellone[]) {
    this._righeOmbrellone = righeOmbrellone;
  }

  getOmbrelloniLiberi() {
    this.prenotazioneOmbrelloniservice.getOmbrelloniLiberi(
      this.dataFasciaOraria.get('datePicker')?.value.toISOString().substring(0, 10), this.dataFasciaOraria.get('fasciaOraria')?.value)
      .subscribe(r => {
        this._righeOmbrellone = []; this._righeOmbrellone = r;
        console.log(this._righeOmbrellone.length == 0);
        if (this._righeOmbrellone.length == 0)
          this._isAlertVisible = true;
        else {
          this._isAlertVisible = false;
          this.showTable()
        }
      })

  }

  prenotaOmbrellone(r: RigaCatalogoOmbrellone | null) {
    if (r != null) {
      let prenotazione: PrenotazioneOmbrellone = {
        fasciaOraria: this.dataFasciaOraria.get('fasciaOraria')?.value,
        ombrellone: r.valore,
        dataPrenotazione: this.dataFasciaOraria.get('datePicker')?.value.toISOString().substring(0, 10),
        vendita: { costo: r.prezzoOmbrellone }
      }
      this.prenotazioneOmbrelloniservice.prenotaOmbrellone(prenotazione).subscribe(
        () => this.getOmbrelloniLiberi()
      )
      this._showAlertSuccessResult = true;
    }
    else
      this._showAlertSuccessResult = false;

  }

  showForm() {
    this._isFormVisible = true;
    this._isTableVisible = false;
  }

  showTable() {
    this._isFormVisible = false;
    this._isTableVisible = true;
  }

  // Funzione per aprire popup selezione prenotazioni ombrelloni
  openReservationUmbrellaSelection(content: any) {
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then(() => {
      this.disableButtonOnClosingPopup();
    }, () => {
      this.disableButtonOnClosingPopup();
    });
  }

  private disableButtonOnClosingPopup() {
    this._isPrenotaEnabled = false;
  }

  // Funzione per aprire popup esito prenotazioni ombrelloni
  openResultReservation(content: any) {
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then(() => {
      this.disableResult();
    }, () => {
      this.disableResult();
    });
  }

  private disableResult() {
    this._isResult = false;
  }

}

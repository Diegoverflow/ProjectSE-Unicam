export class Attivita {

    constructor( private _nome: string, 
                 private _dataInzio: Date,
                 private _dataFine: Date,
                 private _descrizione: string){}

    get nome() { return this._nome  }
    set nome(nome: string ) { this._nome = nome }

    get dataInizio() { return this._dataInzio }
    set dataInizio(dataInizio: Date) { this._dataInzio = dataInizio }

    get dataFine() { return this._dataFine }
    set dataFine(dataFine: Date) { this._dataFine = dataFine }

    get descrizone() { return this._descrizione }
    set descrizione(descrizione: string) { this._descrizione = descrizione }
    
}
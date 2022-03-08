export class ArticoloBar {

    constructor ( private _nome: string,
                  private _descrizione: string ) {}

    get nome() { return this._nome }
    set nome(nome: string) { this._nome = nome }

    get descrizione() { return this._descrizione }
    set descrizione(descrizione: string) { this._descrizione = descrizione }

}
import { Attivita } from "./attivita";

export class RigaCatalogoAttivita{

    constructor( private _attivita: Attivita,
                 private _numPostiTot: number,
                 private _numPostiOccupati: number,
                 private _prezzo: number){}

    get attivita() { return this._attivita }
    set attivita(attivita: Attivita) { this._attivita = attivita }

    get numPostiTot() { return this._numPostiTot }
    set numPostiTot(numPostiTot: number) { this._numPostiTot = numPostiTot }

    get numPostiOccupati() { return this._numPostiOccupati }
    set numPostiOccupati(numPostiOccupati: number) { this._numPostiOccupati = numPostiOccupati }

    get prezzo() { return this._prezzo }
    set prezzo(prezzo: number) { this._prezzo = prezzo }
}
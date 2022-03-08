import { ArticoloBar } from "./articolo"

export class RigaCatalogoBar {

    constructor( private _artico: ArticoloBar,
                 private _prezzo: number,
                 private _quantita: number){}

    get articolo() { return this._artico }
    set articolo(articolo: ArticoloBar) { this._artico = articolo }

    get prezzo() { return this._prezzo }
    set prezzo(prezzo: number) { this._prezzo = prezzo }

    get quantita() { return this._quantita }
    set quantita(quantita: number) { this._quantita = quantita }
}
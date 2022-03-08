import { Ombrellone } from "./ombrellone";

/*export interface RigaCatalogoOmbrellone{
    //id: string,
    prezzoOmbrellone: number,
    ombrellone: Ombrellone
}*/

export class RigaCatalogoOmbrellone{
    
    constructor( private _ombrellone: Ombrellone,
                 private _prezzo: number){}

    //get id(): number { return this._id }
    //set id(id: number) { this._id = id }

    get ombrellone() { return this._ombrellone }
    set ombrellone(ombrellone: Ombrellone) { this._ombrellone = ombrellone }

    get prezzo() { return this._prezzo }
    set prezzo(prezzo: number) { this._prezzo = prezzo }

}
import { CategoriaOmbrellone } from "./categoria-ombrellone";

/*export interface Ombrellone{
    //id: string,
    catagoria: CategoriaOmbrellone,
    codiceSpiaggia: string
}*/

export class Ombrellone{
    
    constructor(private _categoria: CategoriaOmbrellone,
                private _codiceSpiaggia: string){}

    //get id(): number { return this._id }
    //set id(id: number) { this._id = id}

    get categoria(): CategoriaOmbrellone { return this._categoria }
    set categoria(catagoria: CategoriaOmbrellone) { this._categoria = catagoria }

    get codiceSpiaggia(): string { return this._codiceSpiaggia }
    set codiceSpiaggia(codiceSpiaggia: string) { this._codiceSpiaggia = codiceSpiaggia }
}
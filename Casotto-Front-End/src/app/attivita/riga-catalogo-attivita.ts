import { Attivita } from "./attivita";

export interface RigaCatalogoAttivita{
    id?: string,
    valore: Attivita,
    numPostiTot: number,
    numPostiOccupati: number,
    prezzo: number
}
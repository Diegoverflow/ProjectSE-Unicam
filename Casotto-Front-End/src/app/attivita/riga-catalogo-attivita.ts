import { Attivita } from "./attivita";

export interface RigaCatalogoAttivita{
    id?: string,
    valore: Attivita,
    postiTotali: number,
    postiOccupati: number,
    prezzo: number
}
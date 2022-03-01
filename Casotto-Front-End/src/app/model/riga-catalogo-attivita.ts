import { Attivita } from "./attivita";

export interface RigaCatalogoAttivita {
    id: string;
    valore: Attivita;
    prezzo: number;
    postiTotali: number;
    postiOccupati: number;
}
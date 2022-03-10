import { Attivita } from "./attivita";

export interface RigaCatalogoAttivita {
    id: string;
    attivita: Attivita;
    prezzo: number;
    postiTotali: number;
    postiOccupati: number;
}
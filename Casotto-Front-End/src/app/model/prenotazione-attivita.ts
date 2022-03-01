import { Attivita } from "./attivita";
import { Vendita } from "./vendita";

export interface PrenotazioneAttivita {
    id: string;
    attivita: Attivita;
    vendita: Vendita;
}
import { Ombrellone } from "./ombrellone";
import { FasciaOraria } from "./fascia-oraria";
import { Vendita } from "./vendita";

export interface PrenotazioneOmbrellone{
    id?: string;
    fasciaOraria: FasciaOraria;
    ombrellone: Ombrellone;
    dataPrenotazione: Date|String;
    vendita: Vendita;
}
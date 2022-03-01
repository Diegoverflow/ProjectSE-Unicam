import { ArticoloBar } from "./articolo-bar";
import { StatusOrdinazioneBar } from "./status-ordinazione";
import { Vendita } from "./vendita";

export interface OrdinazioneBar {
    id: string;
    articoloBar: ArticoloBar;
    statusOrdinazioneBar: StatusOrdinazioneBar;
    vendita: Vendita;
    codiceSpiaggia: string;
}
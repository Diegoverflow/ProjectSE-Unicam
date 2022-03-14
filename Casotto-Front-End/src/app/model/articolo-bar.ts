import { TipoArticoloBar } from "./tipo-articolo-bar";

export interface ArticoloBar {
    id: string;
    nome: string;
    descrizione: string;
    tipoArticoloBar : TipoArticoloBar
}
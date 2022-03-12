import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { OrdinazioneBar } from "../model/ordinazione-bar";
import { RigaCatalogoBar } from "../model/riga-catalogo-bar";

@Injectable({
    providedIn: 'root'
})
export class CatalogoBarService {

    private urlCatalogoBar: string = '//localhost:8080/bar/ordinazioni';

    constructor(private http: HttpClient) {
    }

    getRigheBarDisponibili(): Observable<RigaCatalogoBar[]> {
        return this.http.get<RigaCatalogoBar[]>(this.urlCatalogoBar + '/disponibili', { withCredentials: true });
    }

    ordina(riga: RigaCatalogoBar): Observable<OrdinazioneBar> {
        return this.http.post<OrdinazioneBar>(this.urlCatalogoBar, {
            request: "createPrenotazioneAttivita",
            articoloBar: {
                nome: riga.valore.nome,
                descrizione: riga.valore.descrizione
            },
            vendita: {
                costo: riga.prezzo
            },
            codiceSpiaggia: "1"
        }
            , { withCredentials: true });
    }


}
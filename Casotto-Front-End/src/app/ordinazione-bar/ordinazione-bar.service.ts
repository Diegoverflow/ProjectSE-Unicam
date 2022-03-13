import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { OrdinazioneBar } from "../model/ordinazione-bar";
import { RigaCatalogoBar } from "../model/riga-catalogo-bar";

@Injectable({
    providedIn: 'root'
})
export class OrdinazioneBarService {

    private urlOrdinazioniBar: string = '//localhost:8080/bar/ordinazioni';

    constructor(private http: HttpClient) {
    }

    getRigheBarDisponibili(): Observable<RigaCatalogoBar[]> {
        return this.http.get<RigaCatalogoBar[]>(this.urlOrdinazioniBar + '/disponibili', { withCredentials: true });
    }

    ordina(riga: RigaCatalogoBar): Observable<OrdinazioneBar> {
        console.log(riga);
        return this.http.post<OrdinazioneBar>(this.urlOrdinazioniBar, {
            request: "createOrdinazioneBar",
            articoloBar: riga.valore,
            vendita: {
                costo: riga.prezzo
            },
            codiceSpiaggia: "1"
        }
            , { withCredentials: true });
    }


}
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';
import { PrenotazioneAttivita } from '../model/prenotazione-attivita';
import { RigaCatalogoAttivita } from '../model/riga-catalogo-attivita';

@Injectable({
    providedIn: 'root'
})
export class PrenotazioneAttivitaService {

    private urlPrenotazioniAttivita: string = environment.apiBaseUrl + '/prenotazioni/attivita';

    constructor(private http: HttpClient) { }

    getRigheAttivitaDisponibili(): Observable<RigaCatalogoAttivita[]> {
        return this.http.get<RigaCatalogoAttivita[]>(this.urlPrenotazioniAttivita + '/disponibili', { withCredentials: true });
    }

    prenotaAttivita(riga: RigaCatalogoAttivita): Observable<PrenotazioneAttivita> {
        return this.http.post<PrenotazioneAttivita>(this.urlPrenotazioniAttivita, {
            request: "createPrenotazioneAttivita",
            attivita: riga.valore,
            vendita: {
                costo: riga.prezzo
            }
        }
            , { withCredentials: true });
    }

    getPrenotazioniAttivitaLoggedUser() {
        return this.http.get<PrenotazioneAttivita[]>(this.urlPrenotazioniAttivita + '/loggedUser', { withCredentials: true });
    }

}

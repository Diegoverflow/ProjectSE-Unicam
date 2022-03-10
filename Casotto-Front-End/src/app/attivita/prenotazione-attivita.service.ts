import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, of } from 'rxjs';
import { PrenotazioneAttivita } from '../model/prenotazione-attivita';
import { RigaCatalogoAttivita } from './riga-catalogo-attivita';

@Injectable({
    providedIn: 'root'
})
export class PrenotazioneAttivitaService {

    private urlPrenotazioniAttivita: string = '//localhost:8080/prenotazioni/attivita';

    constructor(private http: HttpClient) { }


    getRigheAttivitaDisponibili(): Observable<RigaCatalogoAttivita[]> {
        return this.http.get<RigaCatalogoAttivita[]>(this.urlPrenotazioniAttivita + '/disponibili', { withCredentials: true });
    }

    prenotaAttivita(riga: RigaCatalogoAttivita) {
        console.log(riga);
        /*let prenotazione : PrenotazioneAttivita = {
            request: "createUser",
            valore: {
                dataOrarioInizio: riga.valore.dataOrarioInizio,
                dataOrarioFine: riga.valore.dataOrarioFine,
                descrizione: riga.valore.descrizione,
                nome: riga.valore.nome
            },
            prezzo: riga.prezzo,
            postiTotali: riga.postiTotali
        };*/
        this.http.post(this.urlPrenotazioniAttivita, {
            request: "createPrenotazioneAttivita",
            attivita: riga.valore,
            vendita:{
                costo: riga.prezzo
            }
        }
        , { withCredentials: true }).subscribe();
    }

}

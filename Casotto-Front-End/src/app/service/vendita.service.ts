import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Vendita } from "../model/vendita";

@Injectable({
    providedIn: 'root'
})
export class VenditaService {

    private urlVendite: string = environment.apiBaseUrl + 'vendite';

    constructor(private http: HttpClient) { }


    getAllVendite(): Observable<Vendita[]> {
        return this.http.get<Vendita[]>(this.urlVendite + '/all', { withCredentials: true });
    }

    getVenditeByUserMail(emailUtente: string): Observable<Vendita[]> {
        return this.http.get<Vendita[]>(this.urlVendite + '/utente/${emailUtente}/da-pagare', { withCredentials: true });
    }

    saldaVendita(idVendita: string, isPagato: boolean) {
        return this.http.patch<Vendita[]>(this.urlVendite + '/${idVendita}/${isPagato}', { withCredentials: true });
    }

}
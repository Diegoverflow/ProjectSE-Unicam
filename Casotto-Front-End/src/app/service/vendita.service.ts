import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Vendita } from "../model/vendita";

@Injectable({
    providedIn: 'root'
})
export class VenditaService{

    private urlVendite: string = '//localhost:8080/vendite';

    constructor(private http: HttpClient) { }


    getAllVendite(): Observable<Vendita[]> {
        return this.http.get<Vendita[]>(this.urlVendite + '/all', { withCredentials: true });
    }

}
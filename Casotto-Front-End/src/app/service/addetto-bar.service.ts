import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { OrdinazioneBar } from "../model/ordinazione-bar";
import { StatusOrdinazioneBar } from "../model/status-ordinazione";

@Injectable({
    providedIn: 'root'
})
export class AddettoBarService {

    private urlOrdinazioniBar: string = environment.apiBaseUrl + '/bar/ordinazioni';

    constructor(private http: HttpClient) { }

    getAllOrdinazioniBy(status: StatusOrdinazioneBar): Observable<OrdinazioneBar[]> {
        let queryParams = new HttpParams();
        queryParams = queryParams.append("status", status);
        return this.http.get<OrdinazioneBar[]>(this.urlOrdinazioniBar,
            { params: queryParams, withCredentials: true });
    }

    removeOrdinazione(id: string) {
        return this.http.delete<OrdinazioneBar>(this.urlOrdinazioniBar + '${id}'
            , { withCredentials: true });
    }

    prendiInCarico(id: string) {
        const url = `${this.urlOrdinazioniBar}/prendi-in-carico/${id}`;
        return this.http.patch<OrdinazioneBar>(this.urlOrdinazioniBar + url, { withCredentials: true });
    }

    consegna(id: string) {
        const url = `${this.urlOrdinazioniBar}/consegna/${id}`;
        return this.http.patch<OrdinazioneBar>(this.urlOrdinazioniBar + url, { withCredentials: true });
    }

}
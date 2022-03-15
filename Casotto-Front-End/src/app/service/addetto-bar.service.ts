
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { OrdinazioneBar } from "../model/ordinazione-bar";
import { StatusOrdinazioneBar } from "../model/status-ordinazione";

@Injectable({
    providedIn: 'root'
})
export class AddettoBarService {

    private urlOrdinazioniBar: string = environment.apiBaseUrl+'/bar/ordinazioni';

    constructor(private http: HttpClient) { }

    getAllOrdinazioniBy(status : StatusOrdinazioneBar) : Observable<OrdinazioneBar[]>{
        return this.http.get<OrdinazioneBar[]>(this.urlOrdinazioniBar+'?status='+status, { withCredentials: true });
    }

}
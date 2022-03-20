import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AreaInfrastruttura } from '../model/area-infrastruttura';

@Injectable({
    providedIn: 'root'
})
export class InfrastrutturaChaletService {

    private apiServerUrl: string = environment.apiBaseUrl + '/infrastruttura/aree';

    constructor(private http: HttpClient) { }

    getAree(): Observable<AreaInfrastruttura[]> {
        return this.http.get<AreaInfrastruttura[]>(this.apiServerUrl + '/all', { withCredentials: true });
    }

    addArea(area: AreaInfrastruttura): Observable<AreaInfrastruttura> {
        return this.http.post<AreaInfrastruttura>(this.apiServerUrl, area, { withCredentials: true })
    }

    // PENSARE A COME FARLO
    //   updateArea(area: AreaInfrastruttura): Observable<unknown> {
    //     const url = `${this.apiServerUrl}/${area}`;
    //     return this.http.delete(url, { withCredentials: true })
    //   }

    removeArea(idArea: string): Observable<unknown> {
        const url = `${this.apiServerUrl}/${idArea}`;
        return this.http.delete(url, { withCredentials: true })
    }

}

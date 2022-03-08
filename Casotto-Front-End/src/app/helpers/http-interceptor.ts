import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { catchError, EMPTY, Observable, tap } from "rxjs";
import { environment } from "src/environments/environment";

@Injectable({
    providedIn: 'root'
})
export class DefaultHttpInterceptor implements HttpInterceptor {

    private apiServerUrl: string = environment.apiBaseUrl;

    constructor(private router : Router){}

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        if (req.url ===`${this.apiServerUrl}/check-token`)
            return next.handle(req);

        return next.handle(req).pipe(
            catchError((e: HttpErrorResponse) => {
                if(e.status == 401){
                    sessionStorage.clear()
                    this.router.navigate(['/login']);
                }
                alert(e.message);
                return EMPTY;
            })
        );
    }



}
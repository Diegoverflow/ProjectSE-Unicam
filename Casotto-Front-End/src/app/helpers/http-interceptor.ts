import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { catchError, EMPTY, Observable, tap, throwError } from "rxjs";
import { environment } from "src/environments/environment";

@Injectable({
    providedIn: 'root'
})
export class DefaultHttpInterceptor implements HttpInterceptor {

    private apiServerUrl: string = environment.apiBaseUrl;

    constructor(private router: Router) { }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(req).pipe(
            catchError((e: HttpErrorResponse) => {
                if (e.status === 401) {
                    sessionStorage.clear()
                    this.router.navigate(['/login']);
                }

                return throwError(() => e)
            })
        );
    }

}
import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, CanActivateChild, UrlTree, CanLoad, Route, UrlSegment } from '@angular/router';
import { lastValueFrom, Observable } from 'rxjs';
import { AuthenticationService } from '../authentication/service/authentication.service';

@Injectable({
    providedIn: 'root'
})

export class AuthGuard implements CanActivate, CanActivateChild {

    constructor(private router: Router, private authService: AuthenticationService) { }

    async canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        let tokenValidation !: boolean
        await lastValueFrom(this.authService.checkToken()).then(b => tokenValidation = b)
        if (tokenValidation === true) {
            let ruolo !: string
            await lastValueFrom(this.authService.getRuolo()).then(r => ruolo = r)
            this.authService.saveRuolo(ruolo)
            return route.data!['ruolo'] === ruolo
        }
        
        return false;

    }

    canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
        return this.canActivate(childRoute.parent!, state);
    }

}
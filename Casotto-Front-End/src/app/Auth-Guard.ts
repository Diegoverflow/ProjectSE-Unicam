import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

@Injectable()
export class AuthGuard implements CanActivate {

    constructor(private router: Router) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        
        if (sessionStorage.getItem('ruolo')===null) {
            // logged in so return true
            this.router.navigate(['/login']);
            return false;
        }

        // not logged in so redirect to login page with the return url
        
        return true;
    }

}
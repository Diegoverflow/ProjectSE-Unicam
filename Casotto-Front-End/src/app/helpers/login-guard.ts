import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { lastValueFrom, Observable } from "rxjs";
import { AuthenticationService } from "../authentication/service/authentication.service";

@Injectable({
    providedIn: 'root'
})

export class LoginGuard implements CanActivate {

    constructor(private router: Router, private authService: AuthenticationService) { }

    async canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        let tokenValidation!: boolean
        await lastValueFrom(this.authService.checkToken()).then(b => tokenValidation = b)
        if (tokenValidation === true) {
            if (this.authService.getRuoloFromStorage === null)
                this.authService.getRuolo().subscribe(r => this.authService.saveRuolo(r));
            return false
        }
        return true
    }

}
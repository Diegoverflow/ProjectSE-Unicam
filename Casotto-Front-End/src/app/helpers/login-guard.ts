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
            if (this.authService.getRuoloFromStorage() === null){
                await lastValueFrom(this.authService.getRuolo()).then(r => this.authService.saveRuolo(r));
            }
            this.redirect(this.authService.getRuoloFromStorage()!)
            return false
        }
        return true
    }

    private redirect(ruolo: string) {
        if (ruolo === 'GESTORE')
          this.router.navigate(['/gestore-home']);
        if (ruolo === 'CLIENTE')
          this.router.navigate(['/cliente-home']);
        if (ruolo === 'ADDETTO_BAR')
          this.router.navigate(['/addetto-bar-home']);
        if (ruolo === 'CASSIERE')
          this.router.navigate(['/cassiere-home']);
      }

}
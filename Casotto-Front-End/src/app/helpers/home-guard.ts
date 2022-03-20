import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, CanActivateChild, UrlTree, CanLoad, Route, UrlSegment } from '@angular/router';
import { lastValueFrom } from 'rxjs';
import { AuthenticationService } from '../service/authentication.service';

@Injectable({
  providedIn: 'root'
})

export class HomeGuard implements CanActivate, CanActivateChild {

  constructor(private router: Router, private authService: AuthenticationService) { }

  async canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    let tokenValidation !: boolean
    await lastValueFrom(this.authService.checkToken()).then(b => tokenValidation = b)
    if (tokenValidation === true) {
      let ruolo !: string
      await lastValueFrom(this.authService.getRuolo()).then(r => ruolo = r)
      this.authService.saveRuolo(ruolo)
      if (route.data!['ruolo'] !== ruolo) {
        this.redirect(ruolo)
        return false
      }
      return true
    }
    this.router.navigate(['/login'])
    return false;

  }

  canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    return this.canActivate(childRoute.parent!, state)
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
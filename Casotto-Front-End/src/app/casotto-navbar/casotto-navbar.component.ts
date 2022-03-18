import { AfterViewInit, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication/service/authentication.service';

@Component({
  selector: 'app-casotto-navbar',
  templateUrl: './casotto-navbar.component.html',
  styleUrls: ['./casotto-navbar.component.scss']
})
export class CasottoNavbarComponent implements OnInit, AfterViewInit {

  ruolo: string | null;

  nome !: string;

  constructor(private router: Router, private authenticationService: AuthenticationService) {
    this.ruolo = this.authenticationService.getRuoloFromStorage();
  }
  ngAfterViewInit(): void {
    
  }

  ngOnInit(): void {
    this.authenticationService.getUtente().subscribe(u => this.nome = u.nome)
  }

  onLogout() {
    this.authenticationService.logout().subscribe(() => {
      this.router.navigate(['/login'])
      sessionStorage.clear()
      this.ruolo = null;
    })
  }

}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-casotto-navbar',
  templateUrl: './casotto-navbar.component.html',
  styleUrls: ['./casotto-navbar.component.scss']
})
export class CasottoNavbarComponent implements OnInit {

  ruolo: string | null;

  nome !:string;

  constructor(private router: Router, private authenticationService: AuthenticationService) {
    this.ruolo = this.authenticationService.getRuoloFromStorage();
  }

  ngOnInit(): void {
    if(this.ruolo !== null)
      this.authenticationService.getUtente().subscribe(u => this.nome = u.nome)
  }

  onLogout() {
    this.authenticationService.logout().subscribe(() => {
      this.router.navigate(['/home'])
      sessionStorage.clear()
      this.ruolo = null;
      this.nome = '';
    })
  }

}

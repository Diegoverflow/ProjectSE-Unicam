import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication/service/authentication.service';

@Component({
  selector: 'app-casottonavbar',
  templateUrl: './casottoNavbar.component.html',
  styleUrls: ['./casottoNavbar.component.scss']
})
export class CasottoNavbarComponent implements OnInit {

  ruolo: string | null;

  nome !:string;

  constructor(private router: Router, private authenticationService: AuthenticationService) {
    this.ruolo = this.authenticationService.getRuoloFromStorage();
  }

  ngOnInit(): void {
    this.authenticationService.getUtente().subscribe(u => this.nome = u.nome)
  }

  onLogout() {
    this.authenticationService.logout().subscribe(() => {
      this.router.navigate(['/login'])
      sessionStorage.clear()
    })
  }

}

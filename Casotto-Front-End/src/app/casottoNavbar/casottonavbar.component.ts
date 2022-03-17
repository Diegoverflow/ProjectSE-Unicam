import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication/service/authentication.service';

@Component({
  selector: 'app-casottonavbar',
  templateUrl: './casottonavbar.component.html',
  styleUrls: ['./casottonavbar.component.scss']
})
export class CasottoNavbarComponent implements OnInit {

  ruolo: string | null;

  constructor(private router: Router, private authenticationService: AuthenticationService) {
    this.ruolo = this.authenticationService.getRuoloFromStorage();
  }

  ngOnInit(): void {
  }

  onLogout() {
    this.authenticationService.logout().subscribe(() => {
      this.router.navigate(['/login'])
      sessionStorage.clear()
    })
  }

}

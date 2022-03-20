import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';
import { Utente } from '../model/user';

@Component({
  selector: 'app-profilo',
  templateUrl: './profilo.component.html',
  styleUrls: ['./profilo.component.scss']
})
export class ProfiloComponent implements OnInit {

  loggedUser!: Utente;

  constructor(private authenticationService: AuthenticationService) {
  }

  ngOnInit(): void {
    this.initializeUtente();
  }

  initializeUtente() {
    this.authenticationService.getUtente().subscribe(u => {
      this.loggedUser = u;
    });
  }

}

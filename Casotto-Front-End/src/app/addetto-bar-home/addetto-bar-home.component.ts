import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';
import { Notifica } from '../model/notifica';

@Component({
  selector: 'app-addetto-bar-home',
  templateUrl: './addetto-bar-home.component.html',
  styleUrls: ['./addetto-bar-home.component.scss']
})
export class AddettoBarHomeComponent implements OnInit {

  notifiche: Notifica[] = new Array();

  constructor(private router: Router, private aService: AuthenticationService) {
  }

  ngOnInit(): void {
    this.initializeNotifiche();
  }

  private initializeNotifiche() {
    this.aService.getNotifiche().subscribe((n) => {
      this.notifiche = n;
    });
  }

  onLogout() {
    this.aService.logout().subscribe(() => {
      this.router.navigate(['/login'])
      sessionStorage.clear()
    })
  }

}

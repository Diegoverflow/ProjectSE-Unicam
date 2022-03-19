import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { lastValueFrom } from 'rxjs';
import { AuthenticationService } from '../authentication/service/authentication.service';
import { Notifica } from '../model/notifica';
import { OrdinazioneBar } from '../model/ordinazione-bar';
import { StatusOrdinazioneBar } from '../model/status-ordinazione';
import { AddettoBarService } from '../service/addetto-bar.service';

@Component({
  selector: 'app-addetto-bar-home',
  templateUrl: './addetto-bar-home.component.html',
  styleUrls: ['./addetto-bar-home.component.scss']
})
export class AddettoBarHomeComponent implements OnInit {

  notifiche: Notifica[] = new Array();

  constructor(private addettoService: AddettoBarService, private router: Router, private aService: AuthenticationService) {
  }

  ngOnInit(): void {
    console.log(this.aService.getNotifiche().subscribe((n) => {
      this.notifiche = n;
    }));
  }

  onLogout() {
    this.aService.logout().subscribe(() => {
      this.router.navigate(['/login'])
      sessionStorage.clear()
    })
  }

  

  // TODO: serve solo al gestore misa
  // async eliminaOrdinazione(o: OrdinazioneBar) {
  //   if (this.askConfirm("eliminare", "eliminata"))
  //     await lastValueFrom(this.addettoService.removeOrdinazione(o.id)).then(() => {
  //       this.getOrdinazioniByStatus(this.selectedStatus);
  //     })
  // }

  

}

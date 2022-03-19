import { AfterViewInit, Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication/service/authentication.service';
import { Notifica } from '../model/notifica';

@Component({
  selector: 'app-notifica',
  templateUrl: './notifica.component.html',
  styleUrls: ['./notifica.component.scss']
})
export class NotificaComponent implements OnInit, AfterViewInit {

  notifiche: Notifica[] = new Array();

  constructor(private aService: AuthenticationService) { }

  ngAfterViewInit(): void {
    this.getNotifiche();
  }

  ngOnInit(): void {
    this.getNotifiche();
  }

  getNotifiche() {
    this.aService.getNotifiche().subscribe(n => {
      this.notifiche = n;
      console.log(this.notifiche);
    });
  }

}

import { AfterViewInit, Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';
import { Notifica } from '../model/notifica';

@Component({
  selector: 'app-notifica',
  templateUrl: './notifica.component.html',
  styleUrls: ['./notifica.component.scss']
})
export class NotificaComponent implements OnInit, AfterViewInit {

  notifiche: Notifica[] = new Array();

  constructor(private aService: AuthenticationService) { }

  ngOnInit(): void {
    this.getNotifiche();
  }

  ngAfterViewInit(): void {
    this.getNotifiche();
  }

  getNotifiche() {
    this.aService.getNotifiche().subscribe(n => {
      this.notifiche = n;
    });
  }

}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-cliente-home',
  templateUrl: './cliente-home.component.html',
  styleUrls: ['./cliente-home.component.scss']
})
export class ClienteHomeComponent implements OnInit {

  constructor(private router: Router, private authenticationService: AuthenticationService) { }

  onLogout() {
    this.authenticationService.logout().subscribe(() => {
      this.router.navigate(['/login'])
      sessionStorage.clear()
    })
  }

  ngOnInit(): void {
  }

}

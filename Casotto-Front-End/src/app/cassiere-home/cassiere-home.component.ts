import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { catchError, EMPTY } from 'rxjs';
import { AuthenticationService } from '../authentication/service/authentication.service';
import { Vendita } from '../model/vendita';
import { CassiereService } from '../service/cassiere.service';

@Component({
  selector: 'app-cassiere-home',
  templateUrl: './cassiere-home.component.html',
  styleUrls: ['./cassiere-home.component.scss']
})
export class CassiereHomeComponent implements OnInit {

  private _isSearchFormVisible!: boolean;

  private _searchForm!: FormGroup;

  private _vendite !: Vendita[];

  constructor(private builer: FormBuilder, 
    private cassiereService: CassiereService,
    private authenticationService : AuthenticationService,
    private router: Router) { }

  ngOnInit(): void {
    this._vendite = [];
    this._isSearchFormVisible = true;
    this._searchForm = this.builer.group({
      email: ['', Validators.required],
    });
  }

  get vendite(){
    return this._vendite;
  }
  get searchForm() {
    return this._searchForm;
  }

  get isSearchFormVisible() {
    return this._isSearchFormVisible;
  }


  set isSearchFormVisible(b: boolean) {
    this._isSearchFormVisible = b;
  }


  onSearch(): void {
    if (this.searchForm.get('email')?.value === '') {
      alert('email vuota')
      return
    }
    this.cassiereService.getVenditeDaPagare(this.searchForm.get('email')?.value)
      .pipe(catchError((e: HttpErrorResponse) => { alert('email invalida'); return EMPTY }))
      .subscribe(v => {this._vendite = v; this.isSearchFormVisible = false})
  }

  onSaldaVendita(vendita : Vendita){
    this.cassiereService.saldaVendita(vendita).subscribe();
  }

  onLogout() {
    this.authenticationService.logout().subscribe(() => {
      this.router.navigate(['/login'])
      sessionStorage.clear()
    })
  }

}

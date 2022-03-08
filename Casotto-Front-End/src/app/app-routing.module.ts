import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RigheOmbrelloniComponent } from './righe-ombrelloni/righe-ombrelloni.component';
import { RigheBarComponent } from './righe-bar/righe-bar.component';
import { RigaAttiviaComponent } from './attivita/riga-attivita/riga-attivita.component';
import { AuthenticationComponent } from './authentication/component/authentication.component';
import { GestoreHomeComponent } from './gestore-home/gestore-home.component'
import { AuthGuard } from './helpers/auth-guard';
import { ClienteHomeComponent } from './cliente-home/cliente-home.component';
import { PrenotazioneOmbrelloneComponent } from './prenotazione-ombrellone/prenotazione-ombrellone.component';
import { PrenotazioneAttivitaComponent } from './prenotazione-attivita/prenotazione-attivita.component';
import { OrdinazioneBarComponent } from './ordinazione-bar/ordinazione-bar.component';
import { CassiereHomeComponent } from './cassiere-home/cassiere-home.component';
import { AddettoBarHomeComponent } from './addetto-bar-home/addetto-bar-home.component';

// TODO: modificare sul backend le routes righe ombrelloni(etc) da ../catalgo/ombrelloni(etc) 
// in --> ../catalogo-ombelloni
//TODO: inserie redirect e NOTFOUND
const routes: Routes = [
  { path: 'login', component: AuthenticationComponent },
  {
    path: 'cliente-home',
    component: ClienteHomeComponent,
    canActivate: [AuthGuard],
    canActivateChild: [AuthGuard],
    data: { ruolo: 'CLIENTE' },
    children: [
      { path: 'prenotazione-ombrellone', component: PrenotazioneOmbrelloneComponent },
      { path: 'prenotazione-attivita', component: PrenotazioneAttivitaComponent },
      { path: 'ordinazione-bar', component: OrdinazioneBarComponent }
    ]
  },
  
  {
    path: 'gestore-home',
    component: GestoreHomeComponent,
    canActivate: [AuthGuard],
    canActivateChild: [AuthGuard],
    data: { ruolo: 'GESTORE' },
    children: [
      { path: 'catalogo-bar', component: RigheBarComponent },
      { path: 'catalogo-attivita', component: RigaAttiviaComponent },
      { path: 'catalogo-ombrelloni', component: RigheOmbrelloniComponent },
    ]
  },

  {
    path: 'cassiere-home',
    component: CassiereHomeComponent,
    canActivate: [AuthGuard],
    canActivateChild: [AuthGuard],
    data: { ruolo: 'CASSIERE' },
    children: [
    ]
  },

  {
    path: 'addetto-bar-home',
    component: AddettoBarHomeComponent,
    canActivate: [AuthGuard],
    canActivateChild: [AuthGuard],
    data: { ruolo: 'ADDETTO_BAR' },
    children: [
    ]
  },

  { path: '**', redirectTo: 'login' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

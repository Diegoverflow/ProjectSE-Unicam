import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RigaAttiviaComponent } from './attivita/riga-attivita/riga-attivita.component';
import { RigaBarComponent } from './bar/riga-bar/riga-bar.component';
import { AuthenticationComponent } from './authentication/component/authentication.component';
import { GestoreHomeComponent } from './gestore-home/gestore-home.component'
import { HomeGuard } from './helpers/home-guard';
import { ClienteHomeComponent } from './cliente-home/cliente-home.component';
import { PrenotazioneOmbrelloneComponent } from './prenotazione-ombrellone/prenotazione-ombrellone.component';
import { PrenotazioneAttivitaComponent } from './prenotazione-attivita/prenotazione-attivita.component';
import { OrdinazioneBarComponent } from './ordinazione-bar/ordinazione-bar.component';
import { CassiereHomeComponent } from './cassiere-home/cassiere-home.component';
import { AddettoBarHomeComponent } from './addetto-bar-home/addetto-bar-home.component';
import { LoginGuard } from './helpers/login-guard';
import { RigaOmbrelloneComponent } from './spiaggia/riga-ombrellone/riga-ombrellone.component';
import { OrdinazioneBarStoricoComponent } from './ordinazione-bar/ordinazione-bar-storico/ordinazione-bar-storico.component';
import { LeMiePrenotazioniOmbrelloniComponent } from './prenotazione-ombrellone/le-mie-prenotazioni-ombrelloni/le-mie-prenotazioni-ombrelloni.component';
import { LeMiePrenotazioniAttivitaComponent } from './prenotazione-attivita/le-mie-prenotazioni-attivita/le-mie-prenotazioni-attivita.component';
import { ProfiloComponent } from './profilo/profilo.component';
import { NotificaComponent } from './notifica/notifica.component';
import { AddettoBarOrdinazioniComponent } from './addetto-bar-home/addetto-bar-ordinazioni/addetto-bar-ordinazioni.component';
import { HomeComponent } from './home/home.component';
import { InfrastrutturaChaletComponent } from './infrastruttura-chalet/infrastruttura-chalet.component';

const routes: Routes = [
  { path: 'login', component: AuthenticationComponent, canActivate: [LoginGuard] },
  { path: 'home', component: HomeComponent, canActivate: [LoginGuard] },
  { path: 'aree-infrastruttura', component: InfrastrutturaChaletComponent, canActivate: [LoginGuard] },
  {
    path: 'cliente-home',
    component: ClienteHomeComponent,
    canActivate: [HomeGuard],
    canActivateChild: [HomeGuard],
    data: { ruolo: 'CLIENTE' },
    children: [
      { path: 'prenotazione-ombrellone', component: PrenotazioneOmbrelloneComponent },
      { path: 'le-mie-prenotazioni-ombrelloni', component: LeMiePrenotazioniOmbrelloniComponent },
      { path: 'prenotazione-attivita', component: PrenotazioneAttivitaComponent },
      { path: 'le-mie-prenotazioni-attivita', component: LeMiePrenotazioniAttivitaComponent },
      { path: 'ordinazione-bar', component: OrdinazioneBarComponent },
      { path: 'ordinazione-bar-storico', component: OrdinazioneBarStoricoComponent },
      { path: 'profilo', component: ProfiloComponent },
      { path: 'notifica', component: NotificaComponent }
    ]
  },

  {
    path: 'gestore-home',
    component: GestoreHomeComponent,
    canActivate: [HomeGuard],
    canActivateChild: [HomeGuard],
    data: { ruolo: 'GESTORE' },
    children: [
      { path: 'catalogo-bar', component: RigaBarComponent },
      { path: 'catalogo-attivita', component: RigaAttiviaComponent },
      { path: 'catalogo-ombrelloni', component: RigaOmbrelloneComponent },
      { path: 'profilo', component: ProfiloComponent },
      { path: 'notifica', component: NotificaComponent }
    ]
  },

  {
    path: 'cassiere-home',
    component: CassiereHomeComponent,
    canActivate: [HomeGuard],
    canActivateChild: [HomeGuard],
    data: { ruolo: 'CASSIERE' },
    children: [
      { path: 'profilo', component: ProfiloComponent },
      { path: 'notifica', component: NotificaComponent }
    ]
  },

  {
    path: 'addetto-bar-home',
    component: AddettoBarHomeComponent,
    canActivate: [HomeGuard],
    canActivateChild: [HomeGuard],
    data: { ruolo: 'ADDETTO_BAR' },
    children: [
      { path: 'profilo', component: ProfiloComponent },
      { path: 'notifica', component: NotificaComponent },
      { path: 'addetto-ordinazioni', component: AddettoBarOrdinazioniComponent }
    ]
  },

  { path: '**', redirectTo: 'home' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

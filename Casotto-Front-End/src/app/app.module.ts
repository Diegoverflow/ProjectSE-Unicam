import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'; // <-- NgModel lives here
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RigheOmbrelloniComponent } from './righe-ombrelloni/righe-ombrelloni.component';
import { RigaOmbrelloneEditorComponent } from './riga-ombrellone-editor/riga-ombrellone-editor.component';
import { RigheBarComponent } from './righe-bar/righe-bar.component';
import { RigaBarEditorComponent } from './riga-bar-editor/riga-bar-editor.component';
import { RigaAttiviaComponent } from './attivita/riga-attivita/riga-attivita.component';
import { RigaAttivitaEditorComponent } from './attivita/riga-attivita-editor/riga-attivita-editor.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthenticationService } from './authentication/service/authentication.service';
import { AuthenticationComponent } from './authentication/component/authentication.component';
import { GestoreHomeComponent} from './gestore-home/gestore-home.component';
import { ClienteHomeComponent } from './cliente-home/cliente-home.component';
import { PrenotazioneOmbrelloneComponent } from './prenotazione-ombrellone/prenotazione-ombrellone.component';
import { PrenotazioneAttivitaComponent } from './prenotazione-attivita/prenotazione-attivita.component';
import { OrdinazioneBarComponent } from './ordinazione-bar/ordinazione-bar.component';
import { DefaultHttpInterceptor } from './helpers/http-interceptor';
import { CassiereHomeComponent } from './cassiere-home/cassiere-home.component';
import { AddettoBarHomeComponent } from './addetto-bar-home/addetto-bar-home.component';
import { LoginGuard } from './helpers/login-guard';


@NgModule({
  declarations: [
    AppComponent,
    RigheOmbrelloniComponent,
    RigaOmbrelloneEditorComponent,
    RigheBarComponent,
    RigaBarEditorComponent,
    RigaAttiviaComponent,
    RigaAttivitaEditorComponent,
    AuthenticationComponent,
    GestoreHomeComponent,
    ClienteHomeComponent,
    PrenotazioneOmbrelloneComponent,
    PrenotazioneAttivitaComponent,
    OrdinazioneBarComponent,
    CassiereHomeComponent,
    AddettoBarHomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    AuthenticationService,
    LoginGuard,
    LoginGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: DefaultHttpInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

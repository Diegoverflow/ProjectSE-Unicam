import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RigheOmbrelloniComponent } from './righe-ombrelloni/righe-ombrelloni.component';
import { RigaOmbrelloneEditorComponent } from './riga-ombrellone-editor/riga-ombrellone-editor.component';
import { RigheBarComponent } from './righe-bar/righe-bar.component';
import { RigaBarEditorComponent } from './riga-bar-editor/riga-bar-editor.component';
import { RigaAttiviaComponent } from './attivita/riga-attivita/riga-attivita.component';
import { RigaAttivitaEditorComponent } from './attivita/riga-attivita-editor/riga-attivita-editor.component';

@NgModule({
  declarations: [
    AppComponent,
    RigheOmbrelloniComponent,
    RigaOmbrelloneEditorComponent,
    RigheBarComponent,
    RigaBarEditorComponent,
    RigaAttiviaComponent,
    RigaAttivitaEditorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

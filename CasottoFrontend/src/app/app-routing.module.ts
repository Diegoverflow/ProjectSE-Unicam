import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RigheOmbrelloniComponent } from './righe-ombrelloni/righe-ombrelloni.component';
import { RigheBarComponent } from './righe-bar/righe-bar.component';
import { RigaAttiviaComponent } from './attivita/riga-attivita/riga-attivita.component';

// TODO: modificare sul backend le routes righe ombrelloni(etc) da ../catalgo/ombrelloni(etc) 
// in --> ../catalogo-ombelloni
//TODO: inserie redirect e NOTFOUND
const routes: Routes = [
  { path: 'catalogo-bar', component: RigheBarComponent },
  { path: 'catalogo-attivita', component: RigaAttiviaComponent },
  { path: 'catalogo-ombrelloni', 
    component: RigheOmbrelloniComponent,
    //children: [
    //  { path: 'riga-editor', component: RigaOmbrelloneEditorComponent, }
    //]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

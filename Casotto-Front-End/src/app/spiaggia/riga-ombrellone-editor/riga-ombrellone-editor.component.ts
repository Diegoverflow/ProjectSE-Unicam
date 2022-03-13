import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { RigaCatalogoOmbrellone } from 'src/app/model/riga-catalogo-ombrellone';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { RigheOmbrelloniService } from '../righe-ombrelloni.service';
import { CategoriaOmbrellone } from 'src/app/categoria-ombrellone';

@Component({
  selector: 'app-riga-ombrellone-editor',
  templateUrl: './riga-ombrellone-editor.component.html',
  styleUrls: ['./riga-ombrellone-editor.component.scss']
})
export class RigaOmbrelloneEditorComponent implements OnInit {

  title: string = 'Editor riga catalogo ombrelloni';

  @Output() rigaAggiunta = new EventEmitter<RigaCatalogoOmbrellone>();

  categorie : CategoriaOmbrellone[] = [CategoriaOmbrellone.STANDARD,
                                       CategoriaOmbrellone.VIP, 
                                       CategoriaOmbrellone.PREMIUM]

  rigaForm = new FormGroup({
    valore : new FormGroup({
      categoria : new FormControl('categoria ombrellone', Validators.required),
      codiceSpiaggia : new FormControl('codice spiaggia')
    }),
    prezzoOmbrellone : new FormControl(10)
  })


  save(){
    this.righeOmbrelloniService.addRiga(this.rigaForm.value)
      .subscribe(rigaConId => this.rigaAggiunta.emit(rigaConId))
  }

  constructor(private righeOmbrelloniService : RigheOmbrelloniService) { }

  ngOnInit(): void {
  }

}

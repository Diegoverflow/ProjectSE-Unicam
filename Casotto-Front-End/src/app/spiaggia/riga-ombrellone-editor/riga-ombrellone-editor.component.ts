import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { RigaCatalogoOmbrellone } from 'src/app/model/riga-catalogo-ombrellone';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { RigheOmbrelloniService } from '../../service/righe-ombrelloni.service';
import { CategoriaOmbrellone } from 'src/app/categoria-ombrellone';
import { AskConfirmService } from 'src/app/service/ask-confirm.service';

@Component({
  selector: 'app-riga-ombrellone-editor',
  templateUrl: './riga-ombrellone-editor.component.html',
  styleUrls: ['./riga-ombrellone-editor.component.scss']
})
export class RigaOmbrelloneEditorComponent implements OnInit {

  title: string = 'Aggiungi Un Ombrellone Al Catalogo Ombrelloni';

  @Output() rigaAggiunta = new EventEmitter<RigaCatalogoOmbrellone>();

  categorie: CategoriaOmbrellone[] = [CategoriaOmbrellone.STANDARD,
  CategoriaOmbrellone.VIP,
  CategoriaOmbrellone.PREMIUM]

  rigaForm = new FormGroup({
    valore: new FormGroup({
      categoria: new FormControl(CategoriaOmbrellone.STANDARD, Validators.required),
      codiceSpiaggia: new FormControl('1')
    }),
    prezzoOmbrellone: new FormControl(10)
  })


  save() {
    if (this.askService.askConfirm("salvare", "salvato", "l'", "ombrellone", "selezionato"))
      this.righeOmbrelloniService.addRiga(this.rigaForm.value)
        .subscribe(rigaConId => this.rigaAggiunta.emit(rigaConId))
  }

  constructor(private righeOmbrelloniService: RigheOmbrelloniService, private askService : AskConfirmService) { }

  ngOnInit(): void {
  }

}

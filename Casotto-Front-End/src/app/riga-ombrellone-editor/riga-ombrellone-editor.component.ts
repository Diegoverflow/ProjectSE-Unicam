import { Component, OnInit } from '@angular/core';
import { RigaCatalogoOmbrellone } from '../riga-catalogo-ombrellone';
import { RigheOmbrelloniService } from '../righe-ombrelloni.service';
import { Ombrellone } from '../ombrellone';
import { CategoriaOmbrellone } from '../categoria-ombrellone';

//import { ActivatedRoute } from '@angular/router';
//import { Location } from '@angular/common';

@Component({
  selector: 'app-riga-ombrellone-editor',
  templateUrl: './riga-ombrellone-editor.component.html',
  styleUrls: ['./riga-ombrellone-editor.component.scss']
})
export class RigaOmbrelloneEditorComponent implements OnInit {

  //saveIsAvaiable: boolean = true;

  categorie:CategoriaOmbrellone[] =
   [CategoriaOmbrellone.PREMIUM, CategoriaOmbrellone.VIP, CategoriaOmbrellone.STANDARD]

  ombrelloneDaAggiungere = new Ombrellone ( this.categorie[2], "inserisci codice")

  nuovaRiga = new RigaCatalogoOmbrellone(this.ombrelloneDaAggiungere, 10);

  //FIXME: aggiustare il save
  save(): void{
    let rigaDaAggiungere: RigaCatalogoOmbrellone = 
                                              new RigaCatalogoOmbrellone
                                                  ( new Ombrellone( this.nuovaRiga.ombrellone.categoria, 
                                                                    this.nuovaRiga.ombrellone.codiceSpiaggia),
                                                    this.nuovaRiga.prezzo, )
    this._righeOmbrelloniService.addRiga(rigaDaAggiungere);
  }

  constructor(private _righeOmbrelloniService: RigheOmbrelloniService,
              /*private route: ActivatedRoute,  
              private location: Location*/) {
               } 

  ngOnInit(): void {
  }

}
  
  

  /*
  rigaForm = new FormGroup({
    prezzoOmbrellone : new FormControl('', Validators.required),
    ombrelloneForm : new FormGroup({
      categoriaOmbrellone : new FormControl('', Validators.required),
      //FIXME: appena si ha il service per ottenere un codice spiaggia rimpiazzare con quello
      codiceSpiaggiaOmbrellone : new FormControl('', Validators.required)
    })
  });*/

  
  

 

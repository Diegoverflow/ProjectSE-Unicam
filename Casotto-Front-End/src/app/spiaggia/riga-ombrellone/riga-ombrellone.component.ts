import { Component, OnInit } from '@angular/core';
import { RigaCatalogoOmbrellone } from 'src/app/model/riga-catalogo-ombrellone';
import { RigheOmbrelloniService } from '../righe-ombrelloni.service';

import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-riga-ombrellone',
  templateUrl: './riga-ombrellone.component.html',
  styleUrls: ['./riga-ombrellone.component.scss']
})
export class RigaOmbrelloneComponent implements OnInit {

  public righe? : RigaCatalogoOmbrellone[];

  title : string = "Catalogo Ombrelloni"

  constructor(private righeOmbrelloniService: RigheOmbrelloniService,
              private route: ActivatedRoute,  
              private location: Location,     
              private router: Router) { }

  public getRigheOmbrelloni() : void {
    this.righeOmbrelloniService.getRighe().subscribe(r => this.righe = r)
  }

  public rigaOmbrelloneAggiunta(rigaAggiunta : RigaCatalogoOmbrellone) {
    this.righe?.push(rigaAggiunta)
  }

  eliminaRiga(rigaDaEliminare : RigaCatalogoOmbrellone) {
    this.righeOmbrelloniService.removeRiga(rigaDaEliminare.id).subscribe(() => this.getRigheOmbrelloni())
  }

  ngOnInit(): void {
    this.getRigheOmbrelloni()
  }

}

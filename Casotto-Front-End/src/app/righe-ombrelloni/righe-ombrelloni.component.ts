import { Component, OnInit } from '@angular/core';
import { RIGHEOMBRELLONI } from './mock-righeombrelloni';
import { RigaCatalogoOmbrellone } from './riga-catalogo-ombrellone';
import { RigheOmbrelloniService } from './righe-ombrelloni.service';

import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';


@Component({
  selector: 'app-righe-ombrelloni',
  templateUrl: './righe-ombrelloni.component.html',
  styleUrls: ['./righe-ombrelloni.component.scss']
})
export class RigheOmbrelloniComponent implements OnInit {

  title: string = 'Catalogo Ombrelloni'

  private _righeCatalogoOmbrelloni: RigaCatalogoOmbrellone[] = RIGHEOMBRELLONI

  constructor(private righeOmbrelloniService: RigheOmbrelloniService,
              private route: ActivatedRoute,  
              private location: Location,
              private router: Router ) {}

  ngOnInit(): void {
    this.righeOmbrelloniService.getRighe()
      .subscribe(righe => this._righeCatalogoOmbrelloni = righe);
  }

  get righeCatalogoOmbrelloni(): RigaCatalogoOmbrellone[]{
    return this._righeCatalogoOmbrelloni;
  }

  eliminaRiga(rigaCatalogoOmbrellone: RigaCatalogoOmbrellone){
    this.righeOmbrelloniService.removeRiga(rigaCatalogoOmbrellone);
  }

}

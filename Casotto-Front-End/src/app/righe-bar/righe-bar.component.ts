import { Component, OnInit } from '@angular/core';
import { RIGHEBAR } from './mock-righebar';
import { RigaCatalogoBar } from './riga-catalogo-bar';
import { RigheBarService } from './righe-bar.service';

import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-righe-bar',
  templateUrl: './righe-bar.component.html',
  styleUrls: ['./righe-bar.component.scss']
})
export class RigheBarComponent implements OnInit {

  title: string = 'Catalogo Bar'

  private _righeCatalogoBar: RigaCatalogoBar[] = RIGHEBAR

  constructor(private righeBarSerivice: RigheBarService,
              private route: ActivatedRoute,  
              private location: Location,     
              private router: Router) {}

  ngOnInit(): void {
    this.righeBarSerivice.getRighe().
      subscribe(righe => this._righeCatalogoBar = righe)
  }

  get righeCatalogoBar(): RigaCatalogoBar[] { return this._righeCatalogoBar }

  eliminaRiga(riga: RigaCatalogoBar){
    this.righeBarSerivice.removeRiga(riga)
  }

}

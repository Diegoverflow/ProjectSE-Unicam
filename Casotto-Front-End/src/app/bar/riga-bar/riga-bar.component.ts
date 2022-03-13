import { Component, OnInit } from '@angular/core';
import { RigaCatalogoBar } from '../riga-catalogo-bar';
import { RigheBarService } from '../righe-bar.service';

import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-riga-bar',
  templateUrl: './riga-bar.component.html',
  styleUrls: ['./riga-bar.component.scss']
})
export class RigaBarComponent implements OnInit {

  public righe? : RigaCatalogoBar[];

  title : string = "Catalogo Bar"

  constructor(private righeBarService: RigheBarService,
              private route: ActivatedRoute,  
              private location: Location,     
              private router: Router) { }

  public getRigheBar() : void {
    this.righeBarService.getRighe().subscribe(r => this.righe = r)
  }

  public rigaBarAggiunta(rigaAggiunta : RigaCatalogoBar) {
    this.righe?.push(rigaAggiunta)
  }

  eliminaRiga(rigaDaEliminare : RigaCatalogoBar) {
    this.righeBarService.removeRiga(rigaDaEliminare.id).subscribe(() => this.getRigheBar())
  }

  ngOnInit(): void {
    this.getRigheBar()
  }

}

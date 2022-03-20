import { Component, OnInit } from '@angular/core';
import { RigaCatalogoOmbrellone } from 'src/app/model/riga-catalogo-ombrellone';
import { RigheOmbrelloniService } from 'src/app/service/righe-ombrelloni.service';

import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';
import { AskConfirmService } from 'src/app/service/ask-confirm.service';

@Component({
  selector: 'app-riga-ombrellone',
  templateUrl: './riga-ombrellone.component.html',
  styleUrls: ['./riga-ombrellone.component.scss']
})
export class RigaOmbrelloneComponent implements OnInit {

  public righe?: RigaCatalogoOmbrellone[];

  title: string = "Catalogo Ombrelloni"

  constructor(private righeOmbrelloniService: RigheOmbrelloniService,
    private route: ActivatedRoute,
    private location: Location,
    private router: Router,
    private askService: AskConfirmService) { }

  public getRigheOmbrelloni(): void {
    this.righeOmbrelloniService.getRighe().subscribe(r => this.righe = r)
  }

  public rigaOmbrelloneAggiunta(rigaAggiunta: RigaCatalogoOmbrellone) {
    this.righe?.push(rigaAggiunta)
  }

  eliminaRiga(rigaDaEliminare: RigaCatalogoOmbrellone) {
    if (this.askService.askConfirm("eliminare", "eliminato", "l'", "ombrellone", "selezionato"))
      this.righeOmbrelloniService.removeRiga(rigaDaEliminare.id).subscribe(() => this.getRigheOmbrelloni())
  }

  ngOnInit(): void {
    this.getRigheOmbrelloni()
  }

}

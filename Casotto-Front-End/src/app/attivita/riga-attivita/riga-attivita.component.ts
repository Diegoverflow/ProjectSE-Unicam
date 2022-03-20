import { Component, OnInit } from '@angular/core';
import { RigaCatalogoAttivita } from 'src/app/model/riga-catalogo-attivita';
import { RigheAttivitaService } from 'src/app/service/righe-attivita.service';
import { AskConfirmService } from 'src/app/service/ask-confirm.service';

@Component({
  selector: 'app-riga-attivita',
  templateUrl: './riga-attivita.component.html',
  styleUrls: ['./riga-attivita.component.scss']
})
export class RigaAttiviaComponent implements OnInit {

  public righe?: RigaCatalogoAttivita[];

  constructor(private righeAttivitaService: RigheAttivitaService,
    private askService: AskConfirmService) {
  }

  ngOnInit(): void {
    this.getRigheAttivita();
  }

  public getRigheAttivita(): void {
    this.righeAttivitaService.getRighe().subscribe(r => { this.righe = r });
  }

  public rigaAttivitaAggiunta(rigaAggiunta: RigaCatalogoAttivita) {
    this.righe?.push(rigaAggiunta);
  }

  eliminaRiga(riga: RigaCatalogoAttivita) {
    if (this.askService.askConfirm("eliminare", "eliminata", "l'", "Attività", "selezionata"))
      this.righeAttivitaService.removeRiga(riga.id).subscribe(() => this.getRigheAttivita())
  }

}

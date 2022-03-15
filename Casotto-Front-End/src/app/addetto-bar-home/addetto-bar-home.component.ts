import { Component, OnInit } from '@angular/core';
import { OrdinazioneBar } from '../model/ordinazione-bar';
import { StatusOrdinazioneBar } from '../model/status-ordinazione';
import { AddettoBarService } from '../service/addetto-bar.service';

@Component({
  selector: 'app-addetto-bar-home',
  templateUrl: './addetto-bar-home.component.html',
  styleUrls: ['./addetto-bar-home.component.scss']
})
export class AddettoBarHomeComponent implements OnInit {

  private ordinazioniBar : OrdinazioneBar[] = new Array();

  constructor(private addettoService : AddettoBarService) { }

  ngOnInit(): void {
    this.addettoService.getAllOrdinazioniBy(StatusOrdinazioneBar.DA_PRENDERE_IN_CARICO).subscribe(o=>{
      this.ordinazioniBar = o;
      console.log(this.ordinazioniBar);
    })
    
  }

}

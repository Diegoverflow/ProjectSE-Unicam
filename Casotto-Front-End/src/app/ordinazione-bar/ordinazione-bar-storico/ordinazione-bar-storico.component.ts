import { AfterViewInit, Component, OnInit } from '@angular/core';
import { OrdinazioneBar } from 'src/app/model/ordinazione-bar';
import { OrdinazioneBarService } from 'src/app/service/ordinazione-bar.service';

@Component({
  selector: 'app-ordinazione-bar-storico',
  templateUrl: './ordinazione-bar-storico.component.html',
  styleUrls: ['./ordinazione-bar-storico.component.scss']
})
export class OrdinazioneBarStoricoComponent implements OnInit, AfterViewInit {

  storicoOrdinazioni: OrdinazioneBar[] = new Array();

  constructor(private barService: OrdinazioneBarService) { }

  ngAfterViewInit(): void {
    this.getOrdinazioniDaPagare();
  }

  ngOnInit(): void {
  }

  getOrdinazioniDaPagare() {
    this.barService.getOrdinazioniDaPagare().subscribe(o => {
      this.storicoOrdinazioni = o;
    })
  }

}

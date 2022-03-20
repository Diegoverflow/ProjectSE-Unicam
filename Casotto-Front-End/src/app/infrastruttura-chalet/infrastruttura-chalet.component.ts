import { Component, OnInit } from '@angular/core';
import { AreaInfrastruttura } from '../model/area-infrastruttura';
import { InfrastrutturaChaletService } from '../service/infrastruttura-chalet.service';

@Component({
  selector: 'app-infrastruttura-chalet',
  templateUrl: './infrastruttura-chalet.component.html',
  styleUrls: ['./infrastruttura-chalet.component.scss']
})
export class InfrastrutturaChaletComponent implements OnInit {

  aree: AreaInfrastruttura[] = new Array();

  constructor(private infrastrutturaService: InfrastrutturaChaletService) { }

  ngOnInit(): void {
    this.getAreeInfrastruttura();
  }

  getAreeInfrastruttura() {
    this.infrastrutturaService.getAree().subscribe(a => {
      this.aree = a;
    });
  }


}

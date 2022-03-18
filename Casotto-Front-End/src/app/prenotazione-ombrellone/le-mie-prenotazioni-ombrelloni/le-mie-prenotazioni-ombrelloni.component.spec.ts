import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeMiePrenotazioniOmbrelloniComponent } from './le-mie-prenotazioni-ombrelloni.component';

describe('LeMiePrenotazioniOmbrelloniComponent', () => {
  let component: LeMiePrenotazioniOmbrelloniComponent;
  let fixture: ComponentFixture<LeMiePrenotazioniOmbrelloniComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LeMiePrenotazioniOmbrelloniComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LeMiePrenotazioniOmbrelloniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

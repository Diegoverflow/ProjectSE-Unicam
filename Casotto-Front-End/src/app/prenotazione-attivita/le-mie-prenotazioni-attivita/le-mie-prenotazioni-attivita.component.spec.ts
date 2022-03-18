import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeMiePrenotazioniAttivitaComponent } from './le-mie-prenotazioni-attivita.component';

describe('LeMiePrenotazioniAttivitaComponent', () => {
  let component: LeMiePrenotazioniAttivitaComponent;
  let fixture: ComponentFixture<LeMiePrenotazioniAttivitaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LeMiePrenotazioniAttivitaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LeMiePrenotazioniAttivitaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

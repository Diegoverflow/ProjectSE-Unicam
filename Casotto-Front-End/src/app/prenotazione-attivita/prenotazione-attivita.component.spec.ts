import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrenotazioneAttivitaComponent } from './prenotazione-attivita.component';

describe('PrenotazioneAttivitaComponent', () => {
  let component: PrenotazioneAttivitaComponent;
  let fixture: ComponentFixture<PrenotazioneAttivitaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrenotazioneAttivitaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PrenotazioneAttivitaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

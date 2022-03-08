import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrenotazioneOmbrelloneComponent } from './prenotazione-ombrellone.component';

describe('PrenotazioneOmbrelloneComponent', () => {
  let component: PrenotazioneOmbrelloneComponent;
  let fixture: ComponentFixture<PrenotazioneOmbrelloneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrenotazioneOmbrelloneComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PrenotazioneOmbrelloneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

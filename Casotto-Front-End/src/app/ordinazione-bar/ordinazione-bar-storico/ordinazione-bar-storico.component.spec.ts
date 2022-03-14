import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdinazioneBarStoricoComponent } from './ordinazione-bar-storico.component';

describe('OrdinazioneBarStoricoComponent', () => {
  let component: OrdinazioneBarStoricoComponent;
  let fixture: ComponentFixture<OrdinazioneBarStoricoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrdinazioneBarStoricoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrdinazioneBarStoricoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

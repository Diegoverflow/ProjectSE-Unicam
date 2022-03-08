import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdinazioneBarComponent } from './ordinazione-bar.component';

describe('OrdinazioneBarComponent', () => {
  let component: OrdinazioneBarComponent;
  let fixture: ComponentFixture<OrdinazioneBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrdinazioneBarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrdinazioneBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

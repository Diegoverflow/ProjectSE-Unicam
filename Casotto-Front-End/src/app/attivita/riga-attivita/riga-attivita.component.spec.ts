import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RigaAttiviaComponent } from './riga-attivita.component';

describe('RigaAttiviaComponent', () => {
  let component: RigaAttiviaComponent;
  let fixture: ComponentFixture<RigaAttiviaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RigaAttiviaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RigaAttiviaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

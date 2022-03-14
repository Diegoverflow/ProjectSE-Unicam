import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VenditaComponent } from './vendita.component';

describe('VenditaComponent', () => {
  let component: VenditaComponent;
  let fixture: ComponentFixture<VenditaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VenditaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VenditaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

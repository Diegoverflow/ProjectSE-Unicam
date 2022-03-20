import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfrastrutturaChaletComponent } from './infrastruttura-chalet.component';

describe('InfrastrutturaChaletComponent', () => {
  let component: InfrastrutturaChaletComponent;
  let fixture: ComponentFixture<InfrastrutturaChaletComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InfrastrutturaChaletComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InfrastrutturaChaletComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

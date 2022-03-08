import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestoreHomeComponent } from './gestore-home.component';

describe('HomeComponentComponent', () => {
  let component: GestoreHomeComponent;
  let fixture: ComponentFixture<GestoreHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GestoreHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GestoreHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

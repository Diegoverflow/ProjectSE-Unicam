import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RigaBarComponent } from './riga-bar.component';

describe('RigaBarComponent', () => {
  let component: RigaBarComponent;
  let fixture: ComponentFixture<RigaBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RigaBarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RigaBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

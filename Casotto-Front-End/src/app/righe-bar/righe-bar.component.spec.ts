import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RigheBarComponent } from './righe-bar.component';

describe('RigheBarComponent', () => {
  let component: RigheBarComponent;
  let fixture: ComponentFixture<RigheBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RigheBarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RigheBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

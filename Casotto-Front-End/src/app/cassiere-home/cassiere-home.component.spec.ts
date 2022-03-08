import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CassiereHomeComponent } from './cassiere-home.component';

describe('CassiereHomeComponent', () => {
  let component: CassiereHomeComponent;
  let fixture: ComponentFixture<CassiereHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CassiereHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CassiereHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

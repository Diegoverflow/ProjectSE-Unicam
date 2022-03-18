import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CasottoNavbarComponent } from './casotto-navbar.component';

describe('CasottoNavbarComponent', () => {
  let component: CasottoNavbarComponent;
  let fixture: ComponentFixture<CasottoNavbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CasottoNavbarComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CasottoNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

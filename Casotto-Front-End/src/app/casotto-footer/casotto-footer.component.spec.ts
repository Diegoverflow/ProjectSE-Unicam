import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CasottoFooterComponent } from './casotto-footer.component';

describe('CasottoFooterComponent', () => {
  let component: CasottoFooterComponent;
  let fixture: ComponentFixture<CasottoFooterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CasottoFooterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CasottoFooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

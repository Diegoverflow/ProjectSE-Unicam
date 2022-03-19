import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddettoBarOrdinazioniComponent } from './addetto-bar-ordinazioni.component';

describe('AddettoBarOrdinazioniComponent', () => {
  let component: AddettoBarOrdinazioniComponent;
  let fixture: ComponentFixture<AddettoBarOrdinazioniComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddettoBarOrdinazioniComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddettoBarOrdinazioniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

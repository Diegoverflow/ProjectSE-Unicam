import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddettoBarHomeComponent } from './addetto-bar-home.component';

describe('AddettoBarHomeComponent', () => {
  let component: AddettoBarHomeComponent;
  let fixture: ComponentFixture<AddettoBarHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddettoBarHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddettoBarHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

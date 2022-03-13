import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RigaOmbrelloneComponent } from './riga-ombrellone.component';

describe('RigaOmbrelloneComponent', () => {
  let component: RigaOmbrelloneComponent;
  let fixture: ComponentFixture<RigaOmbrelloneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RigaOmbrelloneComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RigaOmbrelloneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

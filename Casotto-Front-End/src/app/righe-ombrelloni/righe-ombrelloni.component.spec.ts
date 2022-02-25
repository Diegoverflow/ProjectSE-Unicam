import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RigheOmbrelloniComponent } from './righe-ombrelloni.component';

describe('RigheOmbrelloniComponent', () => {
  let component: RigheOmbrelloniComponent;
  let fixture: ComponentFixture<RigheOmbrelloniComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RigheOmbrelloniComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RigheOmbrelloniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

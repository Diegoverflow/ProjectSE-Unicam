import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RigaBarEditorComponent } from './riga-bar-editor.component';

describe('RigaBarEditorComponent', () => {
  let component: RigaBarEditorComponent;
  let fixture: ComponentFixture<RigaBarEditorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RigaBarEditorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RigaBarEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

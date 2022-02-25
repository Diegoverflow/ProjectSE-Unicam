import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RigaAttivitaEditorComponent } from './riga-attivita-editor.component';

describe('RigaAttivitaEditorComponent', () => {
  let component: RigaAttivitaEditorComponent;
  let fixture: ComponentFixture<RigaAttivitaEditorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RigaAttivitaEditorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RigaAttivitaEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

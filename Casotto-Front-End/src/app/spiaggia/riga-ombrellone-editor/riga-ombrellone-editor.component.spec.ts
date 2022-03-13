import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RigaOmbrelloneEditorComponent } from './riga-ombrellone-editor.component';

describe('RigaOmbrelloneEditorComponent', () => {
  let component: RigaOmbrelloneEditorComponent;
  let fixture: ComponentFixture<RigaOmbrelloneEditorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RigaOmbrelloneEditorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RigaOmbrelloneEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

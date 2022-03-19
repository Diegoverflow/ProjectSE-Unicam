import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NotificaComponent } from './notifica.component';

describe('NotificaComponent', () => {
  let component: NotificaComponent;
  let fixture: ComponentFixture<NotificaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NotificaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NotificaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

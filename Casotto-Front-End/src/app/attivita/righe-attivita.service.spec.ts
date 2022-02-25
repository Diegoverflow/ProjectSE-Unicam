import { TestBed } from '@angular/core/testing';

import { RigheAttivitaService } from './righe-attivita.service';

describe('RigheAttivitaService', () => {
  let service: RigheAttivitaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RigheAttivitaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

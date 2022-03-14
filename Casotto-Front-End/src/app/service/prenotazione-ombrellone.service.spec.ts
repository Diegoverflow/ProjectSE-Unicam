import { TestBed } from '@angular/core/testing';

import { PrenotazioneOmbrelloneService } from './prenotazione-ombrellone.service';

describe('PrenotazioneOmbrelloneService', () => {
  let service: PrenotazioneOmbrelloneService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PrenotazioneOmbrelloneService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

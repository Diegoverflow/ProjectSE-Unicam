import { TestBed } from '@angular/core/testing';

import { RigheOmbrelloniService } from './righe-ombrelloni.service';

describe('RigheOmbrelloniService', () => {
  let service: RigheOmbrelloniService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RigheOmbrelloniService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

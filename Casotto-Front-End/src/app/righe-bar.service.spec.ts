import { TestBed } from '@angular/core/testing';

import { RigheBarService } from './righe-bar.service';

describe('RigheBarService', () => {
  let service: RigheBarService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RigheBarService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

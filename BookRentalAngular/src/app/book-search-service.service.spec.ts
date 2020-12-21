import { TestBed } from '@angular/core/testing';

import { BookSearchServiceService } from './book-search-service.service';

describe('BookSearchServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BookSearchServiceService = TestBed.get(BookSearchServiceService);
    expect(service).toBeTruthy();
  });
});

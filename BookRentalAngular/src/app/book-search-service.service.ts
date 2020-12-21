import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Book} from './models/Book.model';

@Injectable({
  providedIn: 'root'
})
export class BookSearchServiceService {

  constructor(private httpClient: HttpClient) { }

  getBooks(bookTitle: string): Observable<Book[]> {

    return this.httpClient.get<Book[]>('http://localhost:8080/getbook/' + bookTitle);
  }
}

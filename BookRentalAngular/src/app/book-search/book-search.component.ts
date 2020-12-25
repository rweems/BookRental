import {Component, Input, OnInit} from '@angular/core';

import {BookSearchServiceService} from '../book-search-service.service';
import { Subscription} from 'rxjs';
import {Book} from '../models/Book.model';


@Component({
  selector: 'app-book-search',
  templateUrl: './book-search.component.html',
  styleUrls: ['./book-search.component.css']
})
export class BookSearchComponent implements OnInit {
  @Input() book: string;

  @Input() books: Book[] = [];
  title;

  constructor(private bookService: BookSearchServiceService) { }

  ngOnInit() {
  }

  clear() {
    this.books = [];
  }
  findBook(value: string) {
    this.clear();
    this.title = value;
    console.log(value);
    this.book = '';
    this.bookService.getBooks(this.title).subscribe( newBook => {
      newBook.forEach(bookElement => {
        // console.log(bookElement);
        this.books.push(bookElement);
      });
      // console.log(newBook);
      console.log('book: ' + this.books[0].title);
    });

  }
}

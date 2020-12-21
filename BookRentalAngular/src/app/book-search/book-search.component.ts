import {Component, Injectable, Input, OnInit} from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import {BookSearchServiceService} from '../book-search-service.service';
import {Observable, Subscription} from 'rxjs';
import {Book} from '../models/Book.model';

@Component({
  selector: 'app-book-search',
  templateUrl: './book-search.component.html',
  styleUrls: ['./book-search.component.css']
})
export class BookSearchComponent implements OnInit {
  @Input() book: string;


  constructor(private bookService: BookSearchServiceService) { }

  ngOnInit() {
  }

  findBook(value: string): Subscription {
    const title = value;
    console.log(value);
    this.book = '';
    return this.bookService.getBooks(title).subscribe( newBook => {
      console.log(newBook);
    });

  }
}

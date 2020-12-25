
export class Book {


  private _title;
  private _publishYear;
  private _author;
  private _publisher;


  constructor(title, publishYear, author, publisher) {
    this._title = title;
    this._publishYear = publishYear;
    this._author = author;
    this._publisher = publisher;
  }


  get title() {
    return this._title;
  }

  set title(value) {
    this._title = value;
  }

  get publishYear() {
    return this._publishYear;
  }

  set publishYear(value) {
    this._publishYear = value;
  }

  get author() {
    return this._author;
  }

  set author(value) {
    this._author = value;
  }

  get publisher() {
    return this._publisher;
  }

  set publisher(value) {
    this._publisher = value;
  }
}


import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BookSearchComponent } from './book-search/book-search.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import {RouterModule} from '@angular/router';

import {
    MatButtonModule,
    MatCardModule,
    MatGridListModule,
    MatInputModule,
    MatMenuModule,
    MatSidenavModule,
    MatSliderModule
} from '@angular/material';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { BookCardComponent } from './book-card/book-card.component';
import {FlexLayoutModule} from '@angular/flex-layout';


@NgModule({
  declarations: [
    AppComponent,
    BookSearchComponent,
    BookCardComponent
  ],
  imports: [
    BrowserModule,
    NoopAnimationsModule,
    RouterModule,
    MatSidenavModule,
    MatSliderModule,
    MatMenuModule,
    MatButtonModule,
    MatInputModule,
    HttpClientModule,
    FormsModule,
    MatCardModule,
    MatGridListModule,
    FlexLayoutModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

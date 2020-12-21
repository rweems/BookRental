import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BookSearchComponent } from './book-search/book-search.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import {RouterModule} from '@angular/router';
import {MatButtonModule, MatInputModule, MatMenuModule, MatSidenavModule, MatSliderModule} from '@angular/material';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    BookSearchComponent
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
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

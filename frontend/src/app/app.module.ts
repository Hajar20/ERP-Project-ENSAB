import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CarouselModule } from 'ngx-owl-carousel-o';
import { ListOfNewsComponent } from './list-of-news/list-of-news.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { PortfolioComponent } from './portfolio/portfolio.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { ResponsableContentComponent } from './responsable-content/responsable-content.component';

import { MainContentComponent } from './main-content/main-content.component';
@NgModule({
  declarations: [
    AppComponent,
    ListOfNewsComponent,
    LoginFormComponent,
    PortfolioComponent,
    ResponsableContentComponent,

    MainContentComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CarouselModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

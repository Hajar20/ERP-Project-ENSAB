import { NgModule } from '@angular/core';
import { BrowserModule , Title} from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CarouselModule } from 'ngx-owl-carousel-o';
import { ListOfNewsComponent } from './list-of-news/list-of-news.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { PortfolioComponent } from './portfolio/portfolio.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

import { NewsDetailsComponent } from './news-details/news-details.component';

import { DefaultFooterComponent, DefaultHeaderComponent, DefaultLayoutComponent } from './containers';

import {
  AvatarModule,
  BadgeModule,
  BreadcrumbModule,
  ButtonGroupModule,
  ButtonModule,
  CardModule,
  DropdownModule,
  FooterModule,
  FormModule,
  GridModule,
  HeaderModule,
  ListGroupModule,
  NavModule,
  ProgressModule,
  SharedModule,
  SidebarModule,
  TabsModule,
  UtilitiesModule
} from '@coreui/angular';
import { NgScrollbarModule } from 'ngx-scrollbar';
import { IconModule, IconSetService } from '@coreui/icons-angular';
import { InscriptionComponent } from './inscription/inscription.component';
import { CandidatesInfoComponent } from './views/pages/candidates-info/candidates-info.component';
import { PostsComponent } from './posts/posts.component';
import {UploadComponent} from "./views/pages/upload.component";
import { ExcelComponent } from './excel/excel.component';



const APP_CONTAINERS = [
  DefaultFooterComponent,
  DefaultHeaderComponent,
  DefaultLayoutComponent
];
@NgModule({
  declarations: [	
    AppComponent,
    ListOfNewsComponent,
    LoginFormComponent,
    PortfolioComponent,
    NewsDetailsComponent,
    CandidatesInfoComponent,
    DefaultFooterComponent,
    DefaultHeaderComponent,
    DefaultLayoutComponent,
    InscriptionComponent,
    PostsComponent,
    ExcelComponent
   ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CarouselModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    AvatarModule,
    BreadcrumbModule,
    FooterModule,
    DropdownModule,
    GridModule,
    HeaderModule,
    SidebarModule,
    IconModule,
    NavModule,
    ButtonModule,
    UtilitiesModule,
    ButtonGroupModule,
    SidebarModule,
    SharedModule,
    TabsModule,
    ListGroupModule,
    ProgressModule,
    BadgeModule,
    ListGroupModule,
    CardModule,
    NgScrollbarModule,
  ],
  providers: [

    IconSetService,
    Title
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

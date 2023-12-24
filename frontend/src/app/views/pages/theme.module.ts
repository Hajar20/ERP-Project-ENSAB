import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { CardModule, GridModule, NavModule, UtilitiesModule, TabsModule } from '@coreui/angular';
import { IconModule } from '@coreui/icons-angular';

import { ColorsComponent } from './colors.component';
import { TypographyComponent } from './typography.component';

// Theme Routing
import { ThemeRoutingModule } from './theme-routing.module';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {UploadComponent} from "./upload.component";

@NgModule({
    imports: [
        CommonModule,
        ThemeRoutingModule,
        CardModule,
        GridModule,
        UtilitiesModule,
        IconModule,
        NavModule,
        TabsModule,
        FormsModule,
        ReactiveFormsModule
    ],
  declarations: [
    ColorsComponent,
    TypographyComponent,
    UploadComponent
  ]
})
export class ThemeModule {
}

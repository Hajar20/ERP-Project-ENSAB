import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginFormComponent} from "./login-form/login-form.component";
import {PortfolioComponent} from "./portfolio/portfolio.component";

const routes: Routes = [
  {
    path: '',
    component: PortfolioComponent
  },
  {
    path: 'authenticate',
    component: LoginFormComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginFormComponent} from "./login-form/login-form.component";
import {PortfolioComponent} from "./portfolio/portfolio.component";
import {NewsDetailsComponent} from "./news-details/news-details.component";
import { DefaultLayoutComponent } from './containers';
import {PostsComponent} from "./posts/posts.component";
import {UploadComponent} from "./views/pages/upload.component";
import { InscriptionComponent } from './inscription/inscription.component';

const routes: Routes = [
  {
    path: '',
    component: PortfolioComponent
  },
  {
    path: 'inscription',
    component: InscriptionComponent
  },
  {
    path: 'home',
    redirectTo: 'pages/poster',
  },
  {
    path: '',
    component: DefaultLayoutComponent,
    data: {
      title: 'Home'
    },
    children: [
      {
        path: 'dashboard',
        loadChildren: () =>
          import('./views/dashboard/dashboard.module').then((m) => m.DashboardModule)
      },
      {
        path: 'pages',
        loadChildren: () =>
          import('./views/pages/theme.module').then((m) => m.ThemeModule)
      },
    ]
  },
  {
    path: 'authenticate',
    component: LoginFormComponent
  },

  {
    path : 'details/:id',
    component : NewsDetailsComponent
  },
  {
    path : 'posts/:id',
    component : PostsComponent
  },
  {
    path : 'uploadExcel',
    component : UploadComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {

    }
  )
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }

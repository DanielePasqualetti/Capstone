import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './componenti/dashboard/dashboard.component';
import { LoginComponent } from './componenti/login/login.component';
import { RegisterComponent } from './componenti/register/register.component';
import { AboutComponent } from './componenti/about/about.component';
import { ContactComponent } from './componenti/contact/contact.component';
import { HomeComponent } from './componenti/home/home.component';
import { UtentiComponent } from './componenti/utenti/utenti.component';
import { AuthGuard } from './auth.guard';

const routes: Routes = [
  {
    path: '',
    component: DashboardComponent,
    children: [
      { path: '', component: HomeComponent },
      { path: 'home', component: HomeComponent },
      { path: 'about', component: AboutComponent },
      { path: 'contact', component: ContactComponent },
      {
        path: 'soci',
        loadChildren: () =>
          import('./soci/soci.module').then((m) => m.SociModule),
      },
      {
        path: 'tavoli',
        canActivate: [AuthGuard],
        loadChildren: () =>
          import('./tavoli/tavoli.module').then((m) => m.TavoliModule),
      },
      {
        path: 'masters',
        canActivate: [AuthGuard],
        loadChildren: () =>
          import('./masters/masters.module').then((m) => m.MastersModule),
      },
      { path: 'utenti', component: UtentiComponent, canActivate: [AuthGuard] },
      { path: 'login', component: LoginComponent },
      { path: 'register', component: RegisterComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

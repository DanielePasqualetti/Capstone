import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TavoliComponent } from './tavoli.component';

const routes: Routes = [{ path: '', component: TavoliComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TavoliRoutingModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SociComponent } from './soci.component';

const routes: Routes = [{ path: '', component: SociComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SociRoutingModule { }

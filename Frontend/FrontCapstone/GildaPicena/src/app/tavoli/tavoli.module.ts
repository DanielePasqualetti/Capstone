import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TavoliRoutingModule } from './tavoli-routing.module';
import { TavoliComponent } from './tavoli.component';


@NgModule({
  declarations: [
    TavoliComponent
  ],
  imports: [
    CommonModule,
    TavoliRoutingModule
  ]
})
export class TavoliModule { }

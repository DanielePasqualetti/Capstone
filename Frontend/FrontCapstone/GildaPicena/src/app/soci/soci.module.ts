import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SociRoutingModule } from './soci-routing.module';
import { SociComponent } from './soci.component';
import { FormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';

@NgModule({
  declarations: [SociComponent],
  imports: [
    CommonModule,
    SociRoutingModule,
    FormsModule,
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule,
    MatIconModule,
  ],
})
export class SociModule {}

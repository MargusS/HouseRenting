import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { NewRentPageRoutingModule } from './new-rent-routing.module';

import { NewRentPage } from './new-rent.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    NewRentPageRoutingModule
  ],
  declarations: [NewRentPage]
})
export class NewRentPageModule { }

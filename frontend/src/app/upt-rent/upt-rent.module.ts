import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { UptRentPageRoutingModule } from './upt-rent-routing.module';

import { UptRentPage } from './upt-rent.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    UptRentPageRoutingModule
  ],
  declarations: [UptRentPage]
})
export class UptRentPageModule {}

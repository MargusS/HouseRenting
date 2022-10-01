import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { HousesListPageRoutingModule } from './houses-list-routing.module';

import { HousesListPage } from './houses-list.page';
import { ComponentsModule } from '../components/components.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    HousesListPageRoutingModule,
    ComponentsModule
  ],
  declarations: [HousesListPage]
})
export class HousesListPageModule {}

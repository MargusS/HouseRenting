
import { Component, ViewChild } from '@angular/core';

import { MenuController } from '@ionic/angular';
import { HeaderComponent } from './components/header/header.component';
import { MenuComponent } from './components/menu/menu.component';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {

  @ViewChild(MenuComponent) menu: MenuComponent;
  // @ViewChild(HeaderComponent) header: HeaderComponent;

  constructor( private menuController: MenuController) {}
  
  uptMenu(): void {
    this.menu.testLogged();
  }

}

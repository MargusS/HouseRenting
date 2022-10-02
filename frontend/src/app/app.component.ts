
import { Component, ViewChild } from '@angular/core';

import { MenuController, Platform } from '@ionic/angular';
import { MenuComponent } from './components/menu/menu.component';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {

  @ViewChild(MenuComponent) menu: MenuComponent;

  menuOpen = false;

  constructor( private menuController: MenuController) {}
  
  toggleMenu(): void {
    this.menu.testLogged();
    this.menuController.toggle('first');
  }

  changeMenu(): void {
    this.menuOpen = !this.menuOpen;
  }
}

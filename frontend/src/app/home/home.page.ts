import { Component, OnInit } from '@angular/core';
import { HouseService } from '../service/house.service';
import { TokenService } from '../service/token.service';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

  isLogged = false;
  userName = "juan";
  houses: any = [];
  constructor(private houseService: HouseService, private tokenService: TokenService) { }

  ngOnInit() {
    this.testLogged()
  }

  ionViewWillEnter() {
    this.testLogged();
  }

  // getAllHouses() {
  //   this.houseService.getHouses().subscribe(response => {
  //     this.houses = response;
  //   })
  // }

  testLogged(): void {
    this.isLogged = this.tokenService.getToken() != null;
    this.userName = this.tokenService.getUserName();
  }
}
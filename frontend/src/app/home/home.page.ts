import { Component, OnInit } from '@angular/core';
import { HouseService } from '../service/house.service';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

  houses: any = [];
  constructor(private houseService: HouseService) { }

  ngOnInit() {
    this.getAllHouses();
  }

  getAllHouses() {
    this.houseService.getHouses().subscribe(response => {
      this.houses = response;
    })
  }
}

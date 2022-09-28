import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { House } from '../models/house';
import { HouseService } from '../service/house.service';

@Component({
  selector: 'app-new-rent',
  templateUrl: './new-rent.page.html',
  styleUrls: ['./new-rent.page.scss'],
})
export class NewRentPage implements OnInit {

  title: string = '';
  location: string = '';
  price: number = null;
  description: string = '';
  wc: number = null;
  rooms: number = null; 

  constructor(private houseService: HouseService, private router: Router) { }

  ngOnInit() {
  }

  onCreate(): void{
    const house = new House(this.title,this.location,this.price,this.description,this.wc,this.rooms);
    this.houseService.postCreate(house).subscribe(
      data => {
        alert('Producto creado');
        this.router.navigate(['/admin']);
      },
      err => {
        alert('Producto no valido');
        this.router.navigate(['/admin']);
      }
    )
  }

}

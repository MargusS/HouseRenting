import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HouseService } from '../service/house.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.page.html',
  styleUrls: ['./admin.page.scss'],
})
export class AdminPage implements OnInit {
  houses: any = [];
  constructor(private router: Router,private houseService: HouseService) { }

  ngOnInit() {
    this.getAllHouses();
  }

  getAllHouses() :void {
    this.houseService.getHouses().subscribe(response => {
      this.houses = response;
    })
  }

  goToNew() : void{
    this.router.navigateByUrl("/new-rent");
  }

  deleteItem(id:number) :void {
    alert('borrar el ' + id);
    this.houseService.deleteHouse(id).subscribe(
      data => {
        console.log("producto eliminado");
        this.getAllHouses();
      },
      err=>{
        console.log("error al eliminar");
      }
    )
  }

}

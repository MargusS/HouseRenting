import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminPage } from '../admin/admin.page';
import { House } from '../models/house';
import { HouseService } from '../service/house.service';

@Component({
  selector: 'app-upt-rent',
  templateUrl: './upt-rent.page.html',
  styleUrls: ['./upt-rent.page.scss'],
})
export class UptRentPage implements OnInit {

  house: House = null;
  constructor(private houseService: HouseService, private activatedRoute:ActivatedRoute,private router: Router) { }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.params.id;
    this.houseService.getDetail(id).subscribe(
      data=>{
        this.house = data;
      },
      err=>{
        alert("Error");
      }
    )
  }

  onUpdate():void{
    const id = this.activatedRoute.snapshot.params.id;
    this.houseService.putUpdate(id,this.house).subscribe(
      data=>{
        alert("Actualizado")
        this.router.navigate(['/admin']);
      },
      err=>{
        alert("Error al actualizar")
      }
    );
  }
}

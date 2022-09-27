import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { House } from '../models/house';

@Injectable({
  providedIn: 'root'
})
export class HouseService {

  path = 'http://localhost:8080/house'

  constructor(private httpClient: HttpClient) { }

  getHouses() {
    return this.httpClient.get(this.path + '/lista');
  }
  getDetail(id:number) {
    return this.httpClient.get(this.path + `/detail/${id}`);
  }

  postCreate(house: House){
    return this.httpClient.post(this.path + `/create`, house);
  }

  putUpdate(id:number,house:House){
    return this.httpClient.put(this.path + `/update/${id}`,house);
  }

  deleteHouse(id:number){
    return this.httpClient.delete(this.path + `/delete/${id}`);
  }

}

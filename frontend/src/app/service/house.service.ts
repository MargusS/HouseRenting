import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HouseService {

  path = 'http://localhost:8080/house/lista'

  constructor(private httpClient: HttpClient) { }

  getHouses() {
    return this.httpClient.get(this.path);
  }
}

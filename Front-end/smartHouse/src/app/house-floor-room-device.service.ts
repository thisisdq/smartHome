import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { House } from './module';

@Injectable({
  providedIn: 'root'
})
export class HouseFloorRoomDeviceService {

  BASE_URL = "http://localhost:8888/";

  constructor(private http: HttpClient) {

  }


  getHouseByUserID(userID : number){
    return this.http.post<House[]>(this.BASE_URL+ "/userAccount/getHouses/"+userID, {})
  }
}

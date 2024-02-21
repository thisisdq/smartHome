import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAccount } from './module';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  baseUrl: string = 'http://localhost:8888';
  constructor(private http : HttpClient,) {

   }

   fetchTempandHumi(username:string){
    return this.http.post(this.baseUrl + '/userAccount/fetchTemperatureAndHumidity',{ username : username})
   }

   fetchData(username : string) : any {
    return this.http.post(this.baseUrl+"/userAccount/fetchDataAccount",{username: username})
   }

   getHouses (userID : number) {
    return this.http.post(this.baseUrl+"/userAccount/getHouses",{userID: userID})
   }
}

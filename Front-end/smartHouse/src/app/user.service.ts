import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAccount } from './module';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  baseUrl: string = 'http://localhost:8888';
  constructor(private http : HttpClient,) {

   }

   fetchTempandHumi(username:string){
    return this.http.post(this.baseUrl + '/',username)
   }

   fetchData(username : string) : any {
    let data :UserAccount;
    return this.http.post(this.baseUrl+"/userAccount/fetchDataAccount",{username: username})
   }
}

import { Injectable } from '@angular/core';
import { UserAccount } from './entity';
import { Observable  } from 'rxjs';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }
  baseUrl = 'http://localhost:8888/';
  public authUser(userAccount : UserAccount) {
    return this.http.post<UserAccount>(this.baseUrl +'authUser', userAccount);
  }
  
}

import { Injectable } from '@angular/core';
import { UserService } from './user.service';
import { UserAccount } from './entity';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private userService: UserService, private http : HttpClient,private router : Router) {
  }
  session :any;

  baseUrl :string = 'http://localhost:8888/';
  
  login(userAccount :UserAccount) {
    let user: UserAccount;
    var subject = new Subject<UserAccount>();
    this.http.post<UserAccount>(this.baseUrl +'authUser', userAccount).subscribe(res => {
      user = res;
      if (user){
        console.log(user);
        this.session = user;
        localStorage.setItem('session', JSON.stringify(this.session));
        
      }else{
        console.log('login failed');
      }
      subject.next(user);
    });
    return subject.asObservable();
  }

  logout (){
    this.session = undefined ;
    localStorage.removeItem('session');
    this.router.navigateByUrl('/');
  }
}

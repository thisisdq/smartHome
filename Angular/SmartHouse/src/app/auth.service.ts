import { Injectable } from '@angular/core';
import { UserService } from './user.service';
import { UserAccount } from './entity';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private userService: UserService) {
  }
  session :any;
  login(username:string,password:string) {
    let u : UserAccount = {username:username,password:password};
    let user = this.userService.authUser(u).subscribe();
    console.log(user);
    if (user) {
      this.session = user;
      localStorage.setItem('session', JSON.stringify(this.session));
    }
    return user;
  }
}

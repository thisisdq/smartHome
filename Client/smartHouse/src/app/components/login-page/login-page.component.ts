import { Component, Inject } from '@angular/core';
import { AuthenticationService } from '../../authentication.service';
import { DOCUMENT } from '@angular/common';
import { Router } from '@angular/router';
import { UserAccount } from '../../module';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [ReactiveFormsModule, FormsModule],
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.scss'
})

export class LoginPageComponent {
  constructor(
    @Inject(DOCUMENT) private document: Document,
    private authservice: AuthenticationService,
    private router:Router,
  ) { }

  userAccount : UserAccount = {};

  ngOnInit() {
    const container = this.document.getElementById('login-page-container');
    const registerBtn = this.document.getElementById('register');
    const loginBtn = this.document.getElementById('login');

    registerBtn?.addEventListener('click', () => {
      container?.classList.add("active");
    });

    loginBtn?.addEventListener('click', () => {
      container?.classList.remove("active");
    });
  }
  onSubmitLogin() {
    console.log(this.userAccount);
    let user = this.authservice.login(this.userAccount);
    console.log('user : ');
    user.subscribe(user => {
      if(!user){
        alert('FAIL to login');
      }
      else {
        this.router.navigateByUrl('/smarthousepage');
      }
    });
  }
  onSubmitRegister() {
    console.log(this.userAccount);
  }
}

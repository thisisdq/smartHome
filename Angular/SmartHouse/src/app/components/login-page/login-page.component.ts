import { Component, Inject } from '@angular/core';
import { CommonModule, DOCUMENT } from '@angular/common';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AuthService } from '../../auth.service';
import { UserAccount } from '../../entity';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, FormsModule],
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.css'
})

export class LoginPageComponent {
  constructor(
    @Inject(DOCUMENT) private document: Document,
    private authservice: AuthService,
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

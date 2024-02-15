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
    private router: Router,
  ) { }

  userAccount: UserAccount = {};

  ngOnInit() {
    if (this.authservice.session) {
      this.router.navigateByUrl('/smarthousepage');
    }
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
    this.authservice.login(this.userAccount).subscribe(
      data => {
        if (data != null) {
          this.router.navigateByUrl('/smarthousepage');
        }
        else {
          alert('FAIL to login');
        };
      }
    );
  }
  onSubmitRegister() {
    console.log(this.userAccount);
  }
}

import { Component, Inject } from '@angular/core';
import { CommonModule, DOCUMENT } from '@angular/common';
import { FormGroup, FormBuilder, Validators, FormControl,ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.css'
})

export class LoginPageComponent {
  constructor(@Inject(DOCUMENT) private document: Document, private formbuilder: FormBuilder) { }

  formGroup: FormGroup = new FormGroup({
    username: new FormControl(''),
    password : new FormControl(''),
    fullname : new FormControl(''),
  });

  ngOnInit() {
    const container = this.document.getElementById('container');
    const registerBtn = this.document.getElementById('register');
    const loginBtn = this.document.getElementById('login');

    registerBtn?.addEventListener('click', () => {
      container?.classList.add("active");
    });

    loginBtn?.addEventListener('click', () => {
      container?.classList.remove("active");
      this.onSubmitLogin();
      alert("Please enter");
    });
  }
  onSubmitLogin() {
    console.log(this.formGroup.value);
  }
  onSubmitRegister(){

  }
}

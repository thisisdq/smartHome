import { Component, OnInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
    selector: 'app-test',
    standalone: true,
    imports: [CommonModule, FormsModule, ReactiveFormsModule],
    templateUrl: './test.component.html',
    styleUrl: './test.component.css'
})
export class TestComponent implements OnInit,OnDestroy {

    userAccount = {
        fullname: '',
        username: '',
        password: ''
    }

    public count:any;
    public interval: any;
    ngOnInit(): void {  
        this.count = 0;
        this.interval = setInterval(() => {this.count = this.count +1;
        console.log(this.count);
        }, 1000)
    }

    ngOnDestroy(): void {
        if(this.interval){
            clearInterval(this.interval)
        }
    }

    time = Date.now();

    onRegisterSubmit() {
        console.log(this.userAccount);
        console.log('registerSubmit');
    }
}

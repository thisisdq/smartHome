import { CommonModule, DOCUMENT } from '@angular/common';
import { Component, Inject, OnInit } from '@angular/core';


@Component({
  selector: 'app-calendar',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './calendar.component.html',
  styleUrl: './calendar.component.scss'
})
export class CalendarComponent implements OnInit  {

  // daysTag: any;
  // currentDate: any;
  // prevNextIcon?: NodeListOf<Element>;
  // public date?: Date;
  // currYear?: number;
  // currMonth?: number;
  // months?: string[];

  // constructor(
  //   @Inject(DOCUMENT) private document: Document
  // ){

  // }

  ngOnInit(): void {
  //   this.daysTag = document.querySelector(".days");
  //   this.currentDate = document.querySelector(".current-date");
  //   this.prevNextIcon = document.querySelectorAll(".icons span");

  //   this.date = new Date();
  //   this.currYear = this.date.getFullYear();
  //   this.currMonth = this.date.getMonth();

  //   this.months = ["January", "February", "March", "April", "May", "June", "July",
  //     "August", "September", "October", "November", "December"];

  //   this.renderCalendar();

  //   this.prevNextIcon.forEach(icon => {
  //     icon.addEventListener("click", () => {
  //       this.currMonth = icon.id === "prev" ? this.currMonth! - 1 : this.currMonth! + 1;

  //       if (this.currMonth < 0 || this.currMonth > 11) {
  //         this.date = new Date(this.currYear!, this.currMonth, new Date().getDate());
  //         this.currYear = this.date.getFullYear();
  //         this.currMonth = this.date.getMonth();
  //       } else {
  //         this.date = new Date();
  //       }
  //       this.renderCalendar();
  //     });
  //   });
  }

  // renderCalendar(): void {
  //   let firstDayofMonth = new Date(this.currYear!, this.currMonth!, 1).getDay(),
  //     lastDateofMonth = new Date(this.currYear!, this.currMonth! + 1, 0).getDate(),
  //     lastDayofMonth = new Date(this.currYear!, this.currMonth!, lastDateofMonth).getDay(),
  //     lastDateofLastMonth = new Date(this.currYear!, this.currMonth!, 0).getDate();
  //   let liTag = "";

  //   for (let i = firstDayofMonth; i > 0; i--) {
  //     liTag += `<li class="inactive">${lastDateofLastMonth - i + 1}</li>`;
  //   }

  //   for (let i = 1; i <= lastDateofMonth; i++) {
  //     let isToday = i === this.date?.getDate() && this.currMonth === new Date().getMonth()
  //       && this.currYear === new Date().getFullYear() ? "active" : "";
  //     liTag += `<li class="${isToday}">${i}</li>`;
  //   }

  //   for (let i = lastDayofMonth; i < 6; i++) {
  //     liTag += `<li class="inactive">${i - lastDayofMonth + 1}</li>`;
  //   }
  //   this.currentDate.innerText = `${this.months![this.currMonth!]} ${this.currYear}`;
  //   this.daysTag.innerHTML = liTag;
  // }
  
}
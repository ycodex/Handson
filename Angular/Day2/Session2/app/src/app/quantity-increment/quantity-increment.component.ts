import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-quantity-increment',
  templateUrl: './quantity-increment.component.html',
  styleUrls: ['./quantity-increment.component.css'],
})
export class QuantityIncrementComponent implements OnInit {
  message: number = 0;
  number: number = 0;
  disable: boolean = false;
  constructor() {}

  ngOnInit(): void {}
  show() {
    this.number++;
  }
  decrement() {
    this.message--;
    if (this.message <= 0) this.disable = true;
  }
  increment() {
    this.message++;
  }
}

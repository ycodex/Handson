import { Component, Input, OnInit } from '@angular/core';
import { Employee } from '../employee';

@Component({
  selector: 'app-emp-info',
  templateUrl: './emp-info.component.html',
  styleUrls: ['./emp-info.component.css'],
})
export class EmpInfoComponent implements OnInit {
  @Input() employee: Employee;
  constructor() {}

  ngOnInit(): void {}
}

import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Employee } from '../employee';
import { Department } from '../department';
import { Skill } from '../skill';
import { ActivatedRoute } from '@angular/router';
import { EmployeeService } from '../employee.service';
@Component({
  selector: 'app-edit-emp-reactive',
  templateUrl: './edit-emp-reactive.component.html',
  styleUrls: ['./edit-emp-reactive.component.css'],
})
export class EditEmpReactiveComponent implements OnInit {
  constructor(
    private route: ActivatedRoute,
    private employeeService: EmployeeService
  ) {}
  employeeId: number = Number(this.route.snapshot.paramMap.get('id'));
  ngOnInit(): void {
    console.log(this.employee);
  }

  dept: Department = {
    id: 1,
    name: 'Computer',
  };

  departments: Department[] = [
    { id: 1, name: 'Payroll' },

    { id: 2, name: 'Internal' },

    { id: 3, name: 'HR' },
  ];

  skill: Skill[] = [
    { id: 1, name: 'coding' },
    { id: 2, name: 'drawing' },
  ];

  employee: Employee = this.employeeService.getEmployee(this.employeeId);

  empForm = new FormGroup({
    name: new FormControl(this.employee.name, [
      Validators.required,

      Validators.minLength(4),

      Validators.maxLength(20),
    ]),

    salary: new FormControl(this.employee.salary, [Validators.required]),
    permanent: new FormControl(this.employee.permanent),
    department: new FormControl(this.employee.department),
  });

  // name = new FormControl(this.employee.name);
  get department() {
    return this.empForm.get('department');
  }
  get permanent() {
    return this.empForm.get('permanent');
  }
  get salary() {
    return this.empForm.get('salary');
  }
  get name() {
    return this.empForm.get('name');
  }

  onSubmit() {
    console.log(this.empForm);
  }
}

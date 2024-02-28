import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee.model';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent {
  employee: Employee = {
    id: 0,
    name: '',
    email: '',
    jobTitle: '',
    phone: '',
    imageUrl: '',
    employeeCode: ''
  };

  constructor(
    private router: Router,
    private employeeService: EmployeeService
  ) { }

  createEmployee(): void {
    this.employeeService.createEmployee(this.employee)
      .subscribe(() => this.router.navigate(['/employees']));
  }
}

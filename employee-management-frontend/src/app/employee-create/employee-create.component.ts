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
  constructor(
    private router: Router,
    private employeeService: EmployeeService
  ) { }

  createEmployee(name: string, email: string, jobTitle: string, phone: string, imageUrl: string, employeeCode: string): void {
    const newEmployee: Employee = { name, email, jobTitle, phone, imageUrl, employeeCode } as Employee;
    this.employeeService.createEmployee(newEmployee)
      .subscribe(() => this.router.navigate(['/employees']));
  }
}

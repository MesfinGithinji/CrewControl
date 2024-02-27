import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee.model';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {
  employee: Employee | undefined;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private employeeService: EmployeeService
  ) { }

  ngOnInit(): void {
    this.getEmployee();
  }

  getEmployee(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.employeeService.getEmployee(id)
      .subscribe(employee => this.employee = employee);
  }

  updateEmployee(name: string, email: string, jobTitle: string, phone: string, imageUrl: string, employeeCode: string): void {
    if (!this.employee) {
      return;
    }
    this.employee.name = name;
    this.employee.email = email;
    this.employee.jobTitle = jobTitle;
    this.employee.phone = phone;
    this.employee.imageUrl = imageUrl;
    this.employee.employeeCode = employeeCode;
    this.employeeService.updateEmployee(this.employee)
    .subscribe(() => this.router.navigate(['/employees']));
  }
}

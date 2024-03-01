package com.mesfingithinji.CrewControl;

import com.mesfingithinji.CrewControl.model.Employee;
import com.mesfingithinji.CrewControl.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Tag(
        name = "CrewControl Backend",
        description = "Here are the various HTTP Endpoints for each CRUD functionality"
)
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(
            summary = "This method handles HTTP GET requests to the endpoint /employee/all.",
            description = "It retrieves ALL employees from the database using the employeeService.findAllEmployees() method.The retrieved list of employees is wrapped in a ResponseEntity<List<Employee>>.\n" +
                    "If the operation is successful, it returns a response with an HTTP status of 200 (OK) along with the list of employees.\n" +
                    "If there are no employees found, an empty list is returned with the same HTTP status."
    )
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees () {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    @Operation(
            summary = "This method handles HTTP GET requests to the endpoint /employee/find/{id}, where {id} is a path variable representing the ID of the employee to be found.",
            description = "It retrieves the employee with the specified ID using the employeeService.findEmployeeById(id) method.\n" +
                    "The retrieved employee is wrapped in a ResponseEntity<Employee>.\n" +
                    "If the employee with the specified ID is found, it returns a response with an HTTP status of 200 (OK) along with the employee details.\n" +
                    "If no employee is found with the given ID, it returns a response with an HTTP status of 404 (NOT FOUND)."
    )
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @Operation(
            summary = "This method handles HTTP POST requests to the endpoint /employee/add.",
            description = "It expects a request body containing details of the new employee in JSON format.\n" +
                    "The request body is automatically deserialized into an Employee object using the @RequestBody annotation.\n" +
                    "It adds the new employee to the database or data source using the employeeService.addEmployee(employee) method.\n" +
                    "The newly added employee is wrapped in a ResponseEntity<Employee>.\n" +
                    "If the addition is successful, it returns a response with an HTTP status of 201 (CREATED) along with the details of the newly added employee.\n" +
                    "If there is any issue with adding the employee, it returns an appropriate error response with an appropriate HTTP status code."
    )
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @Operation(
            summary = "This method handles HTTP PUT requests to the endpoint /employee/update.",
            description = "It expects a request body containing updated details of an existing employee in JSON format.\n" +
                    "The request body is automatically deserialized into an Employee object using the @RequestBody annotation.\n" +
                    "It updates the existing employee in the database or data source using the employeeService.updateEmployee(employee) method.\n" +
                    "The updated employee is wrapped in a ResponseEntity<Employee>.\n" +
                    "If the update is successful, it returns a response with an HTTP status of 200 (OK) along with the details of the updated employee.\n" +
                    "If the employee to be updated is not found or there is any other issue, it returns an appropriate error response with an appropriate HTTP status code."
    )
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @Operation(
            summary = "This method handles HTTP DELETE requests to the endpoint /employee/delete/{id}, where {id} is a path variable representing the ID of the employee to be deleted.",
            description = "It deletes the employee with the specified ID from the database or data source using the employeeService.deleteEmployee(id) method.\n" +
                    "It does not expect any request body since it extracts the ID of the employee to be deleted from the URL path.\n" +
                    "After deletion, it returns a ResponseEntity with an empty body.\n" +
                    "If the deletion is successful, it returns a response with an HTTP status of 200 (OK).\n" +
                    "If the employee with the specified ID is not found, it still returns a response with an HTTP status of 200 (OK) as the operation of deleting a non-existing resource is considered successful."
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

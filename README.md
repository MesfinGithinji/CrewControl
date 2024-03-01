```
# CrewControl

CrewControl is a simple CRUD (Create, Read, Update, Delete) employee management system designed to streamline the process of managing employee data within a company or organization.

## Features

- **Create:** Add new employee records to the system with relevant details such as name, position, contact information, etc.
- **Read:** View existing employee records to access information quickly and efficiently.
- **Update:** Modify employee details as needed, including changes to positions, contact information, and other pertinent data.
- **Delete:** Remove employee records from the system when necessary, ensuring data accuracy and relevance.


## Technologies Used

- **Java:** Backend language.
- **Spring Boot:** Backend framework for building Java-based applications.
- **MySQL:** Relational database for storing employee data.
- **Swagger:** API documentation tool for documenting backend APIs.
- **HTML/CSS:** Frontend markup and styling.
- **Angular:** Frontend framework for building single-page applications.

## API Usage

To interact with CrewControl API using Postman or HTTPie, follow these steps:

### Launching Development Server in Spring Boot (IntelliJ):

1. Open IntelliJ IDEA.
2. Load your CrewControl project.
3. Navigate to the main class (typically named `Application` or similar) that contains the `main` method.
4. Right-click on the main class file and select "Run" or "Debug" to start the Spring Boot application.
5. Once the application is running, you'll see the server log output indicating that the application has started successfully.

### Interacting with the API:

- **Adding Employees:** Send a POST request to the appropriate endpoint (`/employees`) with the required employee details in the request body.
- **Viewing Employees:** Send a GET request to the `/employees` endpoint to retrieve a list of all existing employee records.
- **Viewing Specific Employee:** Send a GET request to `/employees/{employee_id}` endpoint to retrieve details of a specific employee.
- **Updating Employees:** Send a PUT request to `/employees/{employee_id}` endpoint with the updated employee details in the request body.
- **Deleting Employees:** Send a DELETE request to `/employees/{employee_id}` endpoint to remove an employee from the system.

Once you have the projrct on your systen ensure that you have the appropriate dependencies and configurations set up in your Spring Boot project for smooth execution.

## Setup

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/MesfinGithinji/CrewControl.git
   ```
2. **Navigate to the Project Directory:**
   ```bash
   cd crewControl
   ```
3. **Install Dependencies:**
   - Backend:
     ```bash
     # Assuming you have Maven installed
     mvn clean install
     ```
   - Frontend:
     ```bash
     # Assuming you have Node.js and npm installed
     cd employee-management-frontend
     npm install
     ```
4. **Run the Application:**
   - Backend:
     ```bash
     java -jar target/crewcControl.jar
     ```
   - Frontend:
     ```bash
     # Make sure you are in the frontend directory
     ng serve
     ```
5. **Access the Application:**
   - Backend: Access the API documentation at `http://localhost:8080/swagger-ui.html`

## Contributing

Contributions are welcome! If you'd like to contribute to CrewControl, please fork the repository and submit a pull request with your changes. Be sure to follow the existing code style and guidelines.


## Contact

For questions or inquiries about CrewControl, please contact [Mesfin Githinji](mailto:mesfingithinji@gmail.com).
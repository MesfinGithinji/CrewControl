import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router'; // Import RouterModule
import { appRoutes } from './app.routes'; // Import routes
import { HttpClientModule } from '@angular/common/http'; // Import HTTP client
import { FormsModule } from '@angular/forms'; 
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { EmployeeCreateComponent } from './employee-create/employee-create.component';
import { EmployeeEditComponent } from './employee-edit/employee-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    EmployeeDetailsComponent,
    EmployeeCreateComponent,
    EmployeeEditComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes), // Import and configure routes
    HttpClientModule, // Import HTTP client
    FormsModule // Import forms functionality
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

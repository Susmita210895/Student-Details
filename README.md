# Student Details - Spring Boot Application

## Overview
This project is a Spring Boot application for managing student details. It provides RESTful APIs to perform CRUD operations and includes a filtering mechanism for student records.

## Project Structure
```
main/java/com/example/StudentDetails/
├── StudentDetailsApplication.java   # Main Spring Boot Application
├── Controller/
│   ├── StudentController.java       # Handles API requests
├── entity/
│   ├── StudentDetails.java          # Defines Student entity
├── repository/
│   ├── StudentRepository.java       # Database interaction
├── service/
│   ├── StudentRecordFiltering.java  # Business logic for filtering records
│   ├── StudentService.java          # Service layer for student operations
main/resources/
├── application.properties           # Configuration file
```

## Prerequisites
- Java 17+
- Spring Boot 3+
- Maven
- PostgreSQL or any JPA-supported database

## Setup Instructions
1. Clone the repository:
   ```sh
   git clone <repository-url>
   cd StudentDetails
   ```
2. Configure the database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/studentdb
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```
3. Build and run the application:
   ```sh
   mvn spring-boot:run
   ```

## API Endpoints
| HTTP Method | Endpoint                          | Description                          |
|------------|------------------------------------|--------------------------------------|
| GET        | `/students`                        | Retrieve all students                |
| POST       | `/students`                        | Add a new student                    |
| GET        | `/students/startWithM`             | get students name staring with M/m   |
| GET        | `/students/countWordsMoreThanFive` | get student count with name length> 5|


## Description
The application Student Details has been designed to store details of the students and incorporate features allowing filtering students based on certain criteria. 
The method countWordsStartingWithM() present in the class studentRecordFiltering helps in getting the number of students based on the first letter of their name.
This method can be accessed using the endpoint '/students/startWithM' from the controller. 
The method getWordsLongerThanFive() present in the class 'StudentRecordFiltering' helps in getting the list of student having long names(names with words greater than 5)
This method can be accessed using the endpoint '/students/countWordsMoreThanFive' from the controller

## Scope
At present the application is enabled for adding and fetching student details, but has scope for adding methods to delete, update and further filtering features as well. 

# Student Management System - Spring Boot

A RESTful API for managing students built with Spring Boot.

## Tech Stack
- Java 17
- Spring Boot 3.5.11
- Spring Data JPA
- SQLite Database
- Lombok
- Maven

## Features
- Create a student
- Get all students
- Get student by ID
- Update student
- Delete student

## API Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | /api/v1/students | Create student |
| GET    | /api/v1/students | Get all students |
| GET    | /api/v1/students/{id} | Get student by ID |
| PUT    | /api/v1/students/{id} | Update student |
| DELETE | /api/v1/students/{id} | Delete student |

## How To Run
1. Clone the repo
2. Open in IntelliJ
3. Run ManagementApplication.java
4. API runs on http://localhost:8080
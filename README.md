<<<<<<< HEAD
# Student Management System - Spring Boot

A RESTful API for managing students built with Spring Boot.

## Tech Stack
- ## Tech Stack
- Java 17
- Spring Boot 3.5.11
- Spring Data JPA
- MySQL Database   ← updated!
- Lombok
- Maven

## Features
- Create a student
- Get all students
- Get student by ID
- Update student
- Delete student

## Live API
https://melodious-simplicity-production-8c31.up.railway.app

## API Endpoints
| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| POST | /api/auth/register | Register | Public |
| POST | /api/auth/login | Login | Public |
| GET | /api/v1/students | Get all students | Protected |
| POST | /api/v1/students | Create student | Protected |
| GET | /api/v1/students/{id} | Get student | Protected |
| PUT | /api/v1/students/{id} | Update student | Protected |
| DELETE | /api/v1/students/{id} | Delete student | Protected |
| GET | /api/courses | Get all courses | Protected |
| POST | /api/courses | Create course | Protected |
| POST | /api/v1/students/{id}/enroll/{courseId} | Enroll | Protected |

## How To Run
1. Clone the repo
2. Open in IntelliJ
3. Run ManagementApplication.java
4. API runs on http://localhost:8080
=======
# student-management-system-springboot
A RESTful Student Management API built with Spring Boot,  featuring full CRUD operations, SQLite database,  input validation and clean layered architecture  (Controller → Service → Repository → Model)


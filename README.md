# 🎓 Online Learning Platform REST API

A backend RESTful API built with **Spring Boot**, designed for managing online learning operations — including students, instructors, courses, and categories — with **MySQL** database integration.

---

## 🚀 Overview

This project implements a simple and scalable backend system for an online learning platform.  
It allows:
- Managing courses, categories, and instructors.
- Students to enroll in multiple courses.
- Tracking course creation and updates via automatic auditing.

---

## 🧩 Features

- **CRUD operations** for all entities (Student, Course, Category, Instructor)
- **Many-to-Many** relationship between Students and Courses (via `enrollments` table)
- **Many-to-One** relationships for Category and Instructor within Course
- **Automatic timestamps** using:
  - `@CreatedDate` → when an entity is created
  - `@LastModifiedDate` → when updated
- **Entity Validation** with `jakarta.validation`
- **JSON handling** with Jackson and reference management (`@JsonManagedReference`, `@JsonBackReference`)
- **Database Auditing** enabled via `AuditingEntityListener`
- **Lombok** for boilerplate code reduction

---

## 🧱 Technologies Used

| Component | Technology |
|------------|-------------|
| Framework | Spring Boot 3.5.6 |
| ORM | Spring Data JPA (Hibernate) |
| Database | MySQL |
| Validation | Jakarta Validation (Bean Validation API) |
| Mapping | Jackson Datatype Hibernate |
| Utilities | Lombok |
| Build Tool | Maven |
| Java Version | 21 |

---

## 🗂️ Entity Relationships

**1. Student**
- `@ManyToMany` with Course (owning side)
- Auto-tracks enrollment date with `@CreatedDate`

**2. Course**
- `@ManyToOne` with Category  
- `@ManyToOne` with Instructor  
- `@ManyToMany(mappedBy = "courses")` with Student  
- Tracks creation and update timestamps  

**3. Category**
- `@OneToMany(mappedBy = "category")` → List of Courses

**4. Instructor**
- `@OneToMany(mappedBy = "instructor")` → List of Courses

📘 **Join Table:**  
`enrollments (student_id, course_id)`

---

## 📚 Example Endpoints

| Method | Endpoint               | Description                  |
| ------ | ---------------------- | ---------------------------- |
| GET    | `/api/courses`         | Get all courses              |
| POST   | `/api/courses`         | Add a new course             |
| PUT    | `/api/courses/{id}`    | Update a course              |
| DELETE | `/api/courses/{id}`    | Delete a student             |
| GET    | `/api/course/{id}`     | Get a specific course        |

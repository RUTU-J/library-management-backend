**Library Management System – Backend**

A Spring Boot REST API for managing books, authors, users, and book borrowing operations.
This project demonstrates real-world backend development using JPA entity relationships, RESTful APIs,
and MySQL.

**Features**

Author Management
1. Create author
2. Update author
3. Delete author
4. List all authors
5. Fetch books written by an author

Book Management
1. Create book with author mapping
2. Update book details
3. Delete book
4. List all books
 
User Management
1. Create user
2. Update user
3. Delete user
4. List all users

Borrowing System
1. Borrow a book by user
2. Return a borrowed book
3. Track borrow & return dates

Tech Stack
* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* REST API
* Maven
* Git & GitHub

**Project Structure**
com.library.library_management
├── controller
├── service
├── repository
├── entity
└── LibraryManagementApplication.java

**Database Design**
Author → Books (One-to-Many)
Book → BorrowRecords (One-to-Many)
User → BorrowRecords (One-to-Many)

**REST API Endpoints**

1. Author APIs
POST /author → Create author
GET /author → Get all authors
PUT /author/{id} → Update author
DELETE /author/{id} → Delete author
GET /author/{id}/books → Get books by author

2.Book APIs
POST /book/author/{authorId} → Create book with author
GET /book → Get all books
PUT /book/{id} → Update book
DELETE /book/{id} → Delete book

3.User APIs
POST /users → Create user
GET /users → Get all users
PUT /users/{id} → Update user
DELETE /users/{id} → Delete user

4.Borrow APIs
POST /borrow/user/{userId}/book/{bookId} → Borrow book
PUT /borrow/return/{recordId} → Return book
GET /borrow/user/{userId} → Get borrowed books by user

**How to Run the Application**
1.Clone the repository
git clone https://github.com/RUTU-J/library-management-backend.git

2.Configure MySQL database in application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/library_db
spring.datasource.username=root
spring.datasource.password=your_password

3.Run the application
mvn spring-boot:run

**API Testing**
APIs tested using Postman
JSON request and response format
Proper HTTP status codes


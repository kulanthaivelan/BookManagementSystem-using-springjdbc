# BookManagementSystem-using-springjdbc

Here’s a polished **README.md** for your Book Management System using Spring JDBC & Thymeleaf. You can copy and paste this into your GitHub repo:

# 📚 Book Management System (Spring JDBC + Thymeleaf)

A simple web application using Spring Boot, Spring JDBC (`JdbcTemplate`), and Thymeleaf for CRUD operations on books.

## 🔧 Features

- List all books
- Create new book entries
- Edit book details
- Delete existing books
- Server-side validation with Jakarta Bean Validation (`@NotBlank`, `@Min`)
- Global exception handling via `@ExceptionHandler`
- User-friendly UI using Bootstrap 5

---

## 🛠️ Prerequisites

Make sure you have the following installed:

- Java 17+ (or Java 11+)
- Maven 3.x
- A relational database (e.g., MySQL, PostgreSQL, H2, etc.)

---

## ⚙️ Setup & Running

### 1. Clone the repository
```bash
git clone https://github.com/kulanthaivelan/BookManagementSystem-using-springjdbc.git
cd BookManagementSystemUsingSpringJDBC
````

### 2. Configure your database

* Create a database schema, e.g.:

  **MySQL**

  ```sql
  CREATE DATABASE bookdb;
  ```
* Update `src/main/resources/application.properties`:

  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/bookdb
  spring.datasource.username=root
  spring.datasource.password=your_password
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

  spring.jpa.show-sql=true
  logging.level.org.springframework.jdbc=DEBUG
  ```

### 3. Initialize the `book` table

```sql
CREATE TABLE book (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  author VARCHAR(255) NOT NULL,
  publication_year INT NOT NULL
);
```

### 4. Build & run

```bash
mvn clean spring-boot:run
```

The app will be available at: `http://localhost:8080/books`

---

## 📦 Project Structure

```
com.example.BookManagementSystemUsingSpringJDBC
├── Controller
│   └── BookController.java       # Handles HTTP requests + validation
├── Entity
│   └── Book.java                 # Domain/model with validation annotations
├── Repository
│   └── BookRepository.java       # Uses JdbcTemplate for DB access
├── Service
│   └── BookService.java          # Business logic + logging
└── resources/templates/
    ├── list.html               # View to list all books
    ├── form.html               # View for create/edit form
    └── error.html              # Generic error page
```

---

## 🧪 Usage

1. Navigate to `http://localhost:8080/books` to view all books.
2. Click **Add Book** to create a new entry.
3. Use **Edit** to update a record.
4. Use **Delete** to remove it.
5. If validation fails (e.g., empty title), error messages appear inline.
6. Any unexpected error shows a stylized error page with the exception message.

---

## 🧠 Notes

* Validation annotations on `Book` ensure data integrity.
* The global exception handler in `BookController` catches all runtime exceptions and displays a user-friendly message.
* Logging (`SLF4J`) tracks service-layer operations.

---

## 🚀 Future Enhancements

* Add pagination support for `listBooks`
* Switch to Spring Data JDBC / JPA for repository abstraction
* Integrate unit/integration tests (e.g., using H2 in-memory DB)
* Add authentication/authorization
* Enhance UI/UX with client-side validation and modals

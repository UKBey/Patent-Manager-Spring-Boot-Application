# PatentManager – Spring Boot Application for Patent Tracking and Management

**PatentManager** is a Spring Boot application designed to manage patent application processes, track status, and allow administrative control over submissions. Built with a layered architecture and RESTful API design, this project serves as a backend system for patent management workflows.

---

## 🚀 Features

- Submit, update, and delete patent records
- REST API architecture using Spring Boot
- Layered code structure (Controller, Service, Repository)
- PostgreSQL database integration
- Input validation and basic error handling
- Lightweight configuration using Maven

---

## 🧱 Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- REST APIs

---

## 📁 Project Structure

```
PatentManager/
├── src/
│   ├── main/
│   │   ├── java/                  → Application source code
│   │   ├── resources/
│   │       ├── application.properties → DB and app configuration
├── pom.xml                        → Maven configuration
```

---

## ⚙️ How to Run

1. Clone the repository:
   ```
   git clone https://github.com/UKBey/patent-manager.git
   ```
2. Open the project in your IDE (e.g., IntelliJ IDEA).
3. Configure the PostgreSQL database in `application.properties`.
4. Build the project using Maven:
   ```
   mvn clean install
   ```
5. Run the application:
   ```
   mvn spring-boot:run
   ```
6. Access API endpoints via Postman or Swagger (if configured).

---

## 📄 License

This project is open-source and intended for learning and portfolio use.

---

## 👤 Author

**Ukbe Taha Şahinkaya**  
[GitHub – UKBey](https://github.com/UKBey)

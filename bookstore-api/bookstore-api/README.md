# RESTful Bookstore API (Spring Boot)

A complete Java **Spring Boot** backend for managing **Books** and **Authors** using **H2 in-memory DB**, **Spring Data JPA**, **pagination/sorting/filtering**, and **Swagger UI**.

## How to run

Requirements: Java 17+, Maven 3.9+

```bash
cd bookstore-api
mvn spring-boot:run
```

Starts at `http://localhost:8080/`

- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`
- H2 Console: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:bookstore`, user: `sa`, blank password)

## API Endpoints
See controllers in source, or Swagger.

## Build Jar
```bash
mvn -DskipTests package
java -jar target/bookstore-api-0.0.1-SNAPSHOT.jar
```

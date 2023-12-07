# Sound Tech Task

This project is a Spring Boot application for managing sound entities. It provides RESTful APIs to create, modify, delete, and retrieve sound entities.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)


## Prerequisites

Make sure you have the following installed on your machine:

- Java (JDK 17 or higher)
- Maven
- PostgreSQL

## Getting Started

1. Clone the repository:

   
``` bash
   git clone https://github.com/vegvarizsuzsi/techtask-sound.git
```
2. Configure the database settings in
```
   src/main/resources/application.properties.
```
3. Build and run the project:
```bash
cd techtask-sound
mvn spring-boot:run
```

The application will be accessible at http://localhost:8080.

### Project Structure
```
src/main/java/com/codecool/techtask: Java source code.
src/test/java/com/codecool/techtask: Test code.
```

### API Endpoints
- POST /api/sounds/selectAllSound: Retrieve all sound entities.
- POST /api/sounds/createSound: Create a new sound entity.
- POST /api/sounds/modifySound/{id}: Modify an existing sound entity.
- POST /api/sounds/deleteSound/{id}: Delete a sound entity by ID.

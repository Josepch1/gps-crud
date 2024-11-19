# 📍 GPS Project

Welcome to the **GPS Project**! This project is a demonstration of a Spring Boot application for managing points of interest (POIs).

## 🚀 Getting Started

### Prerequisites

Ensure you have the following installed:

- Java 23 or higher
- Maven 3.6.5 or higher

### Installation

1. Clone the repository:

  ```sh
  git clone https://github.com/Josepch1/gps-crud.git
  cd gps-crud
  ```

2. Build the project:

  ```sh
  ./mvnw clean package
  ```

3. Run the application:

  ```sh
  java -jar target/gps-0.0.1-SNAPSHOT.jar
  ```

## 📚 Project Structure

- **src/main/java**: Contains the main application code.
  - `controller`: REST controllers for handling HTTP requests.
  - `service`: Business logic and service layer.
  - `repository`: Data access layer using Spring Data JPA.
  - `entity`: JPA entities representing the database tables.
- **src/main/resources**: Contains application configuration files.

## 📖 API Endpoints

### Point of Interest

- **GET /v1/gps**: Retrieve all POIs with pagination.
- **GET /v1/gps/{id}**: Retrieve a POI by its ID.
- **GET /v1/gps/name/{name}**: Retrieve POIs by name.
- **POST /v1/gps**: Create a new POI.
- **DELETE /v1/gps/{id}**: Delete a POI by its ID.

## 🛠️ Technologies Used

- **Spring Boot**: Framework for building Java applications.
- **Spring Data JPA**: Data access layer.
- **H2 Database**: In-memory database for development and testing.
- **Maven**: Build and dependency management tool.

Thank you for using the GPS Project! 🌟

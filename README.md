# Quiz Microservices Application

## Overview
The Quiz Microservices Application is a modular and scalable system designed to manage and deliver quizzes. It leverages Spring Boot and a microservices architecture to ensure flexibility, maintainability, and high availability.

## Features
- **API Gateway**: Centralized entry point for managing and routing API requests.
- **Question Service**: Manages question creation, updates, and retrieval.
- **Quiz Service**: Handles quiz creation, user assignments, and score management.
- **Service Registry**: Service discovery for managing microservices.

## Technologies Used
- Java
- Spring Boot
- Spring Cloud
- Eureka (Service Discovery)
- MySQL
- Feign Client
- Lombok

## Services

### 1. API Gateway
- **Description**: Manages and routes API requests.
- **Dependencies**:
  - `spring-boot-starter-actuator`
  - `spring-cloud-starter-gateway`
  - `spring-cloud-starter-netflix-eureka-client`
- **Configuration**: 
  ```properties
  spring.application.name=Api-Gateway
  server.port=8083
  eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
  spring.cloud.gateway.routes[0].id=QUESTION-SERVICES
  spring.cloud.gateway.routes[0].uri=lb://QUESTION-SERVICES
  spring.cloud.gateway.routes[0].predicates[0]=Path=/question/**
  spring.cloud.gateway.routes[1].id=QUIZ-SERVICES
  spring.cloud.gateway.routes[1].uri=lb://QUIZ-SERVICES
  spring.cloud.gateway.routes[1].predicates[0]=Path=/quiz/**
  ```

### 2. Question Service
- **Description**: Manages questions, including creation, updates, and retrieval.
- **Dependencies**:
  - `spring-boot-starter-data-jpa`
  - `spring-cloud-starter-netflix-eureka-client`
  - `spring-boot-starter-web`
  - `mysql-connector-j`
  - `lombok`
- **Configuration**: 
  ```properties
  spring.application.name=Question-Services
  server.port=8081
  spring.datasource.url=jdbc:mysql://localhost:3306/trial
  spring.datasource.username=root
  spring.datasource.password=12345678
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
  eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
  ```

### 3. Quiz Service
- **Description**: Manages quizzes, including creation, user assignments, and score management.
- **Dependencies**:
  - `spring-boot-starter-data-jpa`
  - `spring-cloud-starter-openfeign`
  - `spring-boot-starter-web`
  - `mysql-connector-j`
  - `lombok`
- **Configuration**:
  ```properties
  spring.application.name=Quiz-Services
  server.port=8082
  spring.datasource.url=jdbc:mysql://localhost:3306/trial
  spring.datasource.username=root
  spring.datasource.password=12345678
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
  eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
  ```

### 4. Service Registry
- **Description**: Eureka server for service discovery.
- **Dependencies**:
  - `spring-boot-starter-web`
  - `spring-cloud-starter-netflix-eureka-server`
  - `lombok`
- **Configuration**:
  ```properties
  spring.application.name=ServiceRegistry
  server.port=8761
  eureka.client.register-with-eureka=false
  eureka.client.fetch-registry=false
  ```

## Getting Started

### Prerequisites
- Java 21
- Maven
- MySQL

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/shreyanshagr/Quiz-Microservices-Application.git
   ```
2. Navigate to the project directory:
   ```bash
   cd Quiz-Microservices-Application
   ```
3. Build the project:
   ```bash
   mvn clean install
   ```

### Running the Application
1. Start the Service Registry:
   ```bash
   cd ServiceRegistry
   mvn spring-boot:run
   ```
2. Start the Question Service:
   ```bash
   cd Question-Services
   mvn spring-boot:run
   ```
3. Start the Quiz Service:
   ```bash
   cd Quiz-Services
   mvn spring-boot:run
   ```
4. Start the API Gateway:
   ```bash
   cd Api-Gateway
   mvn spring-boot:run
   ```

## Usage
- Access the API Gateway at `http://localhost:8083`.
- Use the following endpoints to interact with the services:
  - Question Service: `http://localhost:8083/question`
  - Quiz Service: `http://localhost:8083/quiz`

## Contributing
1. Fork the repository.
2. Create your feature branch:
   ```bash
   git checkout -b feature/AmazingFeature
   ```
3. Commit your changes:
   ```bash
   git commit -m 'Add some AmazingFeature'
   ```
4. Push to the branch:
   ```bash
   git push origin feature/AmazingFeature
   ```
5. Open a pull request.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements
- Spring Boot
- Spring Cloud
- Eureka

---

This README provides an overview of the project, detailed descriptions of each service, installation and running instructions, and guidelines for contributing.

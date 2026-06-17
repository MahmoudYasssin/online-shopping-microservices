# Spring Boot Online Shopping Microservices

A cloud-native E-Commerce platform built using Spring Boot and Spring Cloud following a Microservices Architecture. The project demonstrates service decomposition, synchronous and asynchronous communication, security, fault tolerance, monitoring, and containerization.

## Architecture

The system consists of the following microservices:

* Product Service
* Order Service
* Inventory Service
* Notification Service
* API Gateway
* Eureka Discovery Server

### Communication Flow

1. Client sends requests through API Gateway.
2. API Gateway routes requests to the appropriate microservice.
3. Order Service communicates with Inventory Service using OpenFeign.
4. After a successful order creation, Order Service publishes an event to Kafka.
5. Notification Service consumes the event and processes notifications asynchronously.

## Technologies Used

### Backend

* Java 17
* Spring Boot 3
* Spring Data JPA
* Hibernate
* Spring Validation
* Lombok
* Maven

### Microservices & Cloud

* Spring Cloud
* Eureka Server
* Spring Cloud Gateway
* OpenFeign

### Security

* Spring Security
* OAuth2 Resource Server
* JWT Authentication
* Keycloak

### Messaging

* Apache Kafka
* Event-Driven Architecture

### Resilience

* Resilience4j Circuit Breaker
* Fallback Methods

### Monitoring

* Spring Boot Actuator
* Prometheus
* Grafana

### Database

* MySQL

### Containerization

* Docker
* Docker Compose

---

## Services

### Product Service

Responsibilities:

* Create products
* Update products
* Retrieve products
* Manage product catalog

### Inventory Service

Responsibilities:

* Manage inventory
* Check product availability
* Validate stock before order creation

### Order Service

Responsibilities:

* Create customer orders
* Communicate with Inventory Service using OpenFeign
* Publish Order Events to Kafka

### Notification Service

Responsibilities:

* Consume Kafka events
* Process notifications asynchronously

### API Gateway

Responsibilities:

* Single entry point for clients
* Request routing
* Authentication and authorization
* JWT validation

### Eureka Server

Responsibilities:

* Service registration
* Service discovery

---

## Security

Authentication and authorization are implemented using:

* Keycloak
* OAuth2
* JWT Tokens

The API Gateway acts as a Resource Server and validates JWT tokens before forwarding requests to downstream services.

---

## Fault Tolerance

Resilience4j Circuit Breaker is used to:

* Prevent cascading failures
* Improve system resilience
* Provide fallback mechanisms when dependent services become unavailable

---

## Monitoring

The platform is monitored using:

### Prometheus

Collects metrics from:

* Product Service
* Order Service
* Inventory Service
* Notification Service
* API Gateway

### Grafana

Provides dashboards for:

* JVM Metrics
* HTTP Requests
* Response Times
* Service Health
* System Performance

---

## Dockerized Infrastructure

Infrastructure services are containerized using Docker:

* Kafka
* Prometheus
* Grafana

---

## Running the Project

### Start Infrastructure

```bash
docker compose up -d
```

### Start Applications

Start services in the following order:

1. Eureka Server
2. Product Service
3. Inventory Service
4. Notification Service
5. Order Service
6. API Gateway

---

## Access URLs

### Eureka Dashboard

http://localhost:8761

### Keycloak

http://localhost:8081

### Prometheus

http://localhost:9090

### Grafana

http://localhost:3000

### API Gateway

http://localhost:8072

---

## Features Implemented

* Microservices Architecture
* Service Discovery
* API Gateway Routing
* OpenFeign Communication
* MySQL Integration
* Spring Data JPA
* Hibernate ORM
* DTO Pattern
* Mapper Pattern
* OAuth2 Authentication
* JWT Validation
* Keycloak Integration
* Kafka Messaging
* Event-Driven Architecture
* Circuit Breaker Pattern
* Fallback Mechanism
* Dockerized Infrastructure
* Prometheus Monitoring
* Grafana Dashboards

---

## Future Improvements

* Spring Cloud Config Server
* Distributed Tracing with Zipkin
* Kafka Dead Letter Queue (DLQ)
* Kubernetes Deployment
* CI/CD Pipeline using GitHub Actions
* Distributed Caching with Redis

---

## Author

Mahmoud Yassin

Software Engineer | Java & Spring Boot Developer

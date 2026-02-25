# Order Management System

A Spring Boot REST API for creating, updating, retrieving, and deleting restaurant-style orders.

## Why this project
This project demonstrates core backend engineering skills:
- Layered architecture (`controller` → `service` → `repository`)
- Database persistence with Spring Data JPA + MySQL
- Exception handling with centralized advice
- DTO-driven request payloads

## Tech stack
- Java 25
- Spring Boot 3
- Spring Web
- Spring Data JPA
- MySQL
- Lombok
- Gradle (Kotlin DSL)

## Project structure
```text
src/main/java/org/mehedi/ordermanagementsystem
├── controller        # REST endpoints
├── service           # Business logic
├── repository        # Data access
├── model             # Entities and API response model
├── dto               # Request payload models
├── exception         # Custom exceptions and global handlers
└── utils             # Reusable utility methods
```

## Prerequisites
- JDK 25 installed
- MySQL running locally
- A database named `orderdb`

## Local setup
1. Create the database:
   ```sql
   CREATE DATABASE orderdb;
   ```
2. Configure database credentials in `src/main/resources/application.properties`.
3. Run the app:
   ```bash
   ./gradlew bootRun
   ```
4. API base URL:
   ```text
   http://localhost:8080
   ```

## API endpoints

### Create order
```http
POST /order/create
Content-Type: application/json
```

Example body:
```json
{
  "type": "DINE_IN",
  "paymentMethod": "CASH",
  "tableNumber": 7,
  "billAmount": 455.5,
  "instruction": "No onions"
}
```

### Update order
```http
PUT /order/{uid}
Content-Type: application/json
```

Example body:
```json
{
  "paymentMethod": "CARD",
  "instruction": "Extra spicy"
}
```

### Get one order
```http
GET /order/{uid}
```

### Get all orders
```http
GET /order/all
```

### Get all orders by type
```http
GET /order/all/{type}
```

### Delete order
```http
DELETE /order/{uid}
```

## Example curl commands
```bash
curl -X POST http://localhost:8080/order/create \
  -H 'Content-Type: application/json' \
  -d '{"type":"DINE_IN","paymentMethod":"CASH","tableNumber":5,"billAmount":1200,"instruction":"Less salt"}'

curl http://localhost:8080/order/all

curl -X PUT http://localhost:8080/order/1 \
  -H 'Content-Type: application/json' \
  -d '{"instruction":"No sugar"}'

curl -X DELETE http://localhost:8080/order/1
```

## Response format
Successful responses follow a generic envelope:
```json
{
  "status": 200,
  "data": {}
}
```

Error responses follow a generic envelope:
```json
{
  "status": 404,
  "message": "...",
  "error": "..."
}
```

## Architecture
See [`docs/architecture.md`](docs/architecture.md) for request flow and component responsibilities.

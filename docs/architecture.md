# Architecture Overview

## High-level design
The application uses a standard layered architecture:

1. **Controller layer** accepts HTTP requests and maps them to use cases.
2. **Service layer** contains business logic and entity update rules.
3. **Repository layer** persists and reads `Order` entities with Spring Data JPA.
4. **Database layer** stores order data in MySQL.

## Request lifecycle
```text
Client
  │ HTTP request
  ▼
OrderController
  │ delegates
  ▼
OrderService
  │ calls
  ▼
OrderRepository (Spring Data JPA)
  │ SQL via Hibernate
  ▼
MySQL
```

## Core components

### `OrderController`
- Exposes endpoints under `/order`
- Handles create, update, delete, fetch-by-id, fetch-all, and fetch-by-type operations

### `OrderService`
- Builds new `Order` objects from DTOs
- Applies partial updates for mutable fields
- Delegates persistence to repository

### `OrderRepository`
- Extends `JpaRepository<Order, Long>`
- Uses derived query methods for common operations

### `GlobalExceptionHandler`
- Centralizes exception-to-response mapping
- Returns consistent `GenericResponse` payload for handled exceptions

## Data model summary
`Order` includes:
- `orderId` (primary key)
- `type` (`OrderType` enum)
- `orderTime`
- `updatedTime` (list of update timestamps)
- `paymentMethod` (`PaymentMethod` enum)
- `tableNumber`
- `billAmount`
- `instruction`

## Design rationale
- **Layer separation** improves maintainability and testability.
- **DTO input model** avoids binding API payloads directly to JPA entities.
- **Global exception handling** centralizes error formatting.

## Future architecture improvements
- Introduce mapper layer (MapStruct/manual mapper)
- Add validation and richer domain rules
- Add API documentation with OpenAPI
- Add authentication/authorization layer
- Introduce Docker and CI/CD for deployment readiness

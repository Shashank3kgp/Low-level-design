# Parking Lot Design

## Problem Statement
Design a parking lot system that can:
- support different vehicle types such as two-wheelers and four-wheelers,
- allocate an available parking spot automatically,
- create a ticket when a vehicle enters,
- calculate parking charges when the vehicle exits,
- process payment using different payment methods, and
- handle invalid or full-parking scenarios gracefully.

## Main Design Idea
The system is split into small classes with clear responsibilities:
- vehicle-related classes define what kind of vehicle is being parked,
- parking spot and floor classes manage space allocation,
- ticket class tracks entry and exit details,
- strategy classes handle billing and payment behavior,
- the parking lot class acts as the central coordinator.

## Core Entities

### 1. Vehicle
The system uses a `Vehicle` interface so different vehicle implementations can share the same behavior.

- `TwoWheeler` implements the interface for bikes and scooters.
- `FourWheeler` implements the interface for cars and SUVs.
- `VehicleType` is an enum with values `TWO_WHEELER` and `FOUR_WHEELER`.

### 2. ParkingSpot
A parking spot represents one physical parking space.

Responsibilities:
- store the spot id and floor id,
- know the allowed vehicle type for that spot,
- track whether the spot is available,
- assign a vehicle when parking starts,
- clear the spot when the vehicle leaves.

### 3. ParkingFloor
A floor contains multiple parking spots grouped by vehicle type.

Responsibilities:
- maintain a collection of spots for each vehicle type,
- find the first available matching spot,
- assign a vehicle to an available spot,
- clear a spot when the vehicle exits.

### 4. Ticket
A ticket is generated when a vehicle enters the parking lot.

Responsibilities:
- store the vehicle information,
- store the assigned parking spot,
- record the entry time,
- record the exit time when the vehicle leaves.

## Billing and Payment Design

### 5. Cost Strategy
The system uses the Strategy pattern for cost calculation.

- `CostStrategy` is the interface.
- `HourlyCostStrategy` calculates cost based on the duration of parking.
- The cost is rounded up to the next hour and has a minimum of one hour.

### 6. Payment Strategy
The system also uses the Strategy pattern for payment processing.

- `PaymentStrategy` is the interface.
- `UpiPayment` and `CardPayment` implement it.
- `PaymentStrategyFactory` creates the correct payment implementation based on the selected payment type.

## Central Coordinator

### 7. ParkingLot
`ParkingLot` is the main class that orchestrates the whole flow.

Responsibilities:
- maintain the list of parking floors,
- keep track of active tickets,
- check if parking is available for a vehicle type,
- park a vehicle by assigning it an available spot,
- unpark a vehicle by calculating the cost, processing payment, and freeing the spot.

It follows the Singleton pattern so only one parking lot instance is created.

## Class Relationships
- `ParkingLot` contains multiple `ParkingFloor` objects.
- Each `ParkingFloor` contains multiple `ParkingSpot` objects.
- A `Ticket` references one `Vehicle` and one `ParkingSpot`.
- `ParkingLot` uses `CostStrategy` and `PaymentStrategy` to handle billing and payment.

## Flow of Operations

### Parking a vehicle
1. The user calls `parkVehicle(vehicle)` on the parking lot.
2. The parking lot checks each floor for an available matching spot.
3. If a spot is found, the vehicle is assigned to that spot.
4. A new ticket is created and stored as an active ticket.

### Unparking a vehicle
1. The user calls `unparkVehicle(ticketId, paymentType)`.
2. The system finds the active ticket.
3. The exit time is recorded.
4. The parking cost is calculated.
5. Payment is processed.
6. The parking spot is cleared and the ticket is removed from active tickets.

## Exception Handling
The design includes custom exceptions for common failure cases:
- `ParkingFullException` when there is no available spot.
- `TicketNotFoundException` when the ticket is invalid or already removed.
- `PaymentFailedException` when the payment process fails.

## Advantages of This Design
- Clear separation of concerns between vehicle, parking, ticketing, billing, and payment.
- Easy to extend with new vehicle types or payment methods.
- Strategy-based design makes billing and payment flexible.
- Encapsulation keeps each class focused on a single responsibility.

## Limitations / Future Improvements
- Payment is currently stubbed and not connected to a real gateway.
- There is no reservation or pre-booking feature.
- The design does not yet include advanced features like hourly rate changes, VIP parking, or valet support.

## Summary
This parking lot design models a simple but practical low-level design system using object-oriented principles such as abstraction, encapsulation, strategy pattern, and singleton pattern. It offers a clean structure for implementing a real-world parking management system.
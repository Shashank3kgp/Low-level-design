# Facade Design Pattern

## Problem
A subsystem has many classes and complex interactions, and the client code has to know too much about them.
This leads to tightly coupled code and makes the system harder to use.

## Why this pattern exists
The facade pattern provides a simple interface to a larger, more complex subsystem.
It reduces complexity for the client by hiding internal details and providing a single entry point.

## Real world example
An online payment system may involve card validation, fraud checks, bank communication, and email receipt sending.
A payment facade exposes a single method like `makePayment()` so the client code does not need to deal with all these components directly.

## Class Diagram
- See `design-patterns/Facade-pattern/README.md`

## Advantages
- Simplifies client code.
- Reduces coupling to internal subsystem classes.
- Makes the system easier to use and maintain.

## Disadvantages
- The facade can become a large god object if it handles too much.
- It may hide useful lower-level functionality from advanced users.
- Too many facades can make the design harder to navigate.

## When not to use it
- When the subsystem is simple and does not need abstraction.
- When you need direct access to specific subsystem capabilities.
- When a more specific interface or layered design is better than a single entry point.

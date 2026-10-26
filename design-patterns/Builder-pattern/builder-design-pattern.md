# Builder Design Pattern

## Problem
You need to create a complex object with many optional fields, and passing all of them through a constructor becomes messy and hard to read.
This is common when building SQL queries, API payloads, or domain objects with many configuration options.

## Why this pattern exists
The builder pattern separates object construction from the object itself.
It lets you configure only the parts you need while keeping the final object consistent and readable.

## Real world example
An ORM framework builds SQL queries step by step. A developer may call methods like `select()`, `from()`, `where()`, and `orderBy()` to construct a query without manually writing a long, fragile constructor.
The builder assembles the final SQL logically and cleanly.

## Class Diagram
- See `design-patterns/Builder-pattern/README.md`

## Advantages
- Makes construction of complex objects easier to read.
- Avoids long constructor parameter lists.
- Allows optional attributes without invalid intermediate states.

## Disadvantages
- Adds an extra class or nested builder structure.
- Can be more code than a simple constructor for small objects.

## When not to use it
- When the object is simple and has only a few attributes.
- When there are no optional fields or configuration steps.
- When a factory or dependency injection setup already handles creation cleanly.

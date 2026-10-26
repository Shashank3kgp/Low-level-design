# Singleton Design Pattern

## Problem
You need exactly one instance of a class throughout the application, and you want to control how that instance is created.
If multiple objects of the same type are created accidentally, shared state can become inconsistent and harder to manage.

## Why this pattern exists
The singleton pattern ensures a class has only one instance and provides a global access point to it.
This is useful for shared resources like configuration, logging, or connection managers.

## Real world example
A logging system should use a single logger instance so all parts of an application write to the same output stream.
Instead of creating multiple loggers, the application asks the singleton for the one shared instance.

## Class Diagram
- See `design-patterns/Singleton-design-pattern/README.md`

## Advantages
- Ensures only one instance exists.
- Provides a global point of access.
- Helps coordinate shared resources and state.

## Disadvantages
- Can hide dependencies because global state is hard to trace.
- Makes testing harder if the singleton is tightly coupled to application code.
- Can become a bottleneck if overused for unrelated responsibilities.

## When not to use it
- When you genuinely need multiple instances of the same class.
- When the object is simple and does not need shared global state.
- When a full dependency injection framework is already managing lifecycle and configuration.

# Factory Design Pattern

## Problem
You want to create objects without hard-coding the exact class in every place that uses them.
If client code must instantiate specific types directly, it becomes hard to change or extend later.

## Why this pattern exists
The factory pattern centralizes object creation and keeps clients focused on using objects, not building them.
This makes it easier to add new product types without changing existing client code.

## Real world example
An ordering system needs to create different kinds of notifications such as email or SMS.
The system asks a factory for a notification object instead of instantiating `EmailNotification` or `SmsNotification` directly.

## Class Diagram
- See `design-patterns/Factory-pattern/README.md`

## Advantages
- Keeps object creation logic in one place.
- Makes it easier to add or change concrete product classes.
- Reduces duplicate `new` expressions in client code.

## Disadvantages
- Can add an extra layer of indirection.
- The factory may become large if it handles many product types.

## When not to use it
- When object creation is simple and not likely to change.
- When there are only one or two concrete classes and no need for abstraction.
- When a full dependency injection framework is already managing object creation.

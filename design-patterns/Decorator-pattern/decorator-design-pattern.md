# Decorator Design Pattern

## Problem
You want to add optional features to objects, but you don’t want a separate subclass for every combination.
For example, a coffee can be plain, with mocha, with whip, or with both — and you should be able to build that at runtime.

## Why this pattern exists
This pattern exists so we can keep the core object simple and attach extra behavior from the outside.
Decorators wrap a base object and add features while still using the same interface, so the object can stay small and the extras stay separate.

## Real world example
A coffee shop starts with a beverage like espresso or house blend.
Customers then add condiments like mocha, whip, or soy.
Each condiment adds cost and description while preserving the beverage object.

## Class Diagram
- See `design-patterns/Decorator-pattern/README.md`

## Advantages
- Adds functionality to objects at runtime.
- Avoids creating many subclasses for combinations of features.
- Keeps core classes simple and lets decorators handle optional behavior.

## Disadvantages
- Can make debugging harder because behavior is distributed across decorators.
- Many small decorator objects can make the design more complex to follow.

## When not to use it
- When the behavior can be handled by a single class or simple inheritance.
- When you need strong guarantees about object identity or exact type.
- When performance is critical and many decorator wrappers would add overhead.


# Adapter Design Pattern

## Problem
You have an existing class or library whose interface does not match the interface your application expects.
Instead of rewriting the old code, you want to make it work with the new API using a wrapper.

## Why this pattern exists
The adapter pattern converts one interface into another so incompatible classes can work together.
This is especially useful when integrating third-party libraries, legacy systems, or database access layers.

## Real world example
A legacy database client exposes methods like `executeRawQuery(String sql)`, but your application expects a clean repository API like `findUsers()`. An adapter sits in the middle and translates the modern call into the old database interface.

## Class Diagram
- See `design-patterns/Adapter-pattern/README.md`

## Advantages
- Allows incompatible components to work together.
- Reuses legacy code instead of rewriting it.
- Keeps application code cleaner and more consistent.

## Disadvantages
- Adds another layer of abstraction.
- Can create extra code if many adapters are needed.
- Sometimes the adapter can become too generic and hide real logic.

## When not to use it
- When the existing code already matches your expected interface.
- When you can safely refactor the incompatible code instead of wrapping it.
- When a small change in the original API would be more straightforward than building an adapter.

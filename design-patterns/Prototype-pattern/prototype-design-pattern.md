# Prototype Design Pattern

## Problem
You need to create many similar objects, and creating each one from scratch is expensive, repetitive, or hard to manage.
This is common when building many SQL queries or ORM config objects that share most of the same structure.

## Why this pattern exists
The prototype pattern allows an object to create copies of itself by cloning an existing instance.
This saves time and keeps similar objects consistent without repeating a lot of setup code.

## Real world example
An ORM framework may keep a reusable query template for selecting active users from a table.
Instead of rebuilding the same query each time, the system clones that template and changes only the values that differ, such as filters or ordering.

## Class Diagram
- See `design-patterns/Prototype-pattern/README.md`

## Advantages
- Avoids repeated initialization logic.
- Useful when creating objects is expensive.
- Makes it easy to create variations from an existing object.

## Disadvantages
- Cloning logic can become tricky when objects contain complex nested state.
- Deep-copying may be required for mutable references.
- Can be harder to understand if the object graph is large.

## When not to use it
- When objects are simple and cheap to construct directly.
- When cloning would create confusing shared state.
- When the object structure is not repeated enough to justify the pattern.

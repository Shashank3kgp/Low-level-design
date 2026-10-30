# State Design Pattern

## Problem
An object behaves differently depending on its current condition, and that logic becomes complicated if it is all mixed into one class.
This often leads to long conditional statements and difficult-to-maintain code.

## Why this pattern exists
The state pattern lets an object delegate behavior to a separate state object.
Each state represents a valid condition of the object and defines the actions available in that state.

## Real world example
A vending machine changes behavior based on whether it is idle, has a coin inserted, or has already dispensed an item.
The same operation may do different things depending on the current state, and each state can manage its own transition rules.

## Class Diagram
- See `design-patterns/State-pattern/README.md`

## Advantages
- Simplifies complex conditional logic.
- Makes state-specific behavior easier to understand.
- Helps add new states without modifying central logic extensively.

## Disadvantages
- Adds more classes and object transitions.
- Can be overkill for very simple objects.
- Requires careful handling of state changes to avoid invalid transitions.

## When not to use it
- When there are only one or two simple states.
- When the behavior is not expected to change much over time.
- When a simple switch or if-else block is easier to maintain.

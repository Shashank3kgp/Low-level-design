# Chain of Responsibility Design Pattern

## Problem
A request may need to be handled by one of several components, but the sender does not know which one should process it.
If you hard-code every possible handler in the caller, the code becomes tightly coupled and hard to extend.

## Why this pattern exists
The chain of responsibility pattern passes a request through a sequence of handlers.
Each handler decides either to process the request or pass it to the next handler in the chain.

## Real world example
A customer support system may route issues through levels such as frontend support, backend support, and engineering.
A simple issue is resolved early, while complex issues move down the chain until someone can handle them.

## Class Diagram
- See `design-patterns/Chain-of-responsibility-pattern/README.md`

## Advantages
- Decouples the sender from the receiver.
- Makes it easy to add or reorder handlers.
- Allows requests to be processed by different components without hard-coded conditions.

## Disadvantages
- A request may go unhandled if the chain is incomplete.
- Debugging can be harder because flow depends on several objects in sequence.
- The chain can become difficult to manage if too many handlers are added.

## When not to use it
- When only one handler is needed.
- When the request flow is fixed and does not benefit from dynamic routing.
- When the logic is simple enough to be handled directly in a single method.

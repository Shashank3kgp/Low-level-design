# Proxy Design Pattern

## Problem
You need to control access to an object, delay its creation, or add extra behavior without changing the client code.
Directly using the real object can be expensive, unsafe, or not appropriate in some contexts.

## Why this pattern exists
The proxy pattern introduces a placeholder object that stands in for the real object.
The proxy can enforce permissions, add logging, perform lazy initialization, or provide a safer access layer.

## Real world example
A secure document viewer may show a document only if the user has permission.
The client asks a document proxy for access, and the proxy checks authorization before delegating to the real document object.

## Class Diagram
- See `design-patterns/Proxy-pattern/README.md`

## Advantages
- Controls access to sensitive resources.
- Can add logging and validation without changing the real object.
- Can defer expensive object creation until needed.

## Disadvantages
- Adds an extra layer of indirection.
- Can be confusing if too many proxy behaviors are layered together.
- Sometimes the proxy is only a thin wrapper and adds little value.

## When not to use it
- When the real object is simple and safe to access directly.
- When no control, validation, or lazy loading is needed.
- When a direct object reference is straightforward and clearer.

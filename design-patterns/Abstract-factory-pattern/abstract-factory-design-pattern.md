# Abstract Factory Design Pattern

## Problem
You need to create families of related objects together, and the client should not depend on concrete classes.
If you hard-code one platform’s components, it is hard to switch to another family later.

## Why this pattern exists
Abstract Factory groups a set of related factories behind a common interface.
This lets clients create compatible products without knowing the exact platform or implementation.

## Real world example
A UI toolkit needs to build windows, buttons, and checkboxes for different operating systems.
The app can use a Windows factory or a macOS factory to get matching controls.

## Class Diagram
- See `design-patterns/Abstract-factory-pattern/README.md`

## Advantages
- Ensures product families are used together.
- Makes it easy to switch between different implementations.
- Keeps client code independent of concrete product classes.

## Disadvantages
- Requires many interfaces and classes.
- Can be overkill for small or simple systems.

## When not to use it
- When products are not related or do not need to be used together.
- When only one product family exists.
- When the design is simple and a single factory or direct instantiation is enough.

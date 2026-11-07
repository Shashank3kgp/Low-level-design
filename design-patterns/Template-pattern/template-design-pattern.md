# Template Design Pattern

## Problem
You have an algorithm that is mostly the same across different cases, but a few steps vary depending on the type of object or input.
If you duplicate the shared workflow in each subclass, the code becomes repetitive and hard to maintain.

## Why this pattern exists
The template method pattern defines the skeleton of an algorithm in one place and lets subclasses customize only the changing steps.
This keeps the overall process consistent while allowing different implementations for specific details.

## Real world example
A document processing workflow often has the same high-level steps: open file, parse content, and save results.
A PDF processor and a Word processor may share the same workflow but implement the parsing logic differently.

## Class Diagram
- See `design-patterns/Template-pattern/README.md`

## Advantages
- Avoids code duplication.
- Keeps common workflow logic in one place.
- Makes it easier to add new variants of the same process.

## Disadvantages
- Can be restrictive if every subclass must follow the same algorithm flow.
- Sometimes the template becomes too rigid.
- Subclasses may need to know a lot about the base class structure.

## When not to use it
- When the algorithm is unique for each subclass and has little common structure.
- When there is no stable sequence of steps to standardize.
- When the behavior is too dynamic to fit a fixed template.

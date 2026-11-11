# Composite Design Pattern

## Problem
You want to treat individual objects and groups of objects in the same way.
This is common in file systems, where a file and a folder both behave like a node in a larger structure.

## Why this pattern exists
The composite pattern allows clients to interact with a hierarchy of objects using a common interface.
Leaf nodes and composite nodes are treated uniformly, even though the composite node contains children.

## Real world example
A file system contains files and folders. A folder can contain files and other folders, while a file is a leaf and cannot contain children. Both are represented as components in the same tree.

## Class Diagram
- See `design-patterns/Composite-pattern/README.md`

## Advantages
- Simplifies client code by treating files and folders uniformly.
- Makes recursive structures easier to build and manage.
- Helps represent tree-like hierarchies naturally.

## Disadvantages
- The base component interface can become too general.
- Some operations may not make sense for all components.
- Overuse can make the design more abstract than necessary.

## When not to use it
- When the hierarchy is not tree-shaped.
- When there are few shared operations between parents and leaves.
- When the object structure is simple enough without a common abstraction.

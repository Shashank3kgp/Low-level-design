# Command Design Pattern

## Problem
A client needs to trigger actions without directly calling the target object’s methods.
This is useful when you want to queue, log, undo, or delay operations.

## Why this pattern exists
The command pattern wraps an action in an object so that the caller does not depend on the receiver directly.
This makes it easier to pass requests around and manage them as first-class objects.

## Real world example
A TV remote control is a classic command example. Pressing a button does not directly call the TV logic. Instead, the button triggers a command object such as `TurnOnCommand` or `TurnOffCommand`.

## Class Diagram
- See `design-patterns/Command-pattern/README.md`

## Advantages
- Decouples sender and receiver.
- Makes it easy to add undo/redo or logging.
- Helps support queued or deferred execution.

## Disadvantages
- Can add more classes for each action.
- Sometimes feels heavy for very small operations.
- May be unnecessary if there is no need to queue or parameterize commands.

## When not to use it
- When the action is simple and always called directly.
- When there is no need to store or reuse operations.
- When the code would become unnecessarily abstract for a small system.

# Decorator Pattern

Below is a class diagram for the decorator example implemented in the Java code.

```mermaid
classDiagram
    class Beverage {
        <<interface>>
        +cost()
        +getDescription()
    }

    class Espresso {
        +cost()
        +getDescription()
    }

    class HouseBlend {
        +cost()
        +getDescription()
    }

    class CondimentDecorator {
        <<abstract>>
        +cost()
        +getDescription()
    }

    class Mocha {
        +cost()
        +getDescription()
    }

    class Whip {
        +cost()
        +getDescription()
    }

    class Main {
        +main(String[] args)
    }

    Beverage <|.. Espresso
    Beverage <|.. HouseBlend
    Beverage <|.. CondimentDecorator
    CondimentDecorator <|.. Mocha
    CondimentDecorator <|.. Whip
    Main ..> Espresso
    Main ..> HouseBlend
    Main ..> Mocha
    Main ..> Whip
```

### Explanation
- `Beverage` defines the interface for objects that can have responsibilities added.
- `Espresso` and `HouseBlend` are concrete beverages.
- `CondimentDecorator` is an abstract decorator that also implements `Beverage`.
- `Mocha` and `Whip` add behavior to a `Beverage` object at runtime.
- `Main` builds a decorated beverage and demonstrates the pattern.

# Factory Pattern

Below is a class diagram for a simple factory method example.

```mermaid
classDiagram
    class Product {
        <<interface>>
        +getName()
    }

    class ConcreteProductA {
        +getName()
    }

    class ConcreteProductB {
        +getName()
    }

    class Creator {
        <<abstract>>
        +createProduct(String type)
    }

    class ConcreteCreator {
        +createProduct(String type)
    }

    class Client {
        +main(String[] args)
    }

    Product <|.. ConcreteProductA
    Product <|.. ConcreteProductB
    Creator <|.. ConcreteCreator
    Client ..> Creator : uses
    Client ..> Product : uses
```

### Explanation
- `Product` defines the interface for objects created by the factory.
- `ConcreteProductA` and `ConcreteProductB` are different implementations.
- `Creator` declares the factory method.
- `ConcreteCreator` implements the factory method and decides which product to create.
- `Client` calls the factory method instead of instantiating products directly.

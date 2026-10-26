# Singleton Pattern

Below is a simple class diagram for a thread-safe singleton example.

```mermaid
classDiagram
    class Singleton {
        -static Singleton instance
        -Singleton()
        +static getInstance()
        +doWork()
    }

    class Client {
        +main(String[] args)
    }

    Client ..> Singleton : uses
```

### Explanation
- `Singleton` defines the single global instance and hides its constructor.
- `getInstance()` creates the instance once and reuses it for every call.
- `Client` accesses the singleton through the static method instead of creating new objects directly.

# Observer Design Pattern

Below is a class diagram for the observer example implemented in the Java code.

```mermaid
classDiagram
    class Observer {
        <<interface>>
        +update(String temperature)
    }

    class WeatherStation {
        -List~Observer~ observers
        -String temperature
        +addObserver(Observer observer)
        +setTemperature(String temperature)
        -notifyObservers()
    }

    class MobileApp {
        +update(String temperature)
    }

    class WebApp {
        +update(String temperature)
    }

    class Main {
        +main(String[] args)
    }

    Observer <|.. MobileApp
    Observer <|.. WebApp
    WeatherStation o-- Observer : maintains
    Main ..> WeatherStation : creates
    Main ..> MobileApp : creates
    Main ..> WebApp : creates
```

### Explanation
- `WeatherStation` acts as the subject.
- `Observer` is the interface implemented by all subscribers.
- `MobileApp` and `WebApp` are concrete observers.
- `Main` wires everything together and demonstrates the pattern.

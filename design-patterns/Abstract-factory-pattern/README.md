# Abstract Factory Pattern

Below is a class diagram for an abstract factory example.

```mermaid
classDiagram
    class Button {
        <<interface>>
        +paint()
    }

    class Checkbox {
        <<interface>>
        +paint()
    }

    class GUIFactory {
        <<interface>>
        +createButton()
        +createCheckbox()
    }

    class WinButton {
        +paint()
    }

    class MacButton {
        +paint()
    }

    class WinCheckbox {
        +paint()
    }

    class MacCheckbox {
        +paint()
    }

    class WindowsFactory {
        +createButton()
        +createCheckbox()
    }

    class MacOSFactory {
        +createButton()
        +createCheckbox()
    }

    class Application {
        +Application(GUIFactory)
        +paint()
    }

    Button <|.. WinButton
    Button <|.. MacButton
    Checkbox <|.. WinCheckbox
    Checkbox <|.. MacCheckbox
    GUIFactory <|.. WindowsFactory
    GUIFactory <|.. MacOSFactory
    Application ..> GUIFactory
    Application ..> Button
    Application ..> Checkbox
```

### Explanation
- `Button` and `Checkbox` define the product interfaces.
- `GUIFactory` defines methods for creating related products.
- `WindowsFactory` and `MacOSFactory` create product families for a specific platform.
- `Application` uses the abstract factory to get compatible UI components.
- The client can switch product families without changing application code.

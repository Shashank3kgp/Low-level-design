# Command Pattern

Below is a simple class diagram for a remote-control example.

```mermaid
classDiagram
    class Command {
        <<interface>>
        +execute()
    }

    class LightOnCommand {
        +execute()
    }

    class LightOffCommand {
        +execute()
    }

    class RemoteControl {
        +pressButton(Command command)
    }

    class Light {
        +on()
        +off()
    }

    Command <|.. LightOnCommand
    Command <|.. LightOffCommand
    LightOnCommand ..> Light
    LightOffCommand ..> Light
    RemoteControl ..> Command
```

### Explanation
- `Command` defines the common method every action must implement.
- `LightOnCommand` and `LightOffCommand` wrap concrete actions.
- `RemoteControl` invokes commands without knowing the details of the receiver.
- `Light` is the actual object that performs the work.

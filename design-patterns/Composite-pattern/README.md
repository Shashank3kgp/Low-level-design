# Composite Pattern

Below is a simple class diagram for a file-system example.

```mermaid
classDiagram
    class FileSystemComponent {
        <<abstract>>
        +getName()
        +getSize()
        +add(FileSystemComponent)
        +remove(FileSystemComponent)
        +display(String indent)
    }

    class File {
        +getName()
        +getSize()
        +display(String indent)
    }

    class Folder {
        -List<FileSystemComponent> children
        +add(FileSystemComponent)
        +remove(FileSystemComponent)
        +display(String indent)
    }

    class Client {
        +main(String[] args)
    }

    FileSystemComponent <|-- File
    FileSystemComponent <|-- Folder
    Client ..> FileSystemComponent : uses
```

### Explanation
- `FileSystemComponent` is the common abstraction for both files and folders.
- `File` is a leaf node that has no children.
- `Folder` is a composite node that contains other components.
- The client can work with files and folders uniformly using the same interface.

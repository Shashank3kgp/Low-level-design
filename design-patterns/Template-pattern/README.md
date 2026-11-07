# Template Pattern

Below is a simple class diagram for a document-processing example.

```mermaid
classDiagram
    class DocumentProcessor {
        <<abstract>>
        +processDocument()
        +openDocument()
        +parseContent()
        +saveDocument()
    }

    class PdfProcessor {
        +openDocument()
        +parseContent()
        +saveDocument()
    }

    class WordProcessor {
        +openDocument()
        +parseContent()
        +saveDocument()
    }

    class Client {
        +main(String[] args)
    }

    DocumentProcessor <|-- PdfProcessor
    DocumentProcessor <|-- WordProcessor
    Client ..> DocumentProcessor : uses
```

### Explanation
- `DocumentProcessor` defines the overall template: open, parse, save.
- `PdfProcessor` and `WordProcessor` implement the variable steps.
- The algorithm structure stays fixed while the details differ by document type.

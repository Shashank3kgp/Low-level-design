# Adapter Pattern

Below is a simple class diagram for an ORM adapter example.

```mermaid
classDiagram
    class LegacyDatabase {
        +executeRawQuery(String sql)
    }

    class SqlRepository {
        <<interface>>
        +findAllUsers()
    }

    class DatabaseAdapter {
        +findAllUsers()
    }

    class Application {
        +main(String[] args)
    }

    SqlRepository <|.. DatabaseAdapter
    LegacyDatabase <-- DatabaseAdapter
    Application ..> SqlRepository : uses
```

### Explanation
- `LegacyDatabase` is an existing class with a raw-query API that does not match the repository interface.
- `DatabaseAdapter` adapts the old API into the new interface expected by the application.
- `Application` uses the adapter without knowing the details of the legacy implementation.

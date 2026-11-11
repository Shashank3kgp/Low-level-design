# Facade Pattern

Below is a simple class diagram for a payment processing example.

```mermaid
classDiagram
    class PaymentFacade {
        +makePayment(String cardNumber, double amount)
    }

    class CardProcessor {
        +validateCard(String cardNumber)
    }

    class BankService {
        +chargeCard(String cardNumber, double amount)
    }

    class EmailService {
        +sendReceipt(String email)
    }

    class Client {
        +main(String[] args)
    }

    PaymentFacade ..> CardProcessor
    PaymentFacade ..> BankService
    PaymentFacade ..> EmailService
    Client ..> PaymentFacade : uses
```

### Explanation
- `PaymentFacade` hides the complexity of the payment system behind a simple method.
- The client does not need to know about validation, bank charge, or receipt logic.
- The facade provides a single, cleaner interface to a group of subsystems.

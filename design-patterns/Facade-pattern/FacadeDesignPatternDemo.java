// Beginner-friendly example of the Facade Design Pattern in Java
// This version models a payment system behind a simple facade.

class CardValidator {
    public boolean validateCard(String cardNumber) {
        return cardNumber != null && cardNumber.length() >= 12;
    }
}

class BankService {
    public boolean chargeCard(String cardNumber, double amount) {
        System.out.println("Charging " + amount + " to card " + cardNumber);
        return true;
    }
}

class EmailService {
    public void sendReceipt(String email) {
        System.out.println("Receipt sent to " + email);
    }
}

class PaymentFacade {
    private final CardValidator cardValidator = new CardValidator();
    private final BankService bankService = new BankService();
    private final EmailService emailService = new EmailService();

    public void makePayment(String cardNumber, String email, double amount) {
        if (!cardValidator.validateCard(cardNumber)) {
            System.out.println("Payment failed: invalid card number");
            return;
        }

        boolean paymentSuccess = bankService.chargeCard(cardNumber, amount);
        if (!paymentSuccess) {
            System.out.println("Payment failed: bank declined the transaction");
            return;
        }

        emailService.sendReceipt(email);
        System.out.println("Payment successful!");
    }
}

public class FacadeDesignPatternDemo {
    public static void main(String[] args) {
        PaymentFacade paymentFacade = new PaymentFacade();

        paymentFacade.makePayment("123456789012", "user@example.com", 250.00);
    }
}

// Beginner-friendly example of the Factory Design Pattern in Java

interface Notification {
    void send();
}

class EmailNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending email notification");
    }
}

class SmsNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending SMS notification");
    }
}

abstract class NotificationCreator {
    public abstract Notification createNotification(String channel);
}

class ConcreteNotificationCreator extends NotificationCreator {
    @Override
    public Notification createNotification(String channel) {
        if ("EMAIL".equalsIgnoreCase(channel)) {
            return new EmailNotification();
        } else if ("SMS".equalsIgnoreCase(channel)) {
            return new SmsNotification();
        }
        throw new IllegalArgumentException("Unknown notification channel: " + channel);
    }
}

public class FactoryDesignPatternDemo {
    public static void main(String[] args) {
        NotificationCreator creator = new ConcreteNotificationCreator();

        Notification email = creator.createNotification("EMAIL");
        email.send();

        Notification sms = creator.createNotification("SMS");
        sms.send();
    }
}

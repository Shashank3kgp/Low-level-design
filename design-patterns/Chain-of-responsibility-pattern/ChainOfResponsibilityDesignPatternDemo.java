// Beginner-friendly example of the Chain of Responsibility Design Pattern in Java
// This version models a support ticket escalation system.

abstract class SupportHandler {
    protected SupportHandler nextHandler;

    public void setNext(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(String issue);
}

class FrontDeskSupport extends SupportHandler {
    @Override
    public void handleRequest(String issue) {
        if (issue.equalsIgnoreCase("password reset") || issue.equalsIgnoreCase("login issue")) {
            System.out.println("Front desk support resolved: " + issue);
            return;
        }

        if (nextHandler != null) {
            nextHandler.handleRequest(issue);
        } else {
            System.out.println("No support team could resolve: " + issue);
        }
    }
}

class TechnicalSupport extends SupportHandler {
    @Override
    public void handleRequest(String issue) {
        if (issue.equalsIgnoreCase("slow performance") || issue.equalsIgnoreCase("api timeout")) {
            System.out.println("Technical support resolved: " + issue);
            return;
        }

        if (nextHandler != null) {
            nextHandler.handleRequest(issue);
        } else {
            System.out.println("No support team could resolve: " + issue);
        }
    }
}

class EngineeringSupport extends SupportHandler {
    @Override
    public void handleRequest(String issue) {
        if (issue.equalsIgnoreCase("critical bug") || issue.equalsIgnoreCase("server outage")) {
            System.out.println("Engineering support resolved: " + issue);
            return;
        }

        System.out.println("No support team could resolve: " + issue);
    }
}

public class ChainOfResponsibilityDesignPatternDemo {
    public static void main(String[] args) {
        SupportHandler frontDesk = new FrontDeskSupport();
        SupportHandler techSupport = new TechnicalSupport();
        SupportHandler engineering = new EngineeringSupport();

        frontDesk.setNext(techSupport);
        techSupport.setNext(engineering);

        System.out.println("--- Request 1 ---");
        frontDesk.handleRequest("password reset");

        System.out.println("--- Request 2 ---");
        frontDesk.handleRequest("api timeout");

        System.out.println("--- Request 3 ---");
        frontDesk.handleRequest("server outage");
    }
}

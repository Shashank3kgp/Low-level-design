// Beginner-friendly example of the Proxy Design Pattern in Java
// This version models a secure document viewer using a proxy.

interface Document {
    void access();
}

class RealDocument implements Document {
    private final String fileName;

    public RealDocument(String fileName) {
        this.fileName = fileName;
        System.out.println("Loading document: " + fileName);
    }

    @Override
    public void access() {
        System.out.println("Document accessed: " + fileName);
    }
}

class SecureDocumentProxy implements Document {
    private final String fileName;
    private final String userRole;
    private RealDocument realDocument;

    public SecureDocumentProxy(String fileName, String userRole) {
        this.fileName = fileName;
        this.userRole = userRole;
    }

    @Override
    public void access() {
        if (!"ADMIN".equalsIgnoreCase(userRole) && !"MANAGER".equalsIgnoreCase(userRole)) {
            System.out.println("Access denied for role: " + userRole);
            return;
        }

        if (realDocument == null) {
            realDocument = new RealDocument(fileName);
        }

        realDocument.access();
    }
}

public class ProxyDesignPatternDemo {
    public static void main(String[] args) {
        Document adminDoc = new SecureDocumentProxy("payroll.pdf", "ADMIN");
        Document userDoc = new SecureDocumentProxy("payroll.pdf", "EMPLOYEE");

        System.out.println("Admin access:");
        adminDoc.access();

        System.out.println("\nEmployee access:");
        userDoc.access();
    }
}

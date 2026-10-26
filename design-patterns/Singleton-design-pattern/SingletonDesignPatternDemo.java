// Beginner-friendly example of the Singleton Design Pattern in Java

class ConfigurationManager {
    private static volatile ConfigurationManager instance;
    private String appName;

    private ConfigurationManager() {
        this.appName = "Default Application";
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (ConfigurationManager.class) {
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}

public class SingletonDesignPatternDemo {
    public static void main(String[] args) {
        ConfigurationManager firstInstance = ConfigurationManager.getInstance();
        ConfigurationManager secondInstance = ConfigurationManager.getInstance();

        System.out.println("Are both references the same object? " + (firstInstance == secondInstance));

        firstInstance.setAppName("Order Management System");
        System.out.println("App name from second instance: " + secondInstance.getAppName());
    }
}

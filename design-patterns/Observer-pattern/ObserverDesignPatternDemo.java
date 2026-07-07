import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String temperature);
}

class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private String temperature;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

class MobileApp implements Observer {
    public void update(String temperature) {
        System.out.println("Mobile App: Weather updated to " + temperature);
    }
}

class WebApp implements Observer {
    public void update(String temperature) {
        System.out.println("Web App: Weather updated to " + temperature);
    }
}

public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        MobileApp mobileApp = new MobileApp();
        WebApp webApp = new WebApp();

        station.addObserver(mobileApp);
        station.addObserver(webApp);

        station.setTemperature("25°C");
    }
}
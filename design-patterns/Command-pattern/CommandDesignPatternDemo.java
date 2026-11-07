// Beginner-friendly example of the Command Design Pattern in Java
// This version models a simple remote control that triggers commands on a light.

interface Command {
    void execute();
}

class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

class RemoteControl {
    public void pressButton(Command command) {
        command.execute();
    }
}

public class CommandDesignPatternDemo {
    public static void main(String[] args) {
        Light bedroomLight = new Light();
        RemoteControl remote = new RemoteControl();

        Command turnOn = new LightOnCommand(bedroomLight);
        Command turnOff = new LightOffCommand(bedroomLight);

        remote.pressButton(turnOn);
        remote.pressButton(turnOff);
    }
}

// Beginner-friendly example of the Decorator Design Pattern in Java

interface Beverage {
    String getDescription();
    double cost();
}

class Espresso implements Beverage {
    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double cost() {
        return 2.00;
    }
}

class HouseBlend implements Beverage {
    @Override
    public String getDescription() {
        return "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 1.50;
    }
}

abstract class CondimentDecorator implements Beverage {
    protected Beverage beverage;

    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
}

class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.50;
    }
}

class Whip extends CondimentDecorator {
    public Whip(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.30;
    }
}

public class DecoratorDesignPatternDemo {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage mochaEspresso = new Mocha(new Espresso());
        System.out.println(mochaEspresso.getDescription() + " $" + mochaEspresso.cost());

        Beverage houseBlendWithWhipAndMocha = new Whip(new Mocha(new HouseBlend()));
        System.out.println(houseBlendWithWhipAndMocha.getDescription() + " $" + houseBlendWithWhipAndMocha.cost());
    }
}

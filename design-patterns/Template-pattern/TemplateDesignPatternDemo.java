// Beginner-friendly example of the Template Method Design Pattern in Java
// This version models a coffee/tea preparation workflow with a fixed algorithm and variable steps.

abstract class BeveragePreparation {
    public final void prepareBeverage() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    protected void boilWater() {
        System.out.println("Boiling water");
    }

    protected abstract void brew();

    protected void pourInCup() {
        System.out.println("Pouring into cup");
    }

    protected abstract void addCondiments();
}

class TeaPreparation extends BeveragePreparation {
    @Override
    protected void brew() {
        System.out.println("Steeping tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
}

class CoffeePreparation extends BeveragePreparation {
    @Override
    protected void brew() {
        System.out.println("Brewing coffee grounds");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

public class TemplateDesignPatternDemo {
    public static void main(String[] args) {
        BeveragePreparation tea = new TeaPreparation();
        BeveragePreparation coffee = new CoffeePreparation();

        System.out.println("Preparing tea:");
        tea.prepareBeverage();

        System.out.println("\nPreparing coffee:");
        coffee.prepareBeverage();
    }
}

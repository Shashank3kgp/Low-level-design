// Beginner-friendly example of the Strategy Design Pattern in Java

interface DriveStrategy {
    void drive();
}

class NormalDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Driving normally");
    }
}

class OffRoadDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Driving off-road");
    }
}

class SportsDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Driving fast like a sports car");
    }
}

class GoodsDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Driving carefully with goods");
    }
}

class Vehicle {
    private DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void setDriveStrategy(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive() {
        driveStrategy.drive();
    }
}

class OffRoadVehicle extends Vehicle {
    public OffRoadVehicle() {
        super(new OffRoadDriveStrategy());
    }
}

class SportsVehicle extends Vehicle {
    public SportsVehicle() {
        super(new SportsDriveStrategy());
    }
}

class GoodsVehicle extends Vehicle {
    public GoodsVehicle() {
        super(new GoodsDriveStrategy());
    }
}

public class StrategyDesignPatternDemo {
    public static void main(String[] args) {
        Vehicle offRoadVehicle = new OffRoadVehicle();
        Vehicle sportsVehicle = new SportsVehicle();
        Vehicle goodsVehicle = new GoodsVehicle();

        offRoadVehicle.drive();
        sportsVehicle.drive();
        goodsVehicle.drive();

        // You can also change strategy at runtime
        goodsVehicle.setDriveStrategy(new NormalDriveStrategy());
        goodsVehicle.drive();
    }
}

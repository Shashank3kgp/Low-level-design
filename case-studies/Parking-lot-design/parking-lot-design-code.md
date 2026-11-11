
public enum VehicleType {
    TWO_WHEELER,
    FOUR_WHEELER
}

public interface Vehicle {
    String getVehicleId();
    String getVehicleNumber();
    VehicleType getVehicleType();
}

public class TwoWheeler implements Vehicle {
    private final String vehicleId;
    private final String vehicleNumber;

    public TwoWheeler(String vehicleId, String vehicleNumber) {
        this.vehicleId = vehicleId;
        this.vehicleNumber = vehicleNumber;
    }

    @Override
    public String getVehicleId() {
        return vehicleId;
    }

    @Override
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.TWO_WHEELER;
    }
}

public class FourWheeler implements Vehicle {
    private final String vehicleId;
    private final String vehicleNumber;

    public FourWheeler(String vehicleId, String vehicleNumber) {
        this.vehicleId = vehicleId;
        this.vehicleNumber = vehicleNumber;
    }

    @Override
    public String getVehicleId() {
        return vehicleId;
    }

    @Override
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.FOUR_WHEELER;
    }
}

public class ParkingSpot {
    private final String spotId;
    private final String floorId;
    private final VehicleType spotType;
    private Vehicle vehicle;
    private boolean isAvailable;

    public ParkingSpot(String spotId, String floorId, VehicleType spotType) {
        this.spotId = spotId;
        this.floorId = floorId;
        this.spotType = spotType;
        this.vehicle = null;
        this.isAvailable = true;
    }

    public String getSpotId() {
        return spotId;
    }

    public String getFloorId() {
        return floorId;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void assignVehicle(Vehicle vehicle) {
        if (!isAvailable) {
            throw new IllegalStateException("Spot " + spotId + " is already occupied");
        }
        if (vehicle.getVehicleType() != spotType) {
            throw new IllegalArgumentException("Vehicle type mismatch for spot " + spotId);
        }
        this.vehicle = vehicle;
        this.isAvailable = false;
    }

    public void clearSpot() {
        this.vehicle = null;
        this.isAvailable = true;
    }
}


public class ParkingFloor {
    private final String floorId;
    private final Map<VehicleType, List<ParkingSpot>> spotsByType;

    public ParkingFloor(String floorId, Map<VehicleType, List<ParkingSpot>> spotsByType) {
        this.floorId = floorId;
        this.spotsByType = spotsByType;
    }

    public String getFloorId() {
        return floorId;
    }

    public Optional<ParkingSpot> getAvailableSpot(VehicleType vehicleType) {
        List<ParkingSpot> spots = spotsByType.get(vehicleType);
        if (spots == null) {
            return Optional.empty();
        }
        return spots.stream()
                .filter(ParkingSpot::isAvailable)
                .findFirst();
    }

    public Optional<ParkingSpot> assignAvailableSpot(Vehicle vehicle) {
        Optional<ParkingSpot> spotOpt = getAvailableSpot(vehicle.getVehicleType());
        spotOpt.ifPresent(spot -> spot.assignVehicle(vehicle));
        return spotOpt;
    }

    public void clearSpot(VehicleType vehicleType, String spotId) {
        List<ParkingSpot> spots = spotsByType.get(vehicleType);
        if (spots == null) {
            throw new IllegalArgumentException("No spots of type " + vehicleType + " on floor " + floorId);
        }
        spots.stream()
                .filter(s -> s.getSpotId().equals(spotId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Spot " + spotId + " not found on floor " + floorId))
                .clearSpot();
    }

    public boolean hasAvailableSpot(VehicleType vehicleType) {
        return getAvailableSpot(vehicleType).isPresent();
    }
}

public class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public Ticket(Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
        this.exitTime = null;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void markExit() {
        this.exitTime = LocalDateTime.now();
    }
}

public interface CostStrategy {
    double calculateCost(Ticket ticket);
}


public class HourlyCostStrategy implements CostStrategy {
    private final double ratePerHour;

    public HourlyCostStrategy(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double calculateCost(Ticket ticket) {
        if (ticket.getExitTime() == null) {
            throw new IllegalStateException("Cannot calculate cost before exit time is set");
        }
        Duration duration = Duration.between(ticket.getEntryTime(), ticket.getExitTime());
        long minutes = duration.toMinutes();
        // round up to the next full hour, minimum 1 hour
        long hours = (long) Math.ceil(minutes / 60.0);
        if (hours <= 0) {
            hours = 1;
        }
        return hours * ratePerHour;
    }
}

public enum PaymentType {
    UPI,
    CARD
}

public interface PaymentStrategy {
    boolean pay(double amount);
}


public class UpiPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        // stubbed: integrate with a real UPI gateway here
        System.out.println("Paid ₹" + amount + " via UPI");
        return true;
    }
}

public class CardPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        // stubbed: integrate with a real card gateway here
        System.out.println("Paid ₹" + amount + " via Card");
        return true;
    }
}

public class PaymentStrategyFactory {
    public static PaymentStrategy create(PaymentType type) {
        switch (type) {
            case UPI:
                return new UpiPayment();
            case CARD:
                return new CardPayment();
            default:
                throw new IllegalArgumentException("Unsupported payment type: " + type);
        }
    }
}


public class ParkingLot {
    private static ParkingLot instance;

    private final List<ParkingFloor> floors;
    private final Map<String, Ticket> activeTickets;
    private final CostStrategy costStrategy;

    private ParkingLot(List<ParkingFloor> floors, CostStrategy costStrategy) {
        this.floors = floors;
        this.costStrategy = costStrategy;
        this.activeTickets = new ConcurrentHashMap<>();
    }

    public static synchronized ParkingLot getInstance(List<ParkingFloor> floors, CostStrategy costStrategy) {
        if (instance == null) {
            instance = new ParkingLot(floors, costStrategy);
        }
        return instance;
    }

    public boolean isParkingAvailable(VehicleType vehicleType) {
        return floors.stream().anyMatch(floor -> floor.hasAvailableSpot(vehicleType));
    }

    public synchronized Ticket parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            Optional<ParkingSpot> spotOpt = floor.assignAvailableSpot(vehicle);
            if (spotOpt.isPresent()) {
                Ticket ticket = new Ticket(vehicle, spotOpt.get());
                activeTickets.put(ticket.getTicketId(), ticket);
                return ticket;
            }
        }
        throw new ParkingFullException("No available spot for vehicle type: " + vehicle.getVehicleType());
    }

    public synchronized double unparkVehicle(String ticketId, PaymentType paymentType) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket == null) {
            throw new TicketNotFoundException("No active ticket found with id: " + ticketId);
        }

        ticket.markExit();
        double amount = costStrategy.calculateCost(ticket);

        PaymentStrategy paymentStrategy = PaymentStrategyFactory.create(paymentType);
        boolean paymentSuccess = paymentStrategy.pay(amount);

        if (!paymentSuccess) {
            throw new PaymentFailedException("Payment failed for ticket: " + ticketId);
        }

        ParkingSpot spot = ticket.getSpot();
        ParkingFloor floor = getFloorById(spot.getFloorId());
        floor.clearSpot(spot.getSpotType(), spot.getSpotId());

        activeTickets.remove(ticketId);
        return amount;
    }

    private ParkingFloor getFloorById(String floorId) {
        return floors.stream()
                .filter(f -> f.getFloorId().equals(floorId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Floor not found: " + floorId));
    }
}

// Exceptions 

public class ParkingFullException extends RuntimeException {
    public ParkingFullException(String message) {
        super(message);
    }
}

public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException(String message) {
        super(message);
    }
}

public class PaymentFailedException extends RuntimeException {
    public PaymentFailedException(String message) {
        super(message);
    }
}
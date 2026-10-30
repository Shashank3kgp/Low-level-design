// Beginner-friendly example of the State Design Pattern in Java
// This version models a simple vending machine with different states.

interface MachineState {
    void insertCoin(VendingMachine machine);
    void dispense(VendingMachine machine);
    void cancel(VendingMachine machine);
}

class IdleState implements MachineState {
    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("Coin inserted. Machine is now active.");
        machine.setState(new ActiveState());
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("No item can be dispensed because the machine is idle.");
    }

    @Override
    public void cancel(VendingMachine machine) {
        System.out.println("No transaction to cancel.");
    }
}

class ActiveState implements MachineState {
    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("A coin is already inserted. Please dispense or cancel.");
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("Item dispensed successfully.");
        machine.setState(new IdleState());
    }

    @Override
    public void cancel(VendingMachine machine) {
        System.out.println("Transaction cancelled. Money returned.");
        machine.setState(new IdleState());
    }
}

class VendingMachine {
    private MachineState state;

    public VendingMachine() {
        this.state = new IdleState();
    }

    public void setState(MachineState state) {
        this.state = state;
    }

    public void insertCoin() {
        state.insertCoin(this);
    }

    public void dispense() {
        state.dispense(this);
    }

    public void cancel() {
        state.cancel(this);
    }
}

public class StateDesignPatternDemo {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        machine.insertCoin();
        machine.dispense();

        machine.insertCoin();
        machine.cancel();

        machine.dispense();
    }
}

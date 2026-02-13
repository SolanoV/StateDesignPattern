package concretestates;

import context.VendingMachine;
import stateinterface.VendingMachineState;

public class OutOfOrderState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine vm, String item, double price) {
        System.out.println("Machine is Out of Order.");
    }

    @Override
    public void insertCoin(VendingMachine vm, double amount) {
        System.out.println("Machine is Out of Order.");
    }

    @Override
    public void dispenseItem(VendingMachine vm) {
        System.out.println("Machine is Out of Order.");
    }

    @Override
    public void setOutofOrder(VendingMachine vm) {
        System.out.println("Machine is already Out of Order.");
    }
}

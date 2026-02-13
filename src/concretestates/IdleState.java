package concretestates;

import context.VendingMachine;
import stateinterface.VendingMachineState;

public class IdleState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine vm, String item, double price) {
        System.out.println("Selected Item: " + item + " Price: $" + price);
        vm.setSelectedItemPrice(price);
        vm.setItem(item);
        vm.setState(new ItemSelectedState());
    }

    @Override
    public void insertCoin(VendingMachine vm, double amount) {
        System.out.println("Please select an item first.");
    }

    @Override
    public void dispenseItem(VendingMachine vm) {
        System.out.println("Please select an item first.");
    }

    @Override
    public void setOutofOrder(VendingMachine vm) {
        System.out.println("Machine is now Out of Order.");
        vm.setState(new OutOfOrderState());
    }
}

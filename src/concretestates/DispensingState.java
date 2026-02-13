package concretestates;

import context.VendingMachine;
import stateinterface.VendingMachineState;

public class DispensingState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine vm, String item, double price) {
        System.out.println("Please wait, dispensing item...");
    }

    @Override
    public void insertCoin(VendingMachine vm, double amount) {
        System.out.println("Please wait, dispensing item...");
    }

    @Override
    public void dispenseItem(VendingMachine vm) {
        System.out.println("Dispensing item... [SELECTED ITEM: "+vm.getItem()+"]");
        vm.reduceItemInventory();
        if(vm.getBalance()>0){
            System.out.println("Change is: " + String.format("%.2f",(vm.getBalance()-vm.getSelectedItemPrice())));
        }
        vm.setBalance(0);
        System.out.println("Dispensing item complete.");
        vm.setState(new IdleState());
    }

    @Override
    public void setOutofOrder(VendingMachine vm) {
        System.out.println("Cannot switch to OutOfOrder while dispensing.");
    }
}

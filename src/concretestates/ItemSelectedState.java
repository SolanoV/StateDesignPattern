package concretestates;

import context.VendingMachine;
import stateinterface.VendingMachineState;

public class ItemSelectedState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine vm, String item, double price) {
        System.out.println("Item already selected");
    }

    @Override
    public void insertCoin(VendingMachine vm, double amount) {
        vm.addBalance(amount);
        System.out.println("Inserted " + amount + " coin(s). Current Balance: " + vm.getBalance());
    }

    @Override
    public void dispenseItem(VendingMachine vm) {
        if(vm.getBalance()<vm.getSelectedItemPrice()) {
            System.out.println("Insufficient funds. You need $" + (vm.getSelectedItemPrice()-vm.getBalance())+" more.");
        }
        else {
            if(vm.getItemInventory()==0){
                System.out.println("Machine is out of stock. Returning coins...");
                vm.setBalance(0);
                vm.setState(new IdleState());
            }
            else{
                vm.setState(new DispensingState());
                vm.getState().dispenseItem(vm);
            }
        }
    }

    @Override
    public void setOutofOrder(VendingMachine vm) {
        System.out.println("Machine is now Out of Order. Returning balance: $" + vm.getBalance());
        vm.setBalance(0);
        vm.setState(new OutOfOrderState());
    }
}

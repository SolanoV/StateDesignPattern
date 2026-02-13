package stateinterface;

import context.VendingMachine;

public interface VendingMachineState {
    public void selectItem(VendingMachine vm,String item, double price);
    public void insertCoin(VendingMachine vm, double amount);
    public void dispenseItem(VendingMachine vm);
    public void setOutofOrder(VendingMachine vm);
}

package context;

import concretestates.IdleState;
import stateinterface.VendingMachineState;

public class VendingMachine {
    private VendingMachineState currentState;
    private int itemInventory;
    private String item;
    private double balance;
    private double selectedItemPrice;


    public VendingMachine (int itemInventory) {
        this.currentState = new IdleState();
        this.itemInventory = itemInventory;
        this.balance = 0.0;
    }

    public void selectItem(String item, double price) {
        currentState.selectItem(this, item, price);
    }

    public void insertCoin(double amount) {
        currentState.insertCoin(this, amount);
    }

    public void dispenseItem() {
        currentState.dispenseItem(this);
    }

    public void setOutofOrder() {
        currentState.setOutofOrder(this);
    }

    public void setState(VendingMachineState state) {
        this.currentState = state;
    }

    public VendingMachineState getState() {
        return this.currentState;
    }

    public int getItemInventory() {
        return this.itemInventory;
    }

    public void addItemInventory(int itemInventoryAmount) {
        this.itemInventory += itemInventoryAmount;
        System.out.println("\n[Adding " + itemInventoryAmount + " item(s) into the inventory.]");
    }

    public void reduceItemInventory() {
        if(this.itemInventory > 0) itemInventory--;
        System.out.println(getItem()+" removed from the inventory. [Current Stock: "+this.itemInventory+"]");
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return this.item;
    }

    public void addBalance(double balance) {
        this.balance += balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setSelectedItemPrice(double selectedItemPrice) {
        this.selectedItemPrice = selectedItemPrice;
    }

    public double getSelectedItemPrice() {
        return this.selectedItemPrice;
    }
}

import concretestates.IdleState;
import context.VendingMachine;

public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine(2);

        vm.selectItem("Coca Cola",1.50);
        vm.insertCoin(1.00);
        vm.dispenseItem();
        vm.insertCoin(0.50);
        vm.dispenseItem();

        System.out.println();
        vm.setOutofOrder();
        vm.selectItem("Sprite",1.40);

        System.out.println();
        vm.setState(new IdleState());

        System.out.println();
        vm.selectItem("Sprite",1.40);
        vm.insertCoin(1.40);
        vm.dispenseItem();

        System.out.println();
        vm.selectItem("Royal",1.45);
        vm.dispenseItem();
        vm.insertCoin(1.45);
        vm.dispenseItem();

        vm.addItemInventory(3);

        System.out.println();
        vm.selectItem("Coke Zero",1.65);
        vm.insertCoin(2.00);
        vm.dispenseItem();
    }
}
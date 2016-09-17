package week0.vending;

/**
 * Created by Zhang on 8/29/2015 7:23 下午.
 */
public class MachineTestor {

    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        vm.showPrompt();
        vm.insertMoney(100);
        vm.getFood();
        vm.showBalance();

        VendingMachine vm1 = new VendingMachine(100);
        vm1.showPrompt();
        vm1.insertMoney(200);
        vm1.getFood();
        vm1.showBalance();
    }

}

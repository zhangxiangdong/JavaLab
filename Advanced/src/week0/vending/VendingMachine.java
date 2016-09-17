package week0.vending;

/**
 * Created by Zhang on 8/29/2015 7:17 下午.
 */
public class VendingMachine {

    private int price = 20;
    private int balance;
    private int total;
    
    public VendingMachine() {
        total = 0;
    }

    public VendingMachine(int price) {
        this();
        this.price = price;
    }

    public void showPrompt() {
        System.out.println("Welcome!");
    }

    public void insertMoney(int value) {
        balance = value;
    }

    public void getFood() {
        checkAvailablity(balance);

        System.out.println("Here you are.");
        balance = balance - price;
    }

    public int charge() {
        return balance;
    }

    public void showBalance() {
        System.out.println("Available balance: " + balance);
    }

    private void checkAvailablity(int balance) {
        if (balance < price)
            throw new IllegalArgumentException("Not enough money!");
    }

}

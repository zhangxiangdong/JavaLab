package week0.hashes;

import java.util.HashMap;

/**
 * Created by Zhang on 9/27/2015 12:57 下午.
 */
public class Coin {

    private HashMap<Integer, String> coins = new HashMap<>();

    public Coin() {
        coins.put(1, "Penny");
        coins.put(10, "Dime");
        coins.put(25, "Quarter");
        coins.put(50, "Half-Dollar");
        coins.put(50, "五毛");

        System.out.println(coins.keySet().size());
        System.out.println(coins);

        System.out.println("**************************");

        for (Integer i : coins.keySet()) {
            System.out.println(i + "=" + coins.get(i));
        }
        System.out.println("**************************");
    }

    public String getName(int value) {
        if (coins.containsKey(value))
            return coins.get(value);
        return "Not Found.";
    }

    public static void main(String[] args) {
        Coin coin = new Coin();
        System.out.println(10 + ": " + coin.getName(10));
        System.out.println(11 + ": " + coin.getName(11));
        System.out.println(50 + ": " + coin.getName(50));
    }

}

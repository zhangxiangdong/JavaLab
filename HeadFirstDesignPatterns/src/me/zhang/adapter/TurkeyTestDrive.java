package me.zhang.adapter;

/**
 * Created by Zhang on 11/10/2015 9:23 下午.
 */
public class TurkeyTestDrive {

    public static void main(String[] args) {
        TurkeyClient client = new TurkeyClient();
        MallardDuck duck = new MallardDuck();
        DuckAdapter adapter = new DuckAdapter(duck);
        client.setAdapter(adapter);
        client.action();
    }

}

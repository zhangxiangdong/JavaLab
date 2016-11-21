package me.zhang.adapter;

/**
 * Created by Zhang on 11/10/2015 9:24 下午.
 */
public class TurkeyClient {

    Turkey adapter;

    public TurkeyClient() {
    }

    public TurkeyClient(Turkey adapter) {
        this.adapter = adapter;
    }

    public void setAdapter(Turkey adapter) {
        this.adapter = adapter;
    }

    public void action() {
        adapter.gobble();
        adapter.fly();
    }
}

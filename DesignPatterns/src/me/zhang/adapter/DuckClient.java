package me.zhang.adapter;

/**
 * Created by Zhang on 11/10/2015 9:16 下午.
 */
public class DuckClient {

    Duck adapter;

    public DuckClient() {
    }

    public DuckClient(Duck adapter) {
        this.adapter = adapter;
    }

    public void setAdapter(Duck adapter) {
        this.adapter = adapter;
    }

    public void action() {
        adapter.quack();
        adapter.fly();
    }

}

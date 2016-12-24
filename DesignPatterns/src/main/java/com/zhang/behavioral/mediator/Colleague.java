package com.zhang.behavioral.mediator;

/**
 * Created by Zhang on 2016/12/24 21:40.
 */
public abstract class Colleague {

    private Mediator mediator;
    private int colleagueCode;

    public Colleague(Mediator newMediator) {
        mediator = newMediator;
        mediator.addColleague(this);
    }

    public void saleOffer(String stock, int shares) {
        mediator.saleOffer(stock, shares, this.colleagueCode);
    }

    public void buyOffer(String stock, int shares) {
        mediator.buyOffer(stock, shares, colleagueCode);
    }

    public void setCollCode(int collCode) {
        colleagueCode = collCode;
    }

}

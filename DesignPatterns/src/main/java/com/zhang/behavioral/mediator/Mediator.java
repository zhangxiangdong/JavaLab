package com.zhang.behavioral.mediator;

/**
 * Created by Zhang on 2016/12/24 21:40.
 */
public interface Mediator {

    void saleOffer(String stock, int shares, int collCode);

    void buyOffer(String stock, int shares, int collCode);

    void addColleague(Colleague colleague);


}

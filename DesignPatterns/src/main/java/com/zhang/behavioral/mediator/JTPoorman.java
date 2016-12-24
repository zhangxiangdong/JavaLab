package com.zhang.behavioral.mediator;

/**
 * Created by Zhang on 2016/12/24 21:44.
 */
public class JTPoorman extends Colleague {

    public JTPoorman(Mediator newMediator) {
        super(newMediator);
        System.out.println("JT Poorman signed up with the stockexchange\n");
    }

}

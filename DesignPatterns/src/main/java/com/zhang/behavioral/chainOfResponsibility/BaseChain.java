package com.zhang.behavioral.chainOfResponsibility;

/**
 * Created by Zhang on 12/8/2016 10:53 PM.
 */
public abstract class BaseChain implements Chain {
    protected Chain nextChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextChain = nextChain;
    }
}

package com.zhang.behavioral.chainOfResponsibility;

/**
 * Created by Zhang on 12/8/2016 11:00 PM.
 */
public class ChainTest {

    public static void main(String[] args) {
        Chain addChain = new AddNumbers();
        Chain subtractChain = new SubtractNumbers();
        Chain multChain = new MultNumbers();
        Chain divideChain = new DivideNumbers();

        // Here I tell each object where to forward the
        // data if it can't process the request
        addChain.setNextChain(subtractChain);
        subtractChain.setNextChain(multChain);
        multChain.setNextChain(divideChain);

        // Define the data in the Numbers Object
        // and send it to the first Object in the chain
        Numbers request = new Numbers(12, 3, "/");
        addChain.calculate(request);

        request = new Numbers(22, 180, "=");
        addChain.calculate(request);
    }

}

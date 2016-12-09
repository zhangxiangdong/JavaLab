package com.zhang.behavioral.vistor;

/**
 * Created by Zhang on 12/9/2016 11:09 PM.
 */
public interface Visitor {

    // The visitor pattern is used when you have to perform
    // the same action on many objects of different types

    // Created to automatically use the right
    // code based on the Object sent
    // Method Overloading

    double visit(Liquor liquor);

    double visit(Tobacco tobacco);

    double visit(Neccesity neccesity);

}

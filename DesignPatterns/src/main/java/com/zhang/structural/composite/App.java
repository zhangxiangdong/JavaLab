package com.zhang.structural.composite;

/**
 * Created by zhangxiangdong on 2016/12/2.
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Message from the Jim: ");
        System.out.print("\t");
        LetterComposite jimMessage = new Messenger().messageFromJim();
        jimMessage.print();

        System.out.println();

        System.out.println("Message from the Lily: ");
        System.out.print("\t");
        LetterComposite lilyMessage = new Messenger().messageFromLily();
        lilyMessage.print();
    }

}

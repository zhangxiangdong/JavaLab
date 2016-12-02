package com.zhang.structural.composite;

import java.util.List;

/**
 * Created by zhangxiangdong on 2016/12/2.
 */
public class Word extends LetterComposite {

    public Word(List<Letter> letters) {
        for (Letter letter : letters) {
            add(letter);
        }
    }

    @Override
    protected void printThisBefore() {
        System.out.print(" ");
    }

    @Override
    protected void printThisAfter() {
        // Not required
    }
}

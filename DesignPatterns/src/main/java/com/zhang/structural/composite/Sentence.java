package com.zhang.structural.composite;

import java.util.List;

/**
 * Created by zhangxiangdong on 2016/12/2.
 */
public class Sentence extends LetterComposite {

    public Sentence(List<Word> words) {
        for (Word word : words) {
            add(word);
        }
    }

    @Override
    protected void printThisBefore() {
        // Not required
    }

    @Override
    protected void printThisAfter() {
        // Not required
    }
}

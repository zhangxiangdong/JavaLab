package com.zhang.structural.composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhangxiangdong on 2016/12/2.
 */
public class Messenger {

    LetterComposite messageFromJim() {
        List<Word> words = new ArrayList<>();

        /* Here you are */
        words.add(new Word(Arrays.asList(new Letter('H'), new Letter('e'), new Letter('r'), new Letter('e')))); // Here
        words.add(new Word(Arrays.asList(new Letter('y'), new Letter('o'), new Letter('u')))); // you
        words.add(new Word(Arrays.asList(new Letter('a'), new Letter('r'), new Letter('e')))); // are

        return new Sentence(words);
    }

    LetterComposite messageFromLily() {
        List<Word> words = new ArrayList<>();

        /* Do me a favor */
        words.add(new Word(Arrays.asList(new Letter('D'), new Letter('o')))); // Do
        words.add(new Word(Arrays.asList(new Letter('m'), new Letter('e')))); // me
        words.add(new Word(Collections.singletonList(new Letter('a')))); // a
        words.add(new Word(Arrays.asList(new Letter('f'), new Letter('a'), new Letter('v'), new Letter('o'), new Letter('r')))); // favor

        return new Sentence(words);
    }

}

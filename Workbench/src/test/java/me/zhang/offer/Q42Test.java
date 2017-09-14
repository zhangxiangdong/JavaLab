package me.zhang.offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhangxiangdong on 2017/9/14.
 */
public class Q42Test {

    @Test(expected = NullPointerException.class)
    public void reverse() throws Exception {
        String segment = "student.";
        String reversed = ".tneduts";
        char[] word = segment.toCharArray();
        Q42.reverse(word, 0, word.length - 1);
        Assert.assertEquals(reversed, String.valueOf(word));

        segment = "";
        reversed = "";
        word = segment.toCharArray();
        Q42.reverse(word, 0, word.length - 1);
        Assert.assertEquals(reversed, String.valueOf(word));

        Q42.reverse(null, -1, -1);
    }

    @Test
    public void reverseSentence() {
        String sentence = "I am a student.";
        String reversed = "student. a am I";
        Assert.assertEquals(reversed, Q42.reverseSentence(sentence));
    }

}
package me.zhang.offer;

/**
 * Created by zhangxiangdong on 2017/9/14.
 * <p>
 * 翻转单词顺序 VS 左旋转字符串
 */
public class Q42 {

    /**
     * 输入一个英语句子，翻转句子中单词的顺序，但单词内字符的顺序保持不变。为简单起见，标点符号和普通字母一样处理。
     * 例如输入字符串“I am a student.”，则输出“student. a am I”。
     *
     * @param raw 要反转的句子
     * @return 反转后的句子
     */
    public static String reverseSentence(String raw) {
        if (raw == null) {
            throw new NullPointerException();
        }

        char[] sentence = raw.toCharArray();
        int len = sentence.length;
        /* 1. 反转整句 */
        reverse(sentence, 0, len - 1);

        // 用来标记一个单词的首尾索引
        int begin = 0, end = 0;
        while (begin < len) {
            if (sentence[begin] == ' ') {
                // begin、end索引均指向' '，处理下一个单词
                begin++;
                end++;
            } else if (end == len || sentence[end] == ' ') {
                /* 2. 反转单词 */
                reverse(sentence, begin, end - 1);
                // 准备操作下一个单词
                begin = end;
            } else {
                // 移动end索引，直至索引位置为' '或者移动到句尾
                end++;
            }
        }
        /* 3. 返回反转后的句子 */
        return String.valueOf(sentence);
    }

    public static void reverse(char[] sentence, int lo, int hi) {
        if (sentence == null) {
            throw new NullPointerException();
        }

        while (lo < hi) {
            char t = sentence[lo];
            sentence[lo] = sentence[hi];
            sentence[hi] = t;
            lo++;
            hi--;
        }
    }

}

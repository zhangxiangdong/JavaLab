package me.zhang.basic.re;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Zhang on 2016/4/22 下午 2:19 .
 */
public class BackreferencesTestDrive {
    public static void main(String[] args) {
//        findingRepeatedPattern();
        findingDuplicateWords();
    }

    static void findingRepeatedPattern() {
        String s = "123456123123456123456456";
        Pattern pattern = Pattern.compile("(\\d\\d\\d)\\1"); // (\d\d\d)\1 matches 123123, but does not match 123456 in a row
        Matcher m = pattern.matcher(s);
        System.out.printf("Group Count: %d%n", m.groupCount());

        while (m.find()) {
            String word = m.group();
            System.out.printf("word: %s, start: %d, end: %d%n", word, m.start(), m.end());
        }
    }

    static void findingDuplicateWords() {
        Pattern p = Pattern.compile("\\b(\\w+)\\b[\\w\\W]*\\b\\1\\b", Pattern.CASE_INSENSITIVE);
        String phrase = "unique is not duplicate but unique, Duplicate is duplicate.";
        Matcher matcher = p.matcher(phrase);
        while (matcher.find()) {
            String val = matcher.group();
            System.out.printf("Matching subsequence is \"%s\"%n", val);
            System.out.printf("\tDuplicate word: %s%n", matcher.group(1));
        }
    }
}

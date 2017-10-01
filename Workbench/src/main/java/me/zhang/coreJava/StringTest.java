package me.zhang.coreJava;

/**
 * Created by Zhang on 10/1/2017 4:02 PM.
 */
public class StringTest {

    public static void main(String[] args) {
        String 𐀀 = "\uD800\uDC00";
        String hello = "Hello";
        String greeting = hello + 𐀀;
        final int length = greeting.length();
        System.out.printf("Length of '%s' is %d.\n", greeting, length);

        int cpCount = greeting.codePointCount(0, greeting.length());
        System.out.printf("Code point count of '%s' is %d.\n", greeting, cpCount);

        int index = greeting.offsetByCodePoints(hello.length() - 1, 1);
        int cp = greeting.codePointAt(index);
        System.out.printf("Code point of %s is %d.\n", 𐀀, cp);

        // Print out each code point
        int i = 0;
        while (i < cpCount) {
            int codePoint = greeting.codePointAt(i);
            printOutCodePoint(codePoint);
            if (Character.isSupplementaryCodePoint(codePoint)) {
                i += 2;
            } else {
                i++;
            }
        }

        System.out.println();

        // Reverse
        while (i > 0) {
            i--;
            if (Character.isSurrogate(greeting.charAt(i))) {
                i--;
            }
            int codePoint = greeting.codePointAt(i);
            printOutCodePoint(codePoint);
        }
    }

    private static void printOutCodePoint(int codePoint) {
        System.out.printf("%s", codePoint < 256 ? Character.toString((char) codePoint) : codePoint);
    }

}

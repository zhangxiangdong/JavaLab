package me.zhang.coreJava.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.SortedMap;

/**
 * Created by zhangxiangdong on 2017/12/16.
 */
public class CharsetTest {

    public static void main(String[] args) {
        // printOutAllAvailableCharsets();
        encodeDecode();
    }

    private static void encodeDecode() {
        Charset charset = Charset.forName("UTF-8");

        /* encode */
        String string = "Hello 世界！";
        ByteBuffer byteBuffer = charset.encode(string);
        byte[] bytes = byteBuffer.array();

        /* decode */
        byteBuffer = ByteBuffer.wrap(bytes);
        CharBuffer charBuffer = charset.decode(byteBuffer);

        System.out.println(charBuffer.toString());
    }

    private static void printOutAllAvailableCharsets() {
        SortedMap<String, Charset> availableCharsets = Charset.availableCharsets();
        for (String key : availableCharsets.keySet()) {
            System.out.println(key);
        }
    }

}

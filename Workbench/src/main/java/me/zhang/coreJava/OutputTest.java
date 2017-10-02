package me.zhang.coreJava;

import java.util.Date;

/**
 * Created by Zhang on 10/2/2017 10:39 AM.
 */
public class OutputTest {

    public static void main(String[] args) {
        System.out.printf("d: %d\ns: %s\n", 12, "Hello");
        System.out.printf("x: %x\nc: %c\n", 0x9f, 'N');
        System.out.printf("o: %o\nb: %b\n", 027, true);
        System.out.printf("f: %f\nh: %h\n", 0.26f, "M".hashCode());
        System.out.printf("e: %e\n%%: %%\n", Double.MAX_VALUE);

        System.out.printf("%,.2f\n", 10000000.0 / 3.0); // 3,333,333.33
        System.out.printf("%08d\n", Integer.parseInt(Integer.toBinaryString(12))); // 00001100
        System.out.printf("%08d\n", Integer.parseInt(Integer.toBinaryString(7))); // 00000111
        System.out.printf("%,(d\n", -12345); // (12,345)
        System.out.printf("%x\n", 0xcafe); // cafe
        System.out.printf("%#x\n", 0xcafe); // 0xcafe

        System.out.printf("%tc\n", new Date());
        System.out.printf("%1$s %2$tB %2$te %2$tY", "Due date: ", new Date());
    }

}

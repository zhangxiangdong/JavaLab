package me.zhang.string;

/**
 * Created by Zhang on 8/6/2017 6:36 PM.
 */
public class InternExample {

    public static void main(String[] args) {
        System.out.println("Example1: ");
        example1();
        System.out.println("Example2: ");
        example2();
        System.out.println("Example3: ");
        example3();
        System.out.println("Example4: ");
        example4();

        /*
        
         有了对以上的知识的了解，我们现在再来看常见的面试或笔试题就很简单了：

         Q：String s = new String("xyz")，创建了几个String Object?

         A：两个，常量池中的"xyz"和堆中对象。

         Q：下列程序的输出结果：

         String s1 = "abc";
         String s2 = "abc";
         System.out.println(s1 == s2);

         A：true，均指向常量池中对象。

         Q：下列程序的输出结果：

         String s1 = new String("abc");
         String s2 = new String("abc");
         System.out.println(s1 == s2);

         A：false，两个引用指向堆中的不同对象。

         Q：下列程序的输出结果：

         String s1 = "abc";
         String s2 = "a";
         String s3 = "bc";
         String s4 = s2 + s3;
         System.out.println(s1 == s4);

         A：false，因为s2+s3实际上是使用StringBuilder.append来完成，会生成不同的对象。

         Q：下列程序的输出结果：

         String s1 = "abc";
         final String s2 = "a";
         final String s3 = "bc";
         String s4 = s2 + s3;
         System.out.println(s1 == s4);

         A：true，因为final变量在编译后会直接替换成对应的值，所以实际上等于s4="a"+"bc"，而这种情况下，编译器会直接合并为s4="abc"，所以最终s1==s4。

         Q：下列程序的输出结果：

         String s = new String("abc");
         String s1 = "abc";
         String s2 = new String("abc");

         System.out.println(s == s1.intern());
         System.out.println(s == s2.intern());
         System.out.println(s1 == s2.intern());

         A：false，false，true，具体原因参考第二部分内容。
         
         */
    }

    private static void example1() {
        String str1 = "string";
        String str2 = new String("string");
        String str3 = str2.intern();

        System.out.println(str1 == str2); // false: 因为str1指向的是字符串中的常量，str2是在堆中生成的对象，所以str1==str2返回false。
        System.out.println(str1 == str3); // true: str2调用intern方法，会将str2中值（"string"）复制到常量池中，但是常量池中已经存在该字符串（即str1指向的字符串），所以直接返回该字符串的引用，因此str1==str2返回true。
    }

    private static void example2() {
        String baseStr = "baseStr";
        final String baseFinalStr = "baseStr";

        String str1 = "baseStr01";
        String str2 = "baseStr" + "01";
        String str3 = baseStr + "01";
        String str4 = baseFinalStr + "01";
        String str5 = new String("baseStr01").intern();

        System.out.println(str1 == str2); // true: str1==str2 肯定会返回true，因为str1和str2都指向常量池中的同一引用地址。所以其实在JAVA 1.6之后，常量字符串的"+"操作，编译阶段直接会合成为一个字符串。
        System.out.println(str1 == str3); // false: 因为str3实际上是stringBuilder.append()生成的结果，所以与str1不相等，结果返回false。
        System.out.println(str1 == str4); // true: 因为str1和str4指向的都是常量池中的第三项，所以str1==str4返回true。这里我们还能发现一个现象，对于final字段，编译期直接进行了常量替换，而对于非final字段则是在运行期进行赋值处理的。
        System.out.println(str1 == str5); // true: 因为str5和str1都指向的都是常量池中的同一个字符串，所以str1==str5返回true。
    }

    private static void example3() {
        String str2 = new String("str") + new String("01");
        str2.intern();
        String str1 = "str01";
        System.out.println(str2 == str1); // true: 在第一种情况下，因为常量池中没有"str01"这个字符串，所以会在常量池中生成一个对堆中的"str01"的引用，而在进行字面量赋值的时候，常量池中已经存在，所以直接返回该引用即可，因此str1和str2都指向堆中的字符串，返回true。
    }

    private static void example4() {
        String str1 = "str01";
        String str2 = new String("str") + new String("01");
        str2.intern();
        System.out.println(str2 == str1); // false: 调换位置以后，因为在进行字面量赋值（String str1 = "str01″）的时候，常量池中不存在，所以str1指向的常量池中的位置，而str2指向的是堆中的对象，再进行intern方法时，对str1和str2已经没有影响了，所以返回false。
    }

}

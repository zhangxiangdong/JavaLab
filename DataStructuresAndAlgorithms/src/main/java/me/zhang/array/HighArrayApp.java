package me.zhang.array;

/**
 * Created by Zhang on 2015/11/20 下午 5:35 .
 */
public class HighArrayApp {

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    private static void test3() {
        HighArray highArray = new HighArray(100);
        highArray.insert(13);
        highArray.insert(24);
        highArray.insert(14);
        highArray.insert(14);
        highArray.insert(14);
        highArray.insert(59);
        highArray.insert(35);
        highArray.insert(97);
        highArray.insert(97);
        highArray.insert(97);
        highArray.insert(29);
        highArray.insert(10);
        highArray.insert(46);
        highArray.insert(46);
        highArray.insert(71);

        highArray.display();

        highArray.noDup();
        highArray.display();
    }

    private static void test2() {
        HighArray highArray = new HighArray(100);
        System.out.println("Max: " + highArray.getMax());
    }

    private static void test1() {
        HighArray highArray = new HighArray(100);
        highArray.insert(13);
        highArray.insert(24);
        highArray.insert(14);
        highArray.insert(59);
        highArray.insert(35);
        highArray.insert(97);
        highArray.insert(29);
        highArray.insert(10);
        highArray.insert(46);
        highArray.insert(71);

        highArray.display();
        System.out.println("Max: " + highArray.getMax());

        long searchKey = 35;
        if (highArray.find(searchKey))
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        System.out.println("Removed Max: " + highArray.removeMax());
        highArray.display();

        searchKey = 29;
        if (highArray.delete(searchKey)) {
            System.out.println(searchKey + " deleted");
        }
        highArray.display();
    }

}

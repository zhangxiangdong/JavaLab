package me.zhang.array;

import me.zhang.datatype.InputOutput;

import java.io.IOException;

/**
 * Created by Zhang on 2015/11/23 下午 1:58 .
 */
public class OrdArrayApp {

    public static void main(String[] args) throws IOException {
        OrdArray ordArray = new OrdArray(100);

        /* insert */
        ordArray.insert(13);
        ordArray.insert(24);
        ordArray.insert(14);
        ordArray.insert(59);
        ordArray.insert(35);
        ordArray.insert(97);
        ordArray.insert(29);
        ordArray.insert(10);
        ordArray.insert(46);
        ordArray.insert(71);
        ordArray.insertWithBinarySearch(44);
        ordArray.insertWithBinarySearch(77);

        /* display */
        ordArray.display();

        /* find */
        System.out.print("Input searchKey to find: ");
        int searchKey = InputOutput.getInt();
        int resultIn = ordArray.find(searchKey);

        if (resultIn == ordArray.size())
            System.out.printf("Can't find %d", searchKey);
        else
            System.out.printf("Find %d on index: %d", searchKey, ordArray.find(searchKey));
        System.out.println();

        /* delete */
        System.out.print("Input searchKey to delete: ");
        searchKey = InputOutput.getInt();
        boolean res = ordArray.delete(searchKey);
        if (res)
            System.out.printf("%d Deleted", searchKey);
        else
            System.out.println("Not found");

        System.out.println();
        ordArray.display();
    }

}

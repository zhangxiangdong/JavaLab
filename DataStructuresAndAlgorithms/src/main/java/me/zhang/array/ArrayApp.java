package me.zhang.array;

/**
 * Created by Zhang on 2015/11/20 下午 1:33 .
 */
public class ArrayApp {

    public static void main(String[] args) {
        long[] array; // reference to array
        array = new long[100]; // make array
        int nElems; // number of items
        int j; // loop counter
        int searchKey; // key of item to search for

        // insert 10 items
        array[0] = 13;
        array[1] = 24;
        array[2] = 14;
        array[3] = 59;
        array[4] = 35;
        array[5] = 97;
        array[6] = 29;
        array[7] = 10;
        array[8] = 46;
        array[9] = 71;
        nElems = 10;

        for (int i = 0; i < nElems; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // find item with key 97
        searchKey = 97;
        for (j = 0; j < nElems; j++) {
            if (array[j] == searchKey)
                break;
        }
        if (j == nElems)
            System.out.println("Can't find " + searchKey);
        else
            System.out.println("Found " + searchKey);

        // delete item with key 14
        searchKey = 14;
        for (j = 0; j < nElems; j++) {
            if (array[j] == searchKey) {
                for (int k = j; k < nElems; k++) {
                    array[k] = array[k + 1];
                }
                System.out.println(searchKey + " deleted");
                nElems--;
                break;
            }
        }

        for (int i = 0; i < nElems; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}

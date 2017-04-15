package me.zhang.array;

/**
 * Created by Zhang on 2015/11/20 下午 3:49 .
 */
public class LowArrayApp {

    public static void main(String[] args) {
        LowArray lowArray = new LowArray(100);
        int nElems; // number of items
        int j; // loop counter
        int searchKey; // key of item to search for

        // insert 10 items
        lowArray.setElem(0, 13);
        lowArray.setElem(1, 24);
        lowArray.setElem(2, 14);
        lowArray.setElem(3, 59);
        lowArray.setElem(4, 35);
        lowArray.setElem(5, 97);
        lowArray.setElem(6, 29);
        lowArray.setElem(7, 10);
        lowArray.setElem(8, 46);
        lowArray.setElem(9, 71);
        nElems = 10;

        for (int i = 0; i < nElems; i++) {
            System.out.print(lowArray.getElem(i) + " ");
        }
        System.out.println();

        // find item with key 97
        searchKey = 97;
        for (j = 0; j < nElems; j++) {
            if (lowArray.getElem(j) == searchKey)
                break;
        }
        if (j == nElems)
            System.out.println("Can't find " + searchKey);
        else
            System.out.println("Found " + searchKey);

        // delete item with key 14
        searchKey = 14;
        for (j = 0; j < nElems; j++) {
            if (lowArray.getElem(j) == searchKey) {
                for (int k = j; k < nElems; k++) {
                    lowArray.setElem(k, lowArray.getElem(k + 1));
                }
                System.out.println(searchKey + " deleted");
                nElems--;
                break;
            }
        }

        for (int i = 0; i < nElems; i++) {
            System.out.print(lowArray.getElem(i) + " ");
        }
        System.out.println();
    }

}

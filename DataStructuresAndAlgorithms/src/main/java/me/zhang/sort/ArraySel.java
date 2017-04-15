package me.zhang.sort;

/**
 * Created by Zhang on 2015/12/1 上午 10:57 .
 */
public class ArraySel {
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items

    //--------------------------------------------------------------
    public ArraySel(int max)          // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }

    //--------------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }

    //--------------------------------------------------------------
    public void display()             // displays array contents
    {
        for (int j = 0; j < nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }

    //--------------------------------------------------------------
    public void selectionSort() {
        int out, in, min;
        for (out = 0; out < nElems - 1; out++) {
            min = out; // out 左侧的是从小到大排好序的，所以从out开始，往右侧继续寻找最小的
            for (in = out + 1; in < nElems; in++) {
                if (a[min] > a[in])
                    min = in;
            }
            swap(out, min);
        }
    } // end selectionSort()

    //--------------------------------------------------------------
    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
//--------------------------------------------------------------
}  // end class ArraySel

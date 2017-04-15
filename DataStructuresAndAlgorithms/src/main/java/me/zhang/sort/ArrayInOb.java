package me.zhang.sort;

/**
 * Created by Zhang on 2015/12/2 下午 5:22 .
 */
public class ArrayInOb {
    private Person[] a;               // ref to array a
    private int nElems;               // number of data items

    //--------------------------------------------------------------
    public ArrayInOb(int max)         // constructor
    {
        a = new Person[max];               // create the array
        nElems = 0;                        // no items yet
    }

    //--------------------------------------------------------------
    // put person into array
    public void insert(String last, String first, int age) {
        a[nElems] = new Person(last, first, age);
        nElems++;                          // increment size
    }

    //--------------------------------------------------------------
    public void display()             // displays array contents
    {
        for (int j = 0; j < nElems; j++)       // for each element,
            a[j].displayPerson();          // display it
    }

    //--------------------------------------------------------------
    public void insertionSort() {
        int in, out;
        for (out = 1; out < nElems; out++) {
            Person temp = a[out];
            in = out;
            while (in > 0 &&               // until smaller one found,
                    a[in - 1].getLast().compareTo(temp.getLast()) > 0) {
                a[in] = a[in - 1];         // shift item to the right
                --in;
            }
            a[in] = temp;
        }// end for
    }  // end insertionSort()
//--------------------------------------------------------------
}  // end class ArrayInOb

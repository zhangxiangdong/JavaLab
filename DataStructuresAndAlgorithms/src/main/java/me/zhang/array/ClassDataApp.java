package me.zhang.array;

/**
 * Created by Zhang on 2015/11/30 上午 11:14 .
 */
public class ClassDataApp {
    public static void main(String[] args) {
        int maxSize = 100;             // array size
        ClassDataArray arr;            // reference to array
        arr = new ClassDataArray(maxSize);  // create the array
        // insert 10 items
        arr.insert(new Person("Evans", "Patty", 24));
        arr.insert(new Person("Smith", "Lorraine", 37));
        arr.insert(new Person("Yee", "Tom", 43));
        arr.insert(new Person("Adams", "Henry", 63));
        arr.insert(new Person("Hashimoto", "Sato", 21));
        arr.insert(new Person("Stimson", "Henry", 29));
        arr.insert(new Person("Velasquez", "Jose", 72));
        arr.insert(new Person("Lamarque", "Henry", 54));
        arr.insert(new Person("Vang", "Minh", 22));
        arr.insert(new Person("Creswell", "Lucinda", 18));

        arr.displayA();                // display items

        String searchKey = "Stimson";  // search for item
        Person found;
        found = arr.find(searchKey);
        if (found != null) {
            System.out.print("Found ");
            found.displayPerson();
        } else
            System.out.println("Can't find " + searchKey);

        System.out.println("Deleting Smith, Yee, and Creswell");
        arr.delete("Smith");           // delete 3 items
        arr.delete("Yee");
        arr.delete("Creswell");

        arr.displayA();                // display items again
    }  // end main()
}  // end class ClassDataApp

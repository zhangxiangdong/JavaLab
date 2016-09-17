package week0.notebook;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Zhang on 9/26/2015 11:54 上午.
 */
public class NoteBook {

    private ArrayList<String> notes = new ArrayList<>();

    public void add(String note) {
        notes.add(note);
    }

    public void add(int location, String note) {
        notes.add(location, note);
    }

    public int getSize() {
        return notes.size();
    }

    public String getNote(int index) {
        return notes.get(index);
    }

    public void removeNote(int index) {
        notes.remove(index);
    }

    public String[] list() {
//        String[] ns = new String[notes.size()];
//        for (int i = 0; i < ns.length; i++) {
//            ns[i] = notes.get(i);
//        }
//        return ns;
        String[] a = new String[1];
        return notes.toArray(a);
    }

    public static void main(String[] args) {
        String[] a = new String[2];
        a[0] = "First";
        a[1] = "Second";
        System.out.println(a[1]);

        NoteBook nb = new NoteBook();
        nb.add("First");
        nb.add("Second");
        System.out.println(nb.getSize());
        System.out.println(nb.getNote(1));

        nb.add(1, "Third");
        System.out.println(nb.getSize());
        System.out.println(nb.getNote(1));

        nb.removeNote(1);
        System.out.println(nb.getNote(1));

        System.out.println(Arrays.toString(nb.list()));

        String x = nb.getNote(0);
        System.out.println(x);
        x = "Forth";
        System.out.println(x);
        System.out.println(nb.getNote(0));
    }

}

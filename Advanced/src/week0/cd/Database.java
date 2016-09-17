package week0.cd;

import java.util.ArrayList;

/**
 * Created by Zhang on 9/28/2015 8:57 下午.
 */
public class Database {

    private ArrayList<AbsMedia> mediaItems = new ArrayList<>();

    public void add(AbsMedia item) {
        mediaItems.add(item);
    }

    public void list() {
        for (AbsMedia media : mediaItems) {
            media.print();
        }
    }

    public static void main(String[] args) {
        Database db = new Database();
        db.add(new CD("Sooner or Later", "Mat Kearney", 1, 236, "Young Love"));
        db.add(new CD("Good Life", "Good Life", 1, 252, "Waking Up"));
        db.add(new CD("Divinity", "Divinity", 1, 368, "Worlds"));

        db.add(new DVD("SOL", "MK", 236, "Young Love"));
        db.add(new DVD("GL", "GL", 252, "Waking Up"));
        db.add(new DVD("D", "D", 368, "Worlds"));

        db.list();

        Media media = new Media("SQL", 236, "Young Love");
        CD cd;
        if (media instanceof CD) { // to check that you won't cause a ClassCastException by using instanceof
            cd = (CD) media; // ClassCastException
            cd.print();
        }

        Media media1 = new CD("Sooner or Later", "Mat Kearney", 1, 236, "Young Love");
        CD cd1 = (CD) media1;
        cd1.print();

//        CD cd2 = (CD) "Hello"; // that could never possibly work

        System.out.println(cd1);

        CD a = new CD("Divinity", "Divinity", 1, 368, "Worlds");
        CD b = new CD("Divinity", "Divinity", 1, 368, "Worlds");
        System.out.println("CD a equals CD b ? " + a.equals(b));
    }

}

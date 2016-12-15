package com.zhang.behavioral.iterator;

/**
 * Created by Zhang on 12/15/2016 10:03 PM.
 */
public class IteratorTest {

    public static void main(String[] args) {
        NameRepository nameRepo = new NameRepository("Jim", "Ben", "Tommy", "Lily", "Romain");
        nameRepo.addName("Xiangdong");
        nameRepo.addName("Guy");
        System.out.println("Names: ");
        for (Iterator<String> iterator = nameRepo.iterator(); iterator.hasNext(); ) {
            System.out.println("\t" + iterator.next());
        }

        SongsOfThe70s songsOfThe70s = new SongsOfThe70s();
        System.out.println("Songs: ");
        for (Iterator<Song> iterator = songsOfThe70s.iterator(); iterator.hasNext(); ) {
            System.out.println("\t" + iterator.next());
        }
    }

}

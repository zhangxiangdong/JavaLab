package com.zhang.behavioral.iterator;

/**
 * Created by Zhang on 12/15/2016 10:09 PM.
 */
public class SongsOfThe70s implements Container<Song> {

    private Song[] songs = {
            new Song("Imagine", "John Lennon", 1971),
            new Song("American Pie", "Don McLean", 1971),
            new Song("I Will Survive", "Gloria Gaynor", 1979)
    };

    @Override
    public Iterator<Song> iterator() {
        return new SongIterator();
    }

    private class SongIterator implements Iterator<Song> {

        int index;

        @Override
        public boolean hasNext() {
            return index < songs.length;
        }

        @Override
        public Song next() {
            return hasNext() ? songs[index++] : null;
        }
    }

}

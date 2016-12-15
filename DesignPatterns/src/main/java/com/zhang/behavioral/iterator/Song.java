package com.zhang.behavioral.iterator;

/**
 * Created by Zhang on 12/15/2016 10:08 PM.
 */
public class Song {

    private String songName;
    private String bandName;
    private int yearReleased;

    public Song(String songName, String bandName, int yearReleased) {
        this.songName = songName;
        this.bandName = bandName;
        this.yearReleased = yearReleased;
    }

    public String getSongName() {
        return songName;
    }

    public String getBandName() {
        return bandName;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songName='" + songName + '\'' +
                ", bandName='" + bandName + '\'' +
                ", yearReleased=" + yearReleased +
                '}';
    }
}

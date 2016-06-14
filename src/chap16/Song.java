package chap16;

import java.util.Comparator;

/**
 * Created by anray on 10.06.2016.
 */


public class Song implements MyIntf, Comparable<Song> {
    private String title;
    private String artist;
    private int year;

    public Song(String a, String t, int y) {
        title = t;
        artist = a;
        year = y;
    }

    public void justPrint(){
        System.out.println("Hello");
    }
    public Song(){
        super();

    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return artist + ": " + title + " " + year;
    }

    public int compareTo(Song s) {
        return title.compareTo(s.getTitle());

    }

    public int hashCode() {
        return title.hashCode();
    }

    public boolean equals(Object s) {
        Song ss = (Song) s;
        return title.equals(ss.getTitle());
    }
}




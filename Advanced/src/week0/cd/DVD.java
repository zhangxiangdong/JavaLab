package week0.cd;

/**
 * Created by Zhang on 9/28/2015 9:08 下午.
 */
public class DVD extends AbsMedia {

    private String title;

    private String director;

    public DVD(String title, String director, int playingTime, String comment) {
        super(title, playingTime, comment);
        this.title = title;

        setTitle("MediaItem");

        this.director = director;
    }

    @Override
    public void print() {
        System.out.println("DVD >> " + title + ": " + director);
    }

    @Override
    public String toString() {
        return "DVD{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                '}';
    }
}

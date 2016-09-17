package week0.cd;

/**
 * Created by Zhang on 9/28/2015 8:46 下午.
 */
public class CD extends Media {

    private String artist;

    private int numOfTracks;

    public CD(String title, String artist, int numOfTracks, int playingTime, String comment) {
        super(title, playingTime, comment);
        this.artist = artist;
        this.numOfTracks = numOfTracks;
    }

    @Override
    public void print() {
        System.out.println("CD >> " + getTitle() + " - " + artist);
    }

    @Override
    public String toString() {
        return "CD{" +
                "artist='" + artist + '\'' +
                ", numOfTracks=" + numOfTracks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        if (!(o instanceof CD))
            return false;
        CD cd = (CD) o;

        return numOfTracks == cd.numOfTracks && !(artist != null ? !artist.equals(cd.artist) : cd.artist != null);

    }

    @Override
    public int hashCode() {
        int result = artist != null ? artist.hashCode() : 0;
        result = 31 * result + numOfTracks;
        return result;
    }
}

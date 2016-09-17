package week0.cd;

/**
 * Created by Zhang on 9/28/2015 9:24 下午.
 */
public abstract class AbsMedia {

    private String title;

    private int playingTime;

    private boolean gotIt;

    private String comment;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPlayingTime() {
        return playingTime;
    }

    public boolean isGotIt() {
        return gotIt;
    }

    public String getComment() {
        return comment;
    }

    public AbsMedia(String title, int playingTime, String comment) {
        this.title = title;
        this.playingTime = playingTime;
        this.comment = comment;
    }

    public abstract void print();
}

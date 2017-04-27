package me.zhang.array.game;

/**
 * Created by zhangxiangdong on 2017/4/27.
 */
public class GameEntry {

    private String name; // name of the person earning this score
    private int score; // the score value

    public GameEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "(" + name + "/" + score + ")";
    }

}

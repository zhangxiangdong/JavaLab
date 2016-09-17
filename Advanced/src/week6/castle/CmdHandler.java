package week6.castle;

/**
 * Created by Zhang on 10/17/2015 1:56 下午.
 */
public class CmdHandler {

    protected Game game;

    public CmdHandler(Game game) {
        this.game = game;
    }

    public void runCommand(String params) {

    }

    public boolean isBye() {
        return false;
    }

}

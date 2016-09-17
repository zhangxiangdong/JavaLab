package week6.castle;

/**
 * Created by Zhang on 10/17/2015 2:21 下午.
 */
public class BeatHandler extends CmdHandler {
    public BeatHandler(Game game) {
        super(game);
    }

    @Override
    public void runCommand(String params) {
        game.beat(params);
    }
}

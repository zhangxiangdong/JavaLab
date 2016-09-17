package week6.castle;

/**
 * Created by Zhang on 10/17/2015 2:16 下午.
 */
public class GoHandler extends CmdHandler {

    public GoHandler(Game game) {
        super(game);
    }

    @Override
    public void runCommand(String params) {
        game.goRoom(params);
    }
}

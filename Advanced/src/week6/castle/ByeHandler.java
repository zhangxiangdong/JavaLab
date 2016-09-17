package week6.castle;

/**
 * Created by Zhang on 10/17/2015 1:57 下午.
 */
public class ByeHandler extends CmdHandler {

    public ByeHandler(Game game) {
        super(game);
    }

    @Override
    public boolean isBye() {
        return true;
    }
}

package week6.castle;

/**
 * Created by Zhang on 10/17/2015 2:10 下午.
 */
public class HelpHandler extends CmdHandler {

    public HelpHandler(Game game) {
        super(game);
    }

    @Override
    public void runCommand(String params) {
        String commands = game.getHelp();
        System.out.printf("迷路了吗？你可以做的命令有：%s\t", commands);
        System.out.println("如：\tgo east");
    }
}

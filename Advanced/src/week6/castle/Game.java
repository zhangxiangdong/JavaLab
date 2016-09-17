package week6.castle;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private Room currentRoom;
    private HashMap<String, CmdHandler> handlers = new HashMap<>();

    public Game() {
        handlers.put("bye", new ByeHandler(this));
        handlers.put("help", new HelpHandler(this));
        handlers.put("go", new GoHandler(this));
        handlers.put("beat", new BeatHandler(this));
        createRooms();
    }

    public String getHelp() {
        return handlers.keySet().toString();
    }

    private void createRooms() {
        Room outside, lobby, pub, study, bedroom, canteen;

        //	制造房间
        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");
        canteen = new Room("餐厅");

        //	初始化房间的出口
        outside.setExit("east", lobby);
        outside.setExit("south", study);
        outside.setExit("west", pub);

        lobby.setExit("west", outside);
        lobby.setExit("up", canteen);

        canteen.setExit("down", lobby);

        pub.setExit("east", outside);

        study.setExit("east", bedroom);
        study.setExit("north", outside);

        bedroom.setExit("west", study);

        currentRoom = outside;  //	从城堡门外开始
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println();
        showPrompt();
    }

    private void showPrompt() {
        System.out.println("你在" + currentRoom);
        System.out.print("出口有：");
        System.out.println(currentRoom.getExitDesc());
    }

    public void goRoom(String direction) {
        Room nextRoom = currentRoom.nextRoom(direction);
        if (nextRoom == null) {
            System.out.println("那里没有门！");
        } else {
            currentRoom = nextRoom;
            showPrompt();
        }
    }

    public void beat(String weapon) {
        System.out.println("beat with " + weapon);
    }

    public void play() {
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            String[] commands = line.split(" ");
            CmdHandler handler = handlers.get(commands[0]);
            String direction = "";
            if (commands.length > 1)
                direction = commands[1];
            if (handler != null) {
                handler.runCommand(direction);
                if (handler.isBye()) {
                    break;
                }
            }
        }
        in.close();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.printWelcome();

        game.play();

        System.out.println("感谢您的光临。再见！");
    }

}

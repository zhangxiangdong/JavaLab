package week6.castle;

import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String, Room> exits = new HashMap<>();

    public Room(String description) {
        this.description = description;
    }

    public void setExit(String dir, Room room) {
        exits.put(dir, room);
    }

    public String getExitDesc() {
        StringBuilder exit = new StringBuilder();
        for (String dir : exits.keySet()) {
            exit.append(dir);
            exit.append(" ");
        }
        return exit.toString();
    }

    public Room nextRoom(String direction) {
        return exits.get(direction);
    }

    @Override
    public String toString() {
        return description;
    }
}

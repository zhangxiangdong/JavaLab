package me.zhang.classes;

/**
 * Created by Zhang on 1/8/2017 3:33 PM.
 */
public class Person {

    private String name;
    private String friends;

    public Person(String aName) {
        name = aName;
        friends = "";
    }

    public void addFriend(Person friend) {
        friends += friend.name + " ";
    }

    public void unFriend(Person nonFriend) {
        friends = friends.replace(nonFriend.name + " ", "");
    }

    public String getFriends() {
        if ("".equals(friends)) {
            return name + " has no friend.";
        }
        return friends;
    }

}

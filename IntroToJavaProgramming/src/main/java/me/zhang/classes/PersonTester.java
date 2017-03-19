package me.zhang.classes;

/**
 * Created by Zhang on 1/8/2017 6:07 PM.
 */
public class PersonTester {

    public static void main(String[] args) {
        Person jim = new Person("Jim");
        Person tommy = new Person("Tommy");

        jim.addFriend(tommy);
        System.out.println(jim.getFriends());
        jim.unFriend(tommy);
        System.out.println(jim.getFriends());

        tommy.addFriend(jim);
        System.out.println(tommy.getFriends());
        tommy.unFriend(jim);
        System.out.println(tommy.getFriends());
    }

}

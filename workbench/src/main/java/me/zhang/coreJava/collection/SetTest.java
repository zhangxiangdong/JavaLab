package me.zhang.coreJava.collection;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by zhangxiangdong on 2017/12/2.
 */
public class SetTest {

    public static void main(String[] args) {
        Set<User> users = new HashSet<>();
        User lily = new User("Lily");
        User carl = new User("Carl");
        users.add(lily);
        users.add(carl);

        for (User user : users) {
            System.out.println(user.name);
        }

        System.out.println("******************");
        carl.name = "Lily1";
        for (User user : users) {
            System.out.println(user.name);
        }

        System.out.println("******************");
        System.out.println(users.contains(lily));
        System.out.println(users.contains(carl));

        System.out.println("******************");
        carl.name = "Lily";
        System.out.println(users.remove(lily));
        System.out.println(users.remove(carl));
        carl.name = "Carl";
        for (User user : users) {
            System.out.println(user.name);
        }
    }

    static class User {
        public String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

}

package me.zhang.serialization.Server;

import me.zhang.serialization.Person;
import me.zhang.serialization.SerializationUtils;

/**
 * Created by Zhang on 2015/6/12 上午 11:23 .
 */
public class Producer {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Zhang");
//        person.setAge(22);
        SerializationUtils.writeObject(person);
        System.out.println("Person Produced!");
    }

}

package me.zhang.serialization.Client;

import me.zhang.serialization.SerializationUtils;
import me.zhang.serialization.Person;

/**
 * Created by Zhang on 2015/6/12 上午 2:38 .
 */
public class Consumer {

    public static void main(String[] args) {
        Person person = (Person) SerializationUtils.readObject();
        System.out.println("Name: " + person.getName());
        System.out.println("Sex: " + person.getSex());
        System.out.println("Age: " + person.getAge());
    }

}

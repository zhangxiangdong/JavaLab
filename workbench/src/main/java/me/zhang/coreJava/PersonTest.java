package me.zhang.coreJava;

/**
 * Created by zhangxiangdong on 2017/10/9.
 */
public class PersonTest {

    public static void main(String[] args) {
        Person[] people = new Person[2];
        people[0] = new Employee("Zhang", 1_000_000, 2015, 3, 18);
        people[1] = new Student("Tom");

        for (Person p : people) {
            System.out.println(p.getName() + ", " + p.getDescription());
        }
    }

}

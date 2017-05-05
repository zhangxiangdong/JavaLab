package me.zhang.array;

import me.zhang.dataStructure.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by zhangxiangdong on 2017/5/5.
 */
public class ArraysTestTest {

    @Test
    public void testArrayClone() {
        int[] a = {0, 1, 2, 3, 4, 5};
        int[] b = a;
        int[] c = a.clone();

        Assert.assertTrue(b == a);
        Assert.assertFalse(c == a);
        Assert.assertTrue(Arrays.equals(c, a));

        a[0] = -1; // a[0] == -1 while c[0] == 0
        Assert.assertFalse(a[0] == c[0]);
        Assert.assertTrue(0 == c[0]);
    }

    @Test
    public void testArrayStoresReferenceTypesClone() {
        Person[] contacts = new Person[3];
        Person a = new Person(1, "Zack");
        contacts[0] = a;
        Person b = new Person(2, "Wade");
        contacts[1] = b;
        Person c = new Person(3, "Lucia");
        contacts[2] = c;

        Person[] guests = contacts.clone();
        Assert.assertTrue(guests[0].getName().equals(contacts[0].getName()));

        guests[2].setName("Lucy");
        Assert.assertTrue(guests[2].getName().equals(contacts[2].getName()));

    }

    @Test
    public void testArrayStoresReferenceTypesDeepClone() throws CloneNotSupportedException {
        Person[] contacts = new Person[2];
        Person a = new Person(1, "Zack");
        contacts[0] = a;
        Person b = new Person(2, "Wade");
        contacts[1] = b;

        Person[] guests = new Person[contacts.length];
        for (int i = 0; i < contacts.length; i++) {
            guests[i] = (Person) contacts[i].clone();
        }

        Assert.assertTrue(guests[0].getName().equals(contacts[0].getName()));

        guests[1].setName("Luca");
        Assert.assertFalse(guests[1].getName().equals(contacts[1].getName()));

    }

}
package me.zhang.effective.item2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhangxiangdong on 2017/12/18.
 */
public class UserTest {

    private User user;

    @Before
    public void setUp() {
        user = User.UserBuilder.anUser()
                .firstName("Xiangdong")
                .lastName("Zhang")
                .age(26)
                .address("Peking")
                .phone("18510728641")
                .build();
    }

    @Test
    public void getFirstName() {
        Assert.assertEquals("Xiangdong", user.getFirstName());
    }

    @Test
    public void getLastName() {
        Assert.assertEquals("Zhang", user.getLastName());
    }

    @Test
    public void getAge() {
        Assert.assertEquals(26, user.getAge());
    }

    @Test
    public void getPhone() {
        Assert.assertEquals("18510728641", user.getPhone());
    }

    @Test
    public void getAddress() {
        Assert.assertEquals("Peking", user.getAddress());
    }
}
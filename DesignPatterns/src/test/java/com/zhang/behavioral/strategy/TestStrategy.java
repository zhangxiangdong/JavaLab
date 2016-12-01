package com.zhang.behavioral.strategy;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;

/**
 * Created by zhangxiangdong on 2016/12/1.
 */
public class TestStrategy {

    private static final String DOG = "sparky";
    private static final String FLYS = "flys";
    private HashMap<String, Object> beans;

    @Before
    public void setUp() {
        beans = new HashMap<>();

        Flys flys = Mockito.spy(new CantFly());
        Animal sparky = Mockito.spy(new Dog());
        sparky.setFlyingType(flys);

        beans.put(DOG, sparky);
        beans.put(FLYS, flys);
    }

    @Test
    public void testStrategy() {
        Animal sparky = (Animal) beans.get(DOG);
        sparky.tryToFly(); // When the dog try to flys

        // The dog acts as what its flying type is
        Flys flys = sparky.getFlyingType();
        Mockito.verify(flys).fly();
    }

}

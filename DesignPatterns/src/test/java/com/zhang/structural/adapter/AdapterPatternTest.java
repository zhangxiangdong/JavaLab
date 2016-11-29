package com.zhang.structural.adapter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangxiangdong on 2016/11/29.
 */
public class AdapterPatternTest {

    private static final String BATTLE_CAR = "battle_car";
    private static final String LEADER = "leader";
    private Map<String, Object> beans;

    /**
     * This method runs before the test execution and sets the bean objects in the beans Map.
     */
    @Before
    public void setUp() {
        beans = new HashMap<>();

        Truck truck = Mockito.spy(new Truck());
        BattleCar battleCar = Mockito.spy(new BattleCar(truck));
        beans.put(BATTLE_CAR, battleCar);

        Leader leader = new Leader((BattleCar) beans.get(BATTLE_CAR));
        beans.put(LEADER, leader);
    }

    /**
     * This test asserts that when we use the move() method on a Leader bean(client), it is
     * internally calling move method on the BattleVehicle object. The Adapter ({@link BattleCar})
     * converts the interface of the target class ( {@link Truck}) into a suitable one
     * expected by the client ({@link Leader} ).
     */
    @Test
    public void testAdapter() {
        Leader leader = (Leader) beans.get(LEADER);

        // When the leader move the car
        leader.move();

        // The leader internally calls the BattleCar to move, and then the BattleCar calls the Truck to run
        BattleCar battleCar = (BattleCar) beans.get(BATTLE_CAR);
        Truck truck = battleCar.getTruck();
        Mockito.verify(battleCar).move();
        Mockito.verify(truck).run();

        // The same as above with attack
        leader.attack();
        Mockito.verify(battleCar).attack();
        Mockito.verify(truck).crash();
    }

}

package com.zhang.structural.bridge;

import org.junit.Test;

import static org.mockito.Mockito.spy;

/**
 * Created by zhangxiangdong on 2016/12/1.
 */
public class BridgeTest extends BaseBridgeTest {

    @Test
    public void testTriangle() {
        final Color green = spy(new GreenColor());
        final Shape triangle = spy(new Triangle(green));
        testColorActions(triangle, green);
    }

    @Test
    public void testPentagon() {
        final Color red = spy(new RedColor());
        final Shape pentagon = spy(new Pentagon(red));
        testColorActions(pentagon, red);
    }

}

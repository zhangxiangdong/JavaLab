package com.zhang.structural.bridge;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by zhangxiangdong on 2016/12/1.
 */
abstract public class BaseBridgeTest {

    protected final void testColorActions(final Shape shape, final Color color) {
        assertNotNull(shape);
        assertNotNull(color);

        shape.withColor();
        verify(color, times(1)).applyColor();
    }

}

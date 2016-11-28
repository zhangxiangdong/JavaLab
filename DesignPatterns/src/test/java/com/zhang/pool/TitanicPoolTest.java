package com.zhang.pool;

import org.junit.Test;

import static com.zhang.pool.ObjectPool.poolPattern;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Created by zhangxiangdong on 2016/11/28.
 */
public class TitanicPoolTest {

    /**
     * Use the same object 100 times subsequently. This should not take much time since the heavy
     * object instantiation is done only once. Verify if we get the same object each time.
     */
    @Test(timeout = 5000)
    public void testSubsequentCheckinCheckout() {
        final TitanicPool pool = new TitanicPool();

        // Test initial
        assertEquals(pool.toString(), String.format(poolPattern, 0, 0));

        final Titanic expectedTitanic = pool.checkOut();
        // Test check out
        assertEquals(pool.toString(), String.format(poolPattern, 0, 1));

        pool.checkIn(expectedTitanic);
        // Test check in
        assertEquals(pool.toString(), String.format(poolPattern, 1, 0));

        for (int i = 0; i < 100; i++) {
            final Titanic titanic = pool.checkOut();
            // Test check out
            assertEquals(pool.toString(), String.format(poolPattern, 0, 1));

            // Test same
            assertSame(expectedTitanic, titanic);
            assertEquals(expectedTitanic.getId(), titanic.getId());
            assertEquals(expectedTitanic.toString(), titanic.toString());

            pool.checkIn(titanic);
            assertEquals(pool.toString(), String.format(poolPattern, 1, 0));
        }
    }

}
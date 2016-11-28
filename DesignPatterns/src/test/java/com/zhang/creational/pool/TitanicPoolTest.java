package com.zhang.creational.pool;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.zhang.creational.pool.ObjectPool.poolPattern;
import static org.junit.Assert.*;

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

    /**
     * Use the same object 100 times subsequently. This should not take much time since the heavy
     * object instantiation is done only once. Verify if we get the same object each time.
     */
    @Test(timeout = 5000)
    public void testConcurrentCheckinCheckout() {
        final TitanicPool pool = new TitanicPool();
        assertEquals(pool.toString(), String.format(poolPattern, 0, 0));

        final Titanic firstTitanic = pool.checkOut();
        assertEquals(pool.toString(), String.format(poolPattern, 0, 1));

        final Titanic secondTitanic = pool.checkOut();
        assertEquals(pool.toString(), String.format(poolPattern, 0, 2));

        assertNotSame(firstTitanic, secondTitanic);

        /* After checking in the second, we should get the same when checking out a new */
        pool.checkIn(secondTitanic);
        // One in use, one available
        assertEquals(pool.toString(), String.format(poolPattern, 1, 1));

        final Titanic thirdTitanic = pool.checkOut();
        // No available now
        assertEquals(pool.toString(), String.format(poolPattern, 0, 2));
        // The third checked out one is the same as the second checked in
        assertSame(thirdTitanic, secondTitanic);

        // And the same applies for the first one
        pool.checkIn(firstTitanic);
        assertEquals(pool.toString(), String.format(poolPattern, 1, 1));

        final Titanic fourthTitanic = pool.checkOut();
        assertEquals(pool.toString(), String.format(poolPattern, 0, 2));
        assertSame(fourthTitanic, firstTitanic);

        // When both titanic return to the pool, we should still get the same instances
        pool.checkIn(firstTitanic);
        assertEquals(pool.toString(), String.format(poolPattern, 1, 1));

        pool.checkIn(secondTitanic);
        assertEquals(pool.toString(), String.format(poolPattern, 2, 0));

        // The order of the returned instances is not determined,
        // so just verify if both expected instances are in there.
        List<Titanic> titanics = Arrays.asList(pool.checkOut(), pool.checkOut());
        assertEquals(pool.toString(), String.format(poolPattern, 0, 2));
        assertTrue(titanics.contains(firstTitanic));
        assertTrue(titanics.contains(secondTitanic));
    }

}
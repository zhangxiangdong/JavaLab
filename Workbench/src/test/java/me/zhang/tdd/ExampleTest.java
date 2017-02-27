package me.zhang.tdd;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhangxiangdong on 2017/2/27.
 */
public class ExampleTest {

    @Test
    public void testMultiplication() {
        // Arrange
        Dollar five = new Dollar(5);
        // Act
        Dollar product = five.times(2);
        // Assert
        Assert.assertEquals(10, product.amount);

        product = five.times(3);
        Assert.assertEquals(15, product.amount);
    }

}

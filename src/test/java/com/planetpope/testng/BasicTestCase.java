package com.planetpope.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTestCase {

    @Test
    public void addition() {
        int expected = 40;
        int actual = 22 + 20;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void addition2() {
        int expected = 42;
        int actual = 22 + 20;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void addition3() {
        int expected = 42;
        int actual = 22 + 20;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void addition4() {
        int expected = 42;
        int actual = 22 + 20;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void subtraction() {
        int expected = 42;
        int actual = 84 - 42;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void isTrue() {
        boolean value = true;
        Assert.assertTrue(value);
    }

    @Test
    public void isFalse() {
        boolean value = true;
        Assert.assertFalse(value);
    }
}

package com.planetpope.testng;

import org.testng.TestNG;

public class TestRunner {
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { BasicTestCase.class });
        testng.addListener(new CustomTestListener());
        testng.run();
    }
}

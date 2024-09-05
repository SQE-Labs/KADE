package org.automation.utilities;

import org.automation.base.BaseTest;
import org.automation.logger.Log;
import org.testng.Assert;

import static com.aventstack.extentreports.Status.FAIL;
import static com.aventstack.extentreports.Status.PASS;

public class Assertions extends BaseTest {


    public static void assertEquals(String actual, String expected) {

        try {
            Assert.assertEquals(actual, expected);
            getExtentTest().log(PASS, "Assertion passed , Value is : " + actual);
        } catch (AssertionError e) {
            Log.info("exception in assertEquals method");
            getExtentTest().log(FAIL, "Assertion failed => " + "Actual Value : '" + actual + "' | Expected Value : '" + expected + "'");
            throw e;
        }
    }


    public static void assertNotEquals(String actual, String expected) {

        try {
            Assert.assertNotEquals(actual, expected);
            getExtentTest().log(PASS, "Assertion passed , Value is : " + actual);
        } catch (AssertionError e) {
            Log.info("excpetion in assertEquals method");
            getExtentTest().log(FAIL, "Assertion failed : " + "Actual Value is " + actual + " , Expected Value is " + expected);
            throw e;
        }
    }


    public static void assertTrue(boolean value) {
        try {
            Assert.assertTrue(value);
            getExtentTest().log(PASS, "Assertion passed  : " + value);

        } catch (Exception e) {
            getExtentTest().log(FAIL, "Assertion failed : " + "Actual Value " + value);
            throw e;
        }

    }

    public static void assertFalse(boolean value) {
        try {
            Assert.assertFalse(value);
            getExtentTest().log(PASS, "Assertion passed :  " + value);

        } catch (Exception e) {
            getExtentTest().log(FAIL, "Assertion failed : " + "Actual Value " + value);
            throw e;
        }

    }

    public void assertNotNull(String value) {
        try {
            Assert.assertNotNull(FAIL);
            getExtentTest().log(PASS, "Assertion passed " + value);

        } catch (Exception e) {
            getExtentTest().log(FAIL, "Assertion failed : " + "Actual Value " + value);
            throw e;
        }

    }

    //String Asserts
    public void assertEqualsString_custom(String expvalue, String actualValue, String locatorName) throws Throwable {
        try {
            if (actualValue.equals(expvalue)) {
                //          ExtentFactory.getInstance().getExtent().log(Status.PASS, "String Assertion is successful on field " + locatorName + " Expected value was: " + expvalue + " actual value is: " + actualValue);
            } else {
                //          ExtentFactory.getInstance().getExtent().log(Status.FAIL, "String Assertion FAILED on field " + locatorName + " Expected value was: " + expvalue + " actual value is: " + actualValue);
                Assert.fail();
            }
        } catch (Exception e) {
            Assert.fail(e.toString());
        }
    }
}

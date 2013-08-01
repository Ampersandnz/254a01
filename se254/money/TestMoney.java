package se254.money;
/**
 * SOFTENG 254 2011 Assignment 1 submission
 *
 * Author: (Michael Lo, mlo450)
 **/

import junit.framework.TestCase;

public class TestMoney extends TestCase {
	private Money money;

    public void setUp() {
    	money = null;
    }

    public void tearDown() {
    	money = null;
    }

    //Ensure that the default constructor, Money(), creates a Money with an amount of $0.00
    public void testZeroConstructor() {
    	money = new Money();
    	assertSame("$0.00", money.toString());
    }

    public void testConstructorWithZero() {
    	money = new Money(0,0);
    	assertEquals("$0.00", money.toString());
    }












    /**
     * DO NOT DELETE THIS
     * This is needed for the automatic marking process.
     **/
    public static void main(String[] args) {
        junit.textui.TestRunner.run(TestMoney.class);
    }
}

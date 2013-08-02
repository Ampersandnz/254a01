package se254.money;
/**
 * SOFTENG 254 2011 Assignment 1 submission
 *
 * Author: (Michael Lo, mlo450)
 *
 * GitHub: https://github.com/Ampersandnz/254a01.git
 **/

import junit.framework.TestCase;

public class TestMoney extends TestCase {
https://github.com/Ampersandnz/254a01.git
    public void setUp() {
    }

    public void tearDown() {
    }

    //Ensure that the default constructor, Money(), creates a Money with an amount of $0.00.
    public void testZeroConstructor() {
    	Money money = new Money();
    	assertSame("$0.00", money.toString());
    }

    //Ensure that the constructor Money(int dollars, int cents) correctly creates a Money with an amount of $0.00.
    public void testConstructorAWithZero() {
    	Money money = new Money(0,0);
    	assertEquals("$0.00", money.toString());
    }

    //Ensure that the constructor Money(int dollars, int cents) correctly creates a Money with a negative amount of dollars, cents, and both.
    public void testConstructorAWithNegativeAmounts() {
    	Money money = new Money(-3,0);	
    	Money money = new Money(0,-15);   
    	Money money = new Money(-3,15);
    	assertEquals("-$3.00", money.toString());    
    	assertEquals("-$0.15", money.toString()); 	
    	assertEquals("-$3.15", money.toString());    	
    }

    //Ensure that the constructor Money(int dollars, int cents) correctly creates a Money with a positive amount of dollars, cents, and both.
    public void testConstructorAWithPositiveAmounts() {
    	Money money2 = new Money(3,0);
    	Money money1 = new Money(0,15);
    	Money money3 = new Money(3,15);
    	assertEquals("$3.00", money2.toString());
    	assertEquals("$0.15", money1.toString());
    	assertEquals("$3.15", money3.toString());
    }

    /*
    //Ensure that the constructor Money(int dollars, int cents) correctly handles an input of >99 cents.
    public void testConstructorAWithMoreThan99Cents() {
    	Money money = new Money(0,150);
    	##Throws exception?
    } */
    
    //Ensure that the constructor Money(int dollars, int cents) correctly creates a Money with a positive amount of both dollars and cents.
    public void testImmutability() {
    	Money money = new Money(3,15);
    	money = new Money(3,14);
    	assertEquals("$3.15", money.toString());
    }

    /**
     * DO NOT DELETE THIS
     * This is needed for the automatic marking process.
     **/
    public static void main(String[] args) {
        junit.textui.TestRunner.run(TestMoney.class);
    }
}

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
    //Empty as Moneys are immutable so not much point setting any up before running each test.
    public void setUp() {
    }


    public void tearDown() {
    }

    //Ensure that the default constructor, Money(), creates a Money with an amount of $0.00.
    public void testZeroConstructor() {
        Money money = new Money();
        assertEquals("$0.00", money.toString());
    }

            //CONSTRUCTOR A:
    //Ensure that the constructor Money(int dollars, int cents) correctly creates a Money with an amount of $0.00.
    public void testConstructorAWithZero() {
        Money money = new Money(0,0);
        assertEquals("$0.00", money.toString());
    }

    //Ensure that the constructor Money(int dollars, int cents) correctly creates a Money with a negative amount of dollars, cents, and both.
    public void testConstructorAWithNegativeAmounts() {
        Money money1 = new Money(-3,0);  
        Money money2 = new Money(0,-15);   
        Money money3 = new Money(-3,15);
        assertEquals("-$3.00", money1.toString());    
        assertEquals("-$0.15", money2.toString());   
        assertEquals("-$3.15", money3.toString());       
    }

    //Ensure that the constructor Money(int dollars, int cents) correctly creates a Money with a positive amount of dollars, cents, and both.
    public void testConstructorAWithPositiveAmounts() {
        Money money1 = new Money(3,0);
        Money money2 = new Money(0,15);
        Money money3 = new Money(3,15);
        assertEquals("$3.00", money1.toString());
        assertEquals("$0.15", money2.toString());
        assertEquals("$3.15", money3.toString());
    }

    //Ensure that an IllegalArgumentException is thrown when given an input of >99 cents.
    public void testConstructorAWithMoreThan99Cents() {
        try {
        	Money money = new Money(0,150);
        } catch (IllegalArgumentException e) {
        }
    }
    
    //Ensure that an IllegalArgumentException is thrown when given two negative inputs.
    public void testMoreThanOneNegativeInput() {
        try {
        	Money money = new Money(-1,-10);
    	} catch (IllegalArgumentException e) {
    	}
    }

            //CONSTRUCTOR B:
    		//Assume that constructor B will not fail any tests that constructor A passes, so not copying same tests.
    //Ensure that the constructor Money(int dollars, int cents, int hundredths) correctly creates a Money with a negative amount of hundredths.
    public void testConstructorBWithNegativeHundredths() {
        Money money = new Money(0,0,-25);
        assertEquals("-$0.0025", money.toString());
    }

    //Ensure that the constructor Money(int dollars, int cents, int hundredths) correctly creates a Money with a positive amount of hundredths.
    public void testConstructorBWithPositiveHundredths() {
        Money money = new Money(0,0,25);
        assertEquals("$0.0025", money.toString());
    }

    //Ensure that the constructor Money(int dollars, int cents, int hundredths) correctly handles an input of >99 cents.
    public void testConstructorBWithMoreThan99Hundredths() {
        try {
        	Money money = new Money(0,0,150);
        } catch (IllegalArgumentException e) {
        }
    }

    //Ensure that an IllegalArgumentException is thrown when given a negative input that is not the most significant input.
    public void testMoreNegativeInputInWrongPlace() {
        try {
        	Money money = new Money(1,-10,10);
    	} catch (IllegalArgumentException e) {
    	}
    }

            //METHODS:
    //Ensure that the Add() method correctly adds two positive Moneys.
    public void testAddPositive() {
        Money money1 = new Money(1,50);
        Money money2 = new Money(0,30);
        Money money3 = money1.add(money2);
        assertEquals("$1.80", money3.toString());
    }

    //Ensure that the Add() method correctly adds two negative Moneys, and one negative and one positive Money.
    public void testAddNegative() {
        Money money1 = new Money(-1,0);
        Money money2 = new Money(0,-50);
        Money money3 = new Money(3,25);
        Money money4 = money1.add(money2);
        Money money5 = money3.add(money2);
        assertEquals("-$1.50", money4.toString());
        assertEquals("$2.75", money5.toString());
    }

    //Ensure that the Add() method correctly adds zero to a Money.
    public void testAddZero() {
        Money money1 = new Money(1,50);
        Money money2 = new Money();
        Money money3 = money1.add(money2);
        assertEquals("$1.50", money3.toString());
    }

    //Ensure that the Add() method correctly throws an IllegalArgumentException when given a null input.
    public void testAddNull() {
        Money money1 = new Money(1,50);
        Money money2 = null;
        try {
        	Money money3 = money1.add(money2);
    	} catch (IllegalArgumentException e) {
    	}
    }

    //Ensure that a comparison to a larger Money returns -1.
    public void testCompareToGreater() {
    	Money money1 = new Money(1,0);
    	Money money2 = new Money(2,0);
    	assertEquals(-1, money1.compareTo(money2));
    }

    //Ensure that a comparison to a smaller Money returns 1.
    public void testCompareToSmaller() {
    	Money money1 = new Money(1,0);
    	Money money2 = new Money(0,50);
    	assertEquals(1, money1.compareTo(money2));
    }

    //Ensure that a comparison to a negative Money returns 1.
    public void testCompareToNegative() {
    	Money money1 = new Money(1,0);
    	Money money2 = new Money(-5,0);
    	assertEquals(1, money1.compareTo(money2));
    }

    //Ensure that a comparison to zero returns 1.
    public void testCompareToZero() {
    	Money money1 = new Money(1,0);
    	Money money2 = new Money();
    	assertEquals(1, money1.compareTo(money2));
    }

    //Ensure that a comparison to an equal Money returns 0.
    public void testCompareToSame() {
    	Money money1 = new Money(1,0);
    	Money money2 = new Money(1,0);
    	assertEquals(0, money1.compareTo(money2));
    }

    //Ensure that an equality check with an equivalent Money returns True.
    public void testEqualsEquivalent() {
    	Money money1 = new Money(1,0);
    	Money money2 = new Money(1,0);
    	assertTrue(money1.equals(money2));
    }

    //Ensure that an equality check with a non-equivalent Money returns False.
    public void testEqualsNonEquivalent() {
    	Money money1 = new Money(1,0);
    	Money money2 = new Money(2,0);
    	assertFalse(money1.equals(money2));
    }

    //Ensure that an equality check with a null Money returns False.
    public void testEqualsNull() {
    	Money money1 = new Money(1,0);
    	Money money2 = null;
    	assertFalse(money1.equals(money2));
    }










    /**
     * DO NOT DELETE THIS
     * This is needed for the automatic marking process.
     **/
    public static void main(String[] args) {
        junit.textui.TestRunner.run(TestMoney.class);
    }
}

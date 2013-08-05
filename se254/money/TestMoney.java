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
    //Empty as Moneys are immutable so not much point setting any up before running each test. Less resource intensive to only initialise the Moneys that will be needed.
    public void setUp() {
    }

    public void tearDown() {
    }



            //Constructors:
        //Constructor A
    //Ensure that the default constructor, Money(), creates a Money with an amount of $0.00.
    public void testConstructorA() {
        Money money = new Money();
        assertEquals("$0.00", money.toString());
    }





            //Constructor B
    //Ensure that the constructor Money(int dollars, int cents) correctly creates a Money with an amount of $0.00.
    public void testConstructorBWithZero() {
        Money money = new Money(0,0);
        assertEquals("$0.00", money.toString());
    }

    //Ensure that the constructor Money(int dollars, int cents) correctly displays a Money with an amount in cents only $0.00.
    public void testConstructorBWithCentsOnly() {
        Money money = new Money(0,30);
        assertEquals("$0.30", money.toString());
    }

    //Ensure that the constructor Money(int dollars, int cents) correctly creates a Money with a negative amount of dollars, cents, and both.
    public void testConstructorBWithNegativeAmounts() {
        Money money1 = new Money(-3,0);  
        Money money2 = new Money(0,-15);   
        Money money3 = new Money(-3,15);
        assertEquals("-$3.00", money1.toString());    
        assertEquals("-$0.15", money2.toString());   
        assertEquals("-$3.15", money3.toString());       
    }

    //Ensure that the constructor Money(int dollars, int cents) correctly creates a Money with a positive amount of dollars, cents, and both.
    public void testConstructorBWithPositiveAmounts() {
        Money money1 = new Money(3,0);
        Money money2 = new Money(0,15);
        Money money3 = new Money(3,15);
        assertEquals("$3.00", money1.toString());
        assertEquals("$0.15", money2.toString());
        assertEquals("$3.15", money3.toString());
    }

    //Ensure that an IllegalArgumentException is thrown when given an input of >99 cents.
    public void testConstructorBWithMoreThan99Cents() {
        try {
        	Money money = new Money(0,150);
        } catch (IllegalArgumentException e) {
        }
    }
    
    //Ensure that an IllegalArgumentException is thrown when given an input -0.
    public void testConstructorBWithNegativeZeroInput() {
        try {
            Money money = new Money(-0,0);
        } catch (IllegalArgumentException e) {
        }
        try {
            Money money = new Money(0,-0);
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





            //Constructor C
    		//Assume that constructor B will not fail any tests that constructor A passes, so not copying same tests.
    //Ensure that the constructor Money(int dollars, int cents, int hundredths) correctly creates a Money with a negative amount of hundredths.
    public void testConstructorCWithNegativeHundredths() {
        Money money = new Money(0,0,-25);
        assertEquals("-$0.0025", money.toString());
    }

    //Ensure that the constructor Money(int dollars, int cents, int hundredths) correctly creates a Money with a positive amount of hundredths.
    public void testConstructorCWithPositiveHundredths() {
        Money money = new Money(0,0,25);
        assertEquals("$0.0025", money.toString());
    }

    //Ensure that the constructor Money(int dollars, int cents, int hundredths) correctly handles an input of >99 cents.
    public void testConstructorCWithMoreThan99Hundredths() {
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

    //Ensure that an IllegalArgumentException is thrown when given an input -0.
    public void testConstructorCWithNegativeZeroInput() {
        try {
            Money money = new Money(0,0,-0);
        } catch (IllegalArgumentException e) {
        }
    }

    public void testConstructorCWithPossibleTrailingZero() {
        Money money1 = new Money(50,50,50);
        Money money2 = new Money(50,50,0);
        assertEquals("$50.505", money1.toString());
        assertEquals("$50.50", money2.toString());
    }





            //METHODS:
        //Add
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
        Money money6 = money1.add(money3);
        assertEquals("-$1.50", money4.toString());
        assertEquals("$2.75", money5.toString());
        assertEquals("$2.25", money6.toString());
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

    //Ensure that the Add() method correctly passes up carry digits.
    public void testAddCarry() {
        Money money1 = new Money(1,80,90);
        Money money2 = new Money(0,10,10);
        Money money3 = money1.add(money2);
        assertEquals("$2.00", money3.toString());
    }





        //CompareTo
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

    //Ensure that a comparison to a negative Money returns correctly.
    public void testCompareToNegative() {
    	Money money1 = new Money(1,0);
    	Money money2 = new Money(-5,0);
        assertEquals(1, money1.compareTo(money2));
    	assertEquals(-1, money2.compareTo(money1));
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

    public void testCompareToNull() {
        Money money1 = new Money(1,0);
        Money money2;
        try {
            assertEquals(0, money1.compareTo(money2));
        } catch (IllegalArgumentException e) {
        }
    }





        //Equals
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





        //Multiply
    //Ensure that a Money can be correctly multiplied by a positive number.
    public void testMultiplyPositive() {
        Money money1 = new Money(10,50);
        Money money2 = money1.multiply(2.5);
        assertEquals("$26.25", money2.toString());
    }

    //Ensure that a Money can be correctly multiplied by a positive decimal.
    public void testMultiplyPositiveDecimal() {
        Money money1 = new Money(10,50);
        Money money2 = money1.multiply(0.5);
        assertEquals("$5.25", money2.toString());
    }

    //Ensure that a Money can be correctly multiplied by a negative number.
    public void testMultiplyNegative() {
        Money money1 = new Money(10,50);
        Money money2 = money1.multiply(-2.5);
        assertEquals("-$26.25", money2.toString());
    }

    //Ensure that a Money can be correctly multiplied by a negative decimal.
    public void testMultiplyNegativeDecimal() {
        Money money1 = new Money(10,50);
        Money money2 = money1.multiply(-0.5);
        assertEquals("-$5.25", money2.toString());
    }

    //Ensure that a Money can be correctly multiplied by zero.
    public void testMultiplyZero() {
        Money money1 = new Money(10,50);
        Money money2 = money1.multiply(0);
        assertEquals("-$0.00", money2.toString());
    }

    //Ensure that a Money amount of zero can be correctly multiplied.
    public void testMultiplyNoMoney() {
        Money money1 = new Money(0,0,0);
        Money money2 = money1.multiply(5);
        assertEquals("$0.00", money2.toString());
    }

    //Ensure that a Money amount of zero can be correctly multiplied without rounding errors.
    public void testMultiplyRoundingErrorCheck() {
        Money money1 = new Money(10,50,10);
        Money money2 = money1.multiply(2.234736);
        Money money3 = money1.multiply(5.234324);
        Money money4 = money1.multiply(5.234324);
        assertEquals("$23.467", money2.toString());
        assertEquals("$54.9656", money3.toString());
        assertEquals("$2471488.6188", money4.toString());
    }

    //Ensure that a negative Money amount can be multiplied by a negative number.
    public void testMultiplyNoMoney() {
        Money money1 = new Money(-10,50,10);
        Money money2 = money1.multiply(-5);
        assertEquals("$52.505", money2.toString());
    }

    //Ensure that a multiplication by a very large number does not introduce rounding errors.
    public void testMultiplyByLargeAmount() {
        Money money1 = new Money(5,79,13);
        Money money2 = money1.multiply(100000000);
        assertEquals("$579130000.00", money2.toString());
    }

    //Ensure that a multiplication by a very small number does not introduce rounding errors.
    public void testMultiplyBySmallAmount() {
        Money money1 = new Money(100000000,0,0);
        Money money2 = money1.multiply(0.00000000234);
        assertEquals("$0.234", money2.toString());
    }

    /**
     * DO NOT DELETE THIS
     * This is needed for the automatic marking process.
     **/
    public static void main(String[] args) {
        junit.textui.TestRunner.run(TestMoney.class);
    }
}

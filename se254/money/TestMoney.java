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
    /**
    *Empty as Moneys are immutable so not much point setting any up before running each test. Less resource intensive to only initialise the Moneys that will be needed.
    */
    public void setUp() {
    }

    /**
    *Empty as nothing to clear up that is not automatically done when each method finishes.
    */
    public void tearDown() {
    }



            //Constructors:
        //Constructor A
    /**
    *Ensure that the default constructor, Money(), creates a Money with an amount of $0.00.
    */
    public void testConstructorA() {
        Money money = new Money();
        assertEquals("$0.00", money.toString());
    }





            //Constructor B
    /**
    *Ensure that the constructor Money(int dollars, int cents) correctly creates a Money with an amount of $0.00.
    */
    public void testConstructorBWithZero() {
        Money money = new Money(0,0);
        assertEquals("$0.00", money.toString());
    }

    /**
    *Ensure that the constructor Money(int dollars, int cents) correctly displays a Money with an amount in cents only $0.00.
    */
    public void testConstructorBWithCentsOnly() {
        Money money = new Money(0,30);
        assertEquals("$0.30", money.toString());
    }

    /**
    *Ensure that the constructor Money(int dollars, int cents) correctly creates a Money with a negative amount of dollars, cents, and both.
    */
    public void testConstructorBWithNegativeAmounts() {
        Money money1 = new Money(-3,0);  
        Money money2 = new Money(0,-15);   
        Money money3 = new Money(-3,15);
        assertEquals("-$3.00", money1.toString());    
        assertEquals("-$0.15", money2.toString());   
        assertEquals("-$3.15", money3.toString());       
    }

    /**
    *Ensure that the constructor Money(int dollars, int cents) correctly creates a Money with a positive amount of dollars, cents, and both.
    */
    public void testConstructorBWithPositiveAmounts() {
        Money money1 = new Money(3,0);
        Money money2 = new Money(0,15);
        Money money3 = new Money(3,15);
        assertEquals("$3.00", money1.toString());
        assertEquals("$0.15", money2.toString());
        assertEquals("$3.15", money3.toString());
    }

    /**
    *Ensure that an IllegalArgumentException is thrown when given an input of >99 cents.
    */
    public void testConstructorBWithMoreThan99Cents() {
        try {
        	Money money = new Money(0,150);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }
    
    /**
    *Ensure that an IllegalArgumentException is thrown when given an input -0.
    */
    public void testConstructorBWithNegativeZeroInput() {
        Money money1 = new Money(-0,0);
        Money money2 = new Money(0,-0);
        assertEquals("$0.00", money1.toString());
        assertEquals("$0.00", money2.toString());
    }

    /**
    *Ensure that an IllegalArgumentException is thrown when given two negative inputs.
    */
    public void testConstructorBWithMoreThanOneNegativeInput() {
        try {
        	Money money = new Money(-1,-10);
    	} catch (IllegalArgumentException e) {
            return;
    	}
        fail();
    }

    /**
    *Ensure that an IllegalArgumentException is thrown when given a negative input that is not the most significant input.
    */
    public void testConstructorBWithNegativeInputInWrongPlace() {
        try {
            Money money = new Money(1,-10);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }

        public void testConstructorBWithPossibleTrailingZero() {
        Money money = new Money(50,50);
        assertEquals("$50.50", money.toString());
    }





            //Constructor C
    /**
    *Ensure that the constructor Money(int dollars, int cents, int hundredths) correctly handles various positive inputs.
    */
    public void testConstructorCWithPositiveAmounts() {
        Money money0 = new Money(1,10,10);  
        Money money1 = new Money(1,0,10);  
        Money money2 = new Money(1,10,0);   
        Money money3 = new Money(0,10,10);
        Money money4 = new Money(1,0,0);  
        Money money5 = new Money(0,10,0);   
        Money money6 = new Money(0,0,10);
        assertEquals("$1.101", money0.toString());    
        assertEquals("$1.001", money1.toString());   
        assertEquals("$1.10", money2.toString());       
        assertEquals("$0.101", money3.toString());       
        assertEquals("$1.00", money4.toString());       
        assertEquals("$0.10", money5.toString());       
        assertEquals("$0.001", money6.toString());       
    }

    /**
    *Ensure that the constructor Money(int dollars, int cents, int hundredths) correctly handles various negative inputs.
    */
        public void testConstructorCWithNegativeAmounts() {
        Money money0 = new Money(-1,10,10);  
        Money money1 = new Money(-1,0,10);  
        Money money2 = new Money(-1,10,0);   
        Money money3 = new Money(0,-10,10);
        Money money4 = new Money(-1,0,0);  
        Money money5 = new Money(0,-10,0);   
        Money money6 = new Money(0,0,-10);
        assertEquals("-$1.101", money0.toString());    
        assertEquals("-$1.001", money1.toString());   
        assertEquals("-$1.10", money2.toString());       
        assertEquals("-$0.101", money3.toString());       
        assertEquals("-$1.00", money4.toString());    
        assertEquals("-$0.10", money5.toString());     
        assertEquals("-$0.001", money6.toString());
    }

    /**
    *Ensure that the constructor Money(int dollars, int cents, int hundredths) correctly creates a Money with a negative amount of hundredths.
    */
    public void testConstructorCWithNegativeHundredths() {
        Money money = new Money(0,0,-25);
        assertEquals("-$0.0025", money.toString());
    }

    /**
    *Ensure that the constructor Money(int dollars, int cents, int hundredths) correctly creates a Money with a positive amount of hundredths.
    */
    public void testConstructorCWithPositiveHundredths() {
        Money money = new Money(0,0,25);
        assertEquals("$0.0025", money.toString());
    }

    /**
    *Ensure that an IllegalArgumentException is thrown when given an input of >99 cents.
    */
    public void testConstructorCWithMoreThan99Cents() {
        try {
            Money money = new Money(0,150,50);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }

    /**
    *Ensure that the constructor Money(int dollars, int cents, int hundredths) correctly handles an input of >99 cents.
    */
    public void testConstructorCWithMoreThan99Hundredths() {
        try {
        	Money money = new Money(0,0,150);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }

    /**
    *Ensure that an IllegalArgumentException is thrown when given a negative input that is not the most significant input.
    */
    public void testConstructorCWithNegativeInputInWrongPlace() {
        try {
            Money money = new Money(1,-10,0);
    	} catch (IllegalArgumentException e1) {
            try {
                Money money = new Money(1,0,-10);
            } catch (IllegalArgumentException e2) {
                try {
                    Money money = new Money(0,10,-10);
                } catch (IllegalArgumentException e3) {
                    return;
                }
            }
    	}
        fail();
    }

    /**
    *Ensure that an IllegalArgumentException is thrown when given two negative inputs.
    */
    public void testConstructorCWithMoreThanOneNegativeInput() {
        try {
            Money money1 = new Money(-1,-10,10);
        } catch (IllegalArgumentException e1) {
            try {
                Money money2 = new Money(1,-10,-10);
            } catch (IllegalArgumentException e2) {
                try {
                    Money money3 = new Money(-1,10,-10);
                } catch (IllegalArgumentException e3) {
                    return;
                }
            }
        }
        fail();
    }

    /**
    *Ensure that an IllegalArgumentException is thrown when given an input -0.
    */
    public void testConstructorCWithNegativeZeroInput() {
        Money money1 = new Money(-0,0,0);
        Money money2 = new Money(0,-0,0);
        Money money3 = new Money(0,0,-0);
        assertEquals("$0.00", money1.toString());
        assertEquals("$0.00", money2.toString());
        assertEquals("$0.00", money3.toString());
    }

    public void testConstructorCWithPossibleTrailingZero() {
        Money money1 = new Money(50,50,50);
        Money money2 = new Money(50,50,0);
        assertEquals("$50.505", money1.toString());
        assertEquals("$50.50", money2.toString());
    }





            //METHODS:
        //Add
    /**
    *Ensure that the Add() method correctly adds two positive Moneys.
    */
    public void testAddPositive() {
        Money money1 = new Money(1,50,20);
        Money money2 = new Money(1,0);
        Money money3 = new Money(0,0,20);
        Money money4 = new Money(0,30);
        Money money5 = new Money(1,30,0);
        Money money6 = new Money(1,0,20);
        Money money7 = new Money(0,30,20);
        Money money8 = money1.add(money2);
        Money money9 = money1.add(money3);
        Money money10 = money1.add(money4);
        Money money11 = money1.add(money5);
        Money money12 = money1.add(money6);
        Money money13 = money1.add(money7);
        assertEquals("$2.502", money8.toString());
        assertEquals("$1.504", money9.toString());
        assertEquals("$1.802", money10.toString());
        assertEquals("$2.802", money11.toString());
        assertEquals("$2.504", money12.toString());
        assertEquals("$1.804", money13.toString());
    }

    /**
    *Ensure that the Add() method correctly adds two negative Moneys.
    */
    public void testAddNegativeToNegative() {
        Money money1 = new Money(-1,50,20);
        Money money2 = new Money(-1,0);
        Money money3 = new Money(0,0,-20);
        Money money4 = new Money(0,-30);
        Money money5 = new Money(-1,30);
        Money money6 = new Money(-1,0,20);
        Money money7 = new Money(0,-30,20);
        Money money8 = money1.add(money2);
        Money money9 = money1.add(money3);
        Money money10 = money1.add(money4);
        Money money11 = money1.add(money5);
        Money money12 = money1.add(money6);
        Money money13 = money1.add(money7);
        Money money14 = money2.add(money2);
        Money money15 = money3.add(money3);
        Money money16 = money4.add(money4);
        assertEquals("-$2.502", money8.toString());
        assertEquals("-$1.504", money9.toString());
        assertEquals("-$1.802", money10.toString());
        assertEquals("-$2.802", money11.toString());
        assertEquals("-$2.504", money12.toString());
        assertEquals("-$1.804", money13.toString());
        assertEquals("-$2.00", money14.toString());
        assertEquals("-$0.004", money15.toString());
        assertEquals("-$0.60", money16.toString());
    }

    /**
    *Ensure that the Add() method correctly adds one negative and one positive Money.
    */
    public void testAddNegativeToPositive() {
        Money money1 = new Money(1,10,10);
        Money money2 = new Money(-2,0);
        Money money3 = new Money(0,0,-20);
        Money money4 = new Money(0,-30);
        Money money5 = new Money(-2,30);
        Money money6 = new Money(-2,0,20);
        Money money7 = new Money(0,-30,20);
        Money money8 = money1.add(money2);
        Money money9 = money1.add(money3);
        Money money10 = money1.add(money4);
        Money money11 = money1.add(money5);
        Money money12 = money1.add(money6);
        Money money13 = money1.add(money7);
        assertEquals("-$0.899", money8.toString());
        assertEquals("$1.099", money9.toString());
        assertEquals("$0.801", money10.toString());
        assertEquals("-$1.199", money11.toString());
        assertEquals("-$0.901", money12.toString());
        assertEquals("$0.799", money13.toString());
    }

    /**
    *Ensure that the Add() method correctly adds zero to a Money.
    */
    public void testAddZero() {
        Money money1 = new Money(1,50);
        Money money2 = new Money();
        Money money3 = money1.add(money2);
        Money money4 = money2.add(money1);
        assertEquals("$1.50", money3.toString());
        assertEquals("$1.50", money4.toString());
    }

    /**
    *Ensure that the Add() method correctly throws an IllegalArgumentException when given a null input.
    */
    public void testAddNull() {
        Money money1 = new Money(1,50);
        Money money2 = null;
        try {
        	Money money3 = money1.add(money2);
    	} catch (IllegalArgumentException e) {
            return;
    	}
        fail();
    }

    /**
    *Ensure that the Add() method correctly passes up carry digits.
    */
    public void testAddCarry() {
        Money money1 = new Money(1,80,90);
        Money money2 = new Money(0,19,10);
        Money money3 = new Money(0,0,10);
        Money money4 = new Money(0,20);
        Money money5 = money1.add(money2);
        Money money6 = money1.add(money3);
        Money money7 = money1.add(money4);
        assertEquals("$2.00", money5.toString());
        assertEquals("$1.81", money6.toString());
        assertEquals("$2.009", money7.toString());
    }





        //CompareTo
    /**
    *Ensure that a comparison to a larger Money returns -1.
    */
    public void testCompareToGreater() {
        Money money1 = new Money(1,0);
        Money money2 = new Money(2,0);
        Money money3 = new Money(0,50);
        Money money4 = new Money(0,75);
        Money money5 = new Money(0,0,50);
        Money money6 = new Money(0,0,75);
        Money money7 = new Money(1,20,50);
        Money money8 = new Money(1,20,75);
        assertEquals(-1, money1.compareTo(money2));
        assertEquals(-1, money3.compareTo(money4));
        assertEquals(-1, money5.compareTo(money6));
        assertEquals(-1, money7.compareTo(money8));
    }

    /**
    *Ensure that a comparison to a smaller Money returns 1.
    */
    public void testCompareToSmaller() {
        Money money1 = new Money(1,0);
        Money money2 = new Money(2,0);
        Money money3 = new Money(0,50);
        Money money4 = new Money(0,75);
        Money money5 = new Money(0,0,50);
        Money money6 = new Money(0,0,75);
        Money money7 = new Money(1,20,50);
        Money money8 = new Money(1,20,75);
        assertEquals(1, money2.compareTo(money1));
        assertEquals(1, money4.compareTo(money3));
        assertEquals(1, money6.compareTo(money5));
        assertEquals(1, money8.compareTo(money7));
    }

    /**
    *Ensure that a comparison to a negative Money returns correctly.
    */
    public void testCompareToNegative() {
        Money money1 = new Money(-1,0);
        Money money2 = new Money(-2,0);
        Money money3 = new Money(0,-50);
        Money money4 = new Money(0,-75);
        Money money5 = new Money(0,0,-50);
        Money money6 = new Money(0,0,-75);
        assertEquals(1, money1.compareTo(money2));
        assertEquals(1, money3.compareTo(money4));
        assertEquals(1, money5.compareTo(money6));
        assertEquals(-1, money2.compareTo(money1));
        assertEquals(-1, money4.compareTo(money3));
        assertEquals(-1, money6.compareTo(money5));
    }

    /**
    *Ensure that a comparison to zero returns 1.
    */
    public void testCompareToZero() {
    	Money money1 = new Money(1,0);
    	Money money2 = new Money();
        assertEquals(1, money1.compareTo(money2));
    	assertEquals(-1, money2.compareTo(money1));
    }

    /**
    *Ensure that a comparison to an equal Money returns 0.
    */
    public void testCompareToSame() {
    	Money money1 = new Money(1,0);
    	Money money2 = new Money(1,0);
        assertEquals(0, money1.compareTo(money2));
    }    

    /**
    *Ensure that a comparison to a null Money throws an exception
    */
    public void testCompareToNull() {
    	Money money1 = new Money(1,0);
    	Money money2 = null;
    	try {
        	money1.compareTo(money2);
        } catch (IllegalArgumentException e) {
        	return;
        }
        fail();
    }  





        //Equals
    /**
    *Ensure that an equality check with an equivalent Money returns True.
    */
    public void testEqualsEquivalent() {
    	Money money1 = new Money(1,10,10);
    	Money money2 = new Money(1,10,10);
    	assertTrue(money1.equals(money2));
    }

    /**
    *Ensure that an equality check with a non-equivalent Money returns False.
    */
    public void testEqualsNonEquivalent() {
    	Money money1 = new Money(1,10,10);
        Money money2 = new Money(-1,10,10);
        Money money3 = new Money(2,10,10);
        Money money4 = new Money(1,20,10);
    	Money money5 = new Money(1,10,20);
        assertFalse(money1.equals(money2));
        assertFalse(money1.equals(money3));
        assertFalse(money1.equals(money4));
    	assertFalse(money1.equals(money5));
    }

    /**
    *Ensure that each field is individually checked for equivalence.
    */
    public void testEqualsSeparately() {
        Money money0 = new Money(1,10,10);
        Money money1 = new Money(1,10,0);
        Money money2 = new Money(0,10,10);
        Money money3 = new Money(10,0,10);
        assertFalse(money0.equals(money1));
        assertFalse(money0.equals(money2));
        assertFalse(money0.equals(money3));
    }

    /**
    *Ensure that an equality check with a null Money returns False.
    */
    public void testEqualsNull() {
    	Money money1 = new Money(1,10,10);
    	Money money2 = null;
    	assertFalse(money1.equals(money2));
    }





        //Multiply
    /**
    *Ensure that a Money can be correctly multiplied by a positive number.
    */
    public void testMultiplyPositive() {
        Money money1 = new Money(10,50,50);
        Money money2 = new Money(10,50);
        Money money3 = new Money(10,0,50);
        Money money4 = new Money(0,50,50);
        Money money5 = new Money(10,0);
        Money money6 = new Money(0,50);
        Money money7 = new Money(0,0,50);
        Money money8 = money1.multiply(2.5);
        Money money9 = money2.multiply(2.5);
        Money money10 = money3.multiply(2.5);
        Money money11 = money4.multiply(2.5);
        Money money12 = money5.multiply(2.5);
        Money money13 = money6.multiply(2.5);
        Money money14 = money7.multiply(2.5);
        assertEquals("$26.2625", money8.toString());
        assertEquals("$26.25", money9.toString());
        assertEquals("$25.0125", money10.toString());
        assertEquals("$1.2625", money11.toString());
        assertEquals("$25.00", money12.toString());
        assertEquals("$1.25", money13.toString());
        assertEquals("$0.0125", money14.toString());
    }

    /**
    *Ensure that a Money can be correctly multiplied by a positive decimal.
    */
    public void testMultiplyPositiveDecimal() {
        Money money1 = new Money(10,50,50);
        Money money2 = new Money(10,50);
        Money money3 = new Money(10,0,50);
        Money money4 = new Money(0,50,50);
        Money money5 = new Money(10,0);
        Money money6 = new Money(0,50);
        Money money7 = new Money(0,0,50);
        Money money8 = money1.multiply(0.5);
        Money money9 = money2.multiply(0.5);
        Money money10 = money3.multiply(0.5);
        Money money11 = money4.multiply(0.5);
        Money money12 = money5.multiply(0.5);
        Money money13 = money6.multiply(0.5);
        Money money14 = money7.multiply(0.5);
        assertEquals("$5.2525", money8.toString());
        assertEquals("$5.25", money9.toString());
        assertEquals("$5.0025", money10.toString());
        assertEquals("$0.2525", money11.toString());
        assertEquals("$5.00", money12.toString());
        assertEquals("$0.25", money13.toString());
        assertEquals("$0.0025", money14.toString());
    }

    /**
    *Ensure that a Money can be correctly multiplied by a negative number.
    */
    public void testMultiplyNegative() {
        Money money1 = new Money(10,50,50);
        Money money2 = new Money(10,50);
        Money money3 = new Money(10,0,50);
        Money money4 = new Money(0,50,50);
        Money money5 = new Money(10,0);
        Money money6 = new Money(0,50);
        Money money7 = new Money(0,0,50);
        Money money8 = money1.multiply(-2.5);
        Money money9 = money2.multiply(-2.5);
        Money money10 = money3.multiply(-2.5);
        Money money11 = money4.multiply(-2.5);
        Money money12 = money5.multiply(-2.5);
        Money money13 = money6.multiply(-2.5);
        Money money14 = money7.multiply(-2.5);
        assertEquals("-$26.2625", money8.toString());
        assertEquals("-$26.25", money9.toString());
        assertEquals("-$25.0125", money10.toString());
        assertEquals("-$1.2625", money11.toString());
        assertEquals("-$25.00", money12.toString());
        assertEquals("-$1.25", money13.toString());
        assertEquals("-$0.0125", money14.toString());
    }

    /**
    *Ensure that a Money can be correctly multiplied by a negative decimal.
    */
    public void testMultiplyNegativeDecimal() {
        Money money1 = new Money(10,50,50);
        Money money2 = new Money(10,50);
        Money money3 = new Money(10,0,50);
        Money money4 = new Money(0,50,50);
        Money money5 = new Money(10,0);
        Money money6 = new Money(0,50);
        Money money7 = new Money(0,0,50);
        Money money8 = money1.multiply(-0.5);
        Money money9 = money2.multiply(-0.5);
        Money money10 = money3.multiply(-0.5);
        Money money11 = money4.multiply(-0.5);
        Money money12 = money5.multiply(-0.5);
        Money money13 = money6.multiply(-0.5);
        Money money14 = money7.multiply(-0.5);
        assertEquals("-$5.2525", money8.toString());
        assertEquals("-$5.25", money9.toString());
        assertEquals("-$5.0025", money10.toString());
        assertEquals("-$0.2525", money11.toString());
        assertEquals("-$5.00", money12.toString());
        assertEquals("-$0.25", money13.toString());
        assertEquals("-$0.0025", money14.toString());
    }

    /**
    *Ensure that a Money can be correctly multiplied by zero.
    */
    public void testMultiplyZero() {
        Money money1 = new Money(10,50,50);
        Money money2 = new Money(10,0);
        Money money3 = new Money(0,50);
        Money money4 = new Money(0,0,50);
        Money money5 = new Money(10,0,50);
        Money money6 = new Money(0,50,50);
        Money money7 = new Money(10,50);
        Money money8 = money1.multiply(0);
        Money money9 = money2.multiply(0);
        Money money10 = money3.multiply(0);
        Money money11 = money4.multiply(0);
        Money money12 = money4.multiply(0);
        Money money13 = money4.multiply(0);
        Money money14 = money4.multiply(0);
        assertEquals("$0.00", money8.toString());
        assertEquals("$0.00", money9.toString());
        assertEquals("$0.00", money10.toString());
        assertEquals("$0.00", money11.toString());
        assertEquals("$0.00", money12.toString());
        assertEquals("$0.00", money13.toString());
        assertEquals("$0.00", money14.toString());
    }

    /**
    *Ensure that a Money amount of zero can be correctly multiplied.
    */
    public void testMultiplyNoMoney() {
        Money money1 = new Money(0,0,0);
        Money money2 = money1.multiply(5);
        assertEquals("$0.00", money2.toString());
    }

    /**
    *Ensure that a Money amounts are correctly rounded to the nearest hundredth.
    */
    public void testMultiplyRoundingErrorCheck() {
        Money money1 = new Money(10,0,1);
        Money money2 = new Money(-10,0,1);
        Money money3 = money1.multiply(1.5);
        Money money4 = money1.multiply(1.4);
        Money money5 = money1.multiply(1.6);
        Money money6 = money1.multiply(-1.5);
        Money money7 = money1.multiply(-1.4);
        Money money8 = money1.multiply(-1.6);
        assertEquals("$15.0002", money3.toString());
        assertEquals("$14.0001", money4.toString());
        assertEquals("$16.0002", money5.toString());
        assertEquals("-$15.0002", money6.toString());
        assertEquals("-$14.0001", money7.toString());
        assertEquals("-$16.0002", money8.toString());
    }

    /**
    *Ensure that a negative Money amount can be multiplied correctly.
    */
    public void testMultiplyNegativeMoney() {
        Money money1 = new Money(-10,50,10);
        Money money2 = money1.multiply(-5);
        Money money3 = money1.multiply(5);
        Money money4 = money1.multiply(-0.5);
        Money money5 = money1.multiply(0.5);
        assertEquals("$52.505", money2.toString());
        assertEquals("-$52.505", money3.toString());
        assertEquals("$5.2505", money4.toString());
        assertEquals("-$5.2505", money5.toString());
    }

    /**
    *Ensure that a multiplication by a very large number does not introduce rounding errors.
    */
    public void testMultiplyByLargeAmount() {
        Money money1 = new Money(1,10,10);
        Money money2 = money1.multiply(100000);
        Money money3 = money1.multiply(-100000);
        assertEquals("$110100.00", money2.toString());
        assertEquals("-$110100.00", money3.toString());
    }

    /**
    *Ensure that a multiplication by a very small number does not introduce rounding errors.
    */
    public void testMultiplyBySmallAmount() {
        Money money1 = new Money(10000,0,0);
        Money money2 = money1.multiply(0.0000001);
        Money money3 = money1.multiply(-0.0000001);
        assertEquals("$0.001", money2.toString());
        assertEquals("-$0.001", money3.toString());
    }

    /**
     * DO NOT DELETE THIS
     * This is needed for the automatic marking process.
     **/
    public static void main(String[] args) {
        junit.textui.TestRunner.run(TestMoney.class);
    }
}

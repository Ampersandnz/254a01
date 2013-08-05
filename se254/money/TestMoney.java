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
    public void setUp() {
    }

    public void tearDown() {
    }

    //Ensure that the default constructor, Money(), creates a Money with an amount of $0.00.
    public void testZeroConstructor() {
        Money money = new Money();
        assertSame("$0.00", money.toString());
    }

    //Ensure that Money objects cannot be changed once created.
    public void testImmutability() {
        Money money = new Money(3,15);
        money = new Money(3,14);
        assertSame("$3.15", money.toString());
    }

            //CONSTRUCTOR A:
    //Ensure that the constructor Money(int dollars, int cents) correctly creates a Money with an amount of $0.00.
    public void testConstructorAWithZero() {
        Money money = new Money(0,0);
        assertSame("$0.00", money.toString());
    }

    //Ensure that the constructor Money(int dollars, int cents) correctly creates a Money with a negative amount of dollars, cents, and both.
    public void testConstructorAWithNegativeAmounts() {
        Money money1 = new Money(-3,0);  
        Money money2 = new Money(0,-15);   
        Money money3 = new Money(-3,15);
        assertSame("-$3.00", money1.toString());    
        assertSame("-$0.15", money2.toString());   
        assertSame("-$3.15", money3.toString());       
    }

    //Ensure that the constructor Money(int dollars, int cents) correctly creates a Money with a positive amount of dollars, cents, and both.
    public void testConstructorAWithPositiveAmounts() {
        Money money1 = new Money(3,0);
        Money money2 = new Money(0,15);
        Money money3 = new Money(3,15);
        assertSame("$3.00", money1.toString());
        assertSame("$0.15", money2.toString());
        assertSame("$3.15", money3.toString());
    }

    //Ensure that the constructor Money(int dollars, int cents) correctly handles an input of >99 cents.
    public void testConstructorAWithMoreThan99Cents() {
        Money money = new Money(0,150);
    }
    
            //CONSTRUCTOR B:
    //Ensure that the constructor Money(int dollars, int cents, int hundredths) correctly creates a Money with an amount of $0.00.
    public void testConstructorBWithZero() {
        Money money = new Money(0,0,0);
        assertSame("$0.00", money.toString());
    }

    //Ensure that the constructor Money(int dollars, int cents, int hundredths) correctly creates a Money with a negative amount of hundredths.
    public void testConstructorBWithNegativeAmounts() {
        Money money = new Money(0,0,-25);
        assertSame("-$0.0025", money.toString());
    }

    //Ensure that the constructor Money(int dollars, int cents, int hundredths) correctly creates a Money with a positive amount of dollars, cents, and both.
    public void testConstructorBWithPositiveAmounts() {
        Money money = new Money(0,0,25);
        assertSame("$0.0025", money.toString());
    }

    //Ensure that the constructor Money(int dollars, int cents, int hundredths) correctly handles an input of >99 cents.
    public void testConstructorBWithMoreThan99Hundredths() {
        Money money = new Money(0,0,150);
    }

            //METHODS:
    //Ensure that the Add() method correctly adds the values of the two Moneys.
    public void testAddPositive() {
        Money money1 = new Money();
        Money money2 = new Money();
        Money money3 = money1.add(money2);
        assertSame(, money3.toString());
    }




    /**
     * DO NOT DELETE THIS
     * This is needed for the automatic marking process.
     **/
    public static void main(String[] args) {
        junit.textui.TestRunner.run(TestMoney.class);
    }
}

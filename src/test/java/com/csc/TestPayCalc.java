package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPayCalc
{
    PayCalc paycalc;

    @BeforeEach
    void setUp() {
        paycalc = new PayCalc();
    }

    @Test
    public void testPayForZeroHoursWorked()
    {
        assertEquals(paycalc.grossPay(0), 0);
    }

    @Test
    public void testPayForThirtyFiveHoursWorked()
    {
        assertEquals(paycalc.grossPay(35), 587.30, 0.01);
    }

    @Test
    public void testPayForFiftyThreeHoursWorked()
    {
        assertEquals(paycalc.grossPay(53), 998.41, 0.01);
    }

    @Test
    public void testSocialSecurityWhenPayIsZero()
    {
        assertEquals(paycalc.calcSS(0), 0);
    }

    @Test
    public void testSocialSecurityWhenPayIs587Point30()
    {
        assertEquals(paycalc.calcSS(587.3), 35.23, 0.01);
    }

    @Test
    public void testSocialSecurityWhenPayIs500()
    {
        assertEquals(paycalc.calcSS(500), 30, 0.01);
    }

    @Test 
    public void testFederalTaxWhenPayIsZero()
    {
        assertEquals(paycalc.calcFederalTax(0), 0);
    }

    @Test
    public void testFederalTaxWhenPayIs998Point41()
    {
        assertEquals(paycalc.calcFederalTax(998.41), 139.77, 0.01);
    }

    @Test
    public void testFederalTaxWhenPayIs16Point78()
    {
        assertEquals(paycalc.calcFederalTax(16.78), 2.34, 0.01);
    }

    @Test
    public void testUnionDues()
    {
        assertEquals(paycalc.unionDues(), 10.0);
    }

    @Test
    public void testOneDependent()
    {
        assertEquals(paycalc.dependentCareDues(1), 10.0);
    }

    @Test
    public void testThreeDependents()
    {
        assertEquals(paycalc.dependentCareDues(3), 35.0);
    }

    @Test
    public void testFiveDependents()
    {
        assertEquals(paycalc.dependentCareDues(5), 35.0);
    }
    
    @Test
    public void testDuesForZeroPayAndZeroDependents()
    {
        assertEquals(paycalc.calcAllDues(0, 0), 20.0);
    }

    @Test
    public void testDuesFor998Point41PayAndOneDependent()
    {
        assertEquals(paycalc.calcAllDues(998.41, 1), 269.60, 0.01);
    }

    @Test
    public void testDuesFor587Point30PayAndThreeDependents()
    {
        assertEquals(paycalc.calcAllDues(587.30, 3), 191.82, 0.01);
    }

    @Test
    public void testNetPayForZeroPayAndZeroDependents()
    {
        assertEquals(paycalc.calcNetPay(0, 0), -20.0, 0.01);
    }

    @Test
    public void testNetPayFor998Point41PayAndOneDependent()
    {
        assertEquals(paycalc.calcNetPay(998.41, 1), 728.81, 0.01);
    }

    @Test
    public void testNetPayFor587Point30PayAndThreeDependents()
    {
        assertEquals(paycalc.calcNetPay(587.30, 3), 395.48, 0.01);
    }
}
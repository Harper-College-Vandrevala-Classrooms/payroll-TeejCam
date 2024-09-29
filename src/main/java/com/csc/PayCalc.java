package com.csc;

public class PayCalc 
{
    public double grossPay(double payRate, double hoursWorked)
    {
        if (hoursWorked > 40.0) {
            return (40.0 * payRate) + ((hoursWorked-40.0) * (payRate * 1.50)); 
        }
        else {
            return hoursWorked * payRate; 
        }
    }

    public double calcSS(double grossPay)
    {
        //return 6 percent of grosspay
        return grossPay * .06;
    }

    public double calcFederalTax(double grossPay)
    {
        return grossPay * 0.14;
    }

    public double calcStateTax(double grossPay)
    {
        return grossPay * 0.05;
    }

    public double tentativeNetPay(double grossPay)
    {
        return grossPay - (calcSS(grossPay) + calcFederalTax(grossPay) + calcStateTax(grossPay));
    }

    public double unionDues()
    {
        return 10.0;
    }

    public double dependentCareDues(int numDependents)
    {
        if (numDependents >= 3) {
            return 35.0;
        }
        else {
            return 10.0;
        }
    }

    public double calcAllDues(double grossPay, int numDependents)
    {
        return calcSS(grossPay) + calcFederalTax(grossPay) + calcStateTax(grossPay) + unionDues() + dependentCareDues(numDependents);
    }

    public double calcNetPay(double grossPay, int numDependents)
    {
        return grossPay - calcAllDues(grossPay, numDependents);
    }
}

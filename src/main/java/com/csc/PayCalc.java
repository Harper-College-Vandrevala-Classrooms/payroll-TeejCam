package com.csc;

public class PayCalc 
{
    public double grossPay(double hoursWorked)
    {
        if (hoursWorked > 40.0) {
            return (40.0 * 16.78) + ((hoursWorked-40.0) * 25.17); 
        }
        else {
            return hoursWorked * 16.78; 
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

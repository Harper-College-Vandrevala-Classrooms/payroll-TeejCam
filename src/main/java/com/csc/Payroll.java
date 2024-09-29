package com.csc;
import java.util.Scanner;

public class Payroll {
  public static void main (String [] args) {

    Scanner scanner = new Scanner(System.in);


    System.out.println("Welcome to the Payroll Calculator!");

    System.out.println("How many hours have you worked this week? ");
    double numHours = scanner.nextDouble();
    if (numHours < 0)
    {
      System.out.println("Invalid input! Try again: ");
      numHours = scanner.nextDouble();
    }

    System.out.println("What is your hourly pay rate? ");
    double numPayRate = scanner.nextDouble();
    if (numPayRate < 0)
    {
      System.out.println("Invalid input! Try again: ");
      numPayRate = scanner.nextDouble();
    }

    System.out.print("Now enter how many dependants you have: ");
    int numDependents = scanner.nextInt();
    if (numDependents < 0)
    {
      numDependents = 0;
    }
    scanner.close();

    PayCalc paycalc = new PayCalc();

    
    double grossPay = paycalc.grossPay(numPayRate, numHours);
    double socSec = paycalc.calcSS(grossPay);
    double fedTax = paycalc.calcFederalTax(grossPay);
    double stTax = paycalc.calcStateTax(grossPay);
    double union = paycalc.unionDues();
    double ins = paycalc.dependentCareDues(numDependents);
    double tentativeNetPay = paycalc.tentativeNetPay(grossPay);
    double dues = paycalc.calcAllDues(grossPay, numDependents);
    double netPay = paycalc.calcNetPay(grossPay, numDependents);

    if (tentativeNetPay > netPay)
    {
      netPay = netPay + union + ins;
      System.out.println("Payroll Stub: ");
      System.out.println("Hours: " + numHours);
      System.out.println("Rate: " + numPayRate + " $/hr");
      System.out.printf("Gross: $%.2f", grossPay);
      System.out.println();
      System.out.println();
      System.out.printf("SocSec: $%.2f", socSec);
      System.out.println();
      System.out.printf("FedTax: $%.2f", fedTax);
      System.out.println();
      System.out.printf("StTax: $%.2f", stTax);
      System.out.println();
      //System.out.println("Union: $" + union);
      //System.out.println("Ins: $" + ins);
      System.out.println();
      System.out.printf("Net: $%.2f", netPay);
      System.out.println();
      System.out.println();
      System.out.println("The employee still owes: ");
      System.out.println("Union: $" + union);
      System.out.println("Ins: $" + ins);
      System.out.println("Thank you for using the Payroll Program!");
    }
    else {
      System.out.println("Payroll Stub: ");
      System.out.println("Hours: " + numHours);
      System.out.println("Rate: " + numPayRate + " $/hr");
      System.out.printf("Gross: $%.2f", grossPay);
      System.out.println();
      System.out.println();
      System.out.printf("SocSec: $%.2f", socSec);
      System.out.println();
      System.out.printf("FedTax: $%.2f", fedTax);
      System.out.println();
      System.out.printf("StTax: $%.2f", stTax);
      System.out.println();
      System.out.println("Union: $" + union);
      System.out.println("Ins: $" + ins);
      System.out.println();
      System.out.printf("Net: $%.2f", netPay);
      System.out.println();
      System.out.println("Thank you for using the Payroll Program!");
    }
  }
}

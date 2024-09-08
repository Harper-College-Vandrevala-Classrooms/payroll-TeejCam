package com.csc;
import java.util.Scanner;

public class Payroll {
  public static void main (String [] args) {
    System.out.println("Welcome to the Payroll Calculator!");

    System.out.print("How many hours have you worked this week? ");
    Scanner scanner = new Scanner(System.in);
    int numHours = scanner.nextInt();

    System.out.print("Now enter how many dependants you have: ");
    int numDependents = scanner.nextInt();
    scanner.close();

    PayCalc paycalc = new PayCalc();

    //double grossPay = numHours * 16.78;
    double grossPay = paycalc.grossPay(numHours);
    //double deductions = numDependants * 3.0;
    double dues = paycalc.calcAllDues(grossPay, numDependents);
    //double netPay = grossPay - deductions;
    double netPay = paycalc.calcNetPay(grossPay, numDependents);

    //print everything last
    System.out.printf("Your gross pay is: $%.2f", grossPay);
    System.out.println();
    System.out.printf("Your total dues are: $%.2f", dues);
    System.out.println();
    System.out.printf("Your net pay is: $%.2f", netPay);
  }
}

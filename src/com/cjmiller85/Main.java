package com.cjmiller85;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int principle;
        float annualInterest;
        byte years;

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        NumberFormat percent = NumberFormat.getPercentInstance();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.print("Principle ($1K - $1M): ");
            int input = scanner.nextInt();
            if (input >= 1000 && input <= 1_000_000) {
                principle = input;
                break;
            } else {
                System.out.println("Please enter a value between or equal to 1,000 and 1,000,000");
            }
        }
        while (true) {
            System.out.print("Annual Interest Rate (0-30): ");
            annualInterest = scanner.nextFloat();
            if (annualInterest > 0F && annualInterest <= 30F) {
                break;
            }
            System.out.println("Please enter a value between or equal to 0 and 30");

        }

        while (true) {
            System.out.print("Period (years): ");
            years = scanner.nextByte();
            if (years > 0 && years <= 30)
                break;
            System.out.println("Please enter a value between or equal to 0 and 30");
        }

        double mortgage = calculateMortgage(principle, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("-----------------\n" + "Mortgage is: " + mortgageFormatted);
    }

    public static double calculateMortgage(int principle, float annualInterest, byte years) {
        final int PERCENT = 100;
        final int MONTHS_IN_YEAR = 12;
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);
        float monthlyInterestRate = annualInterest / PERCENT / MONTHS_IN_YEAR;


        double mortgage = principle
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        return mortgage;
    }
}

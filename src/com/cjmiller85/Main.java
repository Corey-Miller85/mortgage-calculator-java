package com.cjmiller85;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int principle = (int) readNumber("Principle: ", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate (0-30): ", 1, 30);
        byte years = (byte) readNumber("Period (Years): ", 1, 30);

        double mortgage = calculateMortgage(principle, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("-----------------\n" + "Mortgage is: " + mortgageFormatted);
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Please enter a value between or equal to " + min + " and " + max );
        }
        return value;
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

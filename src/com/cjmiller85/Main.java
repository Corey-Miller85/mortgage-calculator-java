package com.cjmiller85;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        NumberFormat percent = NumberFormat.getPercentInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principle: ");
        int principle = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float interestRate = scanner.nextFloat() ;
        float monthlyInterestRate = interestRate / 100 / 12;

        System.out.print("Period (years): ");
        int period = scanner.nextInt();
        int payments = period * 12;

        String mortgage = currency.format(principle
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, payments))
                / (Math.pow(1 + monthlyInterestRate, payments) - 1));
        System.out.println("-----------------\n" + "Mortgage is: " + mortgage);
    }
}

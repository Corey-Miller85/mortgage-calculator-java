package com.cjmiller85;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        NumberFormat percent = NumberFormat.getPercentInstance();
        Scanner scanner = new Scanner(System.in);
        int principle = 0;
        float interestRate = 0F;
        int period = 0;

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
            float input = scanner.nextFloat();
            if (input > 0F && input <= 30F) {
                interestRate = input;
                break;
            } else {
                System.out.println("Please enter a value between or equal to 0 and 30");
            }
        }

        while (true) {
            System.out.print("Period (years): ");
            int input = scanner.nextInt();
            if (input > 0 || input <= 30) {
                period = input;
                break;
            } else {
                System.out.println("Please enter a value between or equal to 0 and 30");
            }
        }

        float monthlyInterestRate = interestRate / 100 / 12;
        int payments = period * 12;

        String mortgage = currency.format(principle
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, payments))
                / (Math.pow(1 + monthlyInterestRate, payments) - 1));
        System.out.println("-----------------\n" + "Mortgage is: " + mortgage);
    }
}

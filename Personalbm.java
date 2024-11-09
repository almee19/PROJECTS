/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.personalbm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author almee
 */
public class Personalbm {

private static Scanner scanner = new Scanner(System.in);
    private static List<Expense> expenses = new ArrayList<>();
    private static Income income;


    public static void main(String[] args) {
         System.out.println("Enter your income:");
        double incomeAmount = scanner.nextDouble();
        income = new Salary(incomeAmount);

        // Sample expenses
        Rent rent = new Rent(5600);
        Groceries groceries = new Groceries(600.0);
        expenses.add(rent);
        expenses.add(groceries);

        printExpenses();
        calculateAndPrintSavings();
        calculateAndPrintRemainingAmount();

        // CRUD operations
        // Create
        System.out.println("Enter a new expense amount:");
        double newAmount = scanner.nextDouble();
        expenses.add(new Variableexpense(newAmount));

        // Read
        printExpenses();

        // Update
        System.out.println("Enter the index of the expense you want to update:");
        int index = scanner.nextInt();
        System.out.println("Enter the new amount:");
        double updatedAmount = scanner.nextDouble();
        expenses.get(index).amount = updatedAmount;
        printExpenses();

        // Delete
        System.out.println("Enter the index of the expense you want to delete:");
        int deleteIndex = scanner.nextInt();
        expenses.remove(deleteIndex);
        printExpenses();
    }

    private static void printExpenses() {
        System.out.println("Expenses:");
    for (Expense expense : expenses) {
        System.out.println(expense.getAmount());
    }
        
    }

    private static void calculateAndPrintSavings() {
        double totalExpenses = 0;
        for (Expense expense : expenses) {
            totalExpenses += expense.getAmount();
        }
        double savingsAmount = income.getAmount() - totalExpenses;
        System.out.println("Savings: " + savingsAmount);
    }

    private static void calculateAndPrintRemainingAmount() {
        System.out.println("Enter amount spent:");
        double amountSpent = scanner.nextDouble();
        income.spend(amountSpent);
        System.out.println("Remaining amount: " + income.getAmount());
    }
    }
        


package com.snackbar.util;

import java.util.Scanner;

/**
 * Utility class responsible for managing all user input.
 * Isolates the Scanner to avoid keyboard buffer issues and handles typing errors
 */
public class InputProvider {
    private final Scanner scanner;

    public InputProvider() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays a message and reads the text typed by the user
     * @param prompt the question that will appear on the screen
     * @return the text typed, with no spaces lefts at the ends
     */
    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    /**
     * Displays the message and ensures the user enters a valid integer
     */
    public int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(
                    Icon.ERROR + " Invalid input.\n Please enter an integer without letters or periods."
                );
            }
        }
    }

    /**
     * Displays a message and ensures the user enters a valid decimal number (For prices, discounts)
     */
    public double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                input = input.replace(",", ".");
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println(
                    Icon.ERROR + " Invalid Decimal input.\n Please enter a valid number! [ Ex.: 1.50 or 1,50 ]"
                );
            }
        }
    }

    /**
     * Displays the confirmation message: [Y = Yes | N = No] and returns a boolean
     */
    public boolean readBoolean(String prompt) {
        while (true) {
            String input = readString(prompt + "[ Y = Yes | N = No ] ").toUpperCase();
            if (input.equals("Y") || input.equals("YES")) {
                return true;
            } else if (input.equals("N") || input.equals("NO")) {
                return false;
            } else {
                System.out.println(
                    Icon.ERROR + "Invalid option.\n Type 'Y' to Yes and 'N' to No"

                );
            }
        }
    }

    /**
     * Closes the scanner and free up memory resources when the program terminates
     */
    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}

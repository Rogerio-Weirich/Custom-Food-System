package com.snackbar.main;

import com.snackbar.util.presentation.UserInterface;


public class Main {
    public static void main(String[] args) {
        System.out.println("[ SYSTEM ] Initializing operation modules...\n");

        try {
            UserInterface ui = new UserInterface();
            ui.start();
        } catch (Exception e) {
            System.out.println("\n" +
                    "❌ FATAL ERROR: " +
                    "\nThe system encountered an unexpected problem and needed to be shut down.."
            );
            System.out.println("Tecnical Details: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("\n[ SYSTEM ] Operation completed safely. Come back soon!");
        }
    }
}
package com.snackbar.main;

import com.snackbar.presentation.ConsoleUI;
import com.snackbar.presentation.UserUI;
import com.snackbar.util.InputProvider;
import com.snackbar.util.Icon;


public class Main {
    public static void main(String[] args) {
        System.out.println(Icon.SYSTEM + " Initializing operation modules...\n");
        
        Icon.useEmojis = false;
        InputProvider input = new InputProvider();

        try {
            UserUI ui = new ConsoleUI(input);
            ui.start();
        } catch (Exception e) {
            System.out.println("\n" + Icon.ERROR +
                    " FATAL ERROR: \n" + Icon.WARNING +
                    " The system encountered an unexpected problem and needed to be shut down..."
            );
            System.out.println(Icon.INFO + " Technical Details: \n" + e.getMessage());
            e.printStackTrace();
        } finally {
            input.close();
            System.out.println("\n" + Icon.SYSTEM + " Operation completed safely. Come back soon!");
        }
    }
}
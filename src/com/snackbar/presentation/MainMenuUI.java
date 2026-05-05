package com.snackbar.presentation;

import com.snackbar.persistence.OrderDAO;
import com.snackbar.util.Icon;
import com.snackbar.util.InputProvider;

public class MainMenuUI implements UserUI {
    private final InputProvider input;
    private final UserUI consoleUI;
    private final UserUI kdsConsoleUI;
    
    public MainMenuUI(InputProvider input) {
        this.input = input;
        this.consoleUI = new ConsoleUI(input);
        this.kdsConsoleUI = new KDSConsoleUI(input);
    }

    @Override
    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\n===================================");
            System.out.println("      CENTRAL SYSTEM SNACKBAR      ");
            System.out.println("===================================");
            System.out.println("1. Access Point of Sale");
            System.out.println("2. Access Kitchen Panel");
            System.out.println("0. Shut down system");
            System.out.println("===================================");

            int queuedOrders = OrderDAO.getPendingOrdersCount();
            System.out.println(
                Icon.WARNING +
                "System Status: " +
                queuedOrders +
                " orders in queue."
            );
            
            int choice = input.readInt("Please enter which Module to access: ");

            switch (choice) {
                case 1:
                    System.out.println(
                        Icon.SYSTEM + 
                        " Accessing Point of Sale..."
                    );
                    consoleUI.start();
                    break;
                case 2:
                    System.out.println(
                        Icon.SYSTEM + 
                        " Accessing Kitchen Panel...."
                    );
                    kdsConsoleUI.start();
                    break;
                case 0:
                    running = false;
                    System.out.println(
                        Icon.SYSTEM + 
                        "Shutting down the system..."
                    );
                    break;
                default:
                    System.out.println(
                        Icon.ERROR + 
                        "Invalid Option. Please enter 1, 2 to access the System or 0 to shut down the system."
                    );
            }
        }
    }
}

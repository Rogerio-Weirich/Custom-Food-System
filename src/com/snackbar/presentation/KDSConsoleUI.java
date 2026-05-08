package com.snackbar.presentation;

import com.snackbar.model.enums.OrderStatus;
import com.snackbar.persistence.OrderDAO;
import com.snackbar.util.Icon;
import com.snackbar.util.InputProvider;

/**
 * Kitchen Display System
 */
public class KDSConsoleUI implements UserUI {
    private final InputProvider input;

    public KDSConsoleUI(InputProvider input) {
        this.input = input;
    }

    @Override
    public void start() {
        boolean running = true;

        while (running) {
            OrderDAO.displayActiveOrder();

            System.out.println("\n=== KITCHEN OPTIONS ===");
            System.out.println("1. Update order Status");
            System.out.println("0. Exit and Back to main menu");

            int choice = input.readInt("Select and option: ");

            if (choice == 0) {
                running = false;
                System.out.println(Icon.SYSTEM + " Closing Kitchen panel...");
            } else if (choice == 1) {
                updateProcess();
            } else {
                System.out.println(Icon.ERROR + " Invalid option.");
            }
        }
    }

    private void updateProcess() {
        int orderId = input.readInt("Enter the ID to update: ");

        System.out.println("\nWhich status to change: ");
        System.out.println("1 - " + OrderStatus.PREPARING.getDescription());
        System.out.println("2 - " + OrderStatus.READY.getDescription());
        System.out.println("3 - " + OrderStatus.DELIVERED.getDescription());
        System.out.println("4 - " + OrderStatus.CANCELED.getDescription());

        int statusChoice = input.readInt("Please enter the new status: ");
        OrderStatus newStatus;

        switch (statusChoice) {
            case 1: newStatus = OrderStatus.PREPARING; break;
            case 2: newStatus = OrderStatus.READY; break;
            case 3: newStatus = OrderStatus.DELIVERED; break;
            case 4: newStatus = OrderStatus.CANCELED; break;
            default:
                System.out.println(Icon.ERROR + " Invalid status. Operation cancelled.");
                return;
        }
        OrderDAO.updateOrderStatus(orderId, newStatus);
    }
}

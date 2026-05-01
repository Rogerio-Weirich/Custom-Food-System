package com.snackbar.util;

import com.snackbar.model.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class DataPersistence {
    private static final String FOLDER_PATH = "receipts/";

    public static void saveReceiptToFile(Order order) {
        File folder = new File(FOLDER_PATH);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String fileName = FOLDER_PATH + "Receipt_" + order.getOrderId() + ".txt";

        try (FileWriter fileWriter = new FileWriter(fileName);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            printWriter.print(order.generateReceipt());

            System.out.println("📄 Receipt successfully saved at: " + fileName);

        } catch (IOException e) {
            System.out.println("[ ❌ ] Error while trying to save the Receipt: " + e.getMessage());
        }
    }
}

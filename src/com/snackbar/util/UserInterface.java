package com.snackbar.util;

import com.snackbar.model.*;
import com.snackbar.model.enums.Ingredient;
import com.snackbar.model.products.*;

public class UserInterface {

    private final InputProvider input;
    private Order currentOrder;

    public UserInterface () {
        this.input = new InputProvider();
    }

    public void start() {
        System.out.println("=========================================\n");
        System.out.println("           🍔 CUSTOM FOOD 🍔            \n");
        System.out.println("=========================================\n");

        String customerName = input.readString("Please, enter your name to begin: ");
        currentOrder = new Order(customerName);
        System.out.println("Hello, " + customerName + "! Order #" + currentOrder.getOrderId() + " opened successfully");

        boolean running = true;
        while (running) {
            running = showMainMenu();
        }

        System.out.println("Thanks for using the Custom Food. Hope to see you soon!");
        input.close();
    }

    private boolean showMainMenu() {
        System.out.println("\n--- MAIN MENU ---");
        System.out.println("1. [🍔] Hamburger");
        System.out.println("2. [🥖] Sandwich");
        System.out.println("3. [🌭] Wiener");
        System.out.println("4. [🍟] Side");
        System.out.println("5. [🥤] Drink");
        System.out.println("6. [🍰] Dissert");
        System.out.println("7. [📦] Combo");
        System.out.println("8. [🧾] Check Cart | Receipt");
        System.out.println("0. Finish Order and Exit");

        int choice = input.readInt("Choose an option: ");

        switch (choice) {
            case 1: buildHamburger(); break;
            case 2: buildSandwich(); break;
            case 3: buildWiener(); break;
            case 4: buildSide(); break;
            case 5: buildBeverage(); break;
            case 6: buildDessert(); break;
            case 7: buildCombo(); break;
            case 8: System.out.println(currentOrder.generateReceipt()); break;
            case 0:
                System.out.println("Finishing your order... ");
                System.out.println(currentOrder.generateReceipt());
                DataPersistence.saveReceiptToFile(currentOrder);
                com.snackbar.util.OrderDAO.saveOrderToDatabase(currentOrder);

                return false;
            default:
                System.out.println("[ X ] Invalid option. Try again!");
        }
        return true;
    }

    // Constructor methods for products
    private void buildHamburger() {
        System.out.println("\n--- HAMBURGER MENU ---");
        System.out.println("1. Classic - Standard");
        System.out.println("2. Custom - Build Your Own");
        System.out.println("0. Back");
        int type = input.readInt("Option: ");

        if (type == 1) {
            Hamburger hamburger = ProductFactory.createClassicBurger();
            offerExtras(hamburger, Ingredient.filterByCategory("EXTRAS"));
            addToOrder(hamburger);
        } else if (type == 2) {
            Hamburger custom = ProductFactory.createCustomBurger();
            System.out.println("\n[ STEP 1 ] Select your Bun: ");
            offerSingleChoice(custom, Ingredient.filterByCategory("BUN"));
            System.out.println("\n[ STEP 2 ] Select your Patty: ");
            offerSingleChoice(custom, Ingredient.filterByCategory("PATTY"));
            System.out.println("\n[ STEP 3 ] Select your Salad: ");
            offerSingleChoice(custom, Ingredient.filterByCategory("SALAD"));
            System.out.println("\n[ STEP 4 ] Select your Extras: ");
            offerExtras(custom, Ingredient.filterByCategory("EXTRAS"));
            addToOrder(custom);
        }
    }

    private void buildSandwich() {
        System.out.println("\n--- SANDWICH MENU ---");
        System.out.println("1. Classic - Standard");
        System.out.println("2. Custom - Build Your Own");
        System.out.println("0. Back");
        int type = input.readInt("Option: ");

        if (type == 1) {
            Sandwich sandwich = ProductFactory.createClassicSub();
            offerExtras(sandwich, Ingredient.filterByCategory("EXTRAS"));
            addToOrder(sandwich);
        } else if (type == 2) {
            Sandwich custom = ProductFactory.createCustomSub();
            System.out.println("\n[ STEP 1 ] Select your Bun: ");
            offerSingleChoice(custom, Ingredient.filterByCategory("BUN"));
            System.out.println("\n[ STEP 2 ] Select your Meat: ");
            offerSingleChoice(custom, Ingredient.filterByCategory("MEAT"));
            System.out.println("\n[ STEP 3 ] Select your Salad: ");
            offerSingleChoice(custom, Ingredient.filterByCategory("SALAD"));
            System.out.println("\n[ STEP 4 ] Select your Extras: ");
            offerExtras(custom, Ingredient.filterByCategory("EXTRAS"));
            addToOrder(custom);
        }
    }

    private void buildWiener() {
        System.out.println("\n--- WIENER MENU ---");
        System.out.println("1. Classic - Standard");
        System.out.println("2. Custom - Build Your Own");
        System.out.println("0. Back");
        int type = input.readInt("Option: ");

        if (type == 1) {
            Wiener wiener = ProductFactory.createClassicWiener();
            offerExtras(wiener, Ingredient.filterByCategory("EXTRAS"));
            addToOrder(wiener);
        } else if (type == 2) {
            Wiener custom = ProductFactory.createCustomWiener();
            System.out.println("\n[ STEP 1 ] Select your Bun: ");
            offerSingleChoice(custom, Ingredient.filterByCategory("BUN"));
            System.out.println("\n[ STEP 2 ] Select your Sausage: ");
            offerSingleChoice(custom, Ingredient.filterByCategory("SAUSAGE"));
            System.out.println("\n[ STEP 3 ] Select your Salad: ");
            offerSingleChoice(custom, Ingredient.filterByCategory("SALAD"));
            System.out.println("\n[ STEP 4 ] Select your Extras: ");
            offerExtras(custom, Ingredient.filterByCategory("EXTRAS"));
            addToOrder(custom);
        }
    }

    private void buildSide() {
        System.out.println("\n--- SIDE ---");
        System.out.println("1. French Fries");
        System.out.println("2. Onion Rings");
        System.out.println("3. Nuggets");
        System.out.println("4. Cheese Sticks");
        System.out.println("0. Back");
        int type = input.readInt("Option: ");

        Side side = null;
        switch (type) {
            case 1: side = ProductFactory.createFries(); break;
            case 2: side = ProductFactory.createOnionRings(); break;
            case 3: side = ProductFactory.createNuggets(); break;
            case 4: side = ProductFactory.createCheeseSticks(); break;
            case 0: return;
            default: System.out.println("[ ✖️ ] Invalid Option."); return;
        }

        offerExtras(side, Ingredient.filterByCategory("SAUCE"));
        addToOrder(side);
    }

    private void buildBeverage() {
        System.out.println("\n--- Beverages ---");
        System.out.println("1. Soda");
        System.out.println("2. Natural Juice");
        System.out.println("3. Custom Drink");
        System.out.println("0. Back");
        int type = input.readInt("Option: ");

        Beverage bev = null;
        switch (type) {
            case 1: bev = ProductFactory.createSoda(); break;
            case 2: bev = ProductFactory.createJuice(); break;
            case 3: bev = ProductFactory.createCustomBeverage(); break;
            case 0: return;
            default: System.out.println("[ ✖️ ] Invalid Option."); return;
        }

        offerExtras(bev, Ingredient.filterByCategory("BEV_EXTRA"));
        addToOrder(bev);
    }

    private void buildDessert() {
        System.out.println("\n--- Desserts ---");
        System.out.println("1. Brownie");
        System.out.println("2. Chocolate Cookie");
        System.out.println("3. Ice Cream Cup");
        System.out.println("4. Custom Ice Cream");
        System.out.println("0. Back");
        int type = input.readInt("Options: ");

        Dessert dessert = null;
        switch (type) {
            case 1: dessert = ProductFactory.createBrownie(); break;
            case 2: dessert = ProductFactory.createCookie(); break;
            case 3: dessert = ProductFactory.createIceCream(); break;
            case 4: dessert = ProductFactory.createCustomIceCream(); break;
            case 0: return;
            default: System.out.println("[ ✖️ ] Invalid Option."); return;
        }

        offerExtras(dessert, Ingredient.filterByCategory("DESSERT"));
        addToOrder(dessert);
    }

    private void buildCombo() {
        System.out.println("\n--- PROMOTIONAL COMBOS ---");
        System.out.println("1. Hamburger Combo [Hamburger + Fries + Soda]");
        System.out.println("2. Sub Combo [Sandwich + Nuggets + Natural Juice]");
        System.out.println("3. Wiener Combo [Hot-Dog + Onion Rings + Soda]");
        System.out.println("4. Sharing Platter [Fries + Onion Rings + Nuggets + Cheese Sticks]");
        System.out.println("5. Kids Combo [Nuggets + Juice + Cookie]");
        System.out.println("0. Back");
        int type = input.readInt("Options: ");

        switch (type) {
            case 1: addToOrder(ProductFactory.createBurgerCombo()); break;
            case 2: addToOrder(ProductFactory.createSubCombo()); break;
            case 3: addToOrder(ProductFactory.createWienerCombo()); break;
            case 4: addToOrder(ProductFactory.createServingCombo()); break;
            case 5: addToOrder(ProductFactory.createKidsCombo());
            case 0: return;
            default: System.out.println("[ ✖️ ] Invalid Option.");
        }
    }

    private void offerSingleChoice(Product product, Ingredient[] options) {
        while (true) {
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            int choice = input.readInt("Obligatory Option: ");

            if (choice > 0 && choice <= options.length) {
                Ingredient selected = options[choice - 1];
                product.addIngredient(selected);
                System.out.println("[ ✔️ ]" + selected.getDisplayName() + " added!");
                break;
            } else {
                System.out.println("[ ✖️ ] Invalid Option. ");
            }
        }
    }

    private void offerExtras(Product product, Ingredient[] options) {
        if (options.length == 0) return;

        boolean addingExtras = input.readBoolean("Do you want to add Extras | Customize? ");

        while (addingExtras) {
            System.out.println("\nAvailable Options: ");
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            int extraChoice = input.readInt("0. To Exit and Finish Customization\nSelect the extra: ");

            if (extraChoice == 0) {
                addingExtras = false;
            } else if (extraChoice > 0 && extraChoice <= options.length) {
                Ingredient selected = options[extraChoice - 1];
                product.addIngredient(selected);
                System.out.println("[ ✔️ ]" + selected.getDisplayName() + " added!");
            } else {
                System.out.println("[ ✖️ ] Invalid Option. ");
            }
        }
    }

    public void addToOrder(Product product) {
        try {
            currentOrder.addProduct(product);
            System.out.println("🛒 [" + product.getName() + "] successfully added to the cart!");
        } catch (Exception e) {
            System.out.println("[ ✖️ ] Failed to add: " + e.getMessage());
        }
    }
}

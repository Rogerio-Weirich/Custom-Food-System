package com.snackbar.model;

import com.snackbar.model.enums.Ingredient;
import com.snackbar.model.products.*;

public class ProductFactory {

    public static Hamburger createClassicBurger() {
        return new Hamburger(
                "Classic Hamburger",
                "Bun, Patty and Cheese"
        );
    }

    public static Hamburger createCustomBurger() {
        return new Hamburger(
                "Custom Burger",
                "Build your own"
        );
    }

    public static Sandwich createClassicSub() {
        return new Sandwich(
                "Classic Sandwich",
                "Baguette, Salad"
        );
    }

    public static Sandwich createCustomSub() {
        return new Sandwich(
                "Custom Sandwich",
                "Build your own: "
        );
    }

    public static Wiener createClassicWiener() {
        return new Wiener(
                "Classic Wiener",
                "Traditional Hot-Dog"
        );
    }

    public static Wiener createCustomWiener() {
        return new Wiener(
                "Custom Wiener",
                "Build your own"
        );
    }

    public static Side createFries() {
        return new Side(
                Ingredient.FRENCH_FRIES.getDisplayName(),
                "Crunchy and Salty Fries"
        );
    }

    public static Side createOnionRings() {
        return new Side(
                Ingredient.ONION_RINGS.getDisplayName(),
                "Crunchy onion rings"
        );
    }

    public static Side createNuggets() {
        return new Side(
                Ingredient.NUGGETS.getDisplayName(),
                "Breaded and spicy"
        );
    }

    public static Side createCheeseSticks() {
        return new Side(
                Ingredient.MOZZARELLA_STICKS.getDisplayName(),
                "Fried Cheese Sticks"
        );
    }

    public static Beverage createSoda() {
        return new Beverage(
                Ingredient.SODA_500ML.getDisplayName(),
                "Soda Cup"
        );
    }

    public static Beverage createJuice() {
        return new Beverage(
                Ingredient.NAT_JUICE.getDisplayName(),
                "Fresh seasonal fruit juice"
        );
    }

    public static Beverage createCustomBeverage() {
        return new Beverage(
                Ingredient.DRINK.getDisplayName(),
                "Build your own \nChoose your drink and add-ons: "
        );
    }

    public static Dessert createCookie() {
        return new Dessert(
                Ingredient.CHOC_COOKIE.getDisplayName(),
                "Chocolate Chip Cookie"
        );
    }

    public static Dessert createBrownie() {
        return new Dessert(
                Ingredient.CHOC_BROWNIE.getDisplayName(),
                "Warm chocolate brownie"
        );
    }

    public static Dessert createIceCream() {
        return new Dessert(
                Ingredient.ICE_CREAM_CUP.getDisplayName(),
                "Simple Vanilla Ice Cream"
        );
    }

    public static Dessert createCustomIceCream() {
        return new Dessert(
                "Custom Ice Cream Cup",
                "A Cup with 2 Scoops. \nChoose your toppings: "
        );
    }

    public static Combo createBurgerCombo() {
        Combo combo = new Combo(
                "Hamburger Combo",
                "Classic Burger + Fries + Soda (15% OFF)",
                0.15
        );

        combo.addItem(createClassicBurger());
        combo.addItem(createFries());
        combo.addItem(createSoda());
        return combo;
    }

    public static Combo createSubCombo() {
        Combo combo = new Combo(
                "Sandwich Combo",
                "Classic Sandwich + Nuggets + Natural Juice (10% OFF)",
                0.10
        );

        combo.addItem(createClassicSub());
        combo.addItem(createNuggets());
        combo.addItem(createJuice());
        return combo;
    }

    public static Combo createWienerCombo() {
        Combo combo = new Combo(
                "Wiener Combo",
                "Classic Hot-Dog + Onion Rings + Soda (12% OFF)",
                0.12
        );

        combo.addItem(createClassicWiener());
        combo.addItem(createOnionRings());
        combo.addItem(createSoda());
        return combo;
    }

    public static Combo createServingCombo() {
        Combo combo = new Combo(
                "Serving Combo",
                "Fries + Onion Rings + Nuggets + Cheese Sticks (20% OFF)",
                0.20
        );

        combo.addItem(createFries());
        combo.addItem(createOnionRings());
        combo.addItem(createNuggets());
        combo.addItem(createCheeseSticks());
        return combo;
    }

    public static Combo createKidsCombo() {
        Combo combo = new Combo(
                "Kids Combo",
                "Nuggets + Juice + Brownie (10% OFF)",
                0.10
        );

        combo.addItem(createNuggets());
        combo.addItem(createJuice());
        combo.addItem(createCookie());
        return combo;
    }
}

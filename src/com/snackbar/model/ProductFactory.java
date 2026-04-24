package com.snackbar.model;

public class ProductFactory {

    public static Hamburger createClassicBurger() {
        return new Hamburger(
                "Classic Hamburger", Ingredient.PRICE_CLASSIC_BURGER.getPrice(),
                "Bun, Patty and Cheese", 50
        );
    }

    public static Hamburger createCustomBurger() {
        return new Hamburger(
                "Custom Burger", Ingredient.PRICE_CUSTOM_BURGER.getPrice(),
                "Build your own", 50
        );
    }

    public static Sandwich createClassicSub() {
        return new Sandwich(
                "Classic Sandwich", Ingredient.PRICE_CLASSIC_SUB.getPrice(),
                "Baguette, Salad", 50
        );
    }

    public static Sandwich createCustomSub() {
        return new Sandwich(
                "Custom Sandwich", Ingredient.PRICE_CUSTOM_SUB.getPrice(),
                "Build your own", 50
        );
    }

    public static Wiener createClassicWiener() {
        return new Wiener(
                "Classic Wiener", Ingredient.PRICE_CLASSIC_WIENER.getPrice(),
                "Traditional Hot-Dog", 50
        );
    }

    public static Wiener createCustomWiener() {
        return new Wiener(
                "Custom Wiener", Ingredient.PRICE_CUSTOM_WIENER.getPrice(),
                "Build your own", 50
        );
    }

    public static Side createFries() {
        return new Side(
                Ingredient.FRENCH_FRIES.getDisplayName(),
                Ingredient.FRENCH_FRIES.getPrice(),
                "Crunchy and Salty Fries", 50
        );
    }

    public static Side createOnionRings() {
        return new Side(
                Ingredient.ONION_RINGS.getDisplayName(),
                Ingredient.ONION_RINGS.getPrice(),
                "Crunchy onion rings", 50
        );
    }

    public static Side createNuggets() {
        return new Side(
                Ingredient.NUGGETS.getDisplayName(),
                Ingredient.NUGGETS.getPrice(),
                "Breaded and spicy", 50
        );
    }

    public static Side createCheeseSticks() {
        return new Side(
                Ingredient.CHEESE_STICKS.getDisplayName(),
                Ingredient.CHEESE_STICKS.getPrice(),
                "Fried Cheese Sticks", 50
        );
    }

    public static Beverage createSoda() {
        return new Beverage(
                Ingredient.SODA_500ML.getDisplayName(),
                Ingredient.SODA_500ML.getPrice(),
                "Soda Cup", 100
        );
    }

    public static Beverage createJuice() {
        return new Beverage(
                Ingredient.NAT_JUICE.getDisplayName(),
                Ingredient.NAT_JUICE.getPrice(),
                "Fresh seasonal fruit juice", 80
        );
    }

    public static Beverage createCustomBeverage() {
        return new Beverage(
                Ingredient.DRINK.getDisplayName(),
                Ingredient.PRICE_CUSTOM_BEVERAGE.getPrice(),
                "Choose your drink and add-ons", 100
        );
    }

    public static Dessert createCookie() {
        return new Dessert(
                Ingredient.CHOC_COOKIE.getDisplayName(),
                Ingredient.CHOC_COOKIE.getPrice(),
                "Chocolate Chip Cookie", 150
        );
    }

    public static Dessert createBrownie() {
        return new Dessert(
                Ingredient.CHOC_BROWNIE.getDisplayName(),
                Ingredient.CHOC_BROWNIE.getPrice(),
                "Warm chocolate brownie", 40
        );
    }

    public static Dessert createIceCream() {
        return new Dessert(
                Ingredient.ICE_CREAM_SCOOP.getDisplayName(),
                Ingredient.ICE_CREAM_SCOOP.getPrice(),
                "Simple Vanilla Ice Cream", 50
        );
    }

    public static Dessert createCustomIceCream() {
        return new Dessert(
                "Custom Ice Cream Cup",
                Ingredient.PRICE_CUSTOM_ICE_CREAM.getPrice(),
                "A Cup with 2 Scoops. Choose your toppings!", 50
        );
    }

    public static Combo createBurgerCombo() {
        Combo combo = new Combo(
                "Hamburger Combo",
                "Classic Burger + Fries + Soda (15% OFF)",
                0.15, 30
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
                0.10, 30
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
                0.12, 30
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
                0.20, 45
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
                0.10, 30
        );

        combo.addItem(createNuggets());
        combo.addItem(createJuice());
        combo.addItem(createCookie());
        return combo;
    }
}

package com.snackbar.model;

import java.util.Arrays;

public enum Ingredient {
    // Bun
    BUN("Bun", 0.0, "BUN"),
    WHOLE_WHEAT_BUN("Whole Wheat Bun", 0.0, "BUN"),
    BAGUETTE("Baguette Bread", 0.0, "BUN"),
    HOT_DOG_BUN("Hot Dog Bun", 0.0, "BUN"),

    // Hamburgers
    BEEF_PATTY("Beef Patty", 0.0, "PATTY"),
    CHICKEN_PATTY("Chicken Patty", 0.0, "PATTY"),
    PORKY_PATTY("Porky Patty", 0.0, "PATTY"),
    VEGGIE_PATTY("Veggie Patty", 0.0, "PATTY"),

    // Wiener
    PORK_SAUSAGE("Pork Sausage", 0.0, "SAUSAGE"),
    CHICKEN_SAUSAGE("Chicken Sausage", 0.0, "SAUSAGE"),
    VEGGIE_SAUSAGE("Veggie Sausage", 1.50, "SAUSAGE"),

    //Sandwich
    CHICKEN_BREAST("Chicken Breast", 0.0, "MEAT"),
    TURKEY_BREAST("Turkey Breast", 0.0, "MEAT"),
    ROAST_BEEF("Roast Beef", 0.0, "MEAT"),
    HAM("Sliced Ham", 0.0, "MEAT"),
    MORTADELLA("Sliced Mortadella", 0.0, "MEAT"),

    // Salad
    LETTUCE("Lettuce", 0.0, "SALAD"),
    TOMATO("Tomato", 0.0, "SALAD"),
    ONION("Onion", 0.0, "SALAD"),
    PICKLES("Pickles", 0.0, "SALAD"),
    CORN_PEAS("Corn & Peas", 0.0, "SALAD"),
    OLIVES("Black Olives", 0.50, "SALAD"),

    // Extras
    SALAMI("Salami", 1.50, "EXTRAS"),
    MOZZARELLA("Mozzarella Cheese", 2.00, "EXTRAS"),
    CHEDDAR_CHEESE("Cheddar Cheese", 2.50, "EXTRAS"),
    SWISS_CHEESE("Swiss Cheese", 3.00, "EXTRAS"),
    PROVOLONE("Provolone Cheese", 3.00, "EXTRAS"),
    EGG("Egg", 2.00, "EXTRAS"),
    BACON("Bacon", 3.50, "EXTRAS"),
    BACON_BITS("Bacon Bits", 2.50, "EXTRAS"),
    DOUBLE_MEAT("Double Meat", 4.50, "EXTRAS"), // Sandiwch
    DOUBLE_SAUSAGE("Double Sausage", 5.00, "EXTRAS"), // Wiener
    DOUBLE_PATTY("Double Patty", 6.00, "EXTRAS"), // Hamburger
    ONION_RINGS("Onion Rings", 4.50, "EXTRAS"),
    FRENCH_FRIES("French Fries", 9.90, "EXTRAS"),
    NUGGETS("Nuggets", 11.00, "EXTRAS"),
    CHEESE_STICKS("Mozzarella Sticks", 12.90, "EXTRAS"),
    PARMESAN("Grated Parmesan", 2.00, "EXTRAS"),

    // Sauces
    CHEDDAR_SAUCE("Cheddar Sauce", 3.00, "SAUCE"),
    KETCHUP("Ketchup", 0.0,"SAUCE"),
    MUSTARD("Mustard", 0.0,"SAUCE"),
    MAYONNAISE("Mayonnaise", 0.0,"SAUCE"),
    SPICY_SAUCE("Spicy Sauce", 1.00,"SAUCE"),
    GARLIC_MAYONNAISE("Garlic Mayonnaise Dip", 1.50, "SAUCE"),
    GARLIC_SAUCE("Garlic Sauce", 1.50, "SAUCE"),
    GREEN_SAUCE("Green Sauce", 1.25,"SAUCE"),

    // Dessert
    CHOC_BROWNIE("Chocolate Brownie", 14.00, "DESSERT"),
    CHOC_COOKIE("Chocolate Cookie", 5.00, "DESSERT"),
    ICE_CREAM_SCOOP("Ice Cream Cup", 3.50, "DESSERT"),

    // Dessert Extras
    CHOCOLATE_SYRUP("Chocolate Syrup", 1.50, "DES_EXTRA"),
    STRAWBERRY_SYRUP("Strawberry Syrup", 1.50, "DES_EXTRA"),
    WHIPPED_CREAM("Whipped Cream", 2.00, "DES_EXTRA"),
    CHOC_CHIPS("Chocolate Chips", 1.00, "DES_EXTRA"),

    // Beverage
    SODA_500ML("Soda 500ml", 7.00, "BEVERAGE"),
    NAT_JUICE("Natural Juice", 9.50, "BEVERAGE"),
    DRINK("Drink", 12.50, "BEVERAGE"),

    // Beverage Extras
    ICE_CUBES("Ice Cubes", 0.0, "BEV_EXTRA"),
    LEMON_SLICE("Lemon Slice", 0.50, "BEV_EXTRA"),
    MINT_LEAVES("Mint Leaves", 0.50, "BEV_EXTRA"),
    VANILLA_SYRUP("Vanilla Flavor Syrup", 2.00, "BEV_EXTRA"),
    CARAMEL_SYRUP("Caramel Flavor Syrup", 2.00, "BEV_EXTRA"),

    PRICE_CLASSIC_BURGER("", 18.00, "PRICE_REF"),
    PRICE_CUSTOM_BURGER("", 14.90, "PRICE_REF"),
    PRICE_CLASSIC_SUB("", 15.00, "PRICE_REF"),
    PRICE_CUSTOM_SUB("", 12.90, "PRICE_REF"),
    PRICE_CLASSIC_WIENER("", 13.50, "PRICE_REF"),
    PRICE_CUSTOM_WIENER("", 9.00, "PRICE_REF"),
    PRICE_CUSTOM_BEVERAGE("", 9.00, "PRICE_REF"),
    PRICE_CUSTOM_ICE_CREAM("Custom Ice Cream Base", 7.00, "PRICE_REF");

    // Enum attributes
    private final String displayName;
    private final double price;
    private final String category;

    /**
     * Enum Constructor.
     * @param displayName the "pretty" name which user will see. 😎
     * @param price the value which will be added to the order if it is selected.
     */
    Ingredient(String displayName, double price, String category) {
        this.displayName = displayName;
        this.price = price;
        this.category = category;
    }

    public static Ingredient[] filterByCategory(String cat) {
        return Arrays.stream(values())
                     .filter(i -> i.category.equalsIgnoreCase(cat))
                     .toArray(Ingredient[]::new);
    }

    // Getters
    public String getDisplayName() {
        return displayName;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Format the ingredient exhibition.
     * If the value is > 0, shows the value on the side
     */
    @Override
    public String toString() {
        if (price > 0) {
            return String.format("%s (+R$ %.2f)", displayName, price);
        }
        return displayName;
    }
}
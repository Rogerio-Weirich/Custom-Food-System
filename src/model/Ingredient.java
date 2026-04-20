package model;

public enum Ingredient {
    // Base meats (no initial extra cost for the standard setup)
    BEEF_PATTY("Beef Patty", 0.0),
    CHICKEN_PATTY("Chicken Patty", 0.0),
    PORKY_PATTY("Porky Patty", 0.0),
    VEGGIE_PATTY("Veggie Patty", 0.0),

    // Base buns (no extra cost)
    BUN("Bun", 0.0),
    WHOLE_WHEAT_BUN("Whole Wheat Bun", 0.0),

    // Salads (no extra cost)
    LETTUCE("Lettuce", 0.0),
    TOMATO("Tomato", 0.0),
    ONION("Onion", 0.0),
    PICKLES("Pickles", 0.0),

    // Paid addons (Cheeses, extra meats, etc)
    CHEESE("Cheese", 2.50),
    BACON("Bacon", 3.50),
    EGG("Egg", 2.00),
    DOUBLE_PATTY("Double Patty", 6.00),
    ONION_RINGS("Onion Rings", 4.50),

    // Sauces (few free, some paid)
    KETCHUP("Ketchup", 0.0),
    MUSTARD("Mustard", 0.0),
    MAYONNAISE("Mayonnaise", 0.0),
    SPICY_SAUCE("Spicy Sauce", 1.00),
    GREEN_SAUCE("Green Sauce", 1.25),
    GARLIC_SAUCE("Garlic Sauce", 1.50);

    // Enum attributes
    private final String displayName;
    private final double price;

    /**
     * Enum Constructor.
     * @param displayName the "pretty" name which user will see. 😎
     * @param price the value which will be added to the order if it is selected.
     */
    Ingredient(String displayName, double price) {
        this.displayName = displayName;
        this.price = price;
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
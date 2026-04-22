package model;

public enum Ingredient {
    // Base buns (no extra cost)
    BUN("Bun", 0.0),
    WHOLE_WHEAT_BUN("Whole Wheat Bun", 0.0),
    BAGUETTE("Baguette Bread", 0.0),
    HOT_DOG_BUN("Hot Dog Bun", 0.0),

    // Base Hamburgers (no initial extra cost for the standard setup)
    BEEF_PATTY("Beef Patty", 0.0),
    CHICKEN_PATTY("Chicken Patty", 0.0),
    PORKY_PATTY("Porky Patty", 0.0),
    VEGGIE_PATTY("Veggie Patty", 0.0),

    // Base Sausages
    PORK_SAUSAGE("Pork Sausage", 0.0),
    CHICKEN_SAUSAGE("Chicken Sausage", 0.0),
    VEGGIE_SAUSAGE("Veggie Sausage", 1.50),

    // Base Sandwich
    CHICKEN_BREAST("Chicken Breast", 0.0),
    TURKEY_BREAST("Turkey Breast", 0.0),
    ROAST_BEEF("Roast Beef", 0.0),
    HAM("Sliced Ham", 0.0),
    MORTADELLA("Sliced Mortadella", 0.0),

    // Salads (no extra cost)
    LETTUCE("Lettuce", 0.0),
    TOMATO("Tomato", 0.0),
    ONION("Onion", 0.0),
    PICKLES("Pickles", 0.0),
    CORN_PEAS("Corn & Peas", 0.0),
    OLIVES("Black Olives", 0.50),

    // Paid addons (Cheeses, extra meats, etc)
    SALAMI("Salami", 1.50),
    MOZZARELLA("Mozzarella Cheese", 2.00),
    CHEDDAR_CHEESE("Chedadr Cheese", 2.50),
    SWISS_CHEESE("Swiss Cheese", 3.00),
    PROVOLONE("Provolone Cheese", 3.00),
    EGG("Egg", 2.00),
    BACON("Bacon", 3.50),
    DOUBLE_MEAT("Double Meat", 4.50), // Sandiwch
    DOUBLE_SAUSAGE("Double Sausage", 5.00), // Wiener
    DOUBLE_PATTY("Double Patty", 6.00), // Hamburger
    ONION_RINGS("Onion Rings", 4.50),

    // Extra addons (For Sides)
    CHEDDAR_SAUCE("Cheddar Suace", 3.00),
    BACON_BITS("Bacon Bits", 2.50),
    PARMESAN("Grated Parmesan", 2.00),

    // Sauces (few free, some paid)
    KETCHUP("Ketchup", 0.0),
    MUSTARD("Mustard", 0.0),
    MAYONNAISE("Mayonnaise", 0.0),
    SPICY_SAUCE("Spicy Sauce", 1.00),
    GARLIC_MAYONNAISE("Garlic Mayonnaise Dip", 1.50),
    GARLIC_SAUCE("Garlic Sauce", 1.50),
    GREEN_SAUCE("Green Sauce", 1.25),

    // Extras and Coverages
    ICE_CREAM_SCOOP("Ice Cream Scoop", 3.50),
    CHOCOLATE_SYRUP("Chocolate Syrup", 1.50),
    STRAWBERRY_SYRUP("Strawberry Syrup", 1.50),
    WHIPPED_CREAM("Whipped Cream", 2.00),
    CHOC_CHIPS("Chocolate Chips", 1.00),

    // Extra for Beverage
    ICE_CUBES("Ice Cubes", 0.0),
    LEMON_SLICE("Lemon Slice", 0.0),
    MINT_LEAVES("Mint Leaves", 0.0),
    VANILLA_SYRUP("Vanilla Flavor Syrup", 2.00),
    CARAMEL_SYRUP("Caramel Falvor Syrup", 2.00);


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
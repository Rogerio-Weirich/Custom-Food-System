package com.snackbar.model.enums;

import java.util.Arrays;
import java.util.List;

import com.snackbar.persistence.IngredientDAO;

public enum Ingredient {
    // Burger Buns (BBRG)
    POTATO_BUN          ("Potato",                "BBRG"),
    PRETZEL_BUN         ("Pretzel",               "BBRG"),
    WHEAT_BUN           ("Wheat",                 "BBRG"),
    // Sandwich Buns (BSND)
    BAGUETTE            ("Baguette",              "BSND"),
    CIABATTA            ("Ciabatta",              "BSND"),
    PANINI              ("Panini",                "BSND"),
    // Wiener Buns (BWNE)
    BAKERY_BUN          ("Bakery",                "BWNE"),
    BRIOCHE_BUN         ("Brioche",               "BWNE"),
    FRENCH_BUN          ("French",                "BWNE"),
    // Patty (PTTY)
    BEEF_PATTY          ("Beef Patty",            "PTTY"),
    CHICKEN_PATTY       ("Chicken Patty",         "PTTY"),
    PORKY_PATTY         ("Porky Patty",           "PTTY"),
    VEGGIE_PATTY        ("Veggie Patty",          "PTTY"),
    // Meat (MEAT)
    CHICKEN_BREAST      ("Chicken Breast",        "MEAT"),
    TURKEY_BREAST       ("Turkey Breast",         "MEAT"),
    ROAST_BEEF          ("Roast Beef",            "MEAT"),
    TOFU                ("Tofu",                  "MEAT"),
    // Sausage (SAUS)
    CHICKEN_SAUSAGE     ("Chicken Sausage",       "SAUS"),
    PORK_SAUSAGE        ("Pork Sausage",          "SAUS"),
    VEGGIE_SAUSAGE      ("Veggie Sausage",        "SAUS"),
    VIENNA_SAUSAGE      ("Vienna Sausage",        "SAUS"),
    // Double Meats
    DOUBLE_MEAT         ("Double Meat",           "DSND"),
    DOUBLE_PATTY        ("Double Patty",          "DBRG"),
    DOUBLE_SAUSAGE      ("Double Sausage",        "DWNE"),
    // Salad (SALD)
    ARUGULA             ("Arugula",               "SALD"),
    BELL_PEPPERS        ("Bell Peppers",          "SALD"),
    CORN                ("Corn",                  "SALD"),
    DICED_ONION         ("Diced Onion",           "SALD"),
    JALAPENOS           ("Jalapeños",             "SALD"),
    LETTUCE             ("Lettuce",               "SALD"),
    SLICED_TOMATO       ("Sliced Tomato",         "SALD"),
    BLACK_OLIVES        ("Black Olives",          "SALD"),
    GREEN_OLIVES        ("Green Olives",          "SALD"),
    RED_ONION           ("Red Onion",             "SALD"),
    PEAS                ("Peas",                  "SALD"),
    PICKLE              ("Pickle",                "SALD"),
    // Common Extras (XTRA)
    BACON               ("Bacon",                 "XTRA"),
    EGG                 ("Egg",                   "XTRA"),
    SALAMI              ("Salami",                "XTRA"),
    // Burger Extras (XBRG)
    CARAMELIZED_ONIONS  ("Caramelized Onions",    "XBRG"),
    SAUTEED_MUSHROOMS   ("Sautéed Mushrooms",     "XBRG"),
    // Wiener Extras (XWNE)
    POTATO_STICKS       ("Potato Sticks",         "XWNE"),
    BACON_BITS          ("Bacon Bits",            "XWNE"),
    // Sandwich Extras (XSND)
    SUN_DRIED_TOMATO    ("Sun-Dried Tomato",      "XSND"),
    SLICED_HAM          ("Sliced Ham",            "XSND"),
    SLICED_MORTADELLA   ("Sliced Mortadella",     "XSND"),
    // Side Extras (XSID)
    FRENCH_FRIES        ("French Fries",          "XSID"),
    GARLIC_BREAD        ("Garlic Bread",          "XSID"),
    GRATED_PARMESAN     ("Grated Parmesan",       "XSID"),
    MOZZARELLA_STICKS   ("Mozzarella Sticks",     "XSID"),
    NUGGETS             ("Nuggets",               "XSID"),
    ONION_RINGS         ("Onion Rings",           "XSID"),
    // Cheese (CHSE)
    AMERICAN_CHEESE     ("American",              "CHSE"),
    CHEDDAR_CHEESE      ("Cheddar",               "CHSE"),
    GORGONZOLA          ("Gorgonzola",            "CHSE"),
    MONTEREY_JACK       ("Monterey Jack",         "CHSE"),
    MOZZARELLA          ("Mozzarella",            "CHSE"),
    PARMESAN            ("Parmesan",              "CHSE"),
    PEPPER_JACK         ("Pepper Jack",           "CHSE"),
    PROVOLONE           ("Provolone",             "CHSE"),
    SWISS_CHEESE        ("Swiss",                 "CHSE"),
    CREAM_CHEESE        ("Cream",                 "CHSE"),
    // Dessert (DSRT)
    CHOC_BROWNIE        ("Chocolate Brownie",     "DSRT"),
    CHOC_COOKIE         ("Chocolate Cookie",      "DSRT"),
    ICE_CREAM_CUP       ("Ice Cream Cup",         "DSRT"),
    CUSTOM_ICE_CREAM    ("Custom Ice Cream",      "DSRT"),
    // Dessert Extras (XDES)
    CHOCOLATE_SYRUP     ("Chocolate Syrup",       "XDES"),
    STRAWBERRY_SYRUP    ("Strawberry Syrup",      "XDES"),
    WHIPPED_CREAM       ("Whipped Cream",         "XDES"),     
    CHOC_CHIPS          ("Chocolate Chips",       "XDES"),
    // Sauce (SAUC)
    CHEDDAR_SAUCE       ("Cheddar Sauce",         "SAUC"),
    GARLIC_SAUCE        ("Garlic Sauce",          "SAUC"),
    GREEN_SAUCE         ("Green Sauce",           "SAUC"),
    KETCHUP             ("Ketchup",               "SAUC"),
    MAYONNAISE          ("Mayonnaise",            "SAUC"),
    MUSTARD             ("Mustard",               "SAUC"),
    SPICY_SAUCE         ("Spicy Saude",           "SAUC"), 
    // Beverage (BEVG)
    SODA_350ML          ("Soda 350ml",            "BEVG"),
    SODA_500ML          ("Soda 500ml",            "BEVG"),
    NAT_JUICE           ("Natural Juice",         "BEVG"),
    DRINK               ("Drink",                 "BEVG"),
    // Beverage Extras (XBEV)
    ICE_CUBES           ("Ice Cubes",             "XBEV"),
    LEMON_SLICE         ("Lemon Slice",           "XBEV"),
    MINT_LEAVES         ("Mint Leaves",           "XBEV"),
    VANILLA_SYRUP       ("Vanilla Flavor Syrup",  "XBEV"),
    CARAMEL_SYRUP       ("Caramel Flavor Syrup",  "XBEV");

    // Enum attributes
    private final String displayName;
    private final String category;
    private Double cachedPrice = null;

    /**
     * Enum Constructor.
     * @param displayName the "pretty" name which user will see. 
     * @param price the value which will be added to the order if it is selected.
     */
    Ingredient(String displayName, String category) {
        this.displayName = displayName;
        this.category = category;
    }

    // Getters
    public String getDisplayName() {
        return displayName;
    }

    public String getCategory() {
        return category;
    }
    
    public double getPrice() {
        if (cachedPrice == null) {
            cachedPrice = IngredientDAO.getPrice(this.displayName);
        }
        return cachedPrice;
    }
    
    public static Ingredient[] filterByCategory(String cat) {
        return Arrays.stream(values())
                     .filter(i -> i.category.equalsIgnoreCase(cat))
                     .toArray(Ingredient[]::new);
    }

    public static Ingredient[] filterByCategories(String... cats) {
        List<String> catList = Arrays.asList(cats);
        return Arrays.stream(values())
                 .filter(i -> catList.contains(i.getCategory()))
                 .toArray(Ingredient[]::new);
    }

    /**
     * Format the ingredient exhibition.
     * If the value is > 0, shows the value on the side
     */
    @Override
    public String toString() {
        double price = getPrice();
        if (price > 0) {
            return String.format("%s (+R$ %.2f)", displayName, price);
        }
        return displayName;
    }
}
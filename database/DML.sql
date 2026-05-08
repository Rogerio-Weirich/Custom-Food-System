INSERT INTO products (name, category, base_price) VALUES
("Classic Hamburger",         "BRGR",  5.00),
("Custom Hamburger",          "BRGR",  5.00),
("Classic Sandwich",          "SAND",  4.00),
("Custom Sandwich",           "SAND",  4.00),
("Classic Wiener",            "WNER",  3.50),
("Custom Wiener",             "WNER",  3.50),
("Hamburger Combo",           "CMBO",  0.00),
("Sandwich Combo",            "CMBO",  0.00),
("Wiener Combo",              "CMBO",  0.00),
("Serving Combo",             "CMBO",  0.00),
("Kids Combo",                "CMBO",  0.00);

INSERT INTO ingredients (name, category, price, stock) VALUES
-- Bun
("Potato",                "BBRG",  2.50, 50),
("Pretzel",               "BBRG",  3.00, 50),
("Wheat",                 "BBRG",  2.75, 50),
("Baguette",              "BSND",  3.00, 50),
("Ciabatta",              "BSND",  2.90, 50),
("Panini",                "BSND",  3.10, 50),
("Bakery",                "BWNE",  2.00, 50),
("Brioche",               "BWNE",  2.50, 50),
("French",                "BWNE",  2.75, 50),
-- Patty
("Beef Patty",            "PTTY",  8.00, 40),
("Chicken Patty",         "PTTY",  6.50, 40),
("Porky Patty",           "PTTY",  7.00, 40),
("Veggie Patty",          "PTTY",  9.00, 40),
-- Meat
("Chicken Breast",        "MEAT",  6.00, 40),
("Turkey Breast",         "MEAT",  6.50, 40),
("Roast Beef",            "MEAT",  8.60, 40),
("Tofu",                  "MEAT",  9.00, 40),
-- Sausage
("Chicken Sausage",       "SAUS",  5.00, 40),
("Pork Sausage",          "SAUS",  5.75, 40),
("Veggie Sausage",        "SAUS",  7.89, 40),
("Vienna Sausage",        "SAUS",  6.00, 40),
-- Double Meats
("Double Meat",          "DSND",   7.52, 40),
("Double Patty",         "DBRG",   7.62, 40),
("Double Sausage",       "DWNE",   6.32, 40),
-- Salad
("Arugula",              "SALD",  0.50, 100),
("Bell Peppers",         "SALD",  0.50, 100),
("Corn",                 "SALD",  1.00, 100),
("Diced Onion",          "SALD",  0.50, 100),
("Jalapeños",            "SALD",  1.00, 100),
("Lettuce",              "SALD",  0.50, 100),
("Sliced Tomato",        "SALD",  0.50, 100),
("Black Olives",         "SALD",  2.00, 100),
("Green Olives",         "SALD",  1.00, 100),
("Red Onion",            "SALD",  0.50, 100),
("Peas",                 "SALD",  1.00, 100),
("Pickle",               "SALD",  1.50, 100),
-- Common Extras
("Bacon",                 "XTRA",  2.00, 75),
("Egg",                   "XTRA",  1.50, 75),
("Salami",                "XTRA",  1.89, 75),
-- Categorized Extras
("Caramelized Onions",    "XBRG",  2.50, 50),
("Sautéed Mushrooms",     "XBRG",  3.50, 50),
("Potato Sticks",         "XWNE",  1.50, 50),
("Bacon Bits",            "XWNE",  2.50, 50),
("Sun-Dried Tomato",      "XSND",  3.00, 50),
("Sliced Ham",            "XSND",  4.99, 50),
("Sliced Mortadella",     "XSND",  4.79, 50),
-- Side Extras
("French Fries",          "XSID",  9.90, 75), 
("Garlic Bread",          "XSID",  6.99, 75), 
("Grated Parmesan",       "XSID",  2.79, 75), 
("Mozzarella Sticks",     "XSID", 12.90, 75), 
("Nuggets",               "XSID", 11.99, 75), 
("Onion Rings",           "XSID", 10.75, 75), 
-- Cheese
("American",             "CHSE",  2.50, 150),
("Cheddar",              "CHSE",  2.50, 150),
("Gorgonzola",           "CHSE",  4.00, 150),
("Monterey Jack",        "CHSE",  4.00, 150),
("Mozzarella",           "CHSE",  2.50, 150),
("Parmesan",             "CHSE",  4.00, 150), 
("Pepper Jack",          "CHSE",  4.00, 150),
("Provolone",            "CHSE",  2.50, 150),
("Swiss",                "CHSE",  2.50, 150),
("Cream",                "CHSE",  2.50, 150),
-- Dessert
("Chocolate Brownie",     "DSRT", 12.50, 30),
("Chocolate Cookie",      "DSRT",  5.00, 75),
("Ice Cream Cup",         "DSRT",  3.50, 50),
("Custom Ice Cream",      "DSRT",  6.50, 50),
-- Dessert Extras
("Chocolate Syrup",       "XDES",  2.00, 75),
("Strawberry Syrup",      "XDES",  2.00, 75),
("Whipped Cream",         "XDES",  3.00, 75),
("Chocolate Chips",       "XDES",  2.50, 75),
-- Sauce
("Cheddar Sauce",        "SAUC",  2.15, 200),
("Garlic Sauce",         "SAUC",  1.79, 200),
("Green Sauce",          "SAUC",  1.79, 200),
("Ketchup",              "SAUC",  0.10, 200),
("Mayonnaise",           "SAUC",  0.10, 200),
("Mustard",              "SAUC",  0.10, 200),
("Spicy Sauce",          "SAUC",  0.50, 200),
-- Beverage
("Soda 350ml",            "BEVG",  5.00, 50),
("Soda 500ml",            "BEVG",  7.00, 50),
("Natural Juice",         "BEVG",  8.50, 80),
("Drink",                 "BEVG", 12.50, 50),
-- Beverage Extras
("Ice Cubes",            "XBEV",  0.00, 150),
("Lemon Slice",          "XBEV",  0.50, 150),
("Mint Leaves",          "XBEV",  0.50, 150),
("Vanilla Flavor Syrup", "XBEV",  2.00, 150),
("Caramel Flavor Syrup", "XBEV",  2.00, 150);

-- Classic Hamburger (id=1)
INSERT INTO product_recipes (product_id, ingredient_id, quantity) VALUES
(1, 1,  1),   -- Potato Bun
(1, 10, 1),   -- Beef Patty
(1, 52, 1),   -- American Cheese
(1, 30, 1),   -- Lettuce
(1, 31, 1),   -- Sliced Tomato
(1, 71, 1);   -- Ketchup

-- Classic Sandwich (id=3)
INSERT INTO product_recipes (product_id, ingredient_id, quantity) VALUES
(3, 4,  1),   -- Baguette
(3, 14, 1),   -- Chicken Breast
(3, 30, 1),   -- Lettuce
(3, 31, 1),   -- Sliced Tomato
(3, 28, 1),   -- Diced Onion
(3, 72, 1);   -- Mayonnaise

-- Classic Wiener (id=5)
INSERT INTO product_recipes (product_id, ingredient_id, quantity) VALUES
(5, 7,  1),   -- Bakery Bun
(5, 19, 1),   -- Pork Sausage
(5, 73, 1),   -- Mustard
(5, 71, 1);   -- Ketchup

-- Hamburger Combo (id=7)
INSERT INTO product_recipes (product_id, ingredient_id, quantity) VALUES
(7, 1,  1),   -- Potato Bun
(7, 10, 1),   -- Beef Patty
(7, 52, 1),   -- American Cheese
(7, 30, 1),   -- Lettuce
(7, 31, 1),   -- Sliced Tomato
(7, 71, 1),   -- Ketchup
(7, 80, 1),   -- Soda 500ml
(7, 44, 1);   -- French Fries

-- Sandwich Combo (id=8)
INSERT INTO product_recipes (product_id, ingredient_id, quantity) VALUES
(8, 4,  1),   -- Baguette
(8, 14, 1),   -- Chicken Breast
(8, 30, 1),   -- Lettuce
(8, 31, 1),   -- Sliced Tomato
(8, 28, 1),   -- Diced Onion
(8, 72, 1),   -- Mayonnaise
(8, 47, 1),   -- Nuggets
(8, 82, 1);   -- Natural Juice

-- Wiener Combo (id=9)
INSERT INTO product_recipes (product_id, ingredient_id, quantity) VALUES
(9, 7,  1),   -- Bakery Bun
(9, 19, 1),   -- Pork Sausage
(9, 73, 1),   -- Mustard
(9, 71, 1),   -- Ketchup
(9, 46, 1),   -- Onion Rings
(9, 80, 1);   -- Soda 500ml

-- Serving Combo (id=10)
INSERT INTO product_recipes (product_id, ingredient_id, quantity) VALUES
(10, 44, 1),  -- French Fries
(10, 46, 1),  -- Onion Rings
(10, 47, 1),  -- Nuggets
(10, 48, 1);  -- Mozzarella Sticks

-- Kids Combo (id=11)
INSERT INTO product_recipes (product_id, ingredient_id, quantity) VALUES
(11, 47, 1),  -- Nuggets
(11, 82, 1),  -- Natural Juice
(11, 62, 1);  -- Chocolate Cookie


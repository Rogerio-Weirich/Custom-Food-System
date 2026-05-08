## 🍔 Custom Food Management System 

A robust order management system for highly customizable meals, inspired by the "build-your-own" logic (similar to Subway). 
Developed in Java, focusing on Clean Code, Object-Oriented Programming (OOP) principles, and scalable architecture.


## 🚀 Project Status 
**Active Development:** Core domain model, business logic, and database persistence layer fully implemented.

* **Dynamic Interactive Menu:** Safe terminal navigation, bulletproof against user input errors.
* **Complete Product Catalog:** Support for Burgers, Sandwiches, Wieners, Sides, Desserts, Beverages, and Combos.
* **Advanced Customization Logic:** Customers build their own meals with menus dynamically generated from ingredient categories fetched from the database.
* **Ingredient-based Stock Control:** Stock is tracked per ingredient — selling a Classic Hamburger consumes its individual recipe components (bun, patty, cheese, etc.).
* **Recipe System:** Classic products and combos have defined recipes (`product_recipes`) that drive both availability checks and stock decrement on sale.
* **Price Management via Database:** All product base prices and ingredient prices are stored and managed in MySQL — no hardcoded values in Java.
* **Shopping Cart & Receipt Generation:** Detailed receipt output with base prices, add-ons, and final totals.
* **Dual Interface:** Point of Sale (ConsoleUI) and Kitchen Display System (KDSConsoleUI) — separate panels for cashier and kitchen operations.
* **Order Status Workflow:** Enforced status transitions `PENDING → PREPARING → READY → DELIVERED | CANCELED` with business rule validation.
* **Data Persistence (File I/O):** Automatic saving of receipts in `.txt` format after checkout.
* **Database Persistence (JDBC):** Orders and items saved to MySQL with full transaction control and rollback on failure.
* **Environment-based Configuration:** Database credentials managed via `.env` file — no hardcoded secrets.
* **Global Exception Handling:** System shielded against unexpected crashes with custom business exceptions.

## 🗺️ Development Roadmap 

Done:

* [✔️] Product Superclass (Base structure and pricing contract)
* [✔️] Ingredient Enum (DB-aligned catalog with category codes and cached pricing)
* [✔️] Product Subclasses (Hamburger, Sandwich, Wiener, Side, Beverage, Dessert, Combo)
* [✔️] Customization Logic (Multi-step addon integration and final price calculation)
* [✔️] CLI User Interface — Point of Sale (ConsoleUI)
* [✔️] CLI User Interface — Kitchen Display System (KDSConsoleUI)
* [✔️] Order Status Transitions (Enforced business rules with validated state machine)
* [✔️] MySQL Schema (DDL: products, ingredients, product_recipes, orders, order_items)
* [✔️] Seed Data (DML: products, ingredients, classic recipes, combo recipes)
* [✔️] Analytical Views (DQL: availability, cost, critical stock, recipe detail)
* [✔️] JDBC Persistence Layer (DatabaseConnection, OrderDAO, ProductDAO, IngredientDAO)
* [✔️] Recipe-based Stock Management (Ingredient stock decremented on sale via product_recipes)
* [✔️] Environment Variables (.env via dotenv-java, no hardcoded credentials)

**Next Steps:**

* [ ] Stock replenishment flow (restock ingredients via KDS or admin panel)
* [ ] Low stock alerts integrated into the KDS display

## 🛠️ Tech Stack & Concepts

- **Language:** Java 21
- **Database:** MySQL
- **Connectivity:** JDBC (java.sql) with PreparedStatement and transaction control
- **OOP Patterns:** Polymorphism, Inheritance, Composition, Abstract Classes, Factory Pattern, Enum as catalog
- **Architecture:** Layered (model / persistence / presentation / util)
- **Security:** Credentials via environment variables (dotenv-java)
- **Error Handling:** Custom Business Exceptions (InvalidItemException, OutOfStockException, InvalidOrderStatusException)

## 📂 Project Structure:

```
custom-food-system/
├── sql/
│   ├── DDL.sql               # Schema: tables and constraints
│   ├── DML.sql               # Seed data: products, ingredients, recipes
│   └── DQL.sql               # Queries and analytical views
│
├── src/
│   └── com/snackbar/
│       ├── main/
│       │   └── Main.java
│       │
│       ├── model/
│       │   ├── Product.java
│       │   ├── Order.java
│       │   ├── ProductFactory.java
│       │   ├── enums/
│       │   │   ├── Ingredient.java
│       │   │   └── OrderStatus.java
│       │   └── products/
│       │       ├── Hamburger.java
│       │       ├── Sandwich.java
│       │       ├── Wiener.java
│       │       ├── Side.java
│       │       ├── Beverage.java
│       │       ├── Dessert.java
│       │       └── Combo.java
│       │
│       ├── persistence/
│       │   ├── DatabaseConnection.java
│       │   ├── OrderDAO.java
│       │   ├── ProductDAO.java
│       │   ├── IngredientDAO.java
│       │   └── DataPersistence.java
│       │
│       ├── presentation/
│       │   ├── UserUI.java
│       │   ├── MainMenuUI.java
│       │   ├── ConsoleUI.java
│       │   └── KDSConsoleUI.java
│       │
│       └── util/
│           ├── Icon.java
│           ├── InputProvider.java
│           └── exception/
│               ├── InvalidItemException.java
│               ├── InvalidOrderStatusException.java
│               └── OutOfStockException.java
│
├── lib/
│   └── dotenv-java-3.0.0.jar    # Dependency: environment variable loader
│
├── .env.example                 # Template for environment configuration
├── .gitattributes               # Ensures SQL is counted in GitHub language stats
├── .gitignore
└── README.md
```

---

## ⚙️ How to Run

### Prerequisites
- Java 21+
- MySQL running locally
- `lib/dotenv-java-3.0.0.jar` in your classpath (see [mvnrepository](https://mvnrepository.com/artifact/io.github.cdimascio/dotenv-java/3.0.0))

## 🖥️ Setup

1. Clone the repository:
```bash
git clone https://github.com/Rogerio-Weirich/Custom-Food-System.git
```

2. Set up the database — run the SQL files in order:
sql/DDL.sql   → creates tables
sql/DML.sql   → populates products, ingredients and recipes

3. Configure your environment — copy `.env.example` to `.env` and fill in your credentials:
```env
DB_URL=jdbc:mysql://localhost:3306/custom_food_db
DB_USER=your_user
DB_PASSWORD=your_password
```

4. Add `lib/dotenv-java-3.0.0.jar` to your classpath in VS Code (`.vscode/settings.json`):
```json
{
    "java.project.referencedLibraries": [
        "lib/**/*.jar"
    ]
}
```

5. Run `Main.java` located in `com.snackbar.main` and follow the terminal instructions.

> Generated receipts are saved in the `/receipts` folder at the project root (ignored by version control).
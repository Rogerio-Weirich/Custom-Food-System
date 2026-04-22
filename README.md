## 🍔 Custom Food Management System 

A robust order management system for highly customizable meals, inspired by the "build-your-own" logic (similar to Subway). Developed in Java, focusing on Clean Code, Object-Oriented Programming (OOP) principles, and scalable architecture.

### 🚀 Project Status 
In Progress: Developing the core Domain Model and Business Logic.

🗺️ Development Roadmap:

* [✔️] Product Superclass (Base structure, stock management, and pricing contract)

* [✔️] Ingredient/Addon Enum (Categorized ingredients for customization)

* [✔️] Subclasses Implementation (Hamburger, Sandwiches, Sides, Wieners, Desserts)

* [✔️] Drink & Combo Systems (Implementation of beverages and special pricing)

* [  ] Customization Logic (Addon integration and final price calculation)

* [  ] MySQL Persistence Layer (Database schema, DDL/DML, and JDBC)

* [  ] CLI User Interface (Interactive console-based ordering)

## 🛠️ Tech Stack & Concepts

- Language: Java 21

- OOP Patterns: Polymorphism, Inheritance, Composition, and Interfaces.

- Database: MySQL (Persistence, Security, and Access Control).

- Error Handling: Custom Business Exceptions.

#####  📂 Project Structure:

```
custom-food-system/
│   └── src/
│       └── model/
│           ├── Product.java    (Superclass)
│           ├── Ingredient.java (Enum)
│           ├── Hamburger.java
│           ├── Sandwich.java
│           ├── Wiener.java
│           ├── Side.java
│           ├── Combo.java
│           ├── Dessert.java
│           └── Beverage.java
├── .gitignore
└── README.md
```
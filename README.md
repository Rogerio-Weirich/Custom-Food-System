## 🍔 Custom Food Management System 

A robust order management system for highly customizable meals, inspired by the "build-your-own" logic (similar to Subway). 
Developed in Java, focusing on Clean Code, Object-Oriented Programming (OOP) principles, and scalable architecture.


### 🚀 Project Status 
In Progress: Developing the core Domain Model and Business Logic.

* **Dynamic Interactive Menu:** Safe terminal navigation, bulletproof against user input errors.
* **Complete Product Catalog:** Support for Burgers, Sandwiches, Wieners, Sides, Desserts, Beverages, and Combos.
* **Advanced Customization Logic:** Allows customers to build their own meals, with menus dynamically generated based on ingredient categories.
* **Shopping Cart & Receipt Generation:** Detailed receipt output with line breaks, clear display of base prices, and add-ons.
* **Data Persistence (File I/O):** Automatic saving of receipts in `.txt` format on the local machine after checkout.
* **Global Exception Handling:** System shielded against unexpected crashes, ensuring the shutdown.

## 🗺️ Development Roadmap Done:

* [✔️] Product Superclass (Base structure, stock management, and pricing contract)

* [✔️] Ingredient/Addon Enum (Categorized ingredients for customization)

* [✔️] Subclasses Implementation (Hamburger, Sandwiches, Sides, Wieners, Desserts)

* [✔️] Drink & Combo Systems (Implementation of beverages and special pricing)

* [✔️] Customization Logic (Addon integration and final price calculation)

* [✔️] CLI User Interface (Interactive console-based ordering)

* [✔️] MySQL Persistence Layer (Database schema, DDL/DML, and JDBC)

* [✔️] JDBC (Java Database Connectivity): Connection setup and execution of DDL/DML queries via Java.

## 🗺️ Development Roadmap Next Steps:

* [  ] Working on it...

## 🛠️ Tech Stack & Concepts

- Language: Java 21

- OOP Patterns: Polymorphism, Inheritance, Composition, and Interfaces.

- Database: MySQL (Persistence, Security, and Access Control).

- Error Handling: Custom Business Exceptions.

#####  📂 Project Structure:

```
custom-food-system/
├── database/                                
├── src/
│   └── com/
│       └── snackbar/
│           ├── main/
│           │   └── Main.java                
│           │
│           ├── model/                       
│           │   ├── Product.java             
│           │   ├── Order.java               
│           │   ├── ProductFactory.java      
│           │   ├── enums/                   
│           │   │   ├── Ingredient.java      
│           │   │   └── OrderStatus.java
│           │   └── products/                
│           │       └── ... (Product subclasses)
│           │
│           └── util/                        
│               ├── exception/               
│               │   └── ... (Custom exceptions)
│               │
│               ├── persistence/             
│               │   ├── DatabaseConnection.java
│               │   ├── OrderDAO.java        
│               │   └── DataPersistence.java 
│               │
│               └── presentation/            
│                   ├── UserInterface.java   
│                   └── InputProvider.java   
│
├── .gitignore
└── README.md
```

## 💻 How to run

1. Clone the Repository:

 🔗 git [repository](https://github.com/Rogerio-Weirich/Custom-Food-System.git)

2. Open the Project in your preferred IDE (IntelliJ IDEA, Eclipse, VS Code).
3. Run the `Main.java` class located in the `main` package.
4. Follow the terminal instructions to interact with the system.


Note: Generated receipts will be saved in the ``/receipts`` folder at the root of the project (this folder is ignored by version control)


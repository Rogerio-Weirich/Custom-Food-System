CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_hash VARCHAR(10) NOT NULL UNIQUE,
    customer_name VARCHAR(100) NOT NULL,
    status VARCHAR(50) NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE order_items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    product_name VARCHAR(100) NOT NULL,
    base_price DECIMAL(10, 2) NOT NULL,
    ingredient_name VARCHAR(100),            
    addon_price DECIMAL(10, 2) DEFAULT 0.00,
    product_type VARCHAR(100),              
    total_price DECIMAL(10, 2) NOT NULL,   
    
    CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE
);

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    category VARCHAR(50) NOT NULL,
    base_price DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL DEFAULT 0
);

CREATE TABLE ingredients (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    category VARCHAR(50) NOT NULL,
    price DECIMAL(10,2) NOT NULL DEFAULT 0.00
);

CREATE VIEW vw_available_products AS
SELECT
    name AS       'Product',
    category AS   'Category',
    base_price AS 'Base Price',
    stock AS      'Stock'
FROM products
WHERE stock > 0
ORDER BY category, name;

CREATE VIEW vw_ingredient_catalog AS
SELECT
    category AS 'Category',
    name AS     'Ingredient',
    price AS    'Addon: (R$)'
FROM ingredients
ORDER BY category, price ASC;

CREATE VIEW vw_order_receipt AS
SELECT
    o.order_hash AS       'Hash',
    o.customer_name AS    'Custommer',
    o.status AS           'Status',
    oi.product_name AS    'Product',
    oi.ingredient_name AS 'Extra | Ingredient',
    oi.total_price AS     'Subtotal Item',
    o.total_amount AS     'Total Order',
    o.created_at AS       'Date | Hour'
FROM orders o
JOIN order_items oi ON o.id = oi.order_id
ORDER BY o.created_at DESC;
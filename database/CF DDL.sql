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
USE custom_food_db;

SELECT * FROM orders;
SELECT * FROM order_items;
SELECT * FROM products;
SELECT * FROM ingredients;
SELECT * FROM product_recipes;
SELECT * FROM vw_available_products;
SELECT * FROM vw_ingredient_catalog;
SELECT * FROM vw_order_receipt;

SELECT * FROM products 
WHERE category = "HAMBURGER";

SELECT * FROM products 
WHERE category = "SANDWICH";

SELECT * FROM products 
WHERE category = "WIENER";

SELECT * FROM ingredients
WHERE category = "EXTRAS" 
ORDER BY price DESC;

SELECT id, name, category, stock 
FROM products 
WHERE stock <= 0
ORDER BY stock ASC;

SELECT name, category, price 
FROM ingredients 
WHERE category 
IN ('BBRG', 'PTTY', 'SALD', 'XBRG', 'CHSE', 'SAUC')
ORDER BY category, price;

SELECT 
    DATE(created_at) AS data, 
    COUNT(id) AS total_orders, 
    SUM(total_amount) AS total_revenue
FROM orders 
WHERE status = 'DELIVERED'
GROUP BY DATE(created_at)
ORDER BY data DESC;

SELECT name, category, price
FROM ingredients
WHERE price >= 4.00
ORDER BY price DESC;
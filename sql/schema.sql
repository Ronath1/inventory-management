CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL
);

INSERT INTO products (name, price, quantity) VALUES
('Sample Product 1', 10.99, 100),
('Sample Product 2', 15.49, 50),
('Sample Product 3', 7.99, 200);
CREATE DATABASE  IF NOT EXISTS `finance_directory`;
USE `finance_directory`;

--
-- Table structure for table `transaction`, category, user, account
--

DROP TABLE IF EXISTS `transaction`;
DROP TABLE IF EXISTS `category`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `account`;

-- Create the User table
CREATE TABLE User (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Create the Category table
CREATE TABLE Category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Create the Transaction table with foreign keys to User and Category
CREATE TABLE Transaction (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    amount DECIMAL(10, 2) NOT NULL,
    date DATE NOT NULL,
    user_id INT NOT NULL,
    category_id INT NOT NULL,
	account_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User(id),
    FOREIGN KEY (category_id) REFERENCES Category(id),
    FOREIGN KEY (account_id) REFERENCES Account(id)
);

-- Create the Account table
CREATE TABLE Account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    balance DECIMAL(10, 2) NOT NULL
);

-- Insert data into the User table
INSERT INTO User (username, password) VALUES
    ('user1', 'password1'),
    ('user2', 'password2');

-- Insert data into the Category table
INSERT INTO Category (name) VALUES
    ('Category A'),
    ('Category B'),
    ('Category C');

-- Insert data into the Account table
INSERT INTO Account (name, balance) VALUES
    ('Account 1', 1000.00),
    ('Account 2', 2000.00);

-- Insert data into the Transaction table
-- Note: Associate transactions with users and accounts as needed
INSERT INTO Transaction (description, amount, date, user_id, category_id, account_id) VALUES
    ('Transaction 1', 500.00, '2023-09-23', 1, 1, 1),
    ('Transaction 2', 300.00, '2023-09-24', 1, 2, 1),
    ('Transaction 3', 800.00, '2023-09-25', 2, 1, 2),
    ('Transaction 4', 600.00, '2023-09-26', 2, 2, 2),
    ('Transaction 5', 200.00, '2023-09-27', 1, 3, 1);

-- Ensure that the user_id, category_id, and account_id values correspond to existing records in their respective tables.



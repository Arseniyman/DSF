CREATE DATABASE IF NOT EXISTS sandbox;
USE sandbox;
CREATE TABLE IF NOT EXISTS employee
(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name CHAR(255) NOT NULL,
    age SMALLINT NULL
);

INSERT INTO employee(name, age) VALUES
('Sam Lent', 32),
('Entony Malens', 25),
('Vincent Anremo', 27);
CREATE DATABASE IF NOT EXISTS sandbox;
USE sandbox;
CREATE TABLE IF NOT EXISTS user
(
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nickname CHAR(100) NOT NULL UNIQUE,
    name CHAR(255) NULL,
    rating BIGINT NULL
);

INSERT INTO user(nickname, name, rating) VALUES
('Slent','Sam Lent', 15),
('Enma','Entony Malens', 3),
('Vimo','Vincent Anremo', 7);

CREATE TABLE IF NOT EXISTS creature
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(75) NOT NULL,
    health INT NOT NULL,
    user_id BIGINT NULL,
    FOREIGN KEY (user_id) REFERENCES user (id)
);

INSERT INTO creature(name, health, user_id) VALUES
('Bonya', 45, 1),
('Mike', 39, 2),
('Volt', 57, 3); 
CREATE DATABASE IF NOT EXISTS sandbox;
USE sandbox;
CREATE TABLE IF NOT EXISTS user
(
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nickname CHAR(100) NOT NULL,
    name CHAR(255) NULL,
    rating BIGINT NULL
);

INSERT INTO user(nickname, name, rating) VALUES
('Slent','Sam Lent', 15),
('Enma','Entony Malens', 3),
('Vimo','Vincent Anremo', 7);
CREATE TABLE IF NOT EXISTS userTable(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
address VARCHAR(150) NOT NULL
);

INSERT INTO userTable (name, address) VALUES
('Иван','Москва'),
('Петр','Санкт-Петербург'),
('Олег','Новосибирск');

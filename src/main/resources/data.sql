INSERT INTO categoria (id, name) VALUES (1, 'books');
INSERT INTO categoria (id, name) VALUES (2, 'clothes');
INSERT INTO categoria (id, name) VALUES (3, 'technology');

INSERT INTO producto (name, description, stock, price, status, created_at, category_id)
VALUES('Cuentos Canibales', 'Antalogias', 20, 300.00, 'A', '2023-06-07', 1);
INSERT INTO producto (name, description, stock, price, status, created_at, category_id)
VALUES('Manual del sabor', 'Cocina', 11, 100.00, 'A', '2023-06-08', 1);
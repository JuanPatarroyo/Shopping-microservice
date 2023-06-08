INSERT INTO categoria (id, name) VALUES (1, 'books');
INSERT INTO categoria (id, name) VALUES (2, 'clothes');
INSERT INTO categoria (id, name) VALUES (3, 'technology');

INSERT INTO producto (id, name, description, stock, price, status, created_at, category_id)
VALUES(1, 'Cuentos Canibales', 'Antalogias', 20, 30000, 'A', '2023-06-07', 1);
INSERT INTO producto (id, name, description, stock, price, status, created_at, category_id)
VALUES(2, 'Tertulianos t-shirt', 'Conmemorativo', 11, 20000, 'A', '2023-06-07', 2);
INSERT INTO producto (id, name, description, stock, price, status, created_at, category_id)
VALUES(3, 'LG monitor 4K', 'REF 213', 5, 2000000, 'A', '2023-06-07', 3);
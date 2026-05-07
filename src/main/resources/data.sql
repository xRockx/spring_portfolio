INSERT INTO users (username, password, authority) VALUES 
('admin', 'pass', 'ADMIN');
INSERT INTO dvds (dvdname, genre, rental_days, users_id) VALUES
('テストDVD1', 'お笑い', 7, 1);
INSERT INTO dvds (dvdname, genre, rental_days, users_id) VALUES
('テストDVD2', 'ドラマ', 7, NULL);
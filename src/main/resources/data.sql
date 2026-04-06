INSERT INTO users (username, password, authority) VALUES 
('admin', 'pass', 'ADMIN');
INSERT INTO dvds (dvdname, genre, rental_days, stock) VALUES
('テストDVD1', 'お笑い', 7, 3);
INSERT INTO rentals (user_id, dvd_id, rental_date, return_date) VALUES
(1, 1, CURRENT_TIMESTAMP, NULL);
INSERT INTO users (username, password, authority) VALUES 
('admin', '$2a$10$wjPYLlbtMR0BbFbTSJl.5O26YsaR1nxKXKq0eDgoxRS292yxKpqSy', 'ADMIN');
INSERT INTO users (username, password, authority) VALUES
('user', '$2a$10$EBaqbgLgXZa8.aTUCEOrAeq9LKAqoUrdqDmSjZJeqmPgbDpIBlM12', 'USER');
INSERT INTO dvds (dvdname, genre, rental_days, users_id) VALUES
('テストDVD1', 'お笑い', 7, 1);
INSERT INTO dvds (dvdname, genre, rental_days, users_id) VALUES
('テストDVD2', 'ドラマ', 7, NULL);
INSERT INTO dvds (dvdname, genre, rental_days, users_id) VALUES
('テストDVD3', 'アニメ', 7, NULL);

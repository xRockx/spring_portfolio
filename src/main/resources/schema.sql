DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS dvds;
DROP TABLE IF EXISTS rentals;
DROP TYPE IF EXISTS role;

CREATE TYPE role AS ENUM ('ADMIN', 'USER');

CREATE TABLE users (
	id serial PRIMARY KEY,
	username varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	authority role NOT NULL
);

CREATE TABLE dvds (
	id serial PRIMARY KEY,
	dvdname varchar(255) NOT NULL,
	genre varchar(255) NOT NULL,
	rental_days INT NOT NULL,
	stock INT NOT NULL
);

CREATE TABLE rentals (
	id serial PRIMARY KEY,
	user_id INT,
	dvd_id INT,
	rental_date timestamp without time zone,
	return_date timestamp without time zone,
	FOREIGN KEY (user_id) REFERENCES users(id),
	FOREIGN KEY (dvd_id) REFERENCES dvds(id)
);
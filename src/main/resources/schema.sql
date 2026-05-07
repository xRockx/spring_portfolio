DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS dvds;
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
	users_id INT,
	FOREIGN KEY (users_id) REFERENCES users(id)
);


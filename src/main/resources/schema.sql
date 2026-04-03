CREATE TYPE role AS ENUM ('ADMIN', 'USER');

CREATE TABLE authentications (
	id serial PRIMARY KEY,
	username varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	authority role NOT NULL,
);

CREATE TABLE dvds (
	id serial PRIMARY KEY,
	dvdname varchar(255) NOT NULL,
	genre varchar(255) NOT NULL,
	rental_days INT NOT NULL,
	FOREIGN KEY (authen_id) REFERENCES authentications(id)
);
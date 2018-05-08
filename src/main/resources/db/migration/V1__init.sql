--sudo -u postgres psql

CREATE USER unicorn WITH PASSWORD 'unicorn';

ALTER USER unicorn SUPERUSER CREATEDB;

CREATE DATABASE "unicorn-local-db" WITH OWNER "unicorn" ENCODING 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8' TEMPLATE template0;

CREATE TABLE IF NOT EXISTS employee (
  id SERIAL PRIMARY KEY,
  firstname VARCHAR DEFAULT NULL,
  lastname VARCHAR DEFAULT NULL,
  email VARCHAR NOT NULL UNIQUE
);

-- default entry into db
insert into employee(firstname, lastname, email) values ('john', 'doe', 'john.doe@gmail.com');
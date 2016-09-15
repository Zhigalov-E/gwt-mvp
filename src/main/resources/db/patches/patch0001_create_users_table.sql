CREATE TABLE users(
  user_id SERIAL PRIMARY KEY,
  login varchar(50) NOT NULL,
  password char(32) NOT NULL,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  birtday DATE NOT NULL,
  email varchar(100) UNIQUE
);
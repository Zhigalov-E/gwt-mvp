CREATE TABLE public.users(
  user_id SERIAL PRIMARY KEY,
  login varchar(45) NOT NULL,
  password char(32) NOT NULL,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  birthday DATE NOT NULL,
  email varchar(100) UNIQUE
);
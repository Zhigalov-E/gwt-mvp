INSERT INTO public.roles (role_name) VALUES('ROLE_USER');

INSERT INTO public.users (login, password, first_name, last_name, birthday, email) VALUES('ivan', '5ebe2294ecd0e0f08eab7690d2a6ee69', 'Иван', 'Петров', '1986.02.05', 'petrov.ivan@gmail.com');

INSERT INTO public.users (login, password, first_name, last_name, birthday, email) VALUES('john', 'a66e44736e753d4533746ced572ca821', 'John', 'Looters', '1976.02.05', 'looters.john@gmail.com');

INSERT INTO public.authorities(user_id, role_id)
SELECT u.user_id, r.role_id
  FROM public.users as u
  CROSS JOIN public.roles as r;
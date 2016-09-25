CREATE VIEW public.v_users AS
SELECT login as username, password, true as enabled
FROM public.users;

CREATE VIEW public.v_authorities AS
SELECT users.login as username, roles.role_name as role
FROM public.authorities
INNER JOIN public.users on public.users.user_id = public.authorities.user_id
INNER JOIN public.roles on public.roles.role_id = public.authorities.role_id;
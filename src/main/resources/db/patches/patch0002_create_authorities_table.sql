CREATE TABLE public.roles (
	role_id SERIAL PRIMARY KEY,
	role_name VARCHAR(50),
	CONSTRAINT ix_role_name UNIQUE(role_name)
);

CREATE TABLE public.authorities (
	user_id INTEGER NOT NULL,
	role_id INTEGER NOT NULL,
	CONSTRAINT ix_auth_username UNIQUE(user_id, role_id),
	CONSTRAINT fk_authorities_user_id FOREIGN KEY (user_id) REFERENCES users (user_id),
	CONSTRAINT fk_authorities_role_id FOREIGN KEY (role_id) REFERENCES roles (role_id)
);

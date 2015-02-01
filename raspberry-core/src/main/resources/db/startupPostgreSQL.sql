CREATE TABLE IF NOT EXISTS ra_user (
  id SERIAL PRIMARY KEY,
  username VARCHAR(256) UNIQUE NOT NULL,
  password VARCHAR(256) NOT NULL,
  email VARCHAR(256) NOT NULL,
  last_name VARCHAR(256),
  first_name VARCHAR(256),
  activated BOOLEAN NOT NULL,
  activation_code VARCHAR(256),
  password_expired BOOLEAN NOT NULL);
USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS user;

CREATE TABLE users (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  username VARCHAR(240) NOT NULL,
  email VARCHAR(240) NOT NULL,
  password VARCHAR(255)NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE ads (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id INT UNSIGNED NOT NULL,
  title VARCHAR(240) NOT NULL,
  description VARCHAR(260) NOT NULL,
  PRIMARY KEY(id)
  FOREIGN KEY(uesr_id) REFERENCES users(id)
    ON DELETE CASCADE
);
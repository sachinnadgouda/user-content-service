create sequence HIBERNATE_SEQUENCE  START WITH 4 INCREMENT BY 1;

CREATE TABLE user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  username varchar(100) NOT NULL,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) DEFAULT NULL,
  role varchar(50) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO user(username, first_name, last_name, role) VALUES('User1', 'user', 'one', 'ADMIN');
INSERT INTO user(username, first_name, last_name, role) VALUES('User2', 'user', 'two', 'USER');

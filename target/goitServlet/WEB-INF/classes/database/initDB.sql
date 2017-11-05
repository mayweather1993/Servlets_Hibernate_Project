CREATE TABLE manufacturer(
  id BINARY(16) NOT NULL PRIMARY KEY ,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE product(
  id BINARY(16)  NOT NULL PRIMARY KEY ,
  name VARCHAR(100) NOT NULL ,
  price BIGINT,
  manufacturer_id BINARY(16) NOT NULL ,
  FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(id)

);
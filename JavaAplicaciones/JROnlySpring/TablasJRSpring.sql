CREATE TABLE login (
  usuario varchar(250) PRIMARY KEY,
  password varchar(250) NOT NULL
);

INSERT INTO login (usuario, password) VALUES('scortes', 'rios');

CREATE TABLE clientes (
  id int(10) PRIMARY KEY AUTO_INCREMENT,
  nombre varchar(100) NOT NULL,
  app varchar(50) NOT NULL,
  apm varchar(50) NOT NULL,
  fecha_nacimiento date NOT NULL,
  sexo char(1) DEFAULT NULL,
  usuario varchar(250) NOT NULL,
  FOREIGN KEY(usuario) REFERENCES login(usuario)
);
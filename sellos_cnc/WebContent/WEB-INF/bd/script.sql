CREATE TABLE usuario (
  idUsuario INTEGER NOT NULL AUTO_INCREMENT,
  username VARCHAR(30) NULL,
  clave VARCHAR(50) NULL,
  estado INTEGER NULL,
  nombres VARCHAR(250) NULL,
  apellidos VARCHAR(250) NULL,
  PRIMARY KEY(idUsuario)
)
TYPE=InnoDB;

CREATE TABLE notarios (
  idnotario INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nombre VARCHAR NULL,
  apellidos VARCHAR NULL,
  direccion VARCHAR NULL,
  telefonos VARCHAR NULL,
  nombrenotaria VARCHAR NULL,
  textosello VARCHAR NULL,
  estado INTEGER UNSIGNED NULL,
  fechasello DATE NULL,
  PRIMARY KEY(idnotario)
)
TYPE=InnoDB;

CREATE TABLE authorities (
  authority VARCHAR(30) NOT NULL AUTO_INCREMENT,
  username VARCHAR(30) NULL
)
TYPE=InnoDB;


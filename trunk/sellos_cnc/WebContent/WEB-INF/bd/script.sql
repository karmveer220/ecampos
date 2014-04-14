DROP DATABASE IF EXISTS cnc_sellos;

CREATE DATABASE IF NOT EXISTS cnc_sellos;

USE cnc_sellos;


CREATE TABLE usuario (
  idUsuario INTEGER NOT NULL AUTO_INCREMENT,
  username VARCHAR(30) NULL,
  clave VARCHAR(50) NULL,
  estado INTEGER NULL,
  nombres VARCHAR(250) NULL,
  apellidos VARCHAR(250) NULL,
  PRIMARY KEY(idUsuario)
)
ENGINE=INNODB;

CREATE TABLE notarios (
  idnotario INTEGER NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(250) NULL,
  apellidos VARCHAR(250)  NULL,
  direccion VARCHAR(250)  NULL,
  telefonos VARCHAR(250)  NULL,
  nombrenotaria VARCHAR(250)  NULL,
  textosello VARCHAR(250)  NULL,
  estado INTEGER NULL,
  fechasello DATE NULL,
  PRIMARY KEY(idnotario)
)
ENGINE=INNODB;

CREATE TABLE authorities (
  id INTEGER NOT NULL AUTO_INCREMENT,
  authority VARCHAR(30) NOT NULL ,
  username VARCHAR(30) NULL,
  PRIMARY KEY(id)
)
ENGINE=INNODB;

CREATE TABLE parametros (
  idParametro INTEGER NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(30) NULL,
  valor VARCHAR(100) NULL,
  PRIMARY KEY(idParametro)
)
ENGINE=INNODB;

INSERT INTO `cnc_sellos`.`parametros` (`idParametro`, `nombre`, `valor`)
VALUES (1, 'URL_WEB', 'www.localhost/sistema');
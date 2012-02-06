DROP DATABASE IF EXISTS CONSTITUCION;

CREATE DATABASE CONSTITUCION;

USE CONSTITUCION;


CREATE TABLE t021notaria (
  COD_NOTARIA CHAR(6) NOT NULL,
  NUM_RUCNOT CHAR(11) NOT NULL,
  NOM_RAZSOC VARCHAR(100) NOT NULL,
  DIR_NOTARIA VARCHAR(100) NOT NULL,
  DES_CORREO VARCHAR(100) NOT NULL,
  DES_WEB VARCHAR(100) NOT NULL,
  NUM_TELEF1 VARCHAR(20) NOT NULL,
  NUM_TELEF2 VARCHAR(20) NOT NULL,
  COD_SUNARP VARCHAR(20) NOT NULL,
  COD_COLEGIO CHAR(4) NOT NULL,
  COD_UBIGEO CHAR(6) NOT NULL,
  NUM_LATITUD DECIMAL(10,6) NOT NULL,
  NUM_LONGITUD DECIMAL(10,6) NOT NULL,
  OBS_NOTARIA VARCHAR(100) NOT NULL,
  NUM_DNIPRESEN CHAR(8) NOT NULL,
  APE_PATPRESEN VARCHAR(100) NOT NULL,
  APE_MATPRESEN VARCHAR(100) NOT NULL,
  NOM_PRESEN VARCHAR(100) NOT NULL,
  FEC_REGISTRO DATETIME NOT NULL,
  IND_ELIMINADO CHAR(1) NOT NULL,
  FEC_ELIMINADO DATETIME NOT NULL,
  PRIMARY KEY(COD_NOTARIA),
  INDEX IN01T021(COD_UBIGEO)
)
TYPE=InnoDB;

CREATE TABLE t028log (
  NUM_LOG INTEGER(11) NOT NULL AUTO_INCREMENT,
  ANN_LOG SMALLINT(6) NOT NULL,
  ANN_TRAMITE SMALLINT(6) NOT NULL,
  NUM_TRAMITE INTEGER(11) NOT NULL,
  COD_OPERACION CHAR(2) NOT NULL,
  COD_USUMODIF VARCHAR(20) NOT NULL DEFAULT '-',
  FEC_MODIF DATETIME NOT NULL,
  PRIMARY KEY(NUM_LOG),
  INDEX FK01_T028_T020(ANN_TRAMITE, NUM_TRAMITE)
)
TYPE=InnoDB;

CREATE TABLE users (
  USERNAME CHAR(20) NOT NULL,
  PASSWORD VARCHAR(50) NOT NULL,
  ENABLED TINYINT(1) NOT NULL,
  FEC_REGISTRO DATETIME NOT NULL,
  COD_USUMODIF VARCHAR(20) NOT NULL,
  FEC_MODIF DATETIME NOT NULL,
  PRIMARY KEY(USERNAME)
)
TYPE=InnoDB;

CREATE TABLE authorities (
  USERNAME CHAR(20) NOT NULL,
  AUTHORITY VARCHAR(50) NOT NULL,
  PRIMARY KEY(USERNAME, AUTHORITY)
)
TYPE=InnoDB;

CREATE TABLE t001parametro (
  ID_PARAMETRO INTEGER NOT NULL AUTO_INCREMENT,
  COD_GRUPO CHAR(3) NOT NULL,
  COD_PARAM CHAR(8) NOT NULL,
  DES_PARAM VARCHAR(200) NOT NULL,
  DES_CORTA VARCHAR(50) NOT NULL,
  COD_USUMODIF VARCHAR(20) NOT NULL DEFAULT '-',
  FEC_MODIF DATETIME NOT NULL,
  PRIMARY KEY(ID_PARAMETRO)
)
TYPE=InnoDB;

CREATE TABLE t020tramite (
  NUM_TRAMITE INTEGER(11) NOT NULL AUTO_INCREMENT,
  COD_NOTARIA CHAR(6) NOT NULL,
  ANN_TRAMITE SMALLINT(6) NOT NULL,
  COD_TIPSOC CHAR(2) NOT NULL,
  COD_ZONREG CHAR(2) NOT NULL,
  COD_OFICREG CHAR(4) NOT NULL,
  COD_PRESENTA VARCHAR(20) NOT NULL,
  CLV_KARDEX CHAR(20) NOT NULL,
  IND_LIBROSOC INTEGER(1) NOT NULL,
  IND_LIBROCON INTEGER(1) NOT NULL,
  NUM_CUO CHAR(20) NOT NULL,
  IND_CUO INTEGER(1) NOT NULL,
  FEC_CUO DATETIME NOT NULL,
  COD_TDOCSOL CHAR(2) NOT NULL DEFAULT 09,
  NUM_DOCSOL CHAR(20) NOT NULL,
  NUM_TITULO CHAR(20) NOT NULL,
  NOM_RAZSOC VARCHAR(140) NOT NULL,
  NOM_DENABREV VARCHAR(100) NOT NULL,
  COD_UBIGEO CHAR(6) NOT NULL,
  IND_APORTE INTEGER(1) NOT NULL,
  MTO_APORTE DECIMAL(15,2) NOT NULL,
  MTO_VALORACCION DECIMAL(15,2) NOT NULL,
  MTO_ACCIONPART DECIMAL(15,2) NOT NULL,
  IND_CANCECAPI INTEGER(1) NOT NULL,
  NUM_PORCENCANC INTEGER(11) NOT NULL,
  MTO_DEREREGIS DECIMAL(15,2) NOT NULL,
  IND_FORMAPAGO INTEGER(1) NOT NULL,
  IND_PSC INTEGER(1) NOT NULL,
  IND_ESTADO INTEGER(1) NOT NULL,
  FEC_INGRESO DATETIME NOT NULL,
  FEC_REGISTRO DATETIME NOT NULL,
  FEC_CERRADO DATETIME NOT NULL,
  FEC_FIRMADO DATETIME NOT NULL,
  IND_ELIMINADO INTEGER(1) NOT NULL DEFAULT 0,
  FEC_ELIMINADO DATETIME NOT NULL,
  IND_ENVIO INTEGER(1) NOT NULL,
  FEC_ENVIO DATETIME NOT NULL,
  COD_USUMODIF VARCHAR(20) NOT NULL DEFAULT '-',
  FEC_MODIF DATETIME NOT NULL,
  PRIMARY KEY(NUM_TRAMITE),
  INDEX IN02T020(CLV_KARDEX)
)
TYPE=InnoDB;

CREATE TABLE t026perjur (
  ID_PERJUR INTEGER NOT NULL AUTO_INCREMENT,
  NUM_TRAMITE INTEGER(11) NOT NULL,
  COD_TIPDOC CHAR(2) NOT NULL,
  NUM_DOCUM CHAR(20) NOT NULL,
  NOM_RAZSOC VARCHAR(100) NOT NULL,
  DIR_PERJUR VARCHAR(100) NOT NULL,
  DES_SIGLAS VARCHAR(100) NOT NULL,
  CLV_INSREG CHAR(30) NOT NULL,
  COD_ZONREG CHAR(2) NOT NULL,
  COD_OFICREG CHAR(4) NOT NULL,
  PRIMARY KEY(ID_PERJUR)
)
TYPE=InnoDB;

CREATE TABLE t025pernat (
  ID_PERNAT INTEGER NOT NULL AUTO_INCREMENT,
  NUM_TRAMITE INTEGER(11) NOT NULL,
  COD_TIPDOC CHAR(2) NOT NULL,
  NUM_DOCUM CHAR(20) NOT NULL,
  APE_PATERNO VARCHAR(100) NOT NULL,
  APE_MATERNO VARCHAR(100) NOT NULL,
  NOM_PERNAT VARCHAR(100) NOT NULL,
  FEC_NACIM DATETIME NOT NULL,
  DES_PROFESION VARCHAR(100) NOT NULL,
  COD_PAIS CHAR(2) NOT NULL,
  DIR_PERNAT VARCHAR(100) NOT NULL,
  COD_UBIGEO CHAR(6) NOT NULL,
  COD_ESTCIVIL CHAR(2) NOT NULL,
  COD_TDCON CHAR(2) NOT NULL,
  NUM_DOCCON CHAR(20) NOT NULL,
  APE_PATCON VARCHAR(100) NOT NULL,
  APE_MATCON VARCHAR(100) NOT NULL,
  NOM_CONYUGE VARCHAR(100) NOT NULL,
  DES_PROFCON VARCHAR(100) NOT NULL,
  PRIMARY KEY(ID_PERNAT),
  INDEX FK01_T025_T022(COD_TIPDOC, NUM_DOCUM)
)
TYPE=InnoDB;

CREATE TABLE t029archivo (
  ID_ARCHIVO INTEGER NOT NULL AUTO_INCREMENT,
  NUM_TRAMITE INTEGER(11) NOT NULL,
  NUM_ARCHIVO INTEGER(11) NOT NULL,
  IND_TIPARCH CHAR(1) NOT NULL,
  NOM_ARCHIVO VARCHAR(100) NOT NULL,
  ARC_CONTENIDO LONGBLOB NOT NULL,
  PRIMARY KEY(ID_ARCHIVO)
)
TYPE=InnoDB;

CREATE TABLE t033solicitante (
  ID_SOLICITANTE INTEGER NOT NULL AUTO_INCREMENT,
  NUM_TRAMITE INTEGER(11) NOT NULL,
  COD_TDOCSOL CHAR(2) NOT NULL,
  NUM_DOCSOL CHAR(20) NOT NULL,
  APE_PATERNO VARCHAR(100) NOT NULL,
  APE_MATERNO VARCHAR(100) NOT NULL,
  NOM_SOLICITANTE VARCHAR(100) NOT NULL,
  DES_CORREO VARCHAR(100) NOT NULL,
  NUM_TELEF VARCHAR(20) NOT NULL,
  NUM_CELULAR VARCHAR(20) NOT NULL,
  DIR_SOLICITANTE VARCHAR(100) NOT NULL,
  PRIMARY KEY(ID_SOLICITANTE)
)
TYPE=InnoDB;

CREATE TABLE t032mandatario (
  ID_MANDATARIO INTEGER NOT NULL AUTO_INCREMENT,
  NUM_TRAMITE INTEGER(11) NOT NULL,
  COD_TDOCMAN CHAR(2) NOT NULL,
  NUM_DOCMAN CHAR(20) NOT NULL,
  IND_ACCSOC CHAR(1) NOT NULL,
  NOM_MANDAT VARCHAR(100) NOT NULL,
  APE_PATERNO VARCHAR(100) NOT NULL,
  APE_MATERNO VARCHAR(100) NOT NULL,
  FEC_NACIM DATETIME NOT NULL,
  COD_ESTCIVIL CHAR(2) NOT NULL,
  COD_PAIS CHAR(2) NOT NULL,
  DIR_MANDAT VARCHAR(100) NOT NULL,
  DES_PROFESION VARCHAR(100) NOT NULL,
  CLV_INSREG CHAR(30) NOT NULL,
  COD_CARGO CHAR(5) NULL,
  PRIMARY KEY(ID_MANDATARIO)
)
TYPE=InnoDB;

CREATE TABLE t027perjurrep (
  ID_PERJURREP INTEGER NOT NULL AUTO_INCREMENT,
  NUM_TRAMITE INTEGER(11) NOT NULL,
  COD_TIPDOC CHAR(2) NOT NULL,
  NUM_DOCUM CHAR(20) NOT NULL,
  COD_TDOCREP CHAR(2) NOT NULL,
  NUM_DOCREP CHAR(20) NOT NULL,
  NOM_REPRE VARCHAR(100) NOT NULL,
  APE_PATERNO VARCHAR(100) NOT NULL,
  APE_MATERNO VARCHAR(100) NOT NULL,
  DIR_PERJUR VARCHAR(100) NOT NULL,
  DES_PROFESION VARCHAR(100) NOT NULL,
  CLV_INSREG CHAR(30) NOT NULL,
  PRIMARY KEY(ID_PERJURREP)
)
TYPE=InnoDB;

CREATE TABLE t022accionista (
  ID_ACCIONISTA INTEGER NOT NULL AUTO_INCREMENT,
  NUM_TRAMITE INTEGER(11) NOT NULL,
  COD_TIPDOC CHAR(2) NOT NULL,
  NUM_DOCUM CHAR(20) NOT NULL,
  FEC_REGISTRO DATETIME NOT NULL,
  IND_APORTE CHAR(1) NOT NULL,
  MTO_APORTE DECIMAL(15,2) NOT NULL,
  COD_PARTICIPA CHAR(4) NOT NULL,
  PRIMARY KEY(ID_ACCIONISTA)
)
TYPE=InnoDB;

CREATE TABLE t023aportebien (
  ID_APORTE INTEGER NOT NULL AUTO_INCREMENT,
  ID_ACCIONISTA INTEGER NOT NULL,
  NUM_APORTE INTEGER(11) NOT NULL,
  CNT_BIEN INTEGER(11) NOT NULL,
  DES_BIEN VARCHAR(500) NOT NULL,
  MTO_BIEN DECIMAL(15,2) NOT NULL,
  PRIMARY KEY(ID_APORTE)
)
TYPE=InnoDB;


CREATE DATABASE CNL_DIGEMIN;
use CNL_DIGEMIN;

CREATE TABLE CON_PERFIL_PEF (
  PEF_nCODIGO INTEGER NOT NULL AUTO_INCREMENT,
  PEF_sDESCRIPCION VARCHAR(25) NULL,
  PRIMARY KEY(PEF_nCODIGO)
);

CREATE TABLE CON_COLEGIOS_COL (
  COL_nCODIGO INTEGER NOT NULL AUTO_INCREMENT,
  COL_sNOMBRE VARCHAR(100) NULL,
  COL_sDIRECCION VARCHAR(200) NULL,
  PRIMARY KEY(COL_nCODIGO)
);

CREATE TABLE CON_AUDITORIA_AUD (
  AUD_nCODIGO INTEGER NOT NULL AUTO_INCREMENT,
  AUD_nUSUARIOREGISTRO INTEGER NULL,
  AUD_dFECHAREGISTRO DATE NULL,
  AUD_sMETODO VARCHAR(50) NULL,
  AUD_sSISTEMASONSULTA VARCHAR(100) NULL,
  AUD_sCONSULTA VARCHAR(2000) NULL,
  AUD_sCAMPOSCONSULTA VARCHAR(200) NULL,
  PRIMARY KEY(AUD_nCODIGO)
);

CREATE TABLE CON_NOTARIA_NOT (
  NOT_nCODIGO INTEGER NOT NULL AUTO_INCREMENT,
  COL_nCODIGO INTEGER NOT NULL,
  NOT_sNOMBRE VARCHAR(250) NULL,
  NOT_sDIRECCION VARCHAR(500) NULL,
  NOT_nNOTARIO VARCHAR(100) NULL,
  NOT_sTELEFONO VARCHAR(20) NULL,
  NOT_sFAX VARCHAR(20) NULL,
  NOT_sEMAIL VARCHAR(100) NULL,
  NOT_nUSUARIOS INTEGER NULL DEFAULT '3',
  PRIMARY KEY(NOT_nCODIGO),
  FOREIGN KEY(COL_nCODIGO)
    REFERENCES CON_COLEGIOS_COL(COL_nCODIGO)
);

CREATE TABLE CON_PERSONA_PER (
  PER_nCODIGO INTEGER NOT NULL AUTO_INCREMENT,
  COL_nCODIGO INTEGER NOT NULL,
  NOT_nCODIGO INTEGER NOT NULL,
  PEF_nCODIGO INTEGER NOT NULL,
  PER_sNOMBRE VARCHAR(25) NULL,
  PER_sPATERNO VARCHAR(25) NULL,
  PER_sMATERNO VARCHAR(25) NULL,
  PER_dNACIMIENTO DATE NULL,
  PER_sNUM_DOC VARCHAR(11) NULL,
  PER_sUSUARIO VARCHAR(50) NOT NULL,
  PER_sCLAVE VARCHAR(50) NOT NULL,
  PER_sEMAIL VARCHAR()100 NULL,
  PER_fCLAVE INTEGER NULL,
  PRIMARY KEY(PER_nCODIGO),
  UNIQUE INDEX PER_USER_UNIQUE(PER_sUSUARIO),
  FOREIGN KEY(PEF_nCODIGO)
    REFERENCES CON_PERFIL_PEF(PEF_nCODIGO),
  FOREIGN KEY(NOT_nCODIGO)
    REFERENCES CON_NOTARIA_NOT(NOT_nCODIGO),
  FOREIGN KEY(COL_nCODIGO)
    REFERENCES CON_COLEGIOS_COL(COL_nCODIGO)
);

insert into CON_PERFIL_PEF (PEF_nCODIGO,PEF_sDESCRIPCION) VALUES(1,'Administrador');
insert into CON_PERFIL_PEF (PEF_nCODIGO,PEF_sDESCRIPCION) VALUES(2,'Consulta');

insert into CON_COLEGIOS_COL(COL_nCODIGO,COL_sNOMBRE,COL_sDIRECCION) values(1,'Colegio de Notarios de Lima','Gregorio Escobedo');
insert into CON_COLEGIOS_COL(COL_nCODIGO,COL_sNOMBRE,COL_sDIRECCION) values(1,'Colegio de Notarios del Callao','Av. Costanera');

insert into CON_NOTARIA_NOT(NOT_nCODIGO,COL_nCODIGO,NOT_sNOMBRE,NOT_sDIRECCION,NOT_nNOTARIO,NOT_sTELEFONO,NOT_sFAX,NOT_sEMAIL,NOT_nUSUARIOS) values(0,1,'Ninguna','','','','','',3);
insert into CON_NOTARIA_NOT(NOT_nCODIGO,COL_nCODIGO,NOT_sNOMBRE,NOT_sDIRECCION,NOT_nNOTARIO,NOT_sTELEFONO,NOT_sFAX,NOT_sEMAIL,NOT_nUSUARIOS) values(1,1,'Notaria Principal','Lima','','','','',3);

insert into CON_PERSONA_PER(PER_nCODIGO,COL_nCODIGO,NOT_nCODIGO,PEF_nCODIGO,PER_sNOMBRE,PER_sPATERNO,PER_dNACIMIENTO,PER_sNUM_DOC,PER_sUSUARIO,PER_sCLAVE) 
VALUES(1,1,1,1,'Elvis','Campos','1987-03-30','44194490','ecampos','123456');
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
  colegiatura VARCHAR(50)  NULL,
  nombrenotaria VARCHAR(250)  NULL,
  textosello VARCHAR(250)  NULL,
  estado INTEGER NULL,
  fechasello DATE NULL,
  ruc varchar(11) null,
  textoencriptado varchar(50) null,
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

CREATE TABLE permisos (
  idPermiso INTEGER NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NULL,
  estado INTEGER NULL,
  PRIMARY KEY(idPermiso)
)
ENGINE=INNODB;

INSERT INTO `cnc_sellos`.`permisos`(`idPermiso`,`nombre`,`estado`) VALUES 
(1,'ROLE_USER',1),
(2,'ROLE_ADMIN',1),
(3,'ROLE_SELLO',1);

INSERT INTO `cnc_sellos`.`parametros` (`idParametro`, `nombre`, `valor`)
VALUES (1, 'URL_WEB', 'http://192.168.1.38:8082/sellos_cnc/ver.htm?cod=');

insert into `cnc_sellos`.`usuario` (idUsuario, username, clave, estado, nombres, apellidos)
values (1, 'ecampos', '123456', 1, 'Elvis', 'Campos');
	
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(1,'Francisco Javier ','Villavicencio Cardenas','Av. Primero de Mayo Nº 156','4641480/ 4521331 /4521251','26','10256979841','FranciscoJavierVillavicencio26',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(2,'Walter Ricardo','Diaz Cardenas','Av Elmer Faucett Nº 1818','4523535/4526276','29','10081902742','WalterRicardoDiaz29',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(3,'Rafael Enrique','Rivero Castillo','Av. Sáenz Peña Nº 180','4537110','40','10256816704','RafaelEnriqueRivero40',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(4,'Corina Milagros','Gonzales Barron','Calle 1 Mz. V1 - Ciudad Satelite','5530701','31','10096702715','CorinaMilagrosGonzales31',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(5,'Hugo Maximiliano ','Salas Zuñiga','Urb. Las Casuarinas de Mala Nº 113, Dpto. 101','5309337','24','10098964008','HugoMaximilianoSalas24',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(6,'Hubert','Camacho Galvez','Jr. Bolognesi Nº 324','5811449','43','10076463226','HubertCamacho43',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(7,'Hector Lizardo','Gonzalez Rosales','Av. Bolognesi Nº180','2352165','13','10158596313','HectorLizardoGonzalez13',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(8,'Juan Francisco ','Ausejo Roncagliolo','Av. Saenz Peña Nº 190','4299455','15','10066455250','JuanFranciscoAusejo15',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(9,'Jesus Antonio','Vega Erausquin','Av. Saenz Peña Nº 214','4292114','11','10088081574','JesusAntonioVega11',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(10,'Maximo Luis','Vargas Hornes','Av. Jose Galvez Nº 118','4290848','7','10255388709','MaximoLuisVargas7',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(11,'Jose Alejandro','Ochoa Lopez','Jr. Moore Nº 282,','4531142','38','10092700327','JoseAlejandroOchoa38',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(12,'Pedro German ','Nuñez Palomino','Calle Iquique Nº 246','4533900','21','10082166403','PedroGermanNuñez21',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(13,'Manuel','Galvez Succar','Av. Oscar r. benavides Nº 5177','4525008/ 7198286','12','10077910251','ManuelGalvez12',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(14,'Federico Jesus','Campos Echeandia','Av. San Jose Nº 619 - 623','5621888','28','10325427871','FedericoJesusCampos28',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(15,'Jose Luis','Jessen Hurtado','Mz.C5, Lote 17, Urb. La Bandera','5535450','30','10088697320','JoseLuisJessen30',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(16,'Antonio','Restuccia Atoche','Calle Los Jazmines Nº 16, Int. A, Urb. Experimento','2361998','33','10008684427','AntonioRestuccia33',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(17,'Jorge Hernan','Nieves Chen','Plaza de Armas Nº 124','2354190','35','10095386640','JorgeHernanNieves35',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(18,'Kelly Carolina','Kuzma Alfaro','Jr. Simon Bolivar Nº 445','2364854','47','10077217822','KellyCarolinaKuzma47',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(19,'Javier Alberto','Inga Vasquez','Jr. Jorge Chavez Nº 291','2848841','44','10071972891','JavierAlbertoInga44',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(20,'Pedro Alonso','Noriega Altamirano','Jr. Nicolas Ayllon Nº 105','2841060','25','10257693665','PedroAlonsoNoriega25',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(21,'Itala Andrea ','Garrafa Peña','Jr. O\'Higgins Nº 228','5813394','48','10315205234','ItalaAndreaGarrafa48',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(22,'Julia Yolanda','Narvaez Soto','Av. Jorge Chavez Nº 739','2461265','9','10159624400','JuliaYolandaNarvaez9',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(23,'Edwin Jacinto','Ramos Zea','Calle Benjamin Vizquerra Nº 181, Of. 201','2463989','37','10101988941','EdwinJacintoRamos37',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(24,'Liliana Lucero','Conde Obregon','Jr. Felipe Del Solar Nº 259','3772379','49','10094331124','LilianaLuceroConde49',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(25,'Katiuska Ysabel ','Otayza Wuchi','Calle Las Cucardas 193, Urb. Residencial Huaral','2461884','45','10157510440','KatiuskaYsabelOtayza45',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(26,'Diego Gonzalo ','Gereda Torres de Vidaurre','Jr. Ferrocarril s/n, Cdra. 4','2443238','46','10078061354','DiegoGonzaloGereda46',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(27,'Miguel Angel','Fernandez Aliaga','Carretera Central Km. 38, Av. Bolivar Nº 332 Altos','3612516','17','10060155335','MiguelAngelFernandez17',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(28,'Angel Rogelio','Flores Lanegra','Av. Echenique Nº 374','2324303','5','10157076111','AngelRogelioFlores5',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(29,'Enrique','Lanegra Arzola','Av. Jose T. Garcia Nº 218','2395704','4','10155927998','EnriqueLanegra4',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(30,'Carlos Alberto','Reyes Ugarte','Calle Ausejo Salas Nº 101','2395535','42','10074045117','CarlosAlbertoReyes42',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(31,'Luis felix ','Canales Nicho','Av. San Martin  Nº 218','2358719','41','10075031918','LuisFelixCanales41',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(32,'Claudio Fredy','Galvan Gutierres','Av. Gonzales Prada Nº101, Villa de Oyon','2372021','20','10072812692','ClaudioFredyGalvan20',1,'2014-04-20');
insert into `cnc_sellos`.`notarios` (idnotario, nombre, apellidos, direccion, telefonos, colegiatura, ruc, textosello, estado, fechasello ) values(33,'Saturnino Cesar','Ramos Ramos','jr. Progreso nº 232','3257573','6','10162816522','SaturninoCesarRamos6',1,'2014-04-20');

update notarios set textoencriptado = MD5(textosello);


select MD5( textosello) from notarios;
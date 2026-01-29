CREATE DATABASE videojoc_online;
 
USE videojoc_online;
 
CREATE TABLE JUGADORS (
  id_jugador INT AUTO_INCREMENT,
  nom_usuari VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL,
  data_registre DATE NOT NULL,
  PRIMARY KEY (id_jugador)
);
 
CREATE TABLE PERSONATGES (
  id_personatge INT AUTO_INCREMENT,
  nom_personatge VARCHAR(50) NOT NULL,
  nivell INT NOT NULL,
  classe VARCHAR(30) NOT NULL,
  id_jugador INT NOT NULL,
  PRIMARY KEY (id_personatge),
  FOREIGN KEY (id_jugador) REFERENCES JUGADORS(id_jugador)
);
 
CREATE TABLE PARTIDES (
  id_partida INT AUTO_INCREMENT,
  data_hora_inici DATETIME NOT NULL,
  durada_minuts INT NOT NULL,
  PRIMARY KEY (id_partida)
);
 
CREATE TABLE PARTICIPACIONS (
  id_jugador INT NOT NULL,
  id_partida INT NOT NULL,
  puntuacio INT,
  PRIMARY KEY (id_jugador, id_partida),
  FOREIGN KEY (id_jugador) REFERENCES JUGADORS(id_jugador),
  FOREIGN KEY (id_partida) REFERENCES PARTIDES(id_partida)
);
 
SHOW TABLES;
DESCRIBE jugador;
DESCRIBE personatge;
DESCRIBE partida;
DESCRIBE participa;
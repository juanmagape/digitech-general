CREATE DATABASE videojoc_online;
USE videojoc_online;

CREATE TABLE jugador (
  id_jugador INT AUTO_INCREMENT PRIMARY KEY,
  nom_usuari VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL,
  data_registre DATE NOT NULL
);

CREATE TABLE personatge (
  id_personatge INT AUTO_INCREMENT PRIMARY KEY,
  nom_personatge VARCHAR(50) NOT NULL,
  nivell INT NOT NULL,
  classe VARCHAR(30) NOT NULL,
  id_jugador INT NOT NULL,
  FOREIGN KEY (id_jugador) REFERENCES jugador(id_jugador)
);

CREATE TABLE partida (
  id_partida INT AUTO_INCREMENT PRIMARY KEY,
  data_hora_inici DATETIME NOT NULL,
  durada_minuts INT NOT NULL
);

CREATE TABLE participa (
  id_jugador INT NOT NULL,
  id_partida INT NOT NULL,
  puntuacio INT,
  PRIMARY KEY (id_jugador, id_partida),
  FOREIGN KEY (id_jugador) REFERENCES jugador(id_jugador),
  FOREIGN KEY (id_partida) REFERENCES partida(id_partida)
);

/* INSERTS */

INSERT INTO jugador (nom_usuari, email, data_registre)
VALUES 
    ("perico", "perico@youtube.com", 2024-01-25),
    ("antonello", "antonello@youtube.com", 2024-01-25),
    ("joan", "joan@youtube.com", 2024-01-25);

INSERT INTO personatge (nom_personatge, nivell, classe, id_jugador)
VALUES 
    ("Mario Bros", 3, "plumbers", 1),
    ("Luigi Bros", 4,"plumbers", 1);

INSERT INTO partida (data_hora_inici, durada_minuts)
VALUES 
    (2026-01-10, 120);


INSERT INTO participa
VALUES 
    (1, 1, 200);

INSERT INTO partida (data_hora_inici, durada_minuts)
VALUES 
    (2026-01-11, 122);
INSERT INTO participa
VALUES 
    (2, 1, 200);

SELECT id_jugador
FROM jugador
WHERE nom_usuari = "perico"

-- Per obtenir el id jugador de "perico" [nom_usuari]

INSERT INTO participa
VALUES 
    (
        (SELECT id_jugador
FROM jugador
WHERE nom_usuari = "perico"), 

(SELECT id_partida
FROM partida
WHERE data_hora_inici = 2026-01-10 AND durada_minuts = 120), 3520);
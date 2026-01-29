CREATE DATABASE escaperoom;
USE escaperoom;

CREATE TABLE SEUS (
    id_seu INT AUTO_INCREMENT PRIMARY KEY,
    nom_seu VARCHAR(100) NOT NULL,
    ciutat VARCHAR(100) NOT NULL,
    adreça VARCHAR(200) NOT NULL,
    telef_contacte VARCHAR(15) NOT NULL
);

CREATE TABLE PARTICIPANTS (
    id_participant INT AUTO_INCREMENT PRIMARY KEY,
    nom_participant VARCHAR(100) NOT NULL,
    cognom_participant VARCHAR(100) NOT NULL,
    correu_electronic VARCHAR(100) NOT NULL UNIQUE,
    data_naixement DATE NOT NULL
);

CREATE TABLE EQUIPS (
    id_equip INT AUTO_INCREMENT PRIMARY KEY,
    nom_equip VARCHAR(100) NOT NULL,
    data_creacio DATE NOT NULL,
    nombre_participants INT NOT NULL
);

CREATE TABLE SALES (
    id_sala INT AUTO_INCREMENT PRIMARY KEY,
    nom_sala VARCHAR(100) NOT NULL,
    tematica VARCHAR(100) NOT NULL,
    dificultat enum('Fàcil', 'Mitjà', 'Difícil'),
    durada_max INT NOT NULL,
    max_participants INT NOT NULL,
    id_seu INT,
    FOREIGN KEY (id_seu) REFERENCES SEUS(id_seu)
);

CREATE TABLE EQUIPS_PARTICIPANTS (
    id_equip INT,
    id_participant INT,
    data_incorp DATE NOT NULL,
    PRIMARY KEY (id_equip, id_participant),
    FOREIGN KEY (id_equip) REFERENCES EQUIPS(id_equip),
    FOREIGN KEY (id_participant) REFERENCES PARTICIPANTS(id_participant)
);

CREATE TABLE RESERVES (
    id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    data_i_hora DATETIME NOT NULL,
    estat_reserva enum('Pendent', 'Confirmada', 'Cancel·lada') NOT NULL,
    nombre_participants INT NOT NULL,
    id_equip INT,
    id_sala INT,
    FOREIGN KEY (id_equip) REFERENCES EQUIPS(id_equip),
    FOREIGN KEY (id_sala) REFERENCES SALES(id_sala)
);

CREATE TABLE RESULTATS (
    id_resultat INT AUTO_INCREMENT,
    temps_utilitzat INT,
    exit_fracas boolean,
    puntuacio INT ,
    qtat_pistes INT,
    id_reserva INT,
    PRIMARY KEY (id_resultat, id_reserva),
    FOREIGN KEY (id_reserva) REFERENCES RESERVES(id_reserva)
);
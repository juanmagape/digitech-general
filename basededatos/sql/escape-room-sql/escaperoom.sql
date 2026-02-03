/* CREATE DATABASE escaperoom;
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

*/
ALTER TABLE RESERVES
ADD CONSTRAINT chk_num_participants
CHECK (qtat_participants > 0);


-- =========================================
-- CREACIÓ DE LA BASE DE DADES I LES TAULES
-- Projecte Escape Rooms - Model relacional
-- =========================================

CREATE DATABASE escape_room;

USE escape_room;

-- Primera part de creació de taules
-- Taules independents -> No depenen de cap taula.
CREATE TABLE SEUS (
    id_seu INT AUTO_INCREMENT PRIMARY KEY,
    nom_seu VARCHAR(100),
    ciutat_seu VARCHAR(100),
    adressa_seu VARCHAR(200),
    telef_contacte_seu VARCHAR(20)
);

CREATE TABLE PARTICIPANTS (
    id_parti INT AUTO_INCREMENT PRIMARY KEY,
    nom_parti VARCHAR(100),
    cognom_parti VARCHAR(100),
    email_parti VARCHAR(150),
    data_naixement DATE
);

CREATE TABLE EQUIPS (
    id_equip INT AUTO_INCREMENT PRIMARY KEY,
    nom_equip VARCHAR(100),
    data_creacio DATE,
    qtat_parti INT
);

-- Segona part de creació de taules
-- Taules que depenen d’una altra taula.

CREATE TABLE SALES (
    id_sala INT AUTO_INCREMENT PRIMARY KEY,
    nom_sala VARCHAR(100),
    tematica VARCHAR(50),
    dificultat ENUM('Fàcil', 'Mitjà', 'Difícil') NOT NULL,
    durada_max INT,
    max_parti INT,
    id_seu INT,
    FOREIGN KEY (id_seu) REFERENCES SEUS(id_seu)
);

-- Tercera part de creació de taules
-- Taules amb més dependències

CREATE TABLE EQUIPS_PARTICIPANTS (
    id_equip INT,
    id_parti INT,
    data_incorp DATE,
    PRIMARY KEY (id_equip, id_parti),
    FOREIGN KEY (id_equip) REFERENCES EQUIPS(id_equip),
    FOREIGN KEY (id_parti) REFERENCES PARTICIPANTS(id_parti)
);

CREATE TABLE RESERVES (
    id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    data_hora_reserva DATETIME,
    estat_reserva ENUM('Realitzada', 'Cancel·lada', 'Pendent') NOT NULL,
    qtat_participants INT,
    id_sala INT,
    id_equip INT,
    FOREIGN KEY (id_sala) REFERENCES SALES(id_sala),
    FOREIGN KEY (id_equip) REFERENCES EQUIPS(id_equip)
);

CREATE TABLE RESULTATS (
    id_resultat INT AUTO_INCREMENT PRIMARY KEY,
    temps_utilitzat INT,
    exit_fracas BOOLEAN,
    puntuacio INT,
    qtat_pistes INT,
    id_reserva INT,
    FOREIGN KEY (id_reserva) REFERENCES RESERVES(id_reserva)
);


ALTER TABLE SALES
ADD CONSTRAINT fk_sales_seus
FOREIGN KEY (id_seu)
REFERENCES SEUS(id_seu)
ON DELETE RESTRICT
ON UPDATE CASCADE;

ALTER TABLE EQUIPS_PARTICIPANTS
ADD CONSTRAINT fk_id_equip
FOREIGN KEY (id_equip)
REFERENCES EQUIPS(id_equip)
ON DELETE CASCADE;
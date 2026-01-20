CREATE DATABASE partits;
USE partits;

CREATE TABLE equips (
    id_partit INT AUTO_INCREMENT PRIMARY KEY,
    nom_equip VARCHAR(50) NOT NULL,
    ciutat_equip VARCHAR(50) NOT NULL
);

CREATE TABLE camps (
    id_camp INT PRIMARY KEY AUTO_INCREMENT,
    nom_camp VARCHAR(50) NOT NULL,
    adressa_camp VARCHAR(50) NOT NULL
);

CREATE TABLE juga_partit (
    id_partit INT,
    id_camp INT,
    equip_local VARCHAR(50),
    equip_visitant VARCHAR(50),
    data DATE,
    hora TIME,
    PRIMARY KEY (id_partit, id_camp),
    FOREIGN KEY (id_partit) REFERENCES equips(id_partit),
    FOREIGN KEY (id_camp) REFERENCES camps(id_camp)
);

INSERT INTO equips VALUES
(NULL, 'FC Barcelona', 'Barcelona'),
(NULL, 'Real Madrid', 'Madrid'),
(NULL, 'Atletico Madrid', 'Madrid');

INSERT INTO camps VALUES
(NULL, 'Camp Nou', "C. d\'Aristides Maillol, 12, Barcelona"),
(NULL, 'Santiago Bernabeu', 'Av. de Concha Espina, 1, Madrid'),
(NULL, 'Wanda Metropolitano', 'Av. Luis Aragonés, 4, Madrid');

/* ============================================================
   INSERTS JUGADOR
   ============================================================ */
INSERT IGNORE INTO JUGADORS (nom_usuari, email, data_registre)
VALUES
('Lex_ico', 'lexico@gmail.com', '2026-01-10'),
('cargol.', 'cargol@nightcity.com', '2026-01-11'),
('sindsiefertig', 'sindsiefertig@yahoo.es', '2026-01-12'),
('hide.afk', 'hideafk@protonmail.com', '2026-01-13'),
('wordbomb', 'wordbomb@unsc.gov', '2026-01-14'),

('nobita_456', 'nobita_456@email.com', '2025-01-10'),
('eltoni45', 'eltoni45@email.com', '2025-01-12'),
('marcos__', 'marcos__@email.com', '2025-01-15'),
('luna455', 'luna455@email.com', '2025-01-18'),
('juanito333', 'juanito333@email.com', '2025-01-20'),

('borja', 'cargol@treu.com', '2026-01-15'),
('ignacho', 'ignacho@treu.com', '2026-01-15'),
('albertron', 'albertron@treu.com', '2026-01-15'),
('manzaneras', 'manzaneras@treu.com', '2026-01-15'),
('narizon', 'narizon@treu.com', '2026-01-15'),

('Lem', 'lemquilca@gmail.com', '2024-01-25'),
('Kinberly', 'kinqr@gmail.com', '2024-01-25'),
('Mario', 'parcerosilva@gmail.com', '2024-01-25'),
('Sebastian', 'seye@hotmail.com', '2024-01-25'),
('Emyr', 'emyryou@hotmail.com', '2024-01-25'),
('Emyr2', 'emyry2ou@hotmail.com', '2024-01-25');


/* ============================================================
   INSERTS PARTIDA
   ============================================================ */
INSERT IGNORE INTO PARTIDES (data_hora_inici, durada_minuts)
VALUES
('2026-01-15 00:00:00', 47),
('2026-01-15 00:00:00', 123),
('2026-01-15 00:00:00', 33),
('2026-01-16 00:00:00', 28),
('2026-01-16 00:00:00', 11),

('2026-01-10 10:00:00', 120),
('2026-01-10 16:30:00', 90),
('2026-01-10 18:00:00', 60),
('2026-01-10 20:15:00', 45),
('2026-01-10 22:00:00', 150),

('2026-01-14 12:25:00', 220),
('2025-12-31 22:30:00', 150),
('2026-01-01 00:30:00', 325),
('2026-01-07 06:30:00', 75);


/* ============================================================
   INSERTS PERSONATGE
   ============================================================ */
INSERT IGNORE INTO PERSONATGES (nom_personatge, nivell, classe, id_jugador)
VALUES
('Steve', 50, 'Explorador',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'Lex_ico')),

('Lara Croft', 35, 'Arqueóloga',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'cargol.')),

('Link', 20, 'Héroe',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'sindsiefertig')),

('Kratos', 99, 'Dios de la Guerra',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'hide.afk')),

('Ellie Williams', 25, 'Superviviente',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'wordbomb')),
('pepe', 12, 'mag',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'nobita_456')),

('juan', 18, 'ninja',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'eltoni45')),

('auron', 25, 'elf',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'marcos__')),

('Luna', 10, 'Hada',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'luna455')),

('Draco', 30, 'Guerrer',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'juanito333')),

('kratos2', 10, 'Dios',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'borja')),
('hollow', 3, 'Melee',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'ignacho')),

('knight', 5, 'Melee',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'albertron')),

('zeus', 13, 'Dios',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'manzaneras')),

('pikachu', 4, 'Pokemon',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'narizon')),

('lemqr22', 7, 'Saiyajin',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'Lem')),

('marioSilva', 1, 'Namekian',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'Mario')),
('ElSeye', 13, 'Freezer',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'Sebastian')),

('Emyrsyou', 9, 'Saiyajin',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'Emyr'));

/* ============================================================
   INSERTS PARTICIPA
   ============================================================ */
INSERT IGNORE INTO PARTICIPACIONS (id_jugador, id_partida, puntuacio)
VALUES
((SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'Lex_ico'),
 (SELECT id_partida FROM PARTIDES WHERE data_hora_inici = '2026-01-15 00:00:00' AND durada_minuts = 47),
 2500),

((SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'cargol.'),
 (SELECT id_partida FROM PARTIDES WHERE data_hora_inici = '2026-01-15 00:00:00' AND durada_minuts = 123),
 1800),

((SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'sindsiefertig'),
 (SELECT id_partida FROM PARTIDES WHERE data_hora_inici = '2026-01-15 00:00:00' AND durada_minuts = 33),
 3200),

((SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'hide.afk'),
 (SELECT id_partida FROM PARTIDES WHERE data_hora_inici = '2026-01-16 00:00:00' AND durada_minuts = 28),
 15000),

((SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'wordbomb'),
 (SELECT id_partida FROM PARTIDES WHERE data_hora_inici = '2026-01-16 00:00:00' AND durada_minuts = 11),
 500),

((SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'nobita_456'),
 (SELECT id_partida FROM PARTIDES WHERE data_hora_inici = '2026-01-10 10:00:00' AND durada_minuts = 120),
 100),

((SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'eltoni45'),
 (SELECT id_partida FROM PARTIDES WHERE data_hora_inici = '2026-01-10 16:30:00' AND durada_minuts = 90),
 350),

((SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'marcos__'),
 (SELECT id_partida FROM PARTIDES WHERE data_hora_inici = '2026-01-10 18:00:00' AND durada_minuts = 60),
 700),

((SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'luna455'),
 (SELECT id_partida FROM PARTIDES WHERE data_hora_inici = '2026-01-10 20:15:00' AND durada_minuts = 45),
 60),

((SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'juanito333'),
 (SELECT id_partida FROM PARTIDES WHERE data_hora_inici = '2026-01-10 22:00:00' AND durada_minuts = 150),
 150);


select nom_usuari
FROM  JUGADORS
where nom_usuari='Emyr2';

DELETE FROM JUGADORS
where nom_usuari='Emyr2';


SELECT count(*) AS qtat_de_JUGADORS FROM JUGADORS;
SELECT count(*) AS qtat_de_PARTIDES FROM PARTIDES;
SELECT count(*) AS qtat_de_PERSONATGES FROM PERSONATGES;
SELECT count(*) AS qtat_de_PARTICIPACIONS FROM PARTICIPACIONS;

SELECT count(DISTINCT j.id_jugador) as qtat_de_JUGADORS, count(DISTINCT pa.id_partida) as qtat_de_PARTIDES, count(DISTINCT pers.nom_personatge) as qtat_de_PERSONATGES, count(DISTINCT part.id_jugador) as qtat_de_PARTICIPACIONS
FROM JUGADORS j, PARTIDES pa, PERSONATGES pers, PARTICIPACIONS part;

SELECT nom_usuari as "Nom Usuari", classe as "Classe"
FROM PERSONATGES, JUGADORS
WHERE classe = "Melee" AND PERSONATGES.id_jugador = JUGADORS.id_jugador;
/* ============================================================
   DATASET EXTRA – VIDEOJOC ONLINE
   Pensat per practicar SELECT, JOIN i AGREGACIONS
   ============================================================ */


/* ============================================================
   JUGADORS EXTRA
   ============================================================ */
INSERT INTO JUGADORS (nom_usuari, email, data_registre)
VALUES
('alphaWolf', 'alpha@game.com', '2026-01-18'),
('betaMage', 'beta@game.com', '2026-01-18'),
('deltaSniper', 'delta@game.com', '2026-01-19'),
('omegaTank', 'omega@game.com', '2026-01-19'),
('shadowFox', 'shadow@game.com', '2026-01-20'),
('pixelQueen', 'pixel@game.com', '2026-01-20'),
('ironClad', 'iron@game.com', '2026-01-21'),
('voidRunner', 'void@game.com', '2026-01-21'),
('neonBlade', 'neon@game.com', '2026-01-22'),
('stormCaller', 'storm@game.com', '2026-01-22');


/* ============================================================
   PARTIDES EXTRA
   ============================================================ */
INSERT INTO PARTIDES (data_hora_inici, durada_minuts)
VALUES
('2026-01-20 09:00:00', 30),
('2026-01-20 10:30:00', 45),
('2026-01-20 12:00:00', 60),
('2026-01-20 15:00:00', 90),
('2026-01-20 18:00:00', 120),
('2026-01-21 09:00:00', 25),
('2026-01-21 11:00:00', 55),
('2026-01-21 14:00:00', 80),
('2026-01-21 17:30:00', 110),
('2026-01-21 20:00:00', 150);


/* ============================================================
   PERSONATGES EXTRA
   ============================================================ */
INSERT INTO PERSONATGES (nom_personatge, nivell, classe, id_jugador)
VALUES
('Ares', 40, 'Guerrer',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'alphaWolf')),

('Merlina', 22, 'Maga',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'betaMage')),

('ScopeX', 55, 'Franctirador',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'deltaSniper')),

('Bulwark', 60, 'Tanc',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'omegaTank')),
('Nyx', 35, 'Assassí',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'shadowFox')),

('Pixelia', 18, 'Invocadora',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'pixelQueen')),

('Ferrum', 70, 'Paladí',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'ironClad')),

('GhostRun', 28, 'Explorador',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'voidRunner')),

('NeonX', 44, 'Espadatxí',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'neonBlade')),

('Tempest', 50, 'Xaman',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'stormCaller')),
('Echo', 15, 'Suport',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'pixelQueen')),

('Titan', 80, 'Berserker',
 (SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'omegaTank'));


/* ============================================================
   PARTICIPA EXTRA
   ============================================================ */
INSERT INTO PARTICIPACIONS (id_jugador, id_partida, puntuacio)
VALUES
((SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'alphaWolf'),
 (SELECT id_partida FROM PARTIDES WHERE data_hora_inici = '2026-01-20 09:00:00'),
 1200),

((SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'betaMage'),
 (SELECT id_partida FROM PARTIDES WHERE data_hora_inici = '2026-01-20 09:00:00'),
 980),

((SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'deltaSniper'),
 (SELECT id_partida FROM PARTIDES WHERE data_hora_inici = '2026-01-20 10:30:00'),
 2400),

((SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'omegaTank'),
 (SELECT id_partida FROM PARTIDES WHERE data_hora_inici = '2026-01-20 10:30:00'),
 3100),

((SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'shadowFox'),
 (SELECT id_partida FROM PARTIDES WHERE data_hora_inici = '2026-01-20 12:00:00'),
 1800),

((SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'pixelQueen'),
 (SELECT id_partida FROM PARTIDES WHERE data_hora_inici = '2026-01-20 12:00:00'),
 1500),

((SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'ironClad'),
 (SELECT id_partida FROM PARTIDES WHERE data_hora_inici = '2026-01-20 15:00:00'),
 4200),

((SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'voidRunner'),
 (SELECT id_partida FROM PARTIDES WHERE data_hora_inici = '2026-01-20 18:00:00'),
 1700),

((SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'neonBlade'),
 (SELECT id_partida FROM PARTIDES WHERE data_hora_inici = '2026-01-21 14:00:00'),
 2600),

((SELECT id_jugador FROM JUGADORS WHERE nom_usuari = 'stormCaller'),
 (SELECT id_partida FROM PARTIDES WHERE data_hora_inici = '2026-01-21 20:00:00'),
 3900);

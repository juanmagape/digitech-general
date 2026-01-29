INSERT INTO table_name (column1, column2, column3, ...)
VALUES (value1, value2, value3, ...);
 
-- DATE - format YYYY-MM-DD
 
INSERT INTO
    jugador (nom_usuari, email, data_registre)
VALUES  -- id_jugador no apareix a l'INSERT INTO perquè és AUTO_INCREMENT
    ("perico", "perico@youtube.com", 2024-01-25)        -- id_jugador = 1
    ("antenello", "antenello@youtube.com", 2024-01-25), -- id_jugador = 2
    ("joan", "joan@youtube.com", 2024-01-25)            -- id_jugador = 3
    ;
 
INSERT INTO
    jugador -- sense indicar el llistat de camps
VALUES  -- id_jugador és NULL perquè és AUTO_INCREMENT
    (NULL, "perico", "perico@youtube.com", 2024-01-25)        -- id_jugador = 1
    (NULL, "antenello", "antenello@youtube.com", 2024-01-25), -- id_jugador = 2
    (NULL, "joan", "joan@youtube.com", 2024-01-25)            -- id_jugador = 3
    ;
-- https://stackoverflow.com/questions/3493612/how-to-insert-new-row-to-database-with-auto-increment-column-without-specifying
 
INSERT INTO
    personatge (nom_personatge, nivell, classe, id_jugador)
VALUES      -- id_personatge no apareix a l'INSERT INTO perquè és AUTO_INCREMENT
            -- el  id_jugador MUST existir a jugador
    ('Mario "el bro"', 3, "plumbers", 1)  -- id_personatge = 1
    ,
    ("Luigi bros", 4, "plumbers", 1)       -- id_personatge = 2
    ;
 
-- DATETIME - format: YYYY-MM-DD HH:MI:SS
 
INSERT INTO
    partida (data_hora_inici, durada_minuts)
VALUES      -- id_partida no apareix a l'INSERT INTO perquè és AUTO_INCREMENT
            -- el  id_jugador MUST existir a jugador
    (2026-01-10, 120)  -- id_partida = 1
    ;
 
INSERT INTO
    participa (id_jugador, id_partida, puntuacio)
VALUES  -- id_jugador, id_partida  MUST existir a les taules jugador i partida
    (1, 1, 3520) -- ("perico", (2026-01-10, 120), 3520)
    ;
 
INSERT INTO participa
VALUES  -- id_jugador, id_partida  MUST existir a les taules jugador i partida
    (2, 1, 3700); -- ("antenello", (2026-01-10, 120), 3700)
 
 
SELECT id_jugador
FROM jugador
WHERE nom_usuari = "perico";
 
-- Per obtenir el "id_jugador" de "perico" (nom_usuari)
 
 
SELECT id_partida
FROM participa
WHERE data_hora_inici = 2026-01-10 AND durada_minuts=120;
 
-- Per obtenir el "id_partida" de "perico" (nom_usuari)
-- De la partida "data_hora_inici = 2026-01-10, durada_minuts =120"
 
INSERT INTO
    participa (id_jugador, id_partida, puntuacio)
VALUES  -- id_jugador, id_partida  MUST existir a les taules jugador i partida
    (   (SELECT id_jugador
        FROM jugador
        WHERE nom_usuari = "perico")
        ,
        (SELECT id_partida
        FROM participa
        WHERE data_hora_inici = 2026-01-10 AND durada_minuts =120)
        ,
         3520
    );
         
          -- ("perico", (2026-01-10, 120), 3520)
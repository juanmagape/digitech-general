INSERT INTO JUGADORS (nom_usuari, email, data_registre)
VALUES 
    ("borja", "cargol@treu.com", "2026-01-15"),
    ("ignacho", "ignacho@treu.com", "2026-01-15"),
    ("albertron", "albertron@treu.com", "2026-01-15"),
    ("manzaneras", "manzaneras@treu.com", "2026-01-15"),
    ("narizon", "narizon@treu.com", "2026-01-15");

INSERT INTO PERSONATGES (nom_personatge, nivell, classe, id_jugador)
VALUES
    ("kratos", 10, "Dios", 
    (SELECT id_jugador
    FROM JUGADORS
    WHERE nom_usuari = "borja")),
    ("hollow", 3, "Melee",
    (SELECT id_jugador
    FROM JUGADORS
    WHERE nom_usuari = "ignacho")),
    ("knight", 5, "Melee", 
    (SELECT id_jugador
    FROM JUGADORS
    WHERE nom_usuari = "albertron")),
    ("zeus", 13, "Dios", 
    (SELECT id_jugador
    FROM JUGADORS
    WHERE nom_usuari = "manzaneras")),
    ("pikachu", 4, "Pokemon", 
    (SELECT id_jugador
    FROM JUGADORS
    WHERE nom_usuari = "narizon"));

INSERT INTO PARTIDES  (data_hora_inici, durada_minuts)
VALUES 
    ('2026-01-10 10:00:00', 120),
    ('2026-01-10 16:30:00', 90),
    ('2026-01-10 18:00:00', 60),
    ('2026-01-10 20:15:00', 45),
    ('2026-01-10 22:00:00', 150);

INSERT INTO PARTICIPACIONS (id_jugador, id_partida, puntuacio)
VALUES
    (
        (SELECT id_jugador
        FROM JUGADORS
        WHERE nom_usuari = "borja"),

        (SELECT id_partida
        FROM PARTIDES
        WHERE data_hora_inici = "2026-01-10 10:00:00" AND durada_minuts = 120),
        1002
    ),
        (
        (SELECT id_jugador
        FROM JUGADORS
        WHERE nom_usuari = "ignacho"),

        (SELECT id_partida
        FROM PARTIDES
        WHERE data_hora_inici = "2026-01-10 16:30:00" AND durada_minuts = 90),
        3047
    ),
        (
        (SELECT id_jugador
        FROM JUGADORS
        WHERE nom_usuari = "albertron"),

        (SELECT id_partida
        FROM PARTIDES
        WHERE data_hora_inici = "2026-01-10 18:00:00" AND durada_minuts = 60),
        180
    ),
        (
        (SELECT id_jugador
        FROM JUGADORS
        WHERE nom_usuari = "manzaneras"),

        (SELECT id_partida
        FROM PARTIDES
        WHERE data_hora_inici = "2026-01-10 20:15:00" AND durada_minuts = 45),
        41
    ),
        (
        (SELECT id_jugador
        FROM JUGADORS
        WHERE nom_usuari = "narizon"),

        (SELECT id_partida
        FROM PARTIDES
        WHERE data_hora_inici = "2026-01-10 22:00:00" AND durada_minuts = 150),
        724
    );
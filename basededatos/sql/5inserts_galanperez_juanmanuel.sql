INSERT INTO jugador
VALUES 
    (NULL, "borja", "cargol@treu.com", 2026-01-15),
    (NULL, "ignacho", "ignacho@treu.com", 2026-01-15),
    (NULL, "albertron", "albertron@treu.com", 2026-01-15),
    (NULL, "manzaneras", "manzaneras@treu.com", 2026-01-15),
    (NULL, "narizon", "narizon@treu.com", 2026-01-15);


INSERT INTO personatge
VALUES
    (NULL, "kratos", 10, "Dios", 
    (SELECT id_jugador
    FROM jugador
    WHERE nom_usuari = "borja")),
    (NULL, "hollow", 3, "Melee",
    (SELECT id_jugador
    FROM jugador
    WHERE nom_usuari = "ignacho")),
    (NULL, "knight", 5, "Melee", 
    (SELECT id_jugador
    FROM jugador
    WHERE nom_usuari = "albertron")),
    (NULL, "zeus", 13, "Dios", 
    (SELECT id_jugador
    FROM jugador
    WHERE nom_usuari = "manzaneras")),
    (NULL, "pikachu", 4, "Pokemon", 
    (SELECT id_jugador
    FROM jugador
    WHERE nom_usuari = "narizon"));

INSERT INTO partida
VALUES 
    (NULL, 2026-01-15, 340),
    (NULL, 2026-01-15, 640),
    (NULL, 2026-01-15, 90),
    (NULL, 2026-01-15, 30),
    (NULL, 2026-01-15, 230);

INSERT INTO participa
VALUES
    (
        (SELECT id_jugador
        FROM jugador
        WHERE nom_usuari = "borja"),

        (SELECT id_partida
        FROM partida
        WHERE data_hora_inici = 2026-01-15 AND durada_minuts = 340),
        1002
    ),
        (
        (SELECT id_jugador
        FROM jugador
        WHERE nom_usuari = "ignacho"),

        (SELECT id_partida
        FROM partida
        WHERE data_hora_inici = 2026-01-15 AND durada_minuts = 640),
        3047
    ),
        (
        (SELECT id_jugador
        FROM jugador
        WHERE nom_usuari = "albertron"),

        (SELECT id_partida
        FROM partida
        WHERE data_hora_inici = 2026-01-15 AND durada_minuts = 90),
        180
    ),
        (
        (SELECT id_jugador
        FROM jugador
        WHERE nom_usuari = "manzaneras"),

        (SELECT id_partida
        FROM partida
        WHERE data_hora_inici = 2026-01-15 AND durada_minuts = 30),
        41
    ),
        (
        (SELECT id_jugador
        FROM jugador
        WHERE nom_usuari = "narizon"),

        (SELECT id_partida
        FROM partida
        WHERE data_hora_inici = 2026-01-15 AND durada_minuts = 230),
        724
    );
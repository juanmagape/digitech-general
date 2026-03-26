DELIMITER //

CREATE PROCEDURE fer_comanda(
    IN p_client_id INT,
    IN p_producte_id INT,
    IN p_quantitat INT
)
BEGIN
    INSERT INTO comandes (client_id, data)
    VALUES (p_client_id, NOW());

    UPDATE productes
    SET stock = stock - p_quantitat
    WHERE id = p_producte_id;
END //

DELIMITER ;


DELIMITER //

CREATE PROCEDURE tots_els_clients()
BEGIN
    SELECT *
    FROM clients;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE mostra_prod_sota_10()
BEGIN
    SELECT *
    FROM productes
    WHERE stock < 10;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE mostra_prod_sota(IN qtat INT)
BEGIN
    SELECT *
    FROM productes
    WHERE stock < qtat;
END //

DELIMITER ;


DELIMITER //

CREATE PROCEDURE buscar_per_nom(IN nomProd VARCHAR(100))
BEGIN
    SELECT *
    FROM productes
    WHERE nom = nomProd;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE filtrar_per(IN min INT, IN max INT)
BEGIN
    SELECT *
    FROM productes
    WHERE preu > min AND preu < max;
END //

DELIMITER ;


DELIMITER //

CREATE PROCEDURE comprovarStock()
BEGIN
    IF (SELECT COUNT(*) FROM productes WHERE stock = 0) = 0 THEN
        SELECT *
        FROM productes;
    ELSE
        SELECT CONCAT('No hay stock de: ', nom)
        FROM productes
        WHERE stock = 0;
    END IF;
END //

DELIMITER ;
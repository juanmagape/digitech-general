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


DELIMITER //

CREATE PROCEDURE fer_comanda_segura(
    IN p_client_id INT,
    IN p_producte_id INT,
    IN p_quantitat INT
)
BEGIN
    DECLARE v_stock INT;

    START TRANSACTION;

    SELECT stock INTO v_stock
    FROM productes
    WHERE id = p_producte_id;

    IF v_stock IS NULL THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Producte no existeix';

    ELSEIF v_stock < p_quantitat THEN 
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No hi ha stock';

    ELSE
        INSERT INTO comandes (client_id, data)
        VALUES (p_client_id, NOW());

        UPDATE productes
        SET stock = stock - p_quantitat
        WHERE id = p_producte_id;

        COMMIT;
    END IF;

END //

DELIMITER ;


----



DELIMITER //

CREATE PROCEDURE venda_signal_3(
    IN p_producte_id INT,
    IN p_quantitat INT
)
BEGIN
    DECLARE v_stock INT;

    SELECT stock INTO v_stock
    FROM productes
    WHERE id = p_producte_id;

    IF p_quantitat < 0 THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'No pots vendre productes negatius';
    END IF;

    IF v_stock IS NULL THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Producte no existeix';
    END IF;

    IF v_stock < p_quantitat THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: no hi ha stock';
    END IF;

    UPDATE productes
    SET stock = stock - p_quantitat
    WHERE id = p_producte_id;

END //

DELIMITER ;

call venda_signal_3(1,-3);


DELIMITER //

CREATE PROCEDURE venda_final(
    IN p_producte_id INT,
    IN p_quantitat INT
)
BEGIN
    DECLARE v_stock INT;

    START TRANSACTION;

    SELECT stock INTO v_stock
    FROM productes
    WHERE id = p_producte_id;

    IF v_stock IS NULL THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Producte no existeix';

    ELSEIF p_quantitat <= 0 THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Quantitat incorrecta';

    ELSEIF v_stock < p_quantitat THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Stock insuficient';

    ELSE
        UPDATE productes
        SET stock = stock - p_quantitat
        WHERE id = p_producte_id;

        COMMIT;
    END IF;

END //

DELIMITER ;



CREATE TABLE detalls_comanda (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_comanda INT,
    id_producte INT,
    qtat_venuda INT,
    FOREIGN KEY (id_comanda) REFERENCES comandes(id),
    FOREIGN KEY (id_producte) REFERENCES productes(id)
);




DELIMITER //

create procedure afegir_detalls_comanda(
    IN p_comanda_id INT,
    IN p_producte_id INT,
    IN p_quantitat INT
)
BEGIN 
    DECLARE v_qtat_cdes INT;
    DECLARE v_id_producte INT;
    DECLARE v_stock_producte INT;

    START TRANSACTION;

    SELECT COUNT(*) INTO v_qtat_cdes
    FROM comandes
    WHERE id = p_comanda_id;

    SELECT id, stock INTO v_id_producte, v_stock_producte
    FROM productes
    WHERE id = p_producte_id;

    IF v_qtat_cdes = 0 THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Comanda no existeix';
    END IF;

    IF v_id_producte IS NULL THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'El id del producte no existeix';
    END IF;
    
    IF p_quantitat <= 0 THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'La quantitat no pot ser 0 o inferior';
    END IF;

    IF v_stock_producte < p_quantitat THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'La quantitat no pot ser mes que stock';
    END IF;

        UPDATE productes
        SET stock = stock - p_quantitat
        WHERE id = p_producte_id;

        INSERT INTO detalls_comanda(id_comanda, id_producte, qtat_venuda) VALUES (v_qtat_cdes, v_id_producte, p_quantitat);

        COMMIT;
END //

DELIMITER ;

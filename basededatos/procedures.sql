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



DELIMITER //

create procedure afegir_detalls_comanda_canvia_unitats(
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

    IF (SELECT COUNT(*) FROM detalls_comanda WHERE id_comanda = p_comanda_id AND id_producte = p_producte_id) > 0 THEN
        UPDATE detalls_comanda
        SET qtat_venuda = qtat_venuda + p_quantitat
        WHERE id_comanda = p_comanda_id AND id_producte = p_producte_id;
    ELSE
        INSERT INTO detalls_comanda(id_comanda, id_producte, qtat_venuda) 
        VALUES (p_comanda_id, v_id_producte, p_quantitat);
    END IF;

    COMMIT;
END //

DELIMITER ;



DELIMITER //

CREATE FUNCTION calcular_base_linia(
    p_preu DECIMAL(10,2),
    p_qtat INT,
    p_descompte INT
) RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    RETURN p_preu * p_qtat * (1 - (p_descompte / 100.0));
END //

CREATE FUNCTION calcular_import_linia(
    p_preu DECIMAL(10,2),
    p_qtat INT,
    p_descompte INT,
    p_iva INT
) RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    RETURN p_preu * p_qtat * (1 - (p_descompte / 100.0)) * (1 + (p_iva / 100.0));
END //

DELIMITER ;

DELIMITER //

DROP PROCEDURE IF EXISTS afegir_detalls_comanda_canvia_unitats //

CREATE PROCEDURE afegir_detalls_comanda_canvia_unitats(
    IN p_comanda_id INT,
    IN p_producte_id INT,
    IN p_quantitat INT
)
BEGIN 
    DECLARE v_qtat_cdes INT;
    DECLARE v_id_producte INT;
    DECLARE v_stock_producte INT;
    
    DECLARE v_preu_producte DECIMAL(10,2);
    DECLARE v_base_total DECIMAL(10,2);
    DECLARE v_import_iva DECIMAL(10,2);

    START TRANSACTION;

    SELECT COUNT(*) INTO v_qtat_cdes
    FROM comandes
    WHERE id_cda = p_comanda_id;

    SELECT id_prod, stock_prod INTO v_id_producte, v_stock_producte
    FROM productes
    WHERE id_prod = p_producte_id;

    SELECT preu_prod INTO v_preu_producte 
    FROM productes 
    WHERE id_prod = p_producte_id;

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
    SET stock_prod = stock_prod - p_quantitat
    WHERE id_prod = p_producte_id;

    IF (SELECT COUNT(*) FROM detalls_comanda WHERE id_comanda = p_comanda_id AND id_producte = p_producte_id) > 0 THEN
        UPDATE detalls_comanda
        SET qtat_venuda = qtat_venuda + p_quantitat
        WHERE id_comanda = p_comanda_id AND id_producte = p_producte_id;
    ELSE
        INSERT INTO detalls_comanda(id_comanda, id_producte, qtat_venuda) 
        VALUES (p_comanda_id, v_id_producte, p_quantitat);
    END IF;

    UPDATE detalls_comanda
    SET preu_unitari = v_preu_producte,
        import_linia = calcular_import_linia(v_preu_producte, qtat_venuda, descompte, iva)
    WHERE id_comanda = p_comanda_id AND id_producte = p_producte_id;

    SELECT 
        IFNULL(SUM(calcular_base_linia(preu_unitari, qtat_venuda, descompte)), 0),
        IFNULL(SUM(calcular_base_linia(preu_unitari, qtat_venuda, descompte) * (iva / 100.0)), 0)
    INTO 
        v_base_total, 
        v_import_iva
    FROM detalls_comanda
    WHERE id_comanda = p_comanda_id;

    UPDATE comandes
    SET base_total = v_base_total,
        import_iva = v_import_iva,
        import_cda = v_base_total + v_import_iva
    WHERE id_cda = p_comanda_id;

    COMMIT;
END //

DELIMITER ;

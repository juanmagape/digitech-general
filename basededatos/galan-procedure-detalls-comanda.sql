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
DELIMITER $$

CREATE TRIGGER trg_passa_reserva_a_confirmada
AFTER INSERT
ON PAGAMENTS
FOR EACH ROW
BEGIN
    DECLARE estat_reserva VARCHAR(20);

    SELECT en_estat_reserva INTO estat_reserva
    FROM RESERVES
    WHERE id_reserva = NEW.id_reserva;

    IF(estat_reserva = 'pendent') THEN
    UPDATE RESERVES
    SET en_estat_reserva = 'confirmada'
    WHERE id_reserva = NEW.id_reserva;
    END IF;
END $$

DELIMITER ;


DELIMITER $$

CREATE TRIGGER trg_validar_import
BEFORE INSERT
ON PAGAMENTS
FOR EACH ROW
BEGIN
    IF(NEW.pagament < 0) THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'No puedes pagar cantidades negativas';
    END IF;
END $$

DELIMITER ;



DELIMITER $$

CREATE TRIGGER trg_log_pagaments
AFTER INSERT
ON PAGAMENTS
FOR EACH ROW
BEGIN
    INSERT INTO log_pagaments (
        id_reserva,
        import_pagament,
        missatge
    )
    VALUES (
        NEW.id_reserva,
        NEW.import_paga,
        CONCAT(
            'Nou pagament registrat de ',
            NEW.import_paga,
            ' euros'
        )
    );

END $$

DELIMITER ;
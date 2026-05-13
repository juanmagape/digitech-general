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

CREATE TRIGGER trg_confirma_reserva_si_pendent
AFTER INSERT
ON PAGAMENTS
FOR EACH ROW
BEGIN

    UPDATE RESERVES
    SET en_estat_reserva = 'confirmada'
    WHERE id_reserva = NEW.id_reserva
    AND en_estat_reserva = 'pendent';

END $$

DELIMITER ;


DELIMITER $$

CREATE TRIGGER trg_validar_import
BEFORE INSERT
ON PAGAMENTS
FOR EACH ROW
BEGIN
    IF NEW.import_paga <= 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'L''import del pagament ha de ser positiu';
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


## Trigger: trg_passa_reserva_a_confirmada

### Comanda

```sql
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

```

### Interpretació

- Se ejecuta automáticamente **después** de insertar un nuevo pago (`AFTER INSERT` en `PAGAMENTS`).
- Consulta el estado de la reserva asociada a ese nuevo pago.
- Si la reserva se encuentra en estado `pendent`, la actualiza automáticamente para que pase a estar `confirmada`.

## Trigger: trg_validar_import

### Comanda

```sql
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

```

### Interpretació

- Se ejecuta **antes** de insertar un nuevo pago (`BEFORE INSERT` en `PAGAMENTS`), actuando como una barrera de validación.
- Comprueba el valor económico introducido.
- Si el importe es menor que cero (un valor negativo), bloquea la inserción y lanza un error personalizado indicando que no se admiten cantidades negativas. *(Nota: En la definición de la tabla el campo se llama `import_paga`, pero la lógica del trigger busca validar que no existan pagos en negativo).*

## Trigger: trg_log_pagaments

### Comanda

```sql
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

```

### Interpretació

- Se ejecuta automáticamente **después** de insertar un pago válido (`AFTER INSERT` en `PAGAMENTS`).
- Funciona como un sistema de auditoría o historial.
- Crea un nuevo registro en la tabla `log_pagaments` guardando qué reserva se ha pagado, la cantidad del importe y un texto autogenerado que describe el movimiento.
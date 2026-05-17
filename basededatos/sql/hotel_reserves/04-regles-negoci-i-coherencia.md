## Trigger: `trg_impedeix_sobrepagament` (Tasca 2)

### Explicació de què fa el trigger `trg_impedeix_sobrepagament`

Este trigger se activa automáticamente antes de que se inserte un nuevo registro en la tabla `PAGAMENTS` (`BEFORE INSERT`). Su función es calcular cuánto se ha pagado ya de una reserva y sumarle el importe del nuevo pago. Si este total supera el importe total de la reserva (`imp_tot_reserva`), el trigger bloquea la inserción y lanza un mensaje de error, impidiendo así que el cliente pague de más.

### Comanda creació trigger

```sql
DELIMITER $$

CREATE TRIGGER trg_impedeix_sobrepagament
BEFORE INSERT
ON PAGAMENTS
FOR EACH ROW
BEGIN
    DECLARE v_total_pagat DECIMAL(10,2);
    DECLARE v_total_reserva DECIMAL(10,2);

    SELECT SUM(import_paga) INTO v_total_pagat
    FROM PAGAMENTS
    WHERE id_reserva = NEW.id_reserva;

    IF v_total_pagat IS NULL THEN
        SET v_total_pagat = 0;
    END IF;

    SELECT imp_tot_reserva INTO v_total_reserva
    FROM RESERVES
    WHERE id_reserva = NEW.id_reserva;

    IF (v_total_pagat + NEW.import_paga) > v_total_reserva THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: L''import del pagament supera el total de la reserva.';
    END IF;
END $$

DELIMITER ;

```

### Sortida de la comanda `CREATE TRIGGER`

```sql
mysql> CREATE TRIGGER trg_impedeix_sobrepagament
    -> BEFORE INSERT
    -> ON PAGAMENTS
    -> FOR EACH ROW
    -> BEGIN
    ->     DECLARE v_total_pagat DECIMAL(10,2);
    ->     DECLARE v_total_reserva DECIMAL(10,2);
    ->
    ->     SELECT SUM(import_paga) INTO v_total_pagat
    ->     FROM PAGAMENTS
    ->     WHERE id_reserva = NEW.id_reserva;
    ->
    ->     IF v_total_pagat IS NULL THEN
    ->         SET v_total_pagat = 0;
    ->     END IF;
    ->
    ->     SELECT imp_tot_reserva INTO v_total_reserva
    ->     FROM RESERVES
    ->     WHERE id_reserva = NEW.id_reserva;
    ->
    ->     IF (v_total_pagat + NEW.import_paga) > v_total_reserva THEN
    ->         SIGNAL SQLSTATE '45000'
    ->         SET MESSAGE_TEXT = 'Error: L''import del pagament supera el total de la reserva.';
    ->     END IF;
    -> END $$
Query OK, 0 rows affected (0.02 sec)

mysql>
mysql> DELIMITER ;

```

### Demostració de que el trigger `trg_impedeix_sobrepagament` funciona

Para demostrar que el trigger funciona, ejecutamos primero una consulta para ver el estado de la reserva con `id_reserva = 1`. Vemos que el importe total es de 306.90€ y que en la tabla de pagos ya se han ingresado pagos que suman exactamente esos 306.90€ (100.00 + 206.90).

### Comanda a executar

```sql
SELECT id_reserva, imp_tot_reserva
FROM RESERVES
WHERE id_reserva = 1;

...

SELECT id_paga, id_reserva, import_paga
FROM PAGAMENTS
WHERE id_reserva = 1;

```

### Sortida de la comanda executada

```sql
mysql> SELECT id_reserva, imp_tot_reserva
    -> FROM RESERVES
    -> WHERE id_reserva = 1;
+------------+-----------------+
| id_reserva | imp_tot_reserva |
+------------+-----------------+
|          1 |          306.90 |
+------------+-----------------+
1 row in set (0.00 sec)

mysql> SELECT id_paga, id_reserva, import_paga
    -> FROM PAGAMENTS
    -> WHERE id_reserva = 1;
+---------+------------+-------------+
| id_paga | id_reserva | import_paga |
+---------+------------+-------------+
|       1 |          1 |      100.00 |
|      11 |          1 |      206.90 |
+---------+------------+-------------+
2 rows in set (0.00 sec)

mysql>

```

### Comanda a executar per activar el trigger `trg_impedeix_sobrepagament`

Como la reserva 1 ya está totalmente pagada, intentaremos insertar un nuevo pago de 50€ para esa misma reserva. Esto desencadenará automáticamente el trigger antes de la inserción y debería bloquear el proceso.

### Comanda a executar

```sql
INSERT INTO PAGAMENTS (
    id_reserva,
    data_paga,
    import_paga,
    metode_paga
) VALUES (
    1,
    NOW(),
    50.00,
    'efectiu'
);

```

### Sortida de la comanda executada

```sql
mysql> INSERT INTO PAGAMENTS (
    ->     id_reserva,
    ->     data_paga,
    ->     import_paga,
    ->     metode_paga
    -> ) VALUES (
    ->     1,
    ->     NOW(),
    ->     50.00,
    ->     'efectiu'
    -> );
ERROR 1644 (45000): Error: L'import del pagament supera el total de la reserva.
mysql>

```

### Comanda a executar per veure que s'activat el trigger `trg_impedeix_sobrepagament`

Habiendo saltado el error, volvemos a consultar la tabla `PAGAMENTS`. Veremos que el pago malicioso de 50€ no se ha insertado, demostrando que el trigger ha protegido la integridad de los datos.

### Comanda a executar

```sql
SELECT id_paga, id_reserva, import_paga
FROM PAGAMENTS
WHERE id_reserva = 1;

```

### Sortida de la comanda executada

```sql
mysql> SELECT id_paga, id_reserva, import_paga
    -> FROM PAGAMENTS
    -> WHERE id_reserva = 1;
+---------+------------+-------------+
| id_paga | id_reserva | import_paga |
+---------+------------+-------------+
|       1 |          1 |      100.00 |
|      11 |          1 |      206.90 |
+---------+------------+-------------+
2 rows in set (0.00 sec)

mysql>


```

---

---

## Trigger: `trg_bloqueja_checkout_impagat` (Tasca 3)

### Explicació de què fa el trigger `trg_bloqueja_checkout_impagat`

Este trigger se activa automáticamente antes de que se actualice un registro en la tabla `RESERVES` (`BEFORE UPDATE`). Su función es verificar si el usuario intenta cambiar el estado de la reserva a 'checkout'. Si es así, calcula si el total de los pagos registrados es inferior al precio total de la reserva. Si faltan pagos por realizar, el trigger aborta la actualización lanzando un error, evitando que un cliente se vaya sin pagar.

### Comanda creació trigger

```sql
DELIMITER $$

DELIMITER $$

CREATE TRIGGER trg_bloqueja_checkout_impagat
BEFORE UPDATE
ON RESERVES
FOR EACH ROW
BEGIN
    DECLARE v_total_pagat DECIMAL(10,2);

    IF NEW.en_estat_reserva = 'checkout' THEN

        SELECT SUM(import_paga) INTO v_total_pagat
        FROM PAGAMENTS
        WHERE id_reserva = NEW.id_reserva;

        IF v_total_pagat IS NULL THEN
            SET v_total_pagat = 0;
        END IF;

        IF v_total_pagat < NEW.imp_tot_reserva THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Error: No es pot fer checkout. Hi ha imports pendents de pagament.';
        END IF;

    END IF;
END $$

DELIMITER ;

```

### Sortida de la comanda `CREATE TRIGGER`

```sql
mysql> DELIMITER $$
mysql>
mysql> CREATE TRIGGER trg_bloqueja_checkout_impagat
    -> BEFORE UPDATE
    -> ON RESERVES
    -> FOR EACH ROW
    -> BEGIN
    ->     DECLARE v_total_pagat DECIMAL(10,2);
    ->
    ->     IF NEW.en_estat_reserva = 'checkout' THEN
    ->
    ->         SELECT SUM(import_paga) INTO v_total_pagat
    ->         FROM PAGAMENTS
    ->         WHERE id_reserva = NEW.id_reserva;
    ->
    ->         IF v_total_pagat IS NULL THEN
    ->             SET v_total_pagat = 0;
    ->         END IF;
    ->
    ->         IF v_total_pagat < NEW.imp_tot_reserva THEN
    ->             SIGNAL SQLSTATE '45000'
    ->             SET MESSAGE_TEXT = 'Error: No es pot fer checkout. Hi ha imports pendents de pagament.';
    ->         END IF;
    ->
    ->     END IF;
    -> END $$
Query OK, 0 rows affected (0.03 sec)

mysql>
mysql> DELIMITER ;
mysql>

```

### Demostració de que el trigger `trg_bloqueja_checkout_impagat` funciona

Para demostrar que el trigger funciona, ejecutamos primero una consulta para ver el estado de la reserva `2`. Vemos que cuesta 763.13€ pero, en la tabla `PAGAMENTS`, solo consta un pago parcial de 100.00€. Por lo tanto, esta reserva tiene deuda pendiente.

### Comanda a executar

```sql
SELECT id_reserva, en_estat_reserva, imp_tot_reserva
FROM RESERVES
WHERE id_reserva = 2;

...

SELECT id_paga, import_paga
FROM PAGAMENTS
WHERE id_reserva = 2;

```

### Sortida de la comanda executada

```sql
mysql> SELECT id_reserva, en_estat_reserva, imp_tot_reserva
    -> FROM RESERVES
    -> WHERE id_reserva = 2;
+------------+------------------+-----------------+
| id_reserva | en_estat_reserva | imp_tot_reserva |
+------------+------------------+-----------------+
|          2 | confirmada       |          763.13 |
+------------+------------------+-----------------+
1 row in set (0.00 sec)

mysql>


mysql> SELECT id_paga, import_paga
    -> FROM PAGAMENTS
    -> WHERE id_reserva = 2;
+---------+-------------+
| id_paga | import_paga |
+---------+-------------+
|       6 |      100.00 |
+---------+-------------+
1 row in set (0.00 sec)

mysql>


```

### Comanda a executar per activar el trigger `trg_bloqueja_checkout_impagat`

Como la reserva tiene pagos pendientes, intentaremos forzar un `UPDATE` para cambiar su estado a 'checkout'. Esto desencadenará automáticamente el trigger.

### Comanda a executar

```sql
UPDATE RESERVES
SET en_estat_reserva = 'checkout'
WHERE id_reserva = 2;

```

### Sortida de la comanda executada

```sql
mysql> UPDATE RESERVES
    -> SET en_estat_reserva = 'checkout'
    -> WHERE id_reserva = 2;
ERROR 1644 (45000): Error: No es pot fer checkout. Hi ha imports pendents de pagament.
mysql>

```

### Comanda a executar per veure que s'activat el trigger `trg_bloqueja_checkout_impagat`

Tras haber saltado el error, consultamos nuevamente el estado de la reserva `2`. Comprobaremos que el `UPDATE` fue abortado y la reserva sigue en su estado original ('confirmada').

### Comanda a executar

```sql
SELECT id_reserva, en_estat_reserva
FROM RESERVES
WHERE id_reserva = 2;

```

### Sortida de la comanda executada

```sql
mysql> SELECT id_reserva, en_estat_reserva
    -> FROM RESERVES
    -> WHERE id_reserva = 2;
+------------+------------------+
| id_reserva | en_estat_reserva |
+------------+------------------+
|          2 | confirmada       |
+------------+------------------+
1 row in set (0.00 sec)

mysql>

```
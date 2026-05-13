## Trigger: `trg_passa_reserva_a_confirma`

### Explicació de què fa el trigger `trg_passa_reserva_a_confirma`

Este trigger se activa automáticamente después de que se inserta un nuevo registro en la tabla `PAGAMENTS` (`AFTER INSERT`). Su función es actualizar la tabla `RESERVES`, cambiando el estado de la reserva (`en_estat_reserva`) a 'confirmada' para el identificador de reserva asociado al pago recién ingresado.

### Comanda creació trigger

```sql

DELIMITER $$

CREATE TRIGGER trg_passa_reserva_a_confirma
AFTER INSERT
ON PAGAMENTS
FOR EACH ROW
BEGIN
    UPDATE RESERVES
    SET en_estat_reserva = 'confirmada'
    WHERE id_reserva = NEW.id_reserva;
END $$

DELIMITER ;


```

### Sortida de la comanda `CREATE TRIGGER`

```sql

mysql> DELIMITER $$
mysql>
mysql> CREATE TRIGGER trg_passa_reserva_a_confirma
    -> AFTER INSERT
    -> ON PAGAMENTS
    -> FOR EACH ROW
    -> BEGIN
    ->     UPDATE RESERVES
    ->     SET en_estat_reserva = 'confirmada'
    ->     WHERE id_reserva = NEW.id_reserva;
    -> END $$
Query OK, 0 rows affected (0.02 sec)

mysql>
mysql> DELIMITER ;
mysql>


```

### Demostració de que el trigger `trg_passa_reserva_a_confirma` funciona

Para demostrar que el trigger funciona, ejecutamos primero una consulta para ver el estado actual de las tablas. Observamos que la reserva con `id_reserva = 4` tiene actualmente el estado 'checkout'.

### Comanda a executar

```sql
SELECT *
FROM RESERVES;

...

SELECT *
FROM PAGAMENTS;


```

### Sortida de la comanda executada

```sql
mysql> SELECT *
    -> FROM RESERVES;
+------------+-----------+--------------+--------------------+-------------------+----------------+----------------+------------------+------------------+------------------------+-------------------------+-----------------+-----------------+--------------------+-----------------+-----------------+-----------------+---------------------+----------------------+
| id_reserva | id_client | id_habitacio | data_entra_reserva | data_surt_reserva | adults_reserva | menors_reserva | en_estat_reserva | preu_nit_reserva | quantitat_nits_reserva | subtotal_estada_reserva | per_dte_reserva | imp_dte_reserva | imp_servei_reserva | per_iva_reserva | imp_iva_reserva | imp_tot_reserva | data_crea_reserva   | obser_reserva        |
+------------+-----------+--------------+--------------------+-------------------+----------------+----------------+------------------+------------------+------------------------+-------------------------+-----------------+-----------------+--------------------+-----------------+-----------------+-----------------+---------------------+----------------------+
|          1 |         1 |            2 | 2026-05-10         | 2026-05-13        |              2 |              0 | confirmada       |            85.00 |                      3 |                  255.00 |               0 |            0.00 |              24.00 |              10 |           27.90 |          306.90 | 2026-04-29 09:55:54 | Cap de setmana llarg |
|          2 |         2 |            4 | 2026-07-02         | 2026-07-07        |              2 |              1 | confirmada       |           137.50 |                      5 |                  687.50 |              10 |           68.75 |              75.00 |              10 |           69.38 |          763.13 | 2026-04-29 09:55:54 | Reserva d’estiu    |
|          3 |         3 |            6 | 2026-08-15         | 2026-08-18        |              2 |              0 | confirmada       |           275.00 |                      3 |                  825.00 |               5 |           41.25 |              50.00 |              10 |           83.38 |          917.13 | 2026-04-29 09:55:54 | Aniversari           |
|          4 |         4 |            1 | 2026-04-28         | 2026-04-30        |              1 |              0 | checkout         |            55.00 |                      2 |                  110.00 |               0 |            0.00 |              20.00 |              10 |           13.00 |          143.00 | 2026-04-29 09:55:54 | NULL                 |
+------------+-----------+--------------+--------------------+-------------------+----------------+----------------+------------------+------------------+------------------------+-------------------------+-----------------+-----------------+--------------------+-----------------+-----------------+-----------------+---------------------+----------------------+
4 rows in set (0.00 sec)

mysql> SELECT *
    -> FROM PAGAMENTS;
+---------+------------+---------------------+-------------+---------------+--------------------+
| id_paga | id_reserva | data_paga           | import_paga | metode_paga   | concepte_paga      |
+---------+------------+---------------------+-------------+---------------+--------------------+
|       1 |          1 | 2026-04-29 09:55:54 |      100.00 | targeta       | Paga i senyal      |
|       2 |          1 | 2026-04-29 09:55:54 |      206.90 | targeta       | Pagament final     |
|       3 |          3 | 2026-04-29 09:55:54 |      300.00 | transferencia | Reserva confirmada |
|       4 |          4 | 2026-04-29 09:55:54 |      143.00 | efectiu       | Pagament complet   |
|       6 |          2 | 2026-05-07 07:52:47 |      100.00 | bizum         | Pagament parcial   |
|       7 |          1 | 2026-05-13 10:01:38 |      100.00 | bizum         | Pagament reserva   |
+---------+------------+---------------------+-------------+---------------+--------------------+
6 rows in set (0.00 sec)


```

### Comanda a executar per activar el trigger `trg_passa_reserva_a_confirma`

Como el trigger se activa al registrar un pago nuevo, ejecutamos un comando `INSERT` en la tabla `PAGAMENTS` para añadir un pago a la reserva con ID 4. Esto desencadenará automáticamente el trigger en segundo plano.

### Comanda a executar

```sql
INSERT INTO PAGAMENTS (
    id_reserva,
    import_paga,
    metode_paga
    ) VALUES (
        4,
        100,
        'bizum'
    );
...

```

### Sortida de la comanda executada

```sql
mysql> INSERT INTO PAGAMENTS (
    ->     id_reserva,
    ->     import_paga,
    ->     metode_paga
    ->     ) VALUES (
    ->         4,
    ->         100,
    ->         'bizum'
    ->     );
Query OK, 1 row affected (0.02 sec)


```

### Comanda a executar per veure que s'activat el trigger `trg_passa_reserva_a_confirma`

Habiendo insertado el pago, volvemos a consultar la tabla `RESERVES`. Veremos que el estado de la reserva 4 ha cambiado de 'checkout' a 'confirmada', probando el éxito del trigger.

### Comanda a executar

```sql
SELECT *
FROM RESERVES;

...

SELECT *
FROM PAGAMENTS;

```

### Sortida de la comanda executada

```sql
mysql> SELECT *
    -> FROM RESERVES;
+------------+-----------+--------------+--------------------+-------------------+----------------+----------------+------------------+------------------+------------------------+-------------------------+-----------------+-----------------+--------------------+-----------------+-----------------+-----------------+---------------------+----------------------+
| id_reserva | id_client | id_habitacio | data_entra_reserva | data_surt_reserva | adults_reserva | menors_reserva | en_estat_reserva | preu_nit_reserva | quantitat_nits_reserva | subtotal_estada_reserva | per_dte_reserva | imp_dte_reserva | imp_servei_reserva | per_iva_reserva | imp_iva_reserva | imp_tot_reserva | data_crea_reserva   | obser_reserva        |
+------------+-----------+--------------+--------------------+-------------------+----------------+----------------+------------------+------------------+------------------------+-------------------------+-----------------+-----------------+--------------------+-----------------+-----------------+-----------------+---------------------+----------------------+
|          1 |         1 |            2 | 2026-05-10         | 2026-05-13        |              2 |              0 | confirmada       |            85.00 |                      3 |                  255.00 |               0 |            0.00 |              24.00 |              10 |           27.90 |          306.90 | 2026-04-29 09:55:54 | Cap de setmana llarg |
|          2 |         2 |            4 | 2026-07-02         | 2026-07-07        |              2 |              1 | confirmada       |           137.50 |                      5 |                  687.50 |              10 |           68.75 |              75.00 |              10 |           69.38 |          763.13 | 2026-04-29 09:55:54 | Reserva d’estiu    |
|          3 |         3 |            6 | 2026-08-15         | 2026-08-18        |              2 |              0 | confirmada       |           275.00 |                      3 |                  825.00 |               5 |           41.25 |              50.00 |              10 |           83.38 |          917.13 | 2026-04-29 09:55:54 | Aniversari           |
|          4 |         4 |            1 | 2026-04-28         | 2026-04-30        |              1 |              0 | confirmada       |            55.00 |                      2 |                  110.00 |               0 |            0.00 |              20.00 |              10 |           13.00 |          143.00 | 2026-04-29 09:55:54 | NULL                 |
+------------+-----------+--------------+--------------------+-------------------+----------------+----------------+------------------+------------------+------------------------+-------------------------+-----------------+-----------------+--------------------+-----------------+-----------------+-----------------+---------------------+----------------------+
4 rows in set (0.00 sec)



mysql> SELECT *
    -> FROM PAGAMENTS;
+---------+------------+---------------------+-------------+---------------+--------------------+
| id_paga | id_reserva | data_paga           | import_paga | metode_paga   | concepte_paga      |
+---------+------------+---------------------+-------------+---------------+--------------------+
|       1 |          1 | 2026-04-29 09:55:54 |      100.00 | targeta       | Paga i senyal      |
|       2 |          1 | 2026-04-29 09:55:54 |      206.90 | targeta       | Pagament final     |
|       3 |          3 | 2026-04-29 09:55:54 |      300.00 | transferencia | Reserva confirmada |
|       4 |          4 | 2026-04-29 09:55:54 |      143.00 | efectiu       | Pagament complet   |
|       6 |          2 | 2026-05-07 07:52:47 |      100.00 | bizum         | Pagament parcial   |
|       7 |          1 | 2026-05-13 10:01:38 |      100.00 | bizum         | Pagament reserva   |
|       8 |          4 | 2026-05-13 10:10:08 |      100.00 | bizum         | Pagament reserva   |
+---------+------------+---------------------+-------------+---------------+--------------------+
7 rows in set (0.00 sec)


```

---

## Trigger: `trg_confirma_reserva_si_pendent`

### Explicació de què fa el trigger `trg_confirma_reserva_si_pendent`

Este trigger actualiza el estado de una reserva a 'confirmada' al recibir un nuevo pago, pero añade una condición extra: solo realizará el cambio si la reserva se encuentra actualmente en estado 'pendent'.

### Comanda creació trigger

```sql
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
 ...


```

### Sortida de la comanda `CREATE TRIGGER`

```sql
mysql> DELIMITER $$
mysql>
mysql> CREATE TRIGGER trg_confirma_reserva_si_pendent
    -> AFTER INSERT
    -> ON PAGAMENTS
    -> FOR EACH ROW
    -> BEGIN
    ->
    ->     UPDATE RESERVES
    ->     SET en_estat_reserva = 'confirmada'
    ->     WHERE id_reserva = NEW.id_reserva
    ->     AND en_estat_reserva = 'pendent';
    ->
    -> END $$
Query OK, 0 rows affected (0.02 sec)

mysql>
mysql> DELIMITER ;
mysql>


```

### Demostració de que el trigger `trg_confirma_reserva_si_pendent` funciona

Verificaremos el estado inicial. Consultamos la tabla `RESERVES` y vemos que la reserva con `id_reserva = 1` está explícitamente en el estado 'pendent'.

### Comanda a executar

```sql
SELECT *
FROM RESERVES;

...

SELECT *
FROM PAGAMENTS;

```

### Sortida de la comanda executada

```sql
mysql> SELECT * FROM PAGAMENTS;
+---------+------------+---------------------+-------------+---------------+--------------------+
| id_paga | id_reserva | data_paga           | import_paga | metode_paga   | concepte_paga      |
+---------+------------+---------------------+-------------+---------------+--------------------+
|       1 |          1 | 2026-04-29 09:55:54 |      100.00 | targeta       | Paga i senyal      |
|       2 |          1 | 2026-04-29 09:55:54 |      206.90 | targeta       | Pagament final     |
|       3 |          3 | 2026-04-29 09:55:54 |      300.00 | transferencia | Reserva confirmada |
|       4 |          4 | 2026-04-29 09:55:54 |      143.00 | efectiu       | Pagament complet   |
|       6 |          2 | 2026-05-07 07:52:47 |      100.00 | bizum         | Pagament parcial   |
|       7 |          1 | 2026-05-13 10:01:38 |      100.00 | bizum         | Pagament reserva   |
|       8 |          4 | 2026-05-13 10:10:08 |      100.00 | bizum         | Pagament reserva   |
+---------+------------+---------------------+-------------+---------------+--------------------+
7 rows in set (0.00 sec)

mysql> SELECT * FROM RESERVES;
+------------+-----------+--------------+--------------------+-------------------+----------------+----------------+------------------+------------------+------------------------+-------------------------+-----------------+-----------------+--------------------+-----------------+-----------------+-----------------+---------------------+----------------------+
| id_reserva | id_client | id_habitacio | data_entra_reserva | data_surt_reserva | adults_reserva | menors_reserva | en_estat_reserva | preu_nit_reserva | quantitat_nits_reserva | subtotal_estada_reserva | per_dte_reserva | imp_dte_reserva | imp_servei_reserva | per_iva_reserva | imp_iva_reserva | imp_tot_reserva | data_crea_reserva   | obser_reserva        |
+------------+-----------+--------------+--------------------+-------------------+----------------+----------------+------------------+------------------+------------------------+-------------------------+-----------------+-----------------+--------------------+-----------------+-----------------+-----------------+---------------------+----------------------+
|          1 |         1 |            2 | 2026-05-10         | 2026-05-13        |              2 |              0 | pendent          |            85.00 |                      3 |                  255.00 |               0 |            0.00 |              24.00 |              10 |           27.90 |          306.90 | 2026-04-29 09:55:54 | Cap de setmana llarg |
|          2 |         2 |            4 | 2026-07-02         | 2026-07-07        |              2 |              1 | confirmada       |           137.50 |                      5 |                  687.50 |              10 |           68.75 |              75.00 |              10 |           69.38 |          763.13 | 2026-04-29 09:55:54 | Reserva d’estiu    |
|          3 |         3 |            6 | 2026-08-15         | 2026-08-18        |              2 |              0 | confirmada       |           275.00 |                      3 |                  825.00 |               5 |           41.25 |              50.00 |              10 |           83.38 |          917.13 | 2026-04-29 09:55:54 | Aniversari           |
|          4 |         4 |            1 | 2026-04-28         | 2026-04-30        |              1 |              0 | confirmada       |            55.00 |                      2 |                  110.00 |               0 |            0.00 |              20.00 |              10 |           13.00 |          143.00 | 2026-04-29 09:55:54 | NULL                 |
+------------+-----------+--------------+--------------------+-------------------+----------------+----------------+------------------+------------------+------------------------+-------------------------+-----------------+-----------------+--------------------+-----------------+-----------------+-----------------+---------------------+----------------------+
4 rows in set (0.00 sec)

mysql>



```

### Comanda a executar per activar el trigger `trg_confirma_reserva_si_pendent`

Para desencadenar la acción, insertamos un nuevo registro en la tabla `PAGAMENTS` vinculado a la reserva 1, que cumple con la condición de estar 'pendent'.

### Comanda a executar

```sql
INSERT INTO PAGAMENTS (
    id_reserva,
    import_paga,
    metode_paga
    ) VALUES (
        1,
        100,
        'efectiu'
    );
...

```

### Sortida de la comanda executada

```sql
mysql> INSERT INTO PAGAMENTS (
    ->     id_reserva,
    ->     import_paga,
    ->     metode_paga
    ->     ) VALUES (
    ->         1,
    ->         100,
    ->         'efectiu'
    ->     );
Query OK, 1 row affected (0.01 sec)

mysql>



```

### Comanda a executar per veure que s'activat el trigger `trg_confirma_reserva_si_pendent`

Consultamos la base de datos de nuevo y confirmamos que la reserva 1 ya no está 'pendent', sino que el trigger la ha pasado con éxito a 'confirmada'.

### Comanda a executar

```sql
SELECT *
FROM RESERVES;

...

SELECT *
FROM PAGAMENTS;
...

```

### Sortida de la comanda executada

```sql
mysql> SELECT * FROM PAGAMENTS;
+---------+------------+---------------------+-------------+---------------+--------------------+
| id_paga | id_reserva | data_paga           | import_paga | metode_paga   | concepte_paga      |
+---------+------------+---------------------+-------------+---------------+--------------------+
|       1 |          1 | 2026-04-29 09:55:54 |      100.00 | targeta       | Paga i senyal      |
|       2 |          1 | 2026-04-29 09:55:54 |      206.90 | targeta       | Pagament final     |
|       3 |          3 | 2026-04-29 09:55:54 |      300.00 | transferencia | Reserva confirmada |
|       4 |          4 | 2026-04-29 09:55:54 |      143.00 | efectiu       | Pagament complet   |
|       6 |          2 | 2026-05-07 07:52:47 |      100.00 | bizum         | Pagament parcial   |
|       7 |          1 | 2026-05-13 10:01:38 |      100.00 | bizum         | Pagament reserva   |
|       8 |          4 | 2026-05-13 10:10:08 |      100.00 | bizum         | Pagament reserva   |
|       9 |          1 | 2026-05-13 10:16:32 |      100.00 | efectiu       | Pagament reserva   |
+---------+------------+---------------------+-------------+---------------+--------------------+
8 rows in set (0.00 sec)

mysql> SELECT * FROM RESERVES;
+------------+-----------+--------------+--------------------+-------------------+----------------+----------------+------------------+------------------+------------------------+-------------------------+-----------------+-----------------+--------------------+-----------------+-----------------+-----------------+---------------------+----------------------+
| id_reserva | id_client | id_habitacio | data_entra_reserva | data_surt_reserva | adults_reserva | menors_reserva | en_estat_reserva | preu_nit_reserva | quantitat_nits_reserva | subtotal_estada_reserva | per_dte_reserva | imp_dte_reserva | imp_servei_reserva | per_iva_reserva | imp_iva_reserva | imp_tot_reserva | data_crea_reserva   | obser_reserva        |
+------------+-----------+--------------+--------------------+-------------------+----------------+----------------+------------------+------------------+------------------------+-------------------------+-----------------+-----------------+--------------------+-----------------+-----------------+-----------------+---------------------+----------------------+
|          1 |         1 |            2 | 2026-05-10         | 2026-05-13        |              2 |              0 | confirmada       |            85.00 |                      3 |                  255.00 |               0 |            0.00 |              24.00 |              10 |           27.90 |          306.90 | 2026-04-29 09:55:54 | Cap de setmana llarg |
|          2 |         2 |            4 | 2026-07-02         | 2026-07-07        |              2 |              1 | confirmada       |           137.50 |                      5 |                  687.50 |              10 |           68.75 |              75.00 |              10 |           69.38 |          763.13 | 2026-04-29 09:55:54 | Reserva d’estiu    |
|          3 |         3 |            6 | 2026-08-15         | 2026-08-18        |              2 |              0 | confirmada       |           275.00 |                      3 |                  825.00 |               5 |           41.25 |              50.00 |              10 |           83.38 |          917.13 | 2026-04-29 09:55:54 | Aniversari           |
|          4 |         4 |            1 | 2026-04-28         | 2026-04-30        |              1 |              0 | confirmada       |            55.00 |                      2 |                  110.00 |               0 |            0.00 |              20.00 |              10 |           13.00 |          143.00 | 2026-04-29 09:55:54 | NULL                 |
+------------+-----------+--------------+--------------------+-------------------+----------------+----------------+------------------+------------------+------------------------+-------------------------+-----------------+-----------------+--------------------+-----------------+-----------------+-----------------+---------------------+----------------------+
4 rows in set (0.00 sec)

mysql>



```

---

## Trigger: `trg_validar_import`

### Explicació de què fa el trigger `trg_validar_import`

Este trigger se ejecuta *antes* de que se intente hacer una inserción (`BEFORE INSERT`) en la tabla `PAGAMENTS`. Comprueba que el valor introducido sea positivo; si el importe es 0 o negativo, detiene la operación y lanza un mensaje de error para proteger la integridad de los datos.

### Comanda creació trigger

```sql
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
 ...


```

### Sortida de la comanda `CREATE TRIGGER`

```sql

DELIMITER $$

mysql> DELIMITER $$
mysql>
mysql> CREATE TRIGGER trg_validar_import
    -> BEFORE INSERT
    -> ON PAGAMENTS
    -> FOR EACH ROW
    -> BEGIN
    ->     IF NEW.import_paga <= 0 THEN
    ->         SIGNAL SQLSTATE '45000'
    ->         SET MESSAGE_TEXT = 'L''import del pagament ha de ser positiu';
    ->     END IF;
    -> END $$
Query OK, 0 rows affected (0.02 sec)

mysql>
mysql> DELIMITER ;
mysql>


```

### Demostració de que el trigger `trg_validar_import` funciona

Verificamos el número total de pagos antes de causar el error intencional. Observamos que tenemos 8 registros válidos.

### Comanda a executar

```sql
SELECT *
FROM RESERVES;

...

SELECT *
FROM PAGAMENTS;

```

### Sortida de la comanda executada

```sql

mysql> SELECT *
    -> FROM PAGAMENTS;
+---------+------------+---------------------+-------------+---------------+--------------------+
| id_paga | id_reserva | data_paga           | import_paga | metode_paga   | concepte_paga      |
+---------+------------+---------------------+-------------+---------------+--------------------+
|       1 |          1 | 2026-04-29 09:55:54 |      100.00 | targeta       | Paga i senyal      |
|       2 |          1 | 2026-04-29 09:55:54 |      206.90 | targeta       | Pagament final     |
|       3 |          3 | 2026-04-29 09:55:54 |      300.00 | transferencia | Reserva confirmada |
|       4 |          4 | 2026-04-29 09:55:54 |      143.00 | efectiu       | Pagament complet   |
|       6 |          2 | 2026-05-07 07:52:47 |      100.00 | bizum         | Pagament parcial   |
|       7 |          1 | 2026-05-13 10:01:38 |      100.00 | bizum         | Pagament reserva   |
|       8 |          4 | 2026-05-13 10:10:08 |      100.00 | bizum         | Pagament reserva   |
|       9 |          1 | 2026-05-13 10:16:32 |      100.00 | efectiu       | Pagament reserva   |
+---------+------------+---------------------+-------------+---------------+--------------------+
8 rows in set (0.00 sec)

mysql> SELECT *
    -> FROM RESERVES;
+------------+-----------+--------------+--------------------+-------------------+----------------+----------------+------------------+------------------+------------------------+-------------------------+-----------------+-----------------+--------------------+-----------------+-----------------+-----------------+---------------------+----------------------+
| id_reserva | id_client | id_habitacio | data_entra_reserva | data_surt_reserva | adults_reserva | menors_reserva | en_estat_reserva | preu_nit_reserva | quantitat_nits_reserva | subtotal_estada_reserva | per_dte_reserva | imp_dte_reserva | imp_servei_reserva | per_iva_reserva | imp_iva_reserva | imp_tot_reserva | data_crea_reserva   | obser_reserva        |
+------------+-----------+--------------+--------------------+-------------------+----------------+----------------+------------------+------------------+------------------------+-------------------------+-----------------+-----------------+--------------------+-----------------+-----------------+-----------------+---------------------+----------------------+
|          1 |         1 |            2 | 2026-05-10         | 2026-05-13        |              2 |              0 | pendent          |            85.00 |                      3 |                  255.00 |               0 |            0.00 |              24.00 |              10 |           27.90 |          306.90 | 2026-04-29 09:55:54 | Cap de setmana llarg |
|          2 |         2 |            4 | 2026-07-02         | 2026-07-07        |              2 |              1 | confirmada       |           137.50 |                      5 |                  687.50 |              10 |           68.75 |              75.00 |              10 |           69.38 |          763.13 | 2026-04-29 09:55:54 | Reserva d’estiu    |
|          3 |         3 |            6 | 2026-08-15         | 2026-08-18        |              2 |              0 | confirmada       |           275.00 |                      3 |                  825.00 |               5 |           41.25 |              50.00 |              10 |           83.38 |          917.13 | 2026-04-29 09:55:54 | Aniversari           |
|          4 |         4 |            1 | 2026-04-28         | 2026-04-30        |              1 |              0 | confirmada       |            55.00 |                      2 |                  110.00 |               0 |            0.00 |              20.00 |              10 |           13.00 |          143.00 | 2026-04-29 09:55:54 | NULL                 |
+------------+-----------+--------------+--------------------+-------------------+----------------+----------------+------------------+------------------+------------------------+-------------------------+-----------------+-----------------+--------------------+-----------------+-----------------+-----------------+---------------------+----------------------+
4 rows in set (0.00 sec)

mysql>



```

### Comanda a executar per activar el trigger `trg_validar_import`

Para probar el trigger, introducimos un valor inválido (`-100`) en la columna `import_paga`. Esto activará la comprobación del bloque `BEFORE INSERT`.

### Comanda a executar

```sql
INSERT INTO PAGAMENTS (
    id_reserva,
    import_paga,
    metode_paga
    ) VALUES (
        1,
        -100,
        'targeta'
    );
...

```

### Sortida de la comanda executada

```sql
mysql> INSERT INTO PAGAMENTS (
    ->     id_reserva,
    ->     import_paga,
    ->     metode_paga
    ->     ) VALUES (
    ->         1,
    ->         -100,
    ->         'targeta'
    ->     );
ERROR 1644 (45000): L'import del pagament ha de ser positiu
mysql>


```

### Comanda a executar per veure que s'activat el trigger `trg_validar_import`

Como el `INSERT` fue bloqueado por el trigger, consultamos la tabla para asegurarnos de que el registro erróneo no se guardó. Seguimos teniendo solo 8 registros.

### Comanda a executar

```sql
SELECT *
FROM RESERVES;

...

SELECT *
FROM PAGAMENTS;
...

```

### Sortida de la comanda executada

```sql
mysql> SELECT *
    -> FROM RESERVES;
+------------+-----------+--------------+--------------------+-------------------+----------------+----------------+------------------+------------------+------------------------+-------------------------+-----------------+-----------------+--------------------+-----------------+-----------------+-----------------+---------------------+----------------------+
| id_reserva | id_client | id_habitacio | data_entra_reserva | data_surt_reserva | adults_reserva | menors_reserva | en_estat_reserva | preu_nit_reserva | quantitat_nits_reserva | subtotal_estada_reserva | per_dte_reserva | imp_dte_reserva | imp_servei_reserva | per_iva_reserva | imp_iva_reserva | imp_tot_reserva | data_crea_reserva   | obser_reserva        |
+------------+-----------+--------------+--------------------+-------------------+----------------+----------------+------------------+------------------+------------------------+-------------------------+-----------------+-----------------+--------------------+-----------------+-----------------+-----------------+---------------------+----------------------+
|          1 |         1 |            2 | 2026-05-10         | 2026-05-13        |              2 |              0 | pendent          |            85.00 |                      3 |                  255.00 |               0 |            0.00 |              24.00 |              10 |           27.90 |          306.90 | 2026-04-29 09:55:54 | Cap de setmana llarg |
|          2 |         2 |            4 | 2026-07-02         | 2026-07-07        |              2 |              1 | confirmada       |           137.50 |                      5 |                  687.50 |              10 |           68.75 |              75.00 |              10 |           69.38 |          763.13 | 2026-04-29 09:55:54 | Reserva d’estiu    |
|          3 |         3 |            6 | 2026-08-15         | 2026-08-18        |              2 |              0 | confirmada       |           275.00 |                      3 |                  825.00 |               5 |           41.25 |              50.00 |              10 |           83.38 |          917.13 | 2026-04-29 09:55:54 | Aniversari           |
|          4 |         4 |            1 | 2026-04-28         | 2026-04-30        |              1 |              0 | confirmada       |            55.00 |                      2 |                  110.00 |               0 |            0.00 |              20.00 |              10 |           13.00 |          143.00 | 2026-04-29 09:55:54 | NULL                 |
+------------+-----------+--------------+--------------------+-------------------+----------------+----------------+------------------+------------------+------------------------+-------------------------+-----------------+-----------------+--------------------+-----------------+-----------------+-----------------+---------------------+----------------------+
4 rows in set (0.00 sec)

mysql> SELECT *
    -> FROM PAGAMENTS;
+---------+------------+---------------------+-------------+---------------+--------------------+
| id_paga | id_reserva | data_paga           | import_paga | metode_paga   | concepte_paga      |
+---------+------------+---------------------+-------------+---------------+--------------------+
|       1 |          1 | 2026-04-29 09:55:54 |      100.00 | targeta       | Paga i senyal      |
|       2 |          1 | 2026-04-29 09:55:54 |      206.90 | targeta       | Pagament final     |
|       3 |          3 | 2026-04-29 09:55:54 |      300.00 | transferencia | Reserva confirmada |
|       4 |          4 | 2026-04-29 09:55:54 |      143.00 | efectiu       | Pagament complet   |
|       6 |          2 | 2026-05-07 07:52:47 |      100.00 | bizum         | Pagament parcial   |
|       7 |          1 | 2026-05-13 10:01:38 |      100.00 | bizum         | Pagament reserva   |
|       8 |          4 | 2026-05-13 10:10:08 |      100.00 | bizum         | Pagament reserva   |
|       9 |          1 | 2026-05-13 10:16:32 |      100.00 | efectiu       | Pagament reserva   |
+---------+------------+---------------------+-------------+---------------+--------------------+
8 rows in set (0.00 sec)

mysql>


```

---

## Trigger: `trg_log_pagaments`

### Explicació de què fa el trigger `trg_log_pagaments`

Este trigger guarda automáticamente un historial de todas las transacciones. Al insertarse un nuevo cobro en `PAGAMENTS`, el trigger copia sus datos (ID de la reserva y el importe) en la tabla `log_pagaments`, creando además un mensaje de texto automático.

### Comanda creació trigger

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
 ...


```

### Sortida de la comanda `CREATE TRIGGER`

```sql
mysql> CREATE TRIGGER trg_log_pagaments
    -> AFTER INSERT
    -> ON PAGAMENTS
    -> FOR EACH ROW
    -> BEGIN
    ->     INSERT INTO log_pagaments (
    ->         id_reserva,
    ->         import_pagament,
    ->         missatge
    ->     )
    ->     VALUES (
    ->         NEW.id_reserva,
    ->         NEW.import_paga,
    ->         CONCAT(
    ->             'Nou pagament registrat de ',
    ->             NEW.import_paga,
    ->             ' euros'
    ->         )
    ->     );
    ->
    -> END $$
Query OK, 0 rows affected (0.02 sec)

mysql>
mysql> DELIMITER ;
mysql>


```

### Demostració de que el trigger `trg_log_pagaments` funciona

Para probar el guardado automático de logs, vemos cómo se encuentran ambas tablas (`log_pagaments` y `PAGAMENTS`) antes de la operación.

### Comanda a executar

```sql
SELECT *
FROM log_pagaments;

SELECT *
FROM PAGAMENTS;
...

```

### Sortida de la comanda executada

```sql
    -> FROM log_pagaments;
+--------+------------+-----------------+---------------------+----------------------------------------+
| id_log | id_reserva | import_pagament | data_log            | missatge                               |
+--------+------------+-----------------+---------------------+----------------------------------------+
|      1 |          1 |          100.00 | 2026-05-13 10:01:38 | Nou pagament registrat de 100.00 euros |
|      2 |          4 |          100.00 | 2026-05-13 10:10:08 | Nou pagament registrat de 100.00 euros |
|      3 |          1 |          100.00 | 2026-05-13 10:16:32 | Nou pagament registrat de 100.00 euros |
+--------+------------+-----------------+---------------------+----------------------------------------+
3 rows in set (0.00 sec)

mysql> select * From PAGAMENTS;
+---------+------------+---------------------+-------------+---------------+--------------------+
| id_paga | id_reserva | data_paga           | import_paga | metode_paga   | concepte_paga      |
+---------+------------+---------------------+-------------+---------------+--------------------+
|       1 |          1 | 2026-04-29 09:55:54 |      100.00 | targeta       | Paga i senyal      |
|       2 |          1 | 2026-04-29 09:55:54 |      206.90 | targeta       | Pagament final     |
|       3 |          3 | 2026-04-29 09:55:54 |      300.00 | transferencia | Reserva confirmada |
|       4 |          4 | 2026-04-29 09:55:54 |      143.00 | efectiu       | Pagament complet   |
|       6 |          2 | 2026-05-07 07:52:47 |      100.00 | bizum         | Pagament parcial   |
|       7 |          1 | 2026-05-13 10:01:38 |      100.00 | bizum         | Pagament reserva   |
|       8 |          4 | 2026-05-13 10:10:08 |      100.00 | bizum         | Pagament reserva   |
|       9 |          1 | 2026-05-13 10:16:32 |      100.00 | efectiu       | Pagament reserva   |
+---------+------------+---------------------+-------------+---------------+--------------------+
8 rows in set (0.00 sec)



```

### Comanda a executar per activar el trigger `trg_log_pagaments`

Insertamos de nuevo un pago en `PAGAMENTS` para la reserva 3, con un valor de 200 euros. Esta acción por sí sola deberá lanzar el trigger `trg_log_pagaments`.

### Comanda a executar

```sql
INSERT INTO PAGAMENTS (
    id_reserva,
    import_paga,
    metode_paga
    ) VALUES (
        3,
        200,
        'bizum'
    );
...

```

### Sortida de la comanda executada

```sql
mysql> INSERT INTO PAGAMENTS (
    ->     id_reserva,
    ->     import_paga,
    ->     metode_paga
    ->     ) VALUES (
    ->         3,
    ->         200,
    ->         'bizum'
    ->     );
Query OK, 1 row affected (0.01 sec)

mysql>



```

### Comanda a executar per veure que s'activat el trigger `trg_log_pagaments`

Al revisar el historial y los pagos, observamos que se añadió correctamente la fila con `id_log` 4 a la tabla `log_pagaments`, con el texto autogenerado que incluye el importe de 200 euros.

### Comanda a executar

```sql
SELECT *
FROM log_pagaments;

SELECT *
FROM PAGAMENTS;

...

```

### Sortida de la comanda executada

```sql
mysql> SELECT *
    -> FROM log_pagaments;
+--------+------------+-----------------+---------------------+----------------------------------------+
| id_log | id_reserva | import_pagament | data_log            | missatge                               |
+--------+------------+-----------------+---------------------+----------------------------------------+
|      1 |          1 |          100.00 | 2026-05-13 10:01:38 | Nou pagament registrat de 100.00 euros |
|      2 |          4 |          100.00 | 2026-05-13 10:10:08 | Nou pagament registrat de 100.00 euros |
|      3 |          1 |          100.00 | 2026-05-13 10:16:32 | Nou pagament registrat de 100.00 euros |
|      4 |          3 |          200.00 | 2026-05-13 10:31:11 | Nou pagament registrat de 200.00 euros |
+--------+------------+-----------------+---------------------+----------------------------------------+
4 rows in set (0.00 sec)

mysql>

mysql> SELECT * FROM PAGAMENTS;
+---------+------------+---------------------+-------------+---------------+--------------------+
| id_paga | id_reserva | data_paga           | import_paga | metode_paga   | concepte_paga      |
+---------+------------+---------------------+-------------+---------------+--------------------+
|       1 |          1 | 2026-04-29 09:55:54 |      100.00 | targeta       | Paga i senyal      |
|       2 |          1 | 2026-04-29 09:55:54 |      206.90 | targeta       | Pagament final     |
|       3 |          3 | 2026-04-29 09:55:54 |      300.00 | transferencia | Reserva confirmada |
|       4 |          4 | 2026-04-29 09:55:54 |      143.00 | efectiu       | Pagament complet   |
|       6 |          2 | 2026-05-07 07:52:47 |      100.00 | bizum         | Pagament parcial   |
|       7 |          1 | 2026-05-13 10:01:38 |      100.00 | bizum         | Pagament reserva   |
|       8 |          4 | 2026-05-13 10:10:08 |      100.00 | bizum         | Pagament reserva   |
|       9 |          1 | 2026-05-13 10:16:32 |      100.00 | efectiu       | Pagament reserva   |
|      10 |          3 | 2026-05-13 10:31:11 |      200.00 | bizum         | Pagament reserva   |
+---------+------------+---------------------+-------------+---------------+--------------------+
9 rows in set (0.00 sec)

mysql>


```
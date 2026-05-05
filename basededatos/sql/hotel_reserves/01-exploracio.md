## Taula: CLIENTS

### Comanda
```sql
DESC CLIENTS;
```

### Sortida
```sql
mysql> desc CLIENTS;
+----------------+--------------+------+-----+-------------------+-------------------+
| Field          | Type         | Null | Key | Default           | Extra             |
+----------------+--------------+------+-----+-------------------+-------------------+
| id_client      | int          | NO   | PRI | NULL              | auto_increment    |
| nom_client     | varchar(60)  | NO   |     | NULL              |                   |
| cognoms_client | varchar(100) | NO   |     | NULL              |                   |
| email_client   | varchar(120) | NO   | UNI | NULL              |                   |
| tel_client     | varchar(20)  | YES  |     | NULL              |                   |
| dni_client     | varchar(20)  | NO   | UNI | NULL              |                   |
| data_alta      | datetime     | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| obser_client   | varchar(255) | YES  |     | NULL              |                   |
+----------------+--------------+------+-----+-------------------+-------------------+
8 rows in set (0.00 sec)

```

### Comanda
```sql
SELECT *
FROM CLIENTS;
```

### Sortida
```sql
mysql> SELECT *
    -> FROM CLIENTS;
+-----------+------------+----------------+------------------------+------------+------------+---------------------+-------------------+
| id_client | nom_client | cognoms_client | email_client           | tel_client | dni_client | data_alta           | obser_client      |
+-----------+------------+----------------+------------------------+------------+------------+---------------------+-------------------+
|         1 | Joan       | Serra Puig     | joan.serra@gmail.com   | 600111222  | 72870739T  | 2026-04-29 09:55:54 | Client habitual   |
|         2 | Marta      | Casals Riera   | marta.casals@gmail.com | 600333444  | 72185939W  | 2026-04-29 09:55:54 | NULL              |
|         3 | Pau        | Vidal Costa    | pau.vidal@gmail.com    | 600555666  | 20719618E  | 2026-04-29 09:55:54 | Viatja amb menors |
|         4 | Laia       | Roca Torres    | laia.roca@gmail.com    | 600777888  | 34316289J  | 2026-04-29 09:55:54 | NULL              |
|         5 | Nil        | Ferrer Soler   | nil.ferrer@gmail.com   | 600999000  | 69256903Q  | 2026-04-29 09:55:54 | NULL              |
+-----------+------------+----------------+------------------------+------------+------------+---------------------+-------------------+
5 rows in set (0.00 sec)

```

### Interpretació

- El `id_client` es la primary key.
- El valor `email_client` es único.
- El valor `dni_client` es único.
- Los valores `tel_client` y `obser_client` pueden ser nulos.


## Taula: RESERVES

### Comanda
```sql
DESC RESERVES;
```

### Sortida
```sql
mysql> desc RESERVES;
+-------------------------+-----------------------------------------------------------------+------+-----+-------------------+-------------------+
| Field                   | Type                                                            | Null | Key | Default           | Extra             |
+-------------------------+-----------------------------------------------------------------+------+-----+-------------------+-------------------+
| id_reserva              | int                                                             | NO   | PRI | NULL              | auto_increment    |
| id_client               | int                                                             | NO   | MUL | NULL              |                   |
| id_habitacio            | int                                                             | NO   | MUL | NULL              |                   |
| data_entra_reserva      | date                                                            | NO   |     | NULL              |                   |
| data_surt_reserva       | date                                                            | NO   |     | NULL              |                   |
| adults_reserva          | int                                                             | NO   |     | 1                 |                   |
| menors_reserva          | int                                                             | NO   |     | 0                 |                   |
| en_estat_reserva        | enum('pendent','confirmada','checkin','checkout','cancel_lada') | NO   |     | pendent           |                   |
| preu_nit_reserva        | decimal(10,2)                                                   | YES  |     | NULL              |                   |
| quantitat_nits_reserva  | int                                                             | YES  |     | NULL              |                   |
| subtotal_estada_reserva | decimal(10,2)                                                   | YES  |     | NULL              |                   |
| per_dte_reserva         | int                                                             | NO   |     | 0                 |                   |
| imp_dte_reserva         | decimal(10,2)                                                   | YES  |     | NULL              |                   |
| imp_servei_reserva      | decimal(10,2)                                                   | NO   |     | 0.00              |                   |
| per_iva_reserva         | int                                                             | NO   |     | 10                |                   |
| imp_iva_reserva         | decimal(10,2)                                                   | YES  |     | NULL              |                   |
| imp_tot_reserva         | decimal(10,2)                                                   | YES  |     | NULL              |                   |
| data_crea_reserva       | datetime                                                        | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| obser_reserva           | varchar(255)                                                    | YES  |     | NULL              |                   |
+-------------------------+-----------------------------------------------------------------+------+-----+-------------------+-------------------+
19 rows in set (0.00 sec)

```

### Comanda
```sql
SELECT *
FROM RESERVES;
```

### Sortida
```sql
mysql> select * from RESERVES;
+------------+-----------+--------------+--------------------+-------------------+----------------+----------------+------------------+------------------+------------------------+-------------------------+-----------------+-----------------+--------------------+-----------------+-----------------+-----------------+---------------------+----------------------+
| id_reserva | id_client | id_habitacio | data_entra_reserva | data_surt_reserva | adults_reserva | menors_reserva | en_estat_reserva | preu_nit_reserva | quantitat_nits_reserva | subtotal_estada_reserva | per_dte_reserva | imp_dte_reserva | imp_servei_reserva | per_iva_reserva | imp_iva_reserva | imp_tot_reserva | data_crea_reserva   | obser_reserva        |
+------------+-----------+--------------+--------------------+-------------------+----------------+----------------+------------------+------------------+------------------------+-------------------------+-----------------+-----------------+--------------------+-----------------+-----------------+-----------------+---------------------+----------------------+
|          1 |         1 |            2 | 2026-05-10         | 2026-05-13        |              2 |              0 | confirmada       |            85.00 |                      3 |                  255.00 |               0 |            0.00 |              24.00 |              10 |           27.90 |          306.90 | 2026-04-29 09:55:54 | Cap de setmana llarg |
|          2 |         2 |            4 | 2026-07-02         | 2026-07-07        |              2 |              1 | pendent          |           137.50 |                      5 |                  687.50 |              10 |           68.75 |              75.00 |              10 |           69.38 |          763.13 | 2026-04-29 09:55:54 | Reserva d’estiu      |
|          3 |         3 |            6 | 2026-08-15         | 2026-08-18        |              2 |              0 | confirmada       |           275.00 |                      3 |                  825.00 |               5 |           41.25 |              50.00 |              10 |           83.38 |          917.13 | 2026-04-29 09:55:54 | Aniversari           |
|          4 |         4 |            1 | 2026-04-28         | 2026-04-30        |              1 |              0 | checkout         |            55.00 |                      2 |                  110.00 |               0 |            0.00 |              20.00 |              10 |           13.00 |          143.00 | 2026-04-29 09:55:54 | NULL                 |
+------------+-----------+--------------+--------------------+-------------------+----------------+----------------+------------------+------------------+------------------------+-------------------------+-----------------+-----------------+--------------------+-----------------+-----------------+-----------------+---------------------+----------------------+
4 rows in set (0.00 sec)

```

### Interpretació
- El `id_reserva` es la primary key.
- Los valores `id_client` y `id_habitacio` actúan como claves foráneas.
- El valor `en_estat_reserva` es un ENUM que acepta estados predefinidos y tiene como valor por defecto `pendent`.
- Varios campos relacionados con cálculos económicos (precios, cantidades, subtotales, IVA, importes totales) y observaciones pueden ser nulos.
- El valor `data_crea_reserva` se genera automáticamente con la fecha y hora actuales.


## Taula: HABITACIONS

### Comanda
```sql
DESC HABITACIONS;
```

### Sortida
```sql
mysql> desc HABITACIONS;
+------------------+----------------------------------------------------------+------+-----+------------+----------------+
| Field            | Type                                                     | Null | Key | Default    | Extra          |
+------------------+----------------------------------------------------------+------+-----+------------+----------------+
| id_habitacio     | int                                                      | NO   | PRI | NULL       | auto_increment |
| num_habitacio    | varchar(10)                                              | NO   | UNI | NULL       |                |
| planta_habitacio | int                                                      | NO   |     | NULL       |                |
| id_tipus_hab     | int                                                      | NO   | MUL | NULL       |                |
| estat_habitacio  | enum('disponible','ocupada','manteniment','fora_servei') | NO   |     | disponible |                |
| obser_hab        | varchar(255)                                             | YES  |     | NULL       |                |
+------------------+----------------------------------------------------------+------+-----+------------+----------------+
6 rows in set (0.01 sec)
```

### Comanda
```sql
SELECT *
FROM HABITACIONS;
```

### Sortida
```sql
mysql> SELECT *
    -> FROM HABITACIONS;
+--------------+---------------+------------------+--------------+-----------------+---------------------------+
| id_habitacio | num_habitacio | planta_habitacio | id_tipus_hab | estat_habitacio | obser_hab                 |
+--------------+---------------+------------------+--------------+-----------------+---------------------------+
|            1 | 101           |                1 |            1 | disponible      | NULL                      |
|            2 | 102           |                1 |            2 | disponible      | NULL                      |
|            3 | 103           |                1 |            2 | manteniment     | Revisió aire condicionat  |
|            4 | 201           |                2 |            3 | disponible      | NULL                      |
|            5 | 202           |                2 |            4 | disponible      | NULL                      |
|            6 | 301           |                3 |            5 | disponible      | Vistes al mar             |
+--------------+---------------+------------------+--------------+-----------------+---------------------------+
6 rows in set (0.00 sec)
```

### Interpretació
- El `id_habitacio` es la primary key.
- El valor `num_habitacio` es único.
- El valor `id_tipus_hab` es una clave foránea.
- El valor `estat_habitacio` es un ENUM que por defecto se asigna como `disponible`.
- El valor `obser_hab` puede ser nulo.


## Taula: PAGAMENTS

### Comanda
```sql
DESC PAGAMENTS;
```

### Sortida
```sql
mysql> desc PAGAMENTS;
+---------------+---------------------------------------------------+------+-----+-------------------+-------------------+
| Field         | Type                                              | Null | Key | Default           | Extra             |
+---------------+---------------------------------------------------+------+-----+-------------------+-------------------+
| id_paga       | int                                               | NO   | PRI | NULL              | auto_increment    |
| id_reserva    | int                                               | NO   | MUL | NULL              |                   |
| data_paga     | datetime                                          | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| import_paga   | decimal(10,2)                                     | NO   |     | NULL              |                   |
| metode_paga   | enum('targeta','efectiu','transferencia','bizum') | NO   |     | NULL              |                   |
| concepte_paga | varchar(120)                                      | NO   |     | Pagament reserva  |                   |
+---------------+---------------------------------------------------+------+-----+-------------------+-------------------+
6 rows in set (0.01 sec)
```

### Comanda
```sql
SELECT *
FROM PAGAMENTS;
```

### Sortida
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
+---------+------------+---------------------+-------------+---------------+--------------------+
4 rows in set (0.00 sec)
```

### Interpretació
- El `id_paga` es la primary key.
- El valor `id_reserva` es una clave foránea.
- El valor `metode_paga` es un ENUM de cuatro opciones.
- El valor `data_paga` se autocompleta con el la fecha de cuando se hace el pago.
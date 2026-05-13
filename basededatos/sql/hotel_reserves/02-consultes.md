## Tasca 6

### Enunciat: Mostrar reserves confirmades amb pendent

### Comanda solució

```sql
SELECT 
    p.id_reserva,
    p.Client,
    p.imp_tot_reserva,
    p.`Total Pagat`,
    p.`Pendent Pagament`,
    res.`Estat Reserva`
FROM v_pagaments_reserva p
JOIN v_resum_reserves res 
    ON p.id_reserva = res.id_reserva
WHERE res.`Estat Reserva` = 'confirmada'
  AND p.`Pendent Pagament` > 0
ORDER BY p.`Pendent Pagament` DESC;
```

### Sortida

```sql
mysql> SELECT
    ->     p.id_reserva,
    ->     p.Client,
    ->     p.imp_tot_reserva,
    ->     p.`Total Pagat`,
    ->     p.`Pendent Pagament`,
    ->     res.`Estat Reserva`
    -> FROM v_pagaments_reserva p
    -> JOIN v_resum_reserves res
    ->     ON p.id_reserva = res.id_reserva
    -> WHERE res.`Estat Reserva` = 'confirmada'
    ->   AND p.`Pendent Pagament` > 0
    -> ORDER BY p.`Pendent Pagament` DESC;
+------------+-----------------+-----------------+-------------+------------------+---------------+
| id_reserva | Client          | imp_tot_reserva | Total Pagat | Pendent Pagament | Estat reserva |
+------------+-----------------+-----------------+-------------+------------------+---------------+
|          3 | Pau Vidal Costa |          917.13 |      300.00 |           617.13 | confirmada    |
+------------+-----------------+-----------------+-------------+------------------+---------------+
1 row in set (0.02 sec)

mysql>
```

## Tasca 7

### Enunciat: Mostrar el client que deu més diners

### Comanda solució

```sql
SELECT *
FROM v_pagaments_reserva p
WHERE p.`Pendent Pagament` > 0
ORDER BY p.`Pendent Pagament` DESC
LIMIT 1;
```

### Sortida

```sql
mysql> SELECT *
    -> FROM v_pagaments_reserva p
    -> WHERE p.`Pendent Pagament` > 0
    -> ORDER BY p.`Pendent Pagament` DESC
    -> LIMIT 1;
+------------+--------------------+-----------------+-------------+------------------+
| id_reserva | Client             | imp_tot_reserva | Total pagat | Pendent Pagament |
+------------+--------------------+-----------------+-------------+------------------+
|          2 | Marta Casals Riera |          763.13 |        0.00 |           763.13 |
+------------+--------------------+-----------------+-------------+------------------+
1 row in set (0.01 sec)

mysql>
```

## Tasca 8

### Enunciat: Mostrar reserves amb més de 3 nits

### Comanda solució

```sql
SELECT *
FROM v_resum_reserves 
WHERE `# nits` > 3;
```

### Sortida

```sql
mysql> SELECT *
    -> FROM v_resum_reserves
    -> WHERE `# nits` > 3;
+------------+--------------------+------------+----------------+------------+------------+--------+---------------+--------------+
| id_reserva | Client             | Habitació | Tipus          | Data entr. | Data surt. | # nits | Estat reserva | Import total |
+------------+--------------------+------------+----------------+------------+------------+--------+---------------+--------------+
|          2 | Marta Casals Riera | 201        | Doble superior | 2026-07-02 | 2026-07-07 |      5 | pendent       |       763.13 |
+------------+--------------------+------------+----------------+------------+------------+--------+---------------+--------------+
1 row in set (0.01 sec)

mysql>
```

## Tasca 9

### Enunciat: Mostrar reserves en estat pendent

### Comanda solució

```sql
SELECT *
FROM v_resum_reserves 
WHERE `Estat reserva` = 'pendent';
```

### Sortida

```sql
mysql> SELECT *
    -> FROM v_resum_reserves
    -> WHERE `Estat reserva` = 'pendent';
+------------+--------------------+------------+----------------+------------+------------+--------+---------------+--------------+
| id_reserva | Client             | Habitació | Tipus          | Data entr. | Data surt. | # nits | Estat reserva | Import total |
+------------+--------------------+------------+----------------+------------+------------+--------+---------------+--------------+
|          2 | Marta Casals Riera | 201        | Doble superior | 2026-07-02 | 2026-07-07 |      5 | pendent       |       763.13 |
+------------+--------------------+------------+----------------+------------+------------+--------+---------------+--------------+
1 row in set (0.00 sec)

mysql>
```

## Tasca 10

### Enunciat: Mostrar reserves amb import superior a 500€

### Comanda solució

```sql
SELECT *
FROM v_resum_reserves 
WHERE `Import total` > 500;
```

### Sortida

```sql
mysql> SELECT *
    -> FROM v_resum_reserves
    -> WHERE `Import total` > 500;
+------------+--------------------+------------+----------------+------------+------------+--------+---------------+--------------+
| id_reserva | Client             | Habitació | Tipus          | Data entr. | Data surt. | # nits | Estat reserva | Import total |
+------------+--------------------+------------+----------------+------------+------------+--------+---------------+--------------+
|          2 | Marta Casals Riera | 201        | Doble superior | 2026-07-02 | 2026-07-07 |      5 | pendent       |       763.13 |
|          3 | Pau Vidal Costa    | 301        | Suite          | 2026-08-15 | 2026-08-18 |      3 | confirmada    |       917.13 |
+------------+--------------------+------------+----------------+------------+------------+--------+---------------+--------------+
2 rows in set (0.01 sec)

mysql>
```

## Tasca 11

### Enunciat: Mostrar totes les reserves ordenades per data d’entrada

### Comanda solució

```sql
SELECT *
FROM v_resum_reserves 
ORDER BY `Data entr.` ASC;
```

### Sortida

```sql
mysql> SELECT *
    -> FROM v_resum_reserves
    -> ORDER BY `Data entr.` ASC;
+------------+--------------------+------------+----------------+------------+------------+--------+---------------+--------------+
| id_reserva | Client             | Habitació | Tipus          | Data entr. | Data surt. | # nits | Estat reserva | Import total |
+------------+--------------------+------------+----------------+------------+------------+--------+---------------+--------------+
|          4 | Laia Roca Torres   | 101        | Individual     | 2026-04-28 | 2026-04-30 |      2 | checkout      |       143.00 |
|          1 | Joan Serra Puig    | 102        | Doble          | 2026-05-10 | 2026-05-13 |      3 | confirmada    |       306.90 |
|          2 | Marta Casals Riera | 201        | Doble superior | 2026-07-02 | 2026-07-07 |      5 | pendent       |       763.13 |
|          3 | Pau Vidal Costa    | 301        | Suite          | 2026-08-15 | 2026-08-18 |      3 | confirmada    |       917.13 |
+------------+--------------------+------------+----------------+------------+------------+--------+---------------+--------------+
4 rows in set (0.00 sec)

mysql>
```

## Tasca 12

### Enunciat: Mostrar només el nom del client i el pendent

### Comanda solució

```sql
SELECT Client, `Pendent pagament`
FROM v_pagaments_reserva;
```

### Sortida

```sql
mysql> SELECT Client, `Pendent pagament`
    -> FROM v_pagaments_reserva;
+--------------------+------------------+
| Client             | Pendent pagament |
+--------------------+------------------+
| Joan Serra Puig    |             0.00 |
| Marta Casals Riera |           763.13 |
| Pau Vidal Costa    |           617.13 |
| Laia Roca Torres   |             0.00 |
+--------------------+------------------+
4 rows in set (0.01 sec)

mysql>
```

## Tasca 13

### Enunciat: Mostrar el total de reserves amb pendent

### Comanda solució

```sql
SELECT COUNT(`Pendent Pagament`)
FROM v_pagaments_reserva
WHERE `Pendent Pagament` > 0;

```

### Sortida

```sql
mysql> SELECT COUNT(`Pendent Pagament`)
    -> FROM v_pagaments_reserva
    -> WHERE `Pendent Pagament` > 0;
+---------------------------+
| COUNT(`Pendent Pagament`) |
+---------------------------+
|                         2 |
+---------------------------+
1 row in set (0.00 sec)

mysql>
```

## Tasca 14

### Enunciat: Mostrar el total de diners pendents (SUM)

### Comanda solució

```sql
SELECT SUM(`Pendent pagament`)
FROM v_pagaments_reserva;

```

### Sortida

```sql
mysql> SELECT SUM(`Pendent pagament`)
    -> FROM v_pagaments_reserva;
+-------------------------+
| SUM(`Pendent pagament`) |
+-------------------------+
|                 1380.26 |
+-------------------------+
1 row in set (0.01 sec)

mysql>
```

## Tasca 15

### Enunciat: Quin client ha pagat més diners en total?

### Comanda solució

```sql
SELECT Client,
    `Total pagat` as total_pagat
FROM v_pagaments_reserva
ORDER BY total_pagat DESC
LIMIT 1;
```

### Sortida

```sql
mysql> SELECT Client,
    ->     `Total pagat` as total_pagat
    -> FROM v_pagaments_reserva
    -> ORDER BY total_pagat DESC
    -> LIMIT 1;
+-----------------+-------------+
| Client          | total_pagat |
+-----------------+-------------+
| Joan Serra Puig |      306.90 |
+-----------------+-------------+
1 row in set (0.01 sec)

mysql>
```
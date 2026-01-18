# Exercicis SQL (70 enunciats)

## Ex 1
**Enunciat:** Llista el nom de tots els clients.

**Sortida:**

| NomClient            |
|:---------------------|
| Cafès Ribas          |
| Cooperativa Mataró   |
| Serra i Fills        |
| Aliments Font        |
| Cooperativa Reus     |
| Aliments Miró        |
| Cooperativa Terrassa |
| Cooperativa Bilbao   |
| Serra Logística      |
| Aliments Casas       |
| Pujol Logística      |
| Pons Distribucions   |

_(Mostrant 12 de 90 files)_

---

## Ex 2
**Enunciat:** Llista el nom i el país de tots els clients.

**Sortida:**

| NomClient            | País    |
|:---------------------|:--------|
| Cafès Ribas          | Espanya |
| Cooperativa Mataró   | Espanya |
| Serra i Fills        | Espanya |
| Aliments Font        | Espanya |
| Cooperativa Reus     | Espanya |
| Aliments Miró        | Espanya |
| Cooperativa Terrassa | Espanya |
| Cooperativa Bilbao   | Espanya |
| Serra Logística      | Espanya |
| Aliments Casas       | Espanya |
| Pujol Logística      | Espanya |
| Pons Distribucions   | Espanya |

_(Mostrant 12 de 90 files)_

---

## Ex 3
**Enunciat:** Mostra totes les columnes de la taula Productes.

**Sortida:**

|   IdProducte | NomProducte                    |   IdProveidor |   IdCategoria | Unitat                |   Preu |
|-------------:|:-------------------------------|--------------:|--------------:|:----------------------|-------:|
|            1 | Pernil curat Raval             |             1 |             6 | 24 bosses de 1 kg     |  54.9  |
|            2 | Pasta espagueti artesà         |             1 |             5 | 10 unitats            |   2.5  |
|            3 | Iogurt natural eco             |             2 |             4 | 24 ampolles de 500 ml |  77.32 |
|            4 | Pomes Golden selecció          |             2 |             8 | 10 pots de 250 g      |  33.27 |
|            5 | Refresc de taronja Mediterrani |             3 |             1 | 20 pots de 250 g      |  79.25 |
|            6 | Quinoa                         |             3 |             5 | 24 bosses de 1 kg     |  30.46 |
|            7 | Kefir                          |             3 |             4 | 20 unitats            |  38.94 |
|            8 | Bacallà dessalat Montseny      |             4 |             7 | 6 pots de 250 g       |  38.64 |
|            9 | Cupcakes Mediterrani           |             4 |             3 | 12 caixes x 12        |  37.6  |
|           10 | Pomes Golden                   |             4 |             8 | 12 bosses de 1 kg     |  33.03 |
|           11 | Infusió de camamilla           |             5 |             1 | 6 pots de 250 g       |  36.41 |
|           12 | Torró d'avellana               |             5 |             3 | 24 unitats            |  77.24 |

_(Mostrant 12 de 120 files)_

---

## Ex 4
**Enunciat:** Mostra els primers 10 clients (amb LIMIT).

**Sortida:**

|   IdClient | NomClient            | NomContacte   | Adreça                 | Ciutat    |   CodiPostal | País    |
|-----------:|:---------------------|:--------------|:-----------------------|:----------|-------------:|:--------|
|          1 | Cafès Ribas          | Marta Font    | Avinguda Sant Pere, 38 | Reus      |        43201 | Espanya |
|          2 | Cooperativa Mataró   | Núria Prat    | Carrer Major, 179      | Mataró    |        08301 | Espanya |
|          3 | Serra i Fills        | Laura Puig    | Plaça de València, 62  | Lleida    |        25001 | Espanya |
|          4 | Aliments Font        | Clara Prat    | Passeig Marina, 70     | Barcelona |        08001 | Espanya |
|          5 | Cooperativa Reus     | Núria Soler   | Passeig Marina, 164    | Reus      |        43201 | Espanya |
|          6 | Aliments Miró        | Anna Puig     | Avinguda Major, 184    | Sabadell  |        08201 | Espanya |
|          7 | Cooperativa Terrassa | Joan Serra    | Carrer de València, 61 | Terrassa  |        08221 | Espanya |
|          8 | Cooperativa Bilbao   | Joan Serra    | Avinguda Gran Via, 41  | Bilbao    |        48001 | Espanya |
|          9 | Serra Logística      | Clara Pons    | Passeig de Gràcia, 78  | Girona    |        17001 | Espanya |
|         10 | Aliments Casas       | Joan Miró     | Plaça de València, 140 | Sevilla   |        41001 | Espanya |

---

## Ex 5
**Enunciat:** Mostra els 5 primers productes ordenats pel preu ascendent.

**Sortida:**

|   IdProducte | NomProducte            |   Preu |
|-------------:|:-----------------------|-------:|
|            2 | Pasta espagueti artesà |   2.5  |
|           84 | Ketchup                |   5.7  |
|          113 | Ketchup Delta          |   5.7  |
|           48 | Cuscús integral        |   5.75 |
|           53 | Tonyina en oli artesà  |   7.35 |

---

## Ex 6
**Enunciat:** Llista tots els països diferents on hi ha clients.

**Sortida:**

| País          |
|:--------------|
| Alemanya      |
| Espanya       |
| Estats Units  |
| França        |
| Itàlia        |
| Països Baixos |
| Portugal      |
| Regne Unit    |
| Suècia        |
| Suïssa        |
| Àustria       |

---

## Ex 7
**Enunciat:** Llista totes les ciutats diferents de clients a Espanya.

**Sortida:**

| Ciutat     |
|:-----------|
| A Corunya  |
| Badalona   |
| Barcelona  |
| Bilbao     |
| Còrdova    |
| Figueres   |
| Girona     |
| Granollers |
| Lleida     |
| Madrid     |
| Manresa    |
| Mataró     |

_(Mostrant 12 de 20 files)_

---

## Ex 8
**Enunciat:** Mostra productes amb preu superior a 50.

**Sortida:**

|   IdProducte | NomProducte                    |   Preu |
|-------------:|:-------------------------------|-------:|
|            1 | Pernil curat Raval             |  54.9  |
|            3 | Iogurt natural eco             |  77.32 |
|            5 | Refresc de taronja Mediterrani |  79.25 |
|           12 | Torró d'avellana               |  77.24 |
|           20 | Kefir                          |  61.74 |
|           25 | Iogurt natural                 |  53.68 |
|           27 | Llet sencera clàssic           |  72.86 |
|           30 | Caramels de mel eco            |  77.47 |
|           31 | Cereals de blat                |  77.08 |
|           32 | Kefir Cristall                 |  73.89 |
|           33 | Sardines en llauna artesà      |  65.87 |
|           35 | Pomes Golden intens            |  56    |

_(Mostrant 12 de 40 files)_

---

## Ex 9
**Enunciat:** Mostra productes amb preu entre 10 i 20.

**Sortida:**

|   IdProducte | NomProducte               |   Preu |
|-------------:|:--------------------------|-------:|
|           19 | Cupcakes Raval            |  12.01 |
|           22 | Enciams variats Fontdelpi |  18.48 |
|           42 | Refresc de taronja        |  18.39 |
|           44 | Salmó fumat               |  19.57 |
|           50 | Llet sencera Bravamar     |  13.36 |
|           52 | Enciams variats Cristall  |  14.56 |
|           61 | Cuscús integral suau      |  15.45 |
|           69 | Roast beef tallat         |  10.74 |
|           74 | Mató artesà               |  13.25 |
|           77 | Farina de força           |  14.4  |
|           80 | Xoriço picant             |  17.65 |
|           86 | Mousse de xocolata        |  16.41 |

_(Mostrant 12 de 16 files)_

---

## Ex 10
**Enunciat:** Mostra clients d'Espanya que siguin de Barcelona o Girona.

**Sortida:**

| NomClient          | Ciutat    | País    |
|:-------------------|:----------|:--------|
| Aliments Font      | Barcelona | Espanya |
| Serra Logística    | Girona    | Espanya |
| Pons Distribucions | Girona    | Espanya |
| Cooperativa Girona | Girona    | Espanya |
| Aliments Ferrer    | Girona    | Espanya |
| Cooperativa Girona | Girona    | Espanya |
| Mercats Girona     | Girona    | Espanya |
| Ribas Logística    | Barcelona | Espanya |
| Pujol i Fills      | Girona    | Espanya |

---

## Ex 11
**Enunciat:** Mostra productes que NO siguin de la categoria 1 ni 2.

**Sortida:**

|   IdProducte | NomProducte               |   IdCategoria |
|-------------:|:--------------------------|--------------:|
|            1 | Pernil curat Raval        |             6 |
|            2 | Pasta espagueti artesà    |             5 |
|            3 | Iogurt natural eco        |             4 |
|            4 | Pomes Golden selecció     |             8 |
|            6 | Quinoa                    |             5 |
|            7 | Kefir                     |             4 |
|            8 | Bacallà dessalat Montseny |             7 |
|            9 | Cupcakes Mediterrani      |             3 |
|           10 | Pomes Golden              |             8 |
|           12 | Torró d'avellana          |             3 |
|           13 | Pernil curat gurmet       |             6 |
|           14 | Cupcakes Empordà          |             3 |

_(Mostrant 12 de 87 files)_

---

## Ex 12
**Enunciat:** Mostra comandes fetes a partir de 2023-01-01.

**Sortida:**

|   IdComanda |   IdClient | DataComanda   |
|------------:|-----------:|:--------------|
|       14023 |         56 | 2023-01-05    |
|       14055 |         26 | 2023-01-16    |
|       14092 |         62 | 2023-01-20    |
|       14127 |         88 | 2023-01-28    |
|       14021 |         84 | 2023-02-06    |
|       14156 |         63 | 2023-02-07    |
|       14029 |         55 | 2023-02-20    |
|       14020 |         56 | 2023-02-28    |
|       14067 |         11 | 2023-03-12    |
|       14105 |         44 | 2023-03-18    |
|       14158 |         32 | 2023-03-19    |
|       14040 |         49 | 2023-03-23    |

_(Mostrant 12 de 87 files)_

---

## Ex 13
**Enunciat:** Mostra empleats amb la foto NULL.

**Sortida:**

|   IdEmpleat | Cognom   | Nom   | Foto   |
|------------:|:---------|:------|:-------|
|           1 | Puig     | Anna  |        |
|           2 | Soler    | Jordi |        |
|           3 | Ferrer   | Marta |        |
|           4 | Vila     | Oriol |        |
|           5 | Prats    | Clara |        |
|           6 | Riera    | Sergi |        |
|           7 | Pons     | Laia  |        |
|           8 | Font     | Marc  |        |
|           9 | Casals   | Núria |        |
|          10 | Miró     | Pere  |        |

---

## Ex 14
**Enunciat:** Mostra empleats on la nota (Notes) no és NULL.

**Sortida:**

|   IdEmpleat | Cognom   | Nom   | Notes                  |
|------------:|:---------|:------|:-----------------------|
|           1 | Puig     | Anna  | Representant de vendes |
|           2 | Soler    | Jordi | Assist. comercial      |
|           3 | Ferrer   | Marta | Representant de vendes |
|           4 | Vila     | Oriol | Director de vendes     |
|           5 | Prats    | Clara | Director de vendes     |
|           6 | Riera    | Sergi | Representant de vendes |
|           7 | Pons     | Laia  | Director de vendes     |
|           8 | Font     | Marc  | Director de vendes     |
|           9 | Casals   | Núria | Director de vendes     |
|          10 | Miró     | Pere  | Assist. comercial      |

---

## Ex 15
**Enunciat:** Mostra els 10 productes més cars (preu descendent).

**Sortida:**

|   IdProducte | NomProducte                    |   Preu |
|-------------:|:-------------------------------|-------:|
|            5 | Refresc de taronja Mediterrani |  79.25 |
|           30 | Caramels de mel eco            |  77.47 |
|            3 | Iogurt natural eco             |  77.32 |
|           78 | Kefir                          |  77.25 |
|           12 | Torró d'avellana               |  77.24 |
|           31 | Cereals de blat                |  77.08 |
|           58 | Pollastre rostit intens        |  76.35 |
|           37 | Salsa mediterrània             |  75.58 |
|          119 | Tè negre Selecta               |  74.57 |
|          104 | Iogurt natural                 |  74.09 |

---

## Ex 16
**Enunciat:** Ordena clients d'Espanya per ciutat i després per nom.

**Sortida:**

| NomClient             | Ciutat    |
|:----------------------|:----------|
| Cooperativa A Corunya | A Corunya |
| Mercats A Corunya     | A Corunya |
| Serra Logística       | A Corunya |
| Pujol Distribucions   | Badalona  |
| Aliments Font         | Barcelona |
| Ribas Logística       | Barcelona |
| Cooperativa Bilbao    | Bilbao    |
| Font i Fills          | Bilbao    |
| Forn Vila             | Bilbao    |
| Aliments Prat         | Còrdova   |
| Pons Distribucions    | Còrdova   |
| Verdura del Còrdova   | Còrdova   |

_(Mostrant 12 de 60 files)_

---

## Ex 17
**Enunciat:** Recupera els 3 productes més barats.

**Sortida:**

|   IdProducte | NomProducte            |   Preu |
|-------------:|:-----------------------|-------:|
|            2 | Pasta espagueti artesà |    2.5 |
|           84 | Ketchup                |    5.7 |
|          113 | Ketchup Delta          |    5.7 |

---

## Ex 18
**Enunciat:** Recupera les 5 comandes més recents.

**Sortida:**

|   IdComanda | DataComanda   |
|------------:|:--------------|
|       14204 | 2024-12-31    |
|       14095 | 2024-12-26    |
|       14153 | 2024-12-07    |
|       14131 | 2024-12-05    |
|       14201 | 2024-12-05    |

---

## Ex 19
**Enunciat:** Busca clients amb el nom que contingui la paraula 'Market' (no sensible a majúscules si la BD ho permet).

**Sortida:**

_Resultat buit_

---

## Ex 20
**Enunciat:** Mostra productes el nom dels quals comenci per 'A'.

**Sortida:**

|   IdProducte | NomProducte            |
|-------------:|:-----------------------|
|           47 | Allioli                |
|           54 | Arròs bomba Delta      |
|          103 | Allioli artesà         |
|          110 | Arròs bomba intens     |
|          118 | Aigua mineral Bravamar |

---

## Ex 21
**Enunciat:** Mostra clients amb un espai al nom (dues paraules).

**Sortida:**

|   IdClient | NomClient            |
|-----------:|:---------------------|
|          1 | Cafès Ribas          |
|          2 | Cooperativa Mataró   |
|          3 | Serra i Fills        |
|          4 | Aliments Font        |
|          5 | Cooperativa Reus     |
|          6 | Aliments Miró        |
|          7 | Cooperativa Terrassa |
|          8 | Cooperativa Bilbao   |
|          9 | Serra Logística      |
|         10 | Aliments Casas       |
|         11 | Pujol Logística      |
|         12 | Pons Distribucions   |

_(Mostrant 12 de 90 files)_

---

## Ex 22
**Enunciat:** Mostra clients de França, Alemanya o Itàlia.

**Sortida:**

| NomClient           | País     |
|:--------------------|:---------|
| Biergarten Munic    | Alemanya |
| Boulangerie Dubois  | França   |
| Maison Moreau       | França   |
| Gastronomia Gallo   | Itàlia   |
| Gastronomia Russo   | Itàlia   |
| Pasticceria Bianchi | Itàlia   |

---

## Ex 23
**Enunciat:** Mostra productes de categories 3, 4 o 5.

**Sortida:**

|   IdProducte | NomProducte                 |   IdCategoria |
|-------------:|:----------------------------|--------------:|
|            2 | Pasta espagueti artesà      |             5 |
|            3 | Iogurt natural eco          |             4 |
|            6 | Quinoa                      |             5 |
|            7 | Kefir                       |             4 |
|            9 | Cupcakes Mediterrani        |             3 |
|           12 | Torró d'avellana            |             3 |
|           14 | Cupcakes Empordà            |             3 |
|           16 | Llet sencera                |             4 |
|           18 | Cuscús integral             |             5 |
|           19 | Cupcakes Raval              |             3 |
|           20 | Kefir                       |             4 |
|           21 | Xocolata negra 70% Montseny |             3 |

_(Mostrant 12 de 47 files)_

---

## Ex 24
**Enunciat:** Mostra comandes amb IdTransportista 1 o 3.

**Sortida:**

|   IdComanda |   IdTransportista |
|------------:|------------------:|
|       14002 |                 3 |
|       14003 |                 1 |
|       14005 |                 1 |
|       14006 |                 1 |
|       14008 |                 1 |
|       14010 |                 3 |
|       14011 |                 1 |
|       14012 |                 3 |
|       14013 |                 1 |
|       14014 |                 1 |

---

## Ex 25
**Enunciat:** Mostra productes amb àlies a les columnes (nom i preu).

**Sortida:**

| Producte                       |   PreuUnitari |
|:-------------------------------|--------------:|
| Pernil curat Raval             |         54.9  |
| Pasta espagueti artesà         |          2.5  |
| Iogurt natural eco             |         77.32 |
| Pomes Golden selecció          |         33.27 |
| Refresc de taronja Mediterrani |         79.25 |
| Quinoa                         |         30.46 |
| Kefir                          |         38.94 |
| Bacallà dessalat Montseny      |         38.64 |
| Cupcakes Mediterrani           |         37.6  |
| Pomes Golden                   |         33.03 |

---

## Ex 26
**Enunciat:** Concatena nom i cognom dels empleats amb àlies 'Empleat'.

**Sortida:**

| Empleat      |
|:-------------|
| Anna Puig    |
| Jordi Soler  |
| Marta Ferrer |
| Oriol Vila   |
| Clara Prats  |
| Sergi Riera  |
| Laia Pons    |
| Marc Font    |
| Núria Casals |
| Pere Miró    |

---

## Ex 27
**Enunciat:** Compta quants clients hi ha en total.

**Sortida:**

|   TotalClients |
|---------------:|
|             90 |

---

## Ex 28
**Enunciat:** Troba el preu mínim i màxim dels productes.

**Sortida:**

|   PreuMinim |   PreuMaxim |
|------------:|------------:|
|         2.5 |       79.25 |

---

## Ex 29
**Enunciat:** Calcula el preu mitjà dels productes.

**Sortida:**

|   PreuMig |
|----------:|
|   40.7991 |

---

## Ex 30
**Enunciat:** Suma la quantitat total venuda (DetallsComanda).

**Sortida:**

|   UnitatsTotals |
|----------------:|
|            4507 |

---

## Ex 31
**Enunciat:** Compta el nombre de comandes per any.

**Sortida:**

|   Any |   NumComandes |
|------:|--------------:|
|  2020 |            45 |
|  2021 |            42 |
|  2022 |            46 |
|  2023 |            42 |
|  2024 |            45 |

---

## Ex 32
**Enunciat:** Compta quants clients hi ha per país (top 10).

**Sortida:**

| País          |   NumClients |
|:--------------|-------------:|
| Espanya       |           60 |
| Països Baixos |            6 |
| Suïssa        |            6 |
| Estats Units  |            4 |
| Itàlia        |            3 |
| Portugal      |            3 |
| Suècia        |            3 |
| França        |            2 |
| Alemanya      |            1 |
| Regne Unit    |            1 |

---

## Ex 33
**Enunciat:** Preu mitjà per categoria (Productes).

**Sortida:**

|   Categoria |   PreuMig |
|------------:|----------:|
|           1 |     35.61 |
|           2 |     41.66 |
|           3 |     44.03 |
|           4 |     49.37 |
|           5 |     30.35 |
|           6 |     37.63 |
|           7 |     38.05 |
|           8 |     46.04 |

---

## Ex 34
**Enunciat:** Quines categories tenen preu mitjà > 30? (HAVING)

**Sortida:**

|   Categoria |   PreuMig |
|------------:|----------:|
|           4 |   49.3741 |
|           8 |   46.038  |
|           3 |   44.0309 |
|           2 |   41.6567 |
|           7 |   38.0538 |
|           6 |   37.6276 |
|           1 |   35.6083 |
|           5 |   30.3464 |

---

## Ex 35
**Enunciat:** Per cada client, quantes comandes té? (top 10)

**Sortida:**

|   IdClient |   NumComandes |
|-----------:|--------------:|
|         46 |             7 |
|         19 |             6 |
|         84 |             6 |
|         85 |             6 |
|         86 |             6 |
|         12 |             5 |
|         16 |             5 |
|         34 |             5 |
|         43 |             5 |
|         56 |             5 |

---

## Ex 36
**Enunciat:** Per cada producte, quantitat total venuda (top 10).

**Sortida:**

|   IdProducte |   TotalVenut |
|-------------:|-------------:|
|           22 |           90 |
|           78 |           80 |
|           89 |           74 |
|          107 |           74 |
|           85 |           71 |
|            5 |           66 |
|           20 |           65 |
|           91 |           65 |
|           31 |           64 |
|           13 |           62 |

---

## Ex 37
**Enunciat:** Comandes entre 2021-01-01 i 2021-12-31.

**Sortida:**

|   IdComanda | DataComanda   |
|------------:|:--------------|
|       14213 | 2021-01-03    |
|       14026 | 2021-01-06    |
|       14028 | 2021-01-27    |
|       14119 | 2021-01-30    |
|       14004 | 2021-02-02    |
|       14042 | 2021-02-11    |
|       14166 | 2021-02-12    |
|       14203 | 2021-03-01    |
|       14070 | 2021-03-07    |
|       14043 | 2021-03-13    |
|       14155 | 2021-03-14    |
|       14036 | 2021-03-30    |

_(Mostrant 12 de 42 files)_

---

## Ex 38
**Enunciat:** Comandes fora de l'any 2022 (NOT BETWEEN).

**Sortida:**

|   IdComanda | DataComanda   |
|------------:|:--------------|
|       14000 | 2024-04-29    |
|       14001 | 2023-09-13    |
|       14002 | 2021-04-03    |
|       14003 | 2021-07-21    |
|       14004 | 2021-02-02    |
|       14005 | 2020-01-05    |
|       14006 | 2020-12-03    |
|       14007 | 2020-10-21    |
|       14008 | 2024-07-18    |
|       14009 | 2023-07-08    |

---

## Ex 39
**Enunciat:** Productes amb preu <= 8 o >= 60 (OR).

**Sortida:**

|   IdProducte | NomProducte               |   Preu |
|-------------:|:--------------------------|-------:|
|            2 | Pasta espagueti artesà    |   2.5  |
|           84 | Ketchup                   |   5.7  |
|          113 | Ketchup Delta             |   5.7  |
|           48 | Cuscús integral           |   5.75 |
|           53 | Tonyina en oli artesà     |   7.35 |
|           63 | Pebrots vermells          |   7.8  |
|           20 | Kefir                     |  61.74 |
|           67 | Caramels de mel intens    |  64.27 |
|           72 | Iogurt natural eco        |  64.97 |
|           33 | Sardines en llauna artesà |  65.87 |
|           59 | Pebrots vermells Alpina   |  67.19 |
|           76 | Pomes Golden              |  67.46 |

_(Mostrant 12 de 33 files)_

---

## Ex 40
**Enunciat:** Clients que no són d'Espanya (NOT).

**Sortida:**

| NomClient          | País          |
|:-------------------|:--------------|
| Biergarten Munic   | Alemanya      |
| Schmid Käse        | Suïssa        |
| de Vries Import BV | Països Baixos |
| Wagner Käse        | Àustria       |
| Maison Moreau      | França        |
| Eriksson Bageri    | Suècia        |
| Bäckerei Huber     | Suïssa        |
| Bakker Kaas        | Països Baixos |
| Eriksson Handel AB | Suècia        |
| Padaria Santos     | Portugal      |

---

## Ex 41
**Enunciat:** Països amb clients, ordenats descendent per nom de país.

**Sortida:**

| País          |
|:--------------|
| Àustria       |
| Suïssa        |
| Suècia        |
| Regne Unit    |
| Portugal      |
| Països Baixos |
| Itàlia        |
| França        |
| Estats Units  |
| Espanya       |
| Alemanya      |

---

## Ex 42
**Enunciat:** Ciutats úniques de Proveïdors (DISTINCT).

**Sortida:**

| Ciutat     |
|:-----------|
| A Corunya  |
| Badalona   |
| Barcelona  |
| Bilbao     |
| Chicago    |
| Còrdova    |
| Girona     |
| Granollers |
| Lausana    |
| Lisboa     |
| Lió        |
| Madrid     |

_(Mostrant 12 de 32 files)_

---

## Ex 43
**Enunciat:** Top 5 països amb més clients (ORDER + LIMIT).

**Sortida:**

| País          |   Num |
|:--------------|------:|
| Espanya       |    60 |
| Països Baixos |     6 |
| Suïssa        |     6 |
| Estats Units  |     4 |
| Itàlia        |     3 |

---

## Ex 44
**Enunciat:** Top 5 productes més venuts per quantitat total (ORDER + LIMIT).

**Sortida:**

|   IdProducte |   Total |
|-------------:|--------:|
|           22 |      90 |
|           78 |      80 |
|          107 |      74 |
|           89 |      74 |
|           85 |      71 |

---

## Ex 45
**Enunciat:** Clients el nom dels quals acaba en 'Co.'

**Sortida:**

_Resultat buit_

---

## Ex 46
**Enunciat:** Proveïdors amb 'Market' o 'Mercat' al nom (OR amb LIKE).

**Sortida:**

|   IdProveidor | NomProveidor       |
|--------------:|:-------------------|
|             2 | Mercats A Corunya  |
|             5 | Mercats Granollers |
|            14 | Mercats Madrid     |
|            29 | Kobayashi Market   |

---

## Ex 47
**Enunciat:** Empleats amb Notes no nul·les (IS NOT NULL).

**Sortida:**

|   IdEmpleat | Nom   | Cognom   | Notes                  |
|------------:|:------|:---------|:-----------------------|
|           1 | Anna  | Puig     | Representant de vendes |
|           2 | Jordi | Soler    | Assist. comercial      |
|           3 | Marta | Ferrer   | Representant de vendes |
|           4 | Oriol | Vila     | Director de vendes     |
|           5 | Clara | Prats    | Director de vendes     |
|           6 | Sergi | Riera    | Representant de vendes |
|           7 | Laia  | Pons     | Director de vendes     |
|           8 | Marc  | Font     | Director de vendes     |
|           9 | Núria | Casals   | Director de vendes     |
|          10 | Pere  | Miró     | Assist. comercial      |

---

## Ex 48
**Enunciat:** Clients per ciutat a Espanya (top 10).

**Sortida:**

| Ciutat     |   NumClients |
|:-----------|-------------:|
| Girona     |            7 |
| Granollers |            6 |
| Mataró     |            5 |
| Reus       |            5 |
| València   |            4 |
| A Corunya  |            3 |
| Bilbao     |            3 |
| Còrdova    |            3 |
| Madrid     |            3 |
| Sabadell   |            3 |

---

## Ex 49
**Enunciat:** Comandes per dia de 2023 (mostra dies amb >= 2 comandes).

**Sortida:**

| DataComanda   |   Num |
|:--------------|------:|
| 2023-04-10    |     2 |
| 2023-11-11    |     2 |

---

## Ex 50
**Enunciat:** Productes de categoria entre 2 i 6, excepte 4 (BETWEEN i NOT IN).

**Sortida:**

|   IdProducte | NomProducte                 |   IdCategoria |
|-------------:|:----------------------------|--------------:|
|            1 | Pernil curat Raval          |             6 |
|            2 | Pasta espagueti artesà      |             5 |
|            6 | Quinoa                      |             5 |
|            9 | Cupcakes Mediterrani        |             3 |
|           12 | Torró d'avellana            |             3 |
|           13 | Pernil curat gurmet         |             6 |
|           14 | Cupcakes Empordà            |             3 |
|           15 | Vinagre balsàmic premium    |             2 |
|           17 | Bacó fumat Cristall         |             6 |
|           18 | Cuscús integral             |             5 |
|           19 | Cupcakes Raval              |             3 |
|           21 | Xocolata negra 70% Montseny |             3 |

_(Mostrant 12 de 57 files)_

---

## Ex 51
**Enunciat:** Comandes amb transportista diferent de 2.

**Sortida:**

|   IdComanda |   IdTransportista |
|------------:|------------------:|
|       14002 |                 3 |
|       14003 |                 1 |
|       14005 |                 1 |
|       14006 |                 1 |
|       14008 |                 1 |
|       14010 |                 3 |
|       14011 |                 1 |
|       14012 |                 3 |
|       14013 |                 1 |
|       14014 |                 1 |

---

## Ex 52
**Enunciat:** Any i mes de la DataComanda amb àlies.

**Sortida:**

|   Any |   Mes |   Num |
|------:|------:|------:|
|  2020 |    01 |     4 |
|  2020 |    02 |     4 |
|  2020 |    03 |     3 |
|  2020 |    04 |     3 |
|  2020 |    05 |     6 |
|  2020 |    06 |     3 |
|  2020 |    07 |     1 |
|  2020 |    08 |     2 |
|  2020 |    09 |     5 |
|  2020 |    10 |     6 |
|  2020 |    11 |     4 |
|  2020 |    12 |     4 |

_(Mostrant 12 de 59 files)_

---

## Ex 53
**Enunciat:** Agrupa productes per categoria mostrant preu mínim i màxim amb àlies.

**Sortida:**

|   Categoria |   PreuMin |   PreuMax |
|------------:|----------:|----------:|
|           1 |      8.74 |     79.25 |
|           2 |      5.7  |     75.58 |
|           3 |      8.26 |     77.47 |
|           4 |     13.25 |     77.32 |
|           5 |      2.5  |     77.08 |
|           6 |     10.74 |     76.35 |
|           7 |      7.35 |     65.87 |
|           8 |      7.8  |     73.01 |

---

## Ex 54
**Enunciat:** Clients d'un conjunt de països (França, Alemanya). Ex 54.

**Sortida:**

| NomClient          | País     |
|:-------------------|:---------|
| Biergarten Munic   | Alemanya |
| Boulangerie Dubois | França   |
| Maison Moreau      | França   |

---

## Ex 55
**Enunciat:** Top 3 productes per preu a la categoria 8.

**Sortida:**

|   IdProducte | NomProducte           |   Preu |
|-------------:|:----------------------|-------:|
|           55 | Enciams variats       |  73.01 |
|           73 | Pastanagues Fontdelpi |  72.2  |
|           99 | Pomes Golden          |  71.83 |

---

## Ex 56
**Enunciat:** Comptatge de comandes per any (ex 56).

**Sortida:**

|   Any |   Num |
|------:|------:|
|  2020 |    45 |
|  2021 |    42 |
|  2022 |    46 |
|  2023 |    42 |
|  2024 |    45 |

---

## Ex 57
**Enunciat:** Clients d'un conjunt de països (França, Alemanya). Ex 57.

**Sortida:**

| NomClient          | País     |
|:-------------------|:---------|
| Biergarten Munic   | Alemanya |
| Boulangerie Dubois | França   |
| Maison Moreau      | França   |

---

## Ex 58
**Enunciat:** Comptatge de comandes per any (ex 58).

**Sortida:**

|   Any |   Num |
|------:|------:|
|  2020 |    45 |
|  2021 |    42 |
|  2022 |    46 |
|  2023 |    42 |
|  2024 |    45 |

---

## Ex 59
**Enunciat:** Comptatge de comandes per any (ex 59).

**Sortida:**

|   Any |   Num |
|------:|------:|
|  2020 |    45 |
|  2021 |    42 |
|  2022 |    46 |
|  2023 |    42 |
|  2024 |    45 |

---

## Ex 60
**Enunciat:** Top 3 productes per preu a la categoria 5.

**Sortida:**

|   IdProducte | NomProducte     |   Preu |
|-------------:|:----------------|-------:|
|           31 | Cereals de blat |  77.08 |
|           26 | Cuscús integral |  49.29 |
|          102 | Quinoa clàssic  |  47.19 |

---

## Ex 61
**Enunciat:** Comptatge de comandes per any (ex 61).

**Sortida:**

|   Any |   Num |
|------:|------:|
|  2020 |    45 |
|  2021 |    42 |
|  2022 |    46 |
|  2023 |    42 |
|  2024 |    45 |

---

## Ex 62
**Enunciat:** Comptatge de comandes per any (ex 62).

**Sortida:**

|   Any |   Num |
|------:|------:|
|  2020 |    45 |
|  2021 |    42 |
|  2022 |    46 |
|  2023 |    42 |
|  2024 |    45 |

---

## Ex 63
**Enunciat:** Clients d'un conjunt de països (França, Alemanya). Ex 63.

**Sortida:**

| NomClient          | País     |
|:-------------------|:---------|
| Biergarten Munic   | Alemanya |
| Boulangerie Dubois | França   |
| Maison Moreau      | França   |

---

## Ex 64
**Enunciat:** Comptatge de comandes per any (ex 64).

**Sortida:**

|   Any |   Num |
|------:|------:|
|  2020 |    45 |
|  2021 |    42 |
|  2022 |    46 |
|  2023 |    42 |
|  2024 |    45 |

---

## Ex 65
**Enunciat:** Top 3 productes per preu a la categoria 2.

**Sortida:**

|   IdProducte | NomProducte        |   Preu |
|-------------:|:-------------------|-------:|
|           37 | Salsa mediterrània |  75.58 |
|           66 | Salsa mediterrània |  72.24 |
|          103 | Allioli artesà     |  68.33 |

---

## Ex 66
**Enunciat:** Clients d'un conjunt de països (França, Alemanya). Ex 66.

**Sortida:**

| NomClient          | País     |
|:-------------------|:---------|
| Biergarten Munic   | Alemanya |
| Boulangerie Dubois | França   |
| Maison Moreau      | França   |

---

## Ex 67
**Enunciat:** Comptatge de comandes per any (ex 67).

**Sortida:**

|   Any |   Num |
|------:|------:|
|  2020 |    45 |
|  2021 |    42 |
|  2022 |    46 |
|  2023 |    42 |
|  2024 |    45 |

---

## Ex 68
**Enunciat:** Comptatge de comandes per any (ex 68).

**Sortida:**

|   Any |   Num |
|------:|------:|
|  2020 |    45 |
|  2021 |    42 |
|  2022 |    46 |
|  2023 |    42 |
|  2024 |    45 |

---

## Ex 69
**Enunciat:** Clients d'un conjunt de països (França, Alemanya). Ex 69.

**Sortida:**

| NomClient          | País     |
|:-------------------|:---------|
| Biergarten Munic   | Alemanya |
| Boulangerie Dubois | França   |
| Maison Moreau      | França   |

---

## Ex 70
**Enunciat:** Top 3 productes per preu a la categoria 7.

**Sortida:**

|   IdProducte | NomProducte               |   Preu |
|-------------:|:--------------------------|-------:|
|           33 | Sardines en llauna artesà |  65.87 |
|          117 | Sardines en llauna        |  56.08 |
|           95 | Gambes congelades         |  47.07 |

---

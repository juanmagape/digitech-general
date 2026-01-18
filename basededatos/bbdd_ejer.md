ejercicio 1

    select NomClient from Clients;

ejercicio 2

    select NomClient, País from Clients;

ejercicio 3

    select * from productes;

ejercicio 4

    select * from productes limit 10;

ejerciocio 5

    select * from productes
    order by Preu ASC
    limit 5;

ejercicio 6

    select distinct País from clients;

ejercicio 7 

    select distinct Ciutat from clients;

ejercicio 8 

    select IdProducte, NomProducte, preu from productes
    where preu > 50;

ejercicio 9

    select IdProducte, NomProducte, preu from productes
    where preu BETWEEN 10 and 20;

ejercicio 10

    select NomClient, Ciutat, País from clients
    where Ciutat IN('Barcelona','Girona');

ejercicio 11

    select idProducte, idCategoria, NomProducte	 from productes
    where idCategoria NOT IN (1,2);

ejercicio 12

    select IdComanda, IdClient, DataComanda from comandes
    where DataComanda >= '2023-01-01';

ejercicio 13

    select IdEmpleat, Cognom, Nom from empleats
    where Foto is null;

ejercicio 14

    select IdEmpleat, Cognom, Nom, Notes from empleats
    where notes is not null;

ejercicio 15

    select idProducte, NomProducte, Preu from productes
    order by preu DESC
    limit 10;

ejercicio 16

    select NomClient, Ciutat from clients
    order by Ciutat, NomClient;

ejercicio 17

    select idProducte, NomProducte, Preu from productes
    order by preu ASC
    limit 3;

ejercicio 18

    select IdComanda, IdClient, DataComanda from comandes
    order by DataComanda desc
    limit 5;

ejercicio 19

    select idClient, NomClient from clients
    where NomClient = 'Market';

ejercicio 20

    select IdProducte, NomProducte from productes
    where NomProducte like 'A%';

ejercicio 21

    select IdClient, NomClient from clients
    where NomClient like '% %';

ejercicio 22 

    select IdClient, NomClient, País from clients
    where País IN ('Alemanya', 'França', 'Italia');

ejercicio 23

    select IdProducte, NomProducte, IdCategoria from productes
    where IdCategoria IN (3, 4, 5);

ejercicio 24

    select IdComanda, IdTransportista from comandes
    where IdTransportista IN (1, 3);

ejercicio 25

    select NomProducte as Producte, Preu as PreuUnitari 
    from productes;

ejercicio 26

    SELECT CONCAT(Nom, ' ', Cognom) AS Empleat
    FROM empleats;

ejercicio 27

    select COUNT(IdClient) as TotalClients
    from clients

ejercicio 28

    select MIN(Preu) AS PreuMinim, MAX(Preu) as PreuMaxim
    from productes;

ejercicio 29

    select AVG(Preu) as PreuMig
    from productes;

ejercicio 30

    SELECT COUNT(Quantitat) as UnitatsTotals
    FROM detallscomanda;

ejercicio 31

    select 
        YEAR(DataComanda) as Any,
        COUNT(*) as NumComandes
    FROM comandes
    GROUP BY YEAR(DataComanda)
    ORDER BY Any;

ejercicio 32

select País as 'Pais', count(País) as 'Qtat Paisos'
from clients
GROUP BY Pais
order by 'Qtat Paisos'
limit 10;

ejercicio 33



ejercicio 34



ejercicio 35



ejercicio 36



ejercicio 37

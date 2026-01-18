


Ejercicio 1 


    select Clients.NomClient,
	   Comandes.DataComanda
    from Comandes
    INNER JOIN Clients
    ON Comandes.IdClient = Clients.IdClient;



Ejercicio 2

    select Clients.NomClient,
	   Empleats.Nom
    from Comandes
    INNER JOIN Clients
    ON Comandes.IdClient = Clients.IdClient
    INNER JOIN Empleats
    On Comandes.IdEmpleat = Empleats.IdEmpleat;



Ejercicio 3

    select Clients.NomClient,
	   Comandes.IdComanda
    from Comandes
    LEFT JOIN Clients
    ON Comandes.IdClient = Clients.IdClient;



Ejercicio 4

    SELECT Empleats.Nom,
       COUNT(Comandes.IdComanda) AS NumComandes
    FROM Empleats
    LEFT JOIN Comandes 
    ON Comandes.IdEmpleat = Empleats.IdEmpleat
    GROUP BY Empleats.Nom;



ejercicio 5

    SELECT 
        Productes.NomProducte,
        Productes.IdProducte,
        COUNT(DetallsComanda.IdProducte) as Aparicions
    FROM Productes
    LEFT JOIN DetallsComanda
    ON Productes.IdProducte = DetallsComanda.IdProducte
    WHERE DetallsComanda.IdDetallComanda IS NULL
    GROUP BY Productes.IdProducte;
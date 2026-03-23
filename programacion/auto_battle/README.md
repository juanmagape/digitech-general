# Auto Battler - Proyecto RA5/RA6

## Descripción del Proyecto

Este proyecto consiste en el desarrollo de un videojuego tipo *Auto Battler* implementado en Java, en el que el jugador debe gestionar un equipo de unidades y enfrentarse a una Inteligencia Artificial en combates automáticos. A lo largo de la partida, el jugador no controla las acciones durante el combate, sino que su estrategia se centra en la gestión recursos y en la selección de las unidades.
El objetivo principal del juego es conseguir un total de diez victorias antes que la IA, obliga al jugador a tomar decisiones estratégicas en la composición de su equipo.

---

## Funcionamiento General

Al iniciar el juego, el jugador introduce su nombre y comienza sin ninguna unidad en su equipo. A partir de ese momento, el flujo del juego se organiza en un bucle principal en el que el jugador puede acceder a la tienda, iniciar combates o salir del juego.
Una de las restricciones es que no se permite iniciar un combate si el jugador no tiene al menos una unidad, lo que obliga a pasar previamente por la tienda y adquirir personajes.

---

## Sistema de Tienda

La tienda permite al jugador construir y mejorar su equipo. En ella aparecen diferentes personajes de forma aleatoria cada vez que se accede o cuando el jugador decide refrescarla mediante la opción de “roll”.
Cada personaje puede ser comprado a cambio de monedas, y una vez adquirido pasa a formar parte del equipo del jugador, siempre respetando el máximo de diez unidades. Además, el sistema permite vender personajes ya adquiridos, que proporciona monedas.

---

## Sistema de Combate

El combate se desarrolla de forma automática. Una vez iniciado, las unidades de ambos jugadores se enfrentan entre sí mediante turnos en los que atacan a un oponente.
Durante cada turno, una unidad realiza un ataque y la unidad defensora tiene la posibilidad de bloquearlo parcialmente o completamente. En caso de recibir daño, la vida se reduce, y si esta llega a cero, la unidad queda eliminada del combate.
El enfrentamiento continúa hasta que uno de los dos equipos se queda sin unidades disponibles. En ese momento se determina el ganador del combate.

---

## Inteligencia Artificial

El proyecto tiene dos tipos de inteligencia artificial. Por un lado, la IA del enemigo es responsable de gestionar la compra de personajes en la tienda y de formar su equipo de combate.
Por otro lado, hay una IA interna que determina el comportamiento de las unidades durante la batalla. Esta IA se basa en decisiones aleatorias, para seleccionar objetivos y para ejecutar acciones como la defensa.

---

## Rondas

El juego se estructura en rondas. Tras cada combate, ambos jugadores reciben una recompensa en monedas: el ganador obtiene tres monedas, mientras que el perdedor recibe cinco para compensar.
El primer jugador en alcanzar diez victorias es declarado ganador de la partida, momento en el cual el juego finaliza.

---

# JUEGO RPG

Un sencillo juego de rol (RPG) por consola implementado en Java. El jugador crea un personaje, escoge una clase y se enfrenta a enemigos aleatorios, gestionando su inventario y recursos para sobrevivir.

## Características del Juego

* **Creación de Personaje:** El jugador puede introducir un nombre y seleccionar una de las cinco clases disponibles.
* **Clases:**
    * Mago
    * Guerrero
    * Guerrero Mágico
    * Elfo
    * Alquimista
* **Combate por Turnos:** El sistema de batalla es por turnos contra enemigos aleatorios, como el Ogro, Goblin, Mago Oscuro, Slime o Árbol encantado.
* **Tipos de Ataque:**
    * Ataque Físico *Melee* (con interacciones de `normal`, `esquivo` y `critico`).
    * Ataque Mágico (consume 25 puntos de maná).
* **Gestión de Inventario:** Utiliza objetos (pociones de vida, maná o daño).
* **Recompensas y Taberna:** Al derrotar a un enemigo, el jugador obtiene oro y una recompensa. Entre batallas, hay la posibilidad de visitar una taberna para comprar más objetos con el oro ganado.


## Cómo Empezar

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/juanmagape/rpg_game.git
    cd rpg_game/rpg_game
    ```

## Estructura de Clases

El juego se organiza en tres clases principales:

* **`Main.java`:** La clase principal del programa. Se encarga de la bienvenida, la introducción del nombre y la selección de la clase del personaje.
* **`Personaje.java`:** Define los atributos base (vida, maná, daño) y las estadísticas iniciales para cada una de las clases seleccionables.
* **`Pelea.java`:** Contiene la lógica central del juego, gestionando el ciclo de combate, los ataques, la interacción con objetos, las recompensas y el sistema de tienda (taberna).

<br>
<br>
<br>

<p>Juan Manuel Galán Pérez</p>
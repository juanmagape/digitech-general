# Wordle en Java

Un juego de consola para adivinar palabras, inspirado en Wordle.

## Cómo funciona

El programa selecciona de forma aleatoria una palabra de cinco letras.
El usuario tiene un máximo de seis intentos para adivinarla.

En cada intento, el usuario introduce una palabra y el programa evalúa cada una de sus letras, dando pistas visuales con colores para indicar el grado de acierto

## Sistema de pistas

En la consola, se mostrarán las letras de la palabra introducida con diferentes colores según su estado:

* **Verde**: La letra es correcta y está en su posición.
* **Amarillo**: La letra está en la palabra, pero en otra posición.
* **Rojo**: La letra no está en la palabra.

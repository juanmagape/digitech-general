/****************************************************
 * script-alumne.js
 * Mòdul 0373 – Llenguatges de marques
 *
 * Objectiu:
 *  - Llegir dades d’un fitxer JSON
 *  - Crear automàticament una taula HTML
 *
 * IMPORTANT:
 *  - No cal entendre-ho tot
 *  - Cal completar els TODOs indicats
 ****************************************************/


/*
  TODO 1
  Busca el <tbody> de la taula HTML on afegirem les files.

  PISTA:
  A l’HTML hi ha una taula amb:
    id="taula-productes"
*/

// TODO 1: completa aquesta línia
const cosTaula = document.querySelector("#taula-productes");



/*
  PAS 2
  Llegim el fitxer JSON amb les dades.
  Aquest codi NO s’ha de modificar.
*/

fetch("dades.json")
  .then(resposta => resposta.json())
  .then(data => {

    console.log("Dades llegides del JSON:");
    console.log(data);


    /*
      TODO 2
      Dins del JSON hi ha una llista de productes.

      El JSON té aquesta estructura general:

      {
        "productes": [ ... ]
      }

      PISTA:
      Guarda la llista de productes dins
      una variable anomenada "productes".
    */

    // TODO 2: completa aquesta línia
    const productes = data.value;



    /*
      PAS 3
      Recorrem els productes un a un.
      Aquest forEach JA ESTÀ FET.
    */

    productes.forEach(producte => {


      /*
        TODO 3
        Crea una nova fila de la taula (<tr>).
      */

      // TODO 3
      const fila = document.createElement("tr");



      /*
        TODO 4
        Crea una cel·la (<td>) pel NOM del producte
        i posa-hi el text corresponent.
      */

      // TODO 4
      const cellaNom = document.createElement("td");
      cellaNom.textContent = producte.nombre;



      /*
        TODO 5
        Afegeix la cel·la del nom dins la fila.
      */

      // TODO 5
      /* ??? */
      fila.appendChild(cellaNom);



      /*
        TODO 6
        Crea una cel·la (<td>) pel PREU.
        Mostra el preu amb el símbol €.
      */

      // TODO 6
      const cellaPreu = document.createElement("td");
      cellaPreu.textContent = producte.precio + "€";



      /*
        TODO 7
        Afegeix la cel·la del preu dins la fila.
      */

      // TODO 7
      fila.appendChild(cellaPreu);



      /*
        TODO 8
        Crea una cel·la (<td>) per la CATEGORIA
        i posa-hi el text corresponent.
      */

      // TODO 8
      const cellaCategoria = document.createElement("td");
      cellaCategoria.textContent = producte.categoria;



      /*
        TODO 9
        Afegeix la cel·la de la categoria dins la fila.
      */

      // TODO 9
      fila.appendChild(cellaCategoria);



      /*
        TODO 10
        Afegeix la fila completa dins la taula HTML.
      */

    const cellaDispo = document.createElement("td");
    cellaDispo.textContent = producte.disponibilitat;

    fila.appendChild(cellaDispo);



    const cellaPes = document.createElement("td");
    cellaPes.textContent = producte.pesGrams + "g";

    fila.appendChild(cellaPes);




      // TODO 10
      cosTaula.appendChild(fila);

    });

  });
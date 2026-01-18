// detall.js
// Llegeix l'ID de la URL, busca l'element al dades.xml i en mostra el detall

// 1. Funció per obtenir el paràmetre "id" de la URL
function obtenirIdDeLaUrl() {
  const params = new URLSearchParams(window.location.search);
  return params.get("id");
}

// 2. Funció per crear i mostrar la targeta de detall
function mostraDetall(joc) {
  const contenidorDetall = document.getElementById("contenidor-detall");

  const id = joc.getAttribute("id") || "";

  const titolEl = joc.querySelector("titol");
  const genereEl = joc.querySelector("genere");
  const anyEl = joc.querySelector("any");
  const plataformaEl = joc.querySelector("plataforma");
  const preuEl = joc.querySelector("preu");
  const valoracioEl = joc.querySelector("valoracio");
  const descripcioEl = joc.querySelector("descripcio");

  const titol = titolEl ? titolEl.textContent : "";
  const genere = genereEl ? genereEl.textContent : "";
  const any = anyEl ? anyEl.textContent : "";
  const plataforma = plataformaEl ? plataformaEl.textContent : "";
  const preu = preuEl ? preuEl.textContent : "";
  const valoracio = valoracioEl ? valoracioEl.textContent : "";
  const descripcio = descripcioEl ? descripcioEl.textContent.trim() : "";

  // Creem la card
  const card = document.createElement("article");
  card.className = "card-detall";

  const h2 = document.createElement("h2");
  h2.textContent = titol;
  card.appendChild(h2);

  const dl = document.createElement("dl");

  function afegeixFila(etic, valor) {
    const dt = document.createElement("dt");
    dt.textContent = etic;
    const dd = document.createElement("dd");
    dd.textContent = valor;
    dl.appendChild(dt);
    dl.appendChild(dd);
  }

  afegeixFila("ID", id);
  afegeixFila("Gènere", genere);
  afegeixFila("Any", any);
  afegeixFila("Plataforma", plataforma);
  afegeixFila("Preu (€)", preu);
  afegeixFila("Valoració", valoracio);

  card.appendChild(dl);

  const pDesc = document.createElement("p");
  pDesc.textContent = descripcio;
  card.appendChild(pDesc);

  contenidorDetall.innerHTML = ""; // per si de cas
  contenidorDetall.appendChild(card);
}

// 3. Funció principal: carregar dades.xml i buscar l'element per ID
async function carregaDetall() {
  const missatgeError = document.getElementById("missatge-error");
  const id = obtenirIdDeLaUrl();

  if (!id) {
    missatgeError.textContent = "No s'ha indicat cap ID a la URL.";
    return;
  }

  try {
    const resposta = await fetch("./data/dades.xml");
    if (!resposta.ok) {
      throw new Error("Error HTTP " + resposta.status);
    }

    const text = await resposta.text();

    const parser = new DOMParser();
    const xmlDoc = parser.parseFromString(text, "application/xml");

    // Agafem tots els <joc> dins de <cataleg>
    const jocs = xmlDoc.querySelectorAll("cataleg > joc");

    let jocTrobat = null;
    jocs.forEach(function (joc) {
      if (!jocTrobat && joc.getAttribute("id") === id) {
        jocTrobat = joc;
      }
    });

    if (!jocTrobat) {
      missatgeError.textContent =
        "No s'ha trobat cap element amb l'ID " + id + ".";
      return;
    }

    // Si l'hem trobat, el mostrem
    mostraDetall(jocTrobat);
  } catch (error) {
    console.error(error);
    missatgeError.textContent =
      "S'ha produït un error en carregar el detall. " +
      "Comprova que el servidor local estigui en marxa i que el fitxer dades.xml existeix.";
  }
}

// 4. Quan el DOM estigui llest, executem la funció principal
document.addEventListener("DOMContentLoaded", carregaDetall);

// detall.js
// Lee el ID desde la URL, busca la entrada <dades> correspondiente y muestra su detalle

function obtenerIdUrl() {
  const params = new URLSearchParams(window.location.search);
  return params.get("id");
}

function mostrarDetalle(item) {
  const cont = document.getElementById("contenidor-detall");

  const id = item.getAttribute("id") || "";
  const titol = item.querySelector("titol")?.textContent || "";
  const genere = item.querySelector("genere")?.textContent || "";
  const any = item.querySelector("any")?.textContent || "";
  const plataforma = item.querySelector("plataforma")?.textContent || "";
  const preu = item.querySelector("preu")?.textContent || "";
  const valoracio = item.querySelector("valoracio")?.textContent || "";
  const descripcio = item.querySelector("descripcio")?.textContent.trim() || "";

  const card = document.createElement("article");
  card.className = "card-detall";

  const h2 = document.createElement("h2");
  h2.textContent = titol;
  card.appendChild(h2);

  const dl = document.createElement("dl");

  const fila = (etiqueta, valor) => {
    const dt = document.createElement("dt");
    dt.textContent = etiqueta;
    const dd = document.createElement("dd");
    dd.textContent = valor;
    dl.appendChild(dt);
    dl.appendChild(dd);
  };

  fila("ID", id);
  fila("Gènere", genere);
  fila("Any", any);
  fila("Plataforma", plataforma);
  fila("Preu", preu);
  fila("Valoració", valoracio);

  card.appendChild(dl);

  const p = document.createElement("p");
  p.textContent = descripcio;
  card.appendChild(p);

  cont.innerHTML = "";
  cont.appendChild(card);
}

async function cargarDetalle() {
  const msg = document.getElementById("missatge-error");
  const idBuscado = obtenerIdUrl();

  if (!idBuscado) {
    msg.textContent = "No s'ha indicat cap ID a la URL.";
    return;
  }

  try {
    const resp = await fetch("./data/dades.xml");
    if (!resp.ok) throw new Error("HTTP " + resp.status);

    const xmlText = await resp.text();
    const xml = new DOMParser().parseFromString(xmlText, "application/xml");

    // ahora buscamos cataleg > dades (NO joc)
    const items = xml.querySelectorAll("cataleg > dades");

    const encontrado = [...items].find(
      (n) => n.getAttribute("id") === idBuscado
    );

    if (!encontrado) {
      msg.textContent = "No existe ningún element amb ID " + idBuscado;
      return;
    }

    mostrarDetalle(encontrado);

  } catch (err) {
    console.error(err);
    msg.textContent =
      "Error en carregar el detall. Comprova el servidor local i el fitxer dades.xml.";
  }
}

document.addEventListener("DOMContentLoaded", cargarDetalle);

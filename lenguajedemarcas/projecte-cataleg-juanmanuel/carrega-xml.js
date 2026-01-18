// carrega-xml.js
// Llegeix dades.xml amb fetch, el parseja com a XML i omple la taula #taula-jocs

async function carregaJocs() {
  const missatgeError = document.getElementById("missatge-error");
  try {
    const resposta = await fetch("dades.xml");
    if (!resposta.ok) {
      throw new Error("Error HTTP " + resposta.status);
    }

    const text = await resposta.text();

    const parser = new DOMParser();
    const xmlDoc = parser.parseFromString(text, "application/xml");

    const jocs = xmlDoc.querySelectorAll("cataleg > joc");
    const tbody = document.querySelector("#taula-jocs tbody");
    tbody.innerHTML = "";

    jocs.forEach((joc) => {
      const tr = document.createElement("tr");

      function creaTd(text) {
        const td = document.createElement("td");
        td.textContent = text;
        return td;
      }

      const id = joc.getAttribute("id") || "";
      const titol = joc.querySelector("titol")?.textContent || "";
      const genere = joc.querySelector("genere")?.textContent || "";
      const any = joc.querySelector("any")?.textContent || "";
      const plataforma = joc.querySelector("plataforma")?.textContent || "";
      const preu = joc.querySelector("preu")?.textContent || "";
      const valoracio = joc.querySelector("valoracio")?.textContent || "";
      const descripcio = joc
        .querySelector("descripcio")
        ?.textContent.trim() || "";

      tr.appendChild(creaTd(id));
      tr.appendChild(creaTd(titol));
      tr.appendChild(creaTd(genere));
      tr.appendChild(creaTd(any));
      tr.appendChild(creaTd(plataforma));
      tr.appendChild(creaTd(preu));
      tr.appendChild(creaTd(valoracio));
      tr.appendChild(creaTd(descripcio));

      tbody.appendChild(tr);
    });
  } catch (error) {
    console.error(error);
    missatgeError.textContent =
      "No s'han pogut carregar les dades del catàleg. Assegura't d'obrir la pàgina amb un servidor local (p. ex. VS Code Live Server o 'python -m http.server').";
  }
}

carregaJocs();

let currentQuestionIndex = 0;
let preguntesAssignades = [];
let answersMemory = {};


// ===============================
// BANCS DE PREGUNTES
// ===============================

const questionsProject = [
    "Quantes màquines virtuals son necessaries dins del projecte PhoenixTech que estem desenvolupant a classe?",
    "Quina és la relació entre el servidor amb Windows 2025 i el servidor amb Linux?",
    "Quina és la distribució dels rols del servidor amb Windows 2025 i del servidor amb Linux?",
    "Quina és la configuració dels adaptadors de xarxa de les màquines virtuals del servidor amb Windows 2025 i del servidor amb Linux",
    "Per què la configuració d'un dels adaptadors de xarxa de la màquina virtual del servidor amb Windows 2025 i el servidor amb Linux, és Bridge?",
    "Explica quina és la diferència entre configurar un adaptador de xarxa, amb Nat, o Host-Only o Bridge?"
];

const questionsJSON = [
    "Què és i per què es fa servir el format JSON?",
    "Per què JSON és molt utilitzat a programació?",
    "Què són la parella clau:valor (key:value) dins del format JSON?",
    "Per què, dins d'un document amb format JSON, les cadenes de text van entre cometes?",
    "Per què, dins d'un document amb format JSON, els enters no van entre cometes?",
    "Què passa si oblides una coma en JSON?",
    "Què significa que un JSON no és vàlid?"
];

const questionsGit = [
    "Què és un repositori Git?",
    "Quina diferència hi ha entre Git i GitHub?",
    "Explica què és i que fan la comanda commit, i la comanda push?",
    "Per què és important fer push?",
    "On es guarda el repositori després del push?",
    "Què passa si només fas commit però no push?",
    "Com pots saber si el teu repositori està actualitzat?",
    "Per què GitHub permet veure l’historial de canvis?",
    "Per què parlem de repositori local i repositori remot?"
];


// ===============================

function preguntaAleatoria(banc) {
    const index = Math.floor(Math.random() * banc.length);
    return {
        index: index,
        text: banc[index]
    };
}


// ===============================
// ALUMNES
// ===============================

let alumnes = [];

async function carregarAlumnes() {
    const response = await fetch("./fitxers/alumnes.json");
    const data = await response.json();
    alumnes = data.alumnes[0];
    const select = document.getElementById("studentSelect");
    alumnes.forEach((a, i) => {
       const option = document.createElement("option");
        option.value = i;
        option.textContent = a.firstname + " " + a.lastname;
        select.appendChild(option);
    });
}

// ===============================
// ELEMENTS DOM
// ===============================

const questionsContainer = document.getElementById("questionsContainer");
const lastSelection = document.getElementById("lastSelection");
const downloadBtn = document.getElementById("downloadBtn");
const nextBtn = document.getElementById("nextBtn");
const prevBtn = document.getElementById("prevBtn");

// ===============================
// OBTENIR PREGUNTES ASSIGNADES
// ===============================

function obtenirPreguntesAssignades() {
    const guardades = localStorage.getItem("phoenixtech_questions");
    if (guardades) {
        return JSON.parse(guardades);
    }
    const q1 = preguntaAleatoria(questionsProject);
    const q2 = preguntaAleatoria(questionsJSON);
    const q3 = preguntaAleatoria(questionsGit);
    const seleccionades = [
        { categoria: "projecte", ...q1 },
        { categoria: "json", ...q2 },
        { categoria: "git", ...q3 }
    ];
    localStorage.setItem(
        "phoenixtech_questions",
        JSON.stringify(seleccionades)
    );
    return seleccionades;
}


// ===============================
// NAVEGACIÓ
// ===============================

nextBtn.addEventListener("click", () => {
    const pregunta = preguntesAssignades[currentQuestionIndex];
    const textarea = document.getElementById("answer-" + pregunta.index);
    answersMemory[pregunta.index] = textarea.value;
    if (currentQuestionIndex < preguntesAssignades.length - 1) {
        currentQuestionIndex++;
        renderQuestion();
    }
});

prevBtn.addEventListener("click", () => {
    const pregunta = preguntesAssignades[currentQuestionIndex];
    const textarea = document.getElementById("answer-" + pregunta.index);
    answersMemory[pregunta.index] = textarea.value;
    if (currentQuestionIndex > 0) {
        currentQuestionIndex--;
        renderQuestion();
    }
});


// ===============================
// MOSTRAR PREGUNTA
// ===============================

function renderQuestion() {
    const pregunta = preguntesAssignades[currentQuestionIndex];
    questionsContainer.innerHTML = `

<article class="question-card">

    <div class="question-number">
Pregunta ${currentQuestionIndex + 1} de 3
    </div>

    <div class="question-text">
${pregunta.text}
    </div>

<textarea
id="answer-${pregunta.index}"
placeholder="Resposta obligatòria..."
required
>${answersMemory[pregunta.index] || ""}</textarea>
<div class="question-required">
* Aquesta resposta és obligatòria
</div>
</article>

`;

    lastSelection.textContent =
        preguntesAssignades.map(p => p.index + 1).join(", ");

}


// ===============================
// GENERAR JSON
// ===============================

downloadBtn.addEventListener("click", () => {

    const indices = preguntesAssignades;

    const answers = {};
    // let hiHaError = false;

    // indices.forEach(p => {

    //     const textarea = document.getElementById("answer-" + p.index);
    //     const text = (answersMemory[p.index] || "").trim();

    //     if (textarea) {
    //         textarea.classList.remove("error");
    //     }

    //     if (text === "") {
    //         if (textarea) {
    //             textarea.classList.add("error");
    //         }
    //         hiHaError = true;
    //     } else {
    //         answers["q" + (p.index + 1)] = text;
    //     }

    // });


    let preguntesFalten = [];

    indices.forEach((p, i) => {

        const textarea = document.getElementById("answer-" + p.index);
        const text = (answersMemory[p.index] || "").trim();

        if (textarea) {
            textarea.classList.remove("error");
        }

        if (text === "") {

            preguntesFalten.push(i + 1);

            if (textarea) {
                textarea.classList.add("error");
            }

        } else {

            answers["q" + (p.index + 1)] = text;

        }

    });
    if (preguntesFalten.length > 0) {

        if (preguntesFalten.length === 1) {
            alert("Falta respondre la pregunta: " + preguntesFalten[0]);
        } else {
            alert("Falten respondre les preguntes: " + preguntesFalten.join(", "));
        }

        return;

    }
    const select = document.getElementById("studentSelect");
    const alumne = alumnes[select.value];

    if (!alumne) {
        alert("Selecciona un alumne.");
        return;
    }

    const data = {

        student: alumne.firstname + " " + alumne.lastname,
        email: alumne.email,
        timestamp: new Date().toISOString(),
        questions: indices.map(p => p.index + 1),
        answers: answers

    };

    const blob = new Blob(
        [JSON.stringify(data, null, 2)],
        { type: "application/json" }
    );

    const a = document.createElement("a");

    const nomFitxer =
        "phoenixtech-" +
        alumne.firstname.replaceAll(" ", "_") + "_" +
        alumne.lastname.replaceAll(" ", "_") +
        ".json";

    a.href = URL.createObjectURL(blob);
    a.download = nomFitxer;

    a.click();

});


// ===============================
// INICIALITZAR
// ===============================

window.addEventListener("DOMContentLoaded", async () => {

    await carregarAlumnes();

    preguntesAssignades = obtenirPreguntesAssignades();

    renderQuestion();

});


// ===============================
// RESET AMB TECLAT
// ===============================

document.addEventListener("keydown", (event) => {

    if (event.ctrlKey && event.shiftKey && event.key === "R") {

        const confirmar = confirm(
            "Reiniciar qüestionari per al següent alumne?"
        );

        if (!confirmar) return;

        localStorage.removeItem("phoenixtech_questions");

        document.querySelectorAll("textarea").forEach(t => {
            t.value = "";
            t.classList.remove("error");
        });

        preguntesAssignades = obtenirPreguntesAssignades();
        currentQuestionIndex = 0;

        renderQuestion();

        const select = document.getElementById("studentSelect");
        if (select) select.value = "";

    }

});
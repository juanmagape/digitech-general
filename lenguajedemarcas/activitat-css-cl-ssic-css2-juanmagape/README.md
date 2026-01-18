[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/W_xFP-qT)
[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-2e0aaae1b6195c2367325f4f02e2d04e9abb55f0b24a779b69b11b9e10269abc.svg)](https://classroom.github.com/online_ide?assignment_repo_id=21569323&assignment_repo_type=AssignmentRepo)

# DAM 0373 — Activitat "CSS clàssic (CSS2)"

> **Modalitat:** individual

## Enunciat

Basant-vos en el [Curs de CSS en català](https://jpardo20.github.io/curscss/index.php.html) cal que:

1) Respongueu el **qüestionari** (**`q-css2.md`**): teoria de selecció, cascada, herència, box model, posicionament.

> 
> Respon editant el fitxer [**`q-css2.md`**](./q-css2.md) del teu repositori.
>

2) Feu la vostra pàgina web estilitzant [**`index.html`**](./index.html) i només fent servir CSS **clàssic** ([**`styles.css`**](./styles.css)), sense fer servir ni **`Flex`**, ni **`Grid`**, ni **`var()`**, ni **`:is/:has/:where`**, etc.

> 
> Respon editant el fitxer [**`index.html`**](./index.html) del teu repositori. Cal que comenteu tot allò que feu, ja sigui dins del fitxer **`index.html`** com del fitxer **`styles.css`**.
>


### Requisits clau

- Dues columnes amb **floats** o `position`, *clearfix* o conteniment del flux.


> El contingut queda en dues columnes: **`main`** (columna principal) i **`aside`** (lateral).
> 
> Les columnes no es trepitgen i el contenidor **`content`** envolta els seus fills (no queda “col·lapsat”).
> 
> Ús de float (esquerra/dreta) o de position (absolute/relative/fixed) per aconseguir el **`layout`**.

- **LVHA**: estats diferenciats.

> Hi ha quatre regles visibles i diferenciades:
> 
> **`a:link`**, **`a:visited`**, **`a:hover`**, **`a:active`**.
> 
> Els estats es veuen diferents (color, subratllat, etc.).

- Taula `.dades` bàsica amb `border-collapse` i capçalera diferenciada.

> La taula té files amb vores i padding a les cel·les.
> 
> La fila de capçalera es distingix visualment (fons, negreta, etc.).
>

- Regles d’impressió `@media print` mínimes.

>
> Existeix un bloc **`@media print { ... }`**.
> 
> En imprimir, s’oculta la navegació i el lateral com a mínim (**`nav`**, **`aside`**).
> 
> L’ample del **`page`** s’adapta (sense la caixa fixa).
> 

**IMPORTANT**: L’HTML es pot tocar **només** per afegir `id`/`class` i contingut (no canviïs l’estructura).

## Lliurament

- Puja els fitxers: **`index.html`**, **`styles.css`**, i **`q-css2.md`** al teu repo.


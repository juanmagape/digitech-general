[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/4a0ZG0kF)
[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-2e0aaae1b6195c2367325f4f02e2d04e9abb55f0b24a779b69b11b9e10269abc.svg)](https://classroom.github.com/online_ide?assignment_repo_id=22073560&assignment_repo_type=AssignmentRepo)
# Mòdul 0483 – Sistemes informàtics

## Activitat: Procés d’arrencada amb Windows 11 (UEFI) - 0483-ae007

### Objectiu de l’Assignment

Aquest repositori és l’**assignment oficial de GitHub Classroom** per a l’activitat sobre el **procés d’arrencada de Windows 11 amb UEFI - 0483-ae007**.

 *  **Tot el que has de fer i lliurar està explicat en aquest repositori.**  
 *  El professor **avaluarà directament el contingut que entreguis** seguint les instruccions indicades.

### Què s’avalua en aquesta activitat

Amb aquesta activitat es valora que siguis capaç de:

- Entendre i explicar el **procés d’arrencada d’un sistema Windows modern**.
- Diferenciar **BIOS/MBR** de **UEFI/GPT**.
- Identificar el funcionament del **Windows Boot Manager**.
- Utilitzar correctament l’eina **bcdedit**.
- Documentar correctament el teu treball amb evidències reals.

### Estructura del repositori (NO la modifiquis)

```text
0483-arrencada-windows11/
├── README.md        ← ENUNCIAT (no s’ha de modificar)
├── respostes.md     ← Document de respostes (obligatori)
└── evidencies/      ← Captures i proves (obligatori)
    ├── disc-particions.png
    └── bcdedit.txt
```

**Important**
- **NO modifiquis el fitxer `README.md`**.
- Escriu les teves respostes **només** als fitxers indicats.
- No canviïs els noms dels fitxers ni carpetes.
- Repositoris que no respectin aquesta estructura poden no ser avaluats correctament.

## Abans de començar

Es dona per fet que:
- Tens descarregada la **ISO de Windows 11**.
- Treballes amb **VirtualBox**.
- Ja s’han explicat a classe:
  - POST
  - BIOS vs UEFI
  - MBR vs GPT
  - Procés d’arrencada de Windows

**No instal·lis Linux** en aquesta activitat.

## Tasca 1 – Preparació de la màquina virtual

1. Crea una màquina virtual amb:
   - Sistema operatiu: **Windows 11**
   - Arquitectura: **64 bits**
   - Firmware: **UEFI (obligatori)**

2. Instal·la Windows 11 utilitzant la ISO.

3. Un cop instal·lat:
   - Obre **Administració de discos**.
   - Fes una captura on es vegin clarament les particions.
   - Desa la captura com:
     ```
     evidencies/disc-particions.png
     ```

## Tasca 2 – Documentació de les particions

Edita el fitxer **respostes.md** i indica:

- Quin esquema de particions utilitza el sistema (GPT o MBR).
- Quines particions apareixen i per a què serveixen:
  - Partició EFI
  - Partició MSR
  - Partició Windows

## Tasca 3 – Procés d’arrencada de Windows 11

Al fitxer **respostes.md**, completa la taula següent:

| Fase | Què passa | Component implicat |
|----|----|----|
| Encès |  |  |
| POST |  |  |
| Firmware |  |  |
| Gestor d’arrencada |  |  |
| Sistema operatiu |  |  |

No es valora memoritzar, sinó **entendre i explicar amb paraules pròpies**.

## Tasca 4 – Gestor d’arrencada (BCDEDIT)

1. Obre el **Símbol del sistema com a administrador**.
2. Executa:
   ```bat
   bcdedit
   ```
3. Copia **tota la sortida** de la comanda i desa-la en el fitxer:
   ```
   evidencies/bcdedit.txt
   ```

4. Identifica:
   - `{bootmgr}`
   - `{current}`
   - El valor de `timeout`

5. Modifica el temps d’espera del menú d’arrencada:
   ```bat
   bcdedit /timeout 10
   ```

6. Al fitxer **respostes.md**, indica:
   - Valor inicial del `timeout`
   - Valor final
   - Comanda utilitzada

**No es permet esborrar ni crear entrades del gestor d’arrencada.**

## Tasca 5 – Reflexió tècnica

Edita el fitxer **respostes.md**, i sota el títol **`## Reflexió tècnica`**, respon de manera clara i raonada:

1. Per què **Windows 11 no pot funcionar en mode BIOS antic**?
2. Quins avantatges té **UEFI + GPT** respecte BIOS + MBR?
3. On s’emmagatzema la configuració d’arrencada de Windows?
4. Què passaria si s’esborra la **partició EFI**?

Respostes pròpies, amb vocabulari tècnic.

## Què s’ha de lliurar

El repositori ha de contenir obligatòriament:

- `respostes.md` completat
- `evidencies/disc-particions.png`
- `evidencies/bcdedit.txt`

Tot pujat correctament al **repositori de GitHub Classroom**.

## Criteris d’avaluació

| Aspecte | Pes |
|------|----|
| Procés d’arrencada ben explicat | 40% |
| Relació teoria – evidències | 30% |
| Ús correcte de **`bcdedit`** | 20% |
| Claredat, ordre i format | 10% |

## Avisos importants

- L’activitat és **individual**.
- Es revisarà la coherència entre:
  - Respostes
  - Evidències
  - Configuració real del sistema
- Repositoris incomplets o amb l’enunciat modificat **no es s'avaluaran com a correctes**.


## Quan acabes

- Fes un últim **commit** amb exactament el següent missatge **`"Activitat finalitzada"`**.
- Assegura’t que **tot està pujat** al repositori.
- No cal fer cap entrega addicional: **el professor corregirà directament el repositori**.


## Aquesta activitat és clau per entendre l’arrencada, el dual boot i la recuperació de sistemes en el mòdul 0483.*


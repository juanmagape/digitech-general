#!/bin/bash
# netejar-carpeta.sh
# -------------------
# Script de manteniment per 1r DAM.
# Mou alguns fitxers de la carpeta de Descàrregues a una subcarpeta "Arxiu".
#
# En concret:
#   - Origen:  carpeta de Descàrregues de l'usuari.
#   - Destí:   subcarpeta "Arxiu" dins de Descàrregues.
#   - Fitxers: només els que acaben en .pdf o .zip
#
# OBJECTIU DIDÀCTIC:
#   - Fer servir variables.
#   - Comprovar si una carpeta existeix.
#   - Crear carpetes si cal.
#   - Construir una LLISTA_FITXERS amb un patró (glob).
#   - Recorre la llista amb un bucle for.
#   - Comptar quants fitxers hem mogut.

# ----------------------------------------------------------
# 1. DEFINIR LA CARPETA D'ORIGEN
# ----------------------------------------------------------
# Fem servir la carpeta Downloads de l'usuari actual.
# $HOME és la carpeta personal (per ex.: /home/joan)

ORIGEN="$HOME/Downloads"

# Comprovem que la carpeta existeix.
# Si no existeix, mostrem un missatge d'error i sortim.
if [ ! -d "$ORIGEN" ]; then
    echo "ERROR: No s'ha trobat la carpeta d'origen: $ORIGEN"
    echo "Revisa la variable ORIGEN dins de l'script."
    exit 1   # Codi de sortida diferent de 0 = ha passat alguna cosa malament
fi

# ----------------------------------------------------------
# 2. DEFINIR LA CARPETA DESTÍ (Arxiu dins de Descàrregues)
# ----------------------------------------------------------

DESTI="$ORIGEN/Arxiu"

# Si la carpeta d'Arxiu no existeix, la creem.
if [ ! -d "$DESTI" ]; then
    echo "Creant la carpeta destí: $DESTI"
    mkdir -p "$DESTI"
fi

echo "Carpeta origen: $ORIGEN"
echo "Carpeta destí:  $DESTI"
echo

# ----------------------------------------------------------
# 3. CONSTRUIR LA LLISTA DE FITXERS QUE VOLEM TRACTAR
# ----------------------------------------------------------
# Volem només els fitxers .pdf i .zip de la carpeta ORIGEN.
#
# Això ho podem provar primer al terminal:
#   ORIGEN="$HOME/Downloads"
#   "$ORIGEN"/*.{pdf,zip}
#
# Això ( "$ORIGEN"/*.{pdf,zip} ) és un PATRÓ que la shell
# converteix en una LLISTA DE FITXERS.
#
# Ara farem el mateix, però guardant aquesta llista a la variable LLISTA_FITXERS.

LLISTA_FITXERS="$ORIGEN"/*.{pdf,zip}

# IMPORTANT:
#   - "$ORIGEN" va entre cometes (per si algun dia té espais).
#   - El patró *.{pdf,zip} NO va entre cometes, perquè s'ha d'expandir.

# ----------------------------------------------------------
# 4. RECÓRRER LA LLISTA AMB UN BUCLE FOR
# ----------------------------------------------------------

COMPTADOR=0    # Comptarà quants fitxers hem mogut

# Recorrem tots els elements de la llista de fitxers.
# FORMA GENERAL:
#   for VARIABLE in LLISTA_DE_COSES; do
#       ...
#   done
#
# En el nostre cas:
#   - LLISTA_DE_COSES és la variable LLISTA_FITXERS.

for FITXER in $LLISTA_FITXERS; do

    # Si no és un fitxer normal (pot ser una carpeta o alguna cosa rara), el saltem.
    if [ ! -f "$FITXER" ]; then
        continue
    fi

    # Nom del fitxer sense la ruta (només per mostrar-ho bonic).
    NOM_FITXER=$(basename "$FITXER")

    echo "Movent: $NOM_FITXER"
    mv -- "$FITXER" "$DESTI/"

    COMPTADOR=$((COMPTADOR + 1))
done

# ----------------------------------------------------------
# 5. MISSATGE FINAL
# ----------------------------------------------------------

if [ "$COMPTADOR" -eq 0 ]; then
    echo "No s'ha mogut cap fitxer: no hi havia fitxers .pdf ni .zip a l'origen."
else
    echo
    echo "Operació completada. Fitxers moguts: $COMPTADOR"
fi

# Si arribem aquí, considerem que tot ha anat bé.
exit 0

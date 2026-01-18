#!/bin/bash
# backup-carpeta.sh
# -------------------
# Script de manteniment per fer una còpia de seguretat senzilla
# d'una carpeta de treball a una carpeta de backup.
#
# En concret:
#   - ORIGEN: carpeta amb els fitxers de treball (per exemple, DAM).
#   - DESTI:  carpeta on guardarem la còpia de seguretat.
#   - Es copien TOTS els fitxers normals (no carpetes) d'ORIGEN a DESTI.
#
# OBJECTIU DIDÀCTIC:
#   - Fer servir variables.
#   - Comprovar si una carpeta existeix.
#   - Crear carpetes si cal.
#   - Recorre fitxers amb un bucle for.
#   - Comptar quants fitxers hem copiat.

# ----------------------------------------------------------
# 1. DEFINIR LA CARPETA D'ORIGEN I DESTÍ
# ----------------------------------------------------------
# Pots adaptar aquestes rutes al que feu a classe.
# Exemple: carpeta de treball "DAM" dins de Documents.

ORIGEN="$HOME/Documents/DAM"
DESTI="$HOME/backup-dam"

# Comprovem que la carpeta ORIGEN existeix.
if [ ! -d "$ORIGEN" ]; then
    echo "ERROR: No s'ha trobat la carpeta d'origen: $ORIGEN"
    echo "Revisa la variable ORIGEN dins de l'script."
    exit 1  # codi de sortida diferent de 0 = alguna cosa ha anat malament
fi

# Si la carpeta DESTI no existeix, la creem.
if [ ! -d "$DESTI" ]; then
    echo "Creant la carpeta destí: $DESTI"
    mkdir -p "$DESTI"
fi

echo "Carpeta origen: $ORIGEN"
echo "Carpeta destí:  $DESTI"
echo

# ----------------------------------------------------------
# 2. RECÓRRER ELS FITXERS I COPIAR-LOS
# ----------------------------------------------------------

COMPTADOR=0  # Comptarà quants fitxers hem copiat

# Recorrem tots els elements de la carpeta d'origen
for FITXER in "$ORIGEN"/*; do
    # Si no és un fitxer normal, el saltem (carpetes, enllaços, etc.)
    if [ ! -f "$FITXER" ]; then
        continue
    fi

    NOM_FITXER=$(basename "$FITXER")
    echo "Copiant: $NOM_FITXER"
    cp -- "$FITXER" "$DESTI/"
    COMPTADOR=$((COMPTADOR + 1))
done

# ----------------------------------------------------------
# 3. MISSATGE FINAL
# ----------------------------------------------------------

if [ "$COMPTADOR" -eq 0 ]; then
    echo "No s'ha copiat cap fitxer: no hi havia fitxers normals a l'origen."
else
    echo
    echo "Còpia de seguretat completada. Fitxers copiats: $COMPTADOR"
fi

# NOTA:
# Si també vols copiar subcarpetes, es podria fer servir:
#   cp -r "$ORIGEN"/* "$DESTI"/
# però aquí ho deixem senzill i explícit amb el bucle.

exit 0  # codi de sortida 0 = tot ha anat bé

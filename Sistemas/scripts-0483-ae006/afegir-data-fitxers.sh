#!/bin/bash
# afegir-data-fitxers.sh
# -----------------------
# Script de manteniment per reanomenar fitxers .log
# i afegir-hi la data actual al nom.
#
# Exemple:
#   error.log  -> error-20251205.log
#   servei.log -> servei-20251205.log
#
# OBJECTIU DIDÀCTIC:
#   - Fer servir variables.
#   - Treballar amb la data (date).
#   - Recorre fitxers .log.
#   - Manipular noms de fitxer (treure l'extensió, construir un nou nom).
#   - Reanomenar fitxers amb mv.

# ----------------------------------------------------------
# 1. DEFINIR LA CARPETA ON TREBALLAREM
# ----------------------------------------------------------
# Pots adaptar aquesta carpeta a la realitat de l'aula.
# Exemple: carpeta "logs" dins de la carpeta personal.

CARPETA="$HOME/logs"

if [ ! -d "$CARPETA" ]; then
    echo "ERROR: No s'ha trobat la carpeta: $CARPETA"
    echo "Crea-la o canvia la variable CARPETA dins de l'script."
    exit 1
fi

# ----------------------------------------------------------
# 2. OBTENIR LA DATA EN FORMAT YYYYMMDD
# ----------------------------------------------------------

DATA=$(date +%Y%m%d)
echo "Data actual (YYYYMMDD): $DATA"
echo "Treballant a la carpeta: $CARPETA"
echo

# ----------------------------------------------------------
# 3. RECÓRRER ELS FITXERS .log I REANOMENAR-LOS
# ----------------------------------------------------------

COMPTADOR=0

# Recorrem tots els fitxers .log de la carpeta
for FITXER in "$CARPETA"/*.log; do
    # Si no és un fitxer normal, el saltem.
    if [ ! -f "$FITXER" ]; then
        continue
    fi

    NOM_FITXER=$(basename "$FITXER")    # ex: error.log
    BASE="${NOM_FITXER%.log}"           # ex: error
    NOU_NOM="${BASE}-${DATA}.log"       # ex: error-20251205.log

    echo "Reanomenant: $NOM_FITXER  ->  $NOU_NOM"
    mv -- "$FITXER" "$CARPETA/$NOU_NOM"
    COMPTADOR=$((COMPTADOR + 1))
done

# ----------------------------------------------------------
# 4. MISSATGE FINAL
# ----------------------------------------------------------

if [ "$COMPTADOR" -eq 0 ]; then
    echo "No s'ha reanomenat cap fitxer: no hi havia fitxers .log a la carpeta."
else
    echo
    echo "Operació completada. Fitxers reanomenats: $COMPTADOR"
fi

exit 0

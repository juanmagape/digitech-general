#!/bin/bash
# informe-disc.sh
# ----------------
# Script de manteniment per generar un petit informe d'espai de disc.
#
# L'informe inclou:
#   - Data i hora actuals.
#   - Sortida de df -h (espai de disc dels volums).
#   - Mida d'una carpeta concreta (du -sh).
#
# OBJECTIU DIDÀCTIC:
#   - Treballar amb date, df i du.
#   - Redirigir sortides a un fitxer (>, >>).
#   - Generar un informe de text.

# ----------------------------------------------------------
# 1. DEFINIR CARPETA A ANALITZAR I FITXER D'INFORME
# ----------------------------------------------------------

CARPETA_ANALITZAR="$HOME/Documents"
INFORME="$HOME/informe-disc.txt"

if [ ! -d "$CARPETA_ANALITZAR" ]; then
    echo "ATENCIÓ: No s'ha trobat la carpeta a analitzar: $CARPETA_ANALITZAR"
    echo "L'informe es generarà igualment, però sense la mida d'aquesta carpeta."
    CARPETA_OK="no"
else
    CARPETA_OK="si"
fi

# ----------------------------------------------------------
# 2. PREPARAR L'INFORME (HEADER)
# ----------------------------------------------------------

DATA_HORA=$(date "+%Y-%m-%d %H:%M:%S")

echo "========================================" >  "$INFORME"
echo " INFORME D'ESPAI DE DISC"              >> "$INFORME"
echo " Generat el: $DATA_HORA"              >> "$INFORME"
echo " Fitxer: $INFORME"                    >> "$INFORME"
echo "========================================" >> "$INFORME"
echo                                          >> "$INFORME"

# ----------------------------------------------------------
# 3. AFEGIR INFORMACIÓ DE df -h
# ----------------------------------------------------------

echo "== ESPAI DE DISC (df -h) =="           >> "$INFORME"
df -h                                        >> "$INFORME"
echo                                          >> "$INFORME"

# ----------------------------------------------------------
# 4. AFEGIR MIDA D'UNA CARPETA CONCRETA (du -sh)
# ----------------------------------------------------------

echo "== MIDA DE LA CARPETA: $CARPETA_ANALITZAR ==" >> "$INFORME"

if [ "$CARPETA_OK" = "si" ]; then
    du -sh "$CARPETA_ANALITZAR"             >> "$INFORME" 2>>"$INFORME"
else
    echo "No s'ha pogut calcular: la carpeta no existeix." >> "$INFORME"
fi

echo                                          >> "$INFORME"
echo "Fi de l'informe."                       >> "$INFORME"

# ----------------------------------------------------------
# 5. MISSATGE FINAL PER PANTALLA
# ----------------------------------------------------------

echo "Informe generat al fitxer:"
echo "  $INFORME"

exit 0

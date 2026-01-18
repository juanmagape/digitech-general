# afegir-data-fitxers.ps1
# ------------------------
# Script de manteniment per reanomenar fitxers .log
# i afegir-hi la data actual al nom.
#
# Exemple:
#   error.log  -> error-20251205.log
#   servei.log -> servei-20251205.log
#
# OBJECTIU DIDÀCTIC:
#   - Fer servir variables.
#   - Treballar amb la data (Get-Date -Format).
#   - Recorre fitxers .log.
#   - Manipular noms de fitxer (BaseName, Extension).
#   - Reanomenar fitxers amb Rename-Item.

# ----------------------------------------------------------
# 1. DEFINIR LA CARPETA ON TREBALLAREM
# ----------------------------------------------------------

$Carpeta = Join-Path $HOME "logs"

if (-not (Test-Path -LiteralPath $Carpeta)) {
    Write-Error "ERROR: No s'ha trobat la carpeta: $Carpeta"
    Write-Host  "Crea-la o canvia la variable `\$Carpeta dins de l'script."
    exit 1
}

# ----------------------------------------------------------
# 2. OBTENIR LA DATA EN FORMAT YYYYMMDD
# ----------------------------------------------------------

$Data = Get-Date -Format "yyyyMMdd"
Write-Host "Data actual (YYYYMMDD): $Data"
Write-Host "Treballant a la carpeta: $Carpeta"
Write-Host ""

# ----------------------------------------------------------
# 3. RECÓRRER ELS FITXERS .log I REANOMENAR-LOS
# ----------------------------------------------------------

[int]$Comptador = 0

$Fitxers = Get-ChildItem -Path $Carpeta -Filter *.log -File -ErrorAction SilentlyContinue

if (-not $Fitxers) {
    Write-Host "No hi ha fitxers .log a la carpeta. Res per reanomenar."
    exit 0
}

foreach ($Fitxer in $Fitxers) {
    $Base = $Fitxer.BaseName      # ex: error
    $Ext  = $Fitxer.Extension     # ex: .log

    $NouNom    = "$Base-$Data$Ext"
    $NouFitxer = Join-Path $Carpeta $NouNom

    Write-Host "Reanomenant: $($Fitxer.Name)  ->  $NouNom"
    Rename-Item -Path $Fitxer.FullName -NewName $NouNom
    $Comptador++
}

# ----------------------------------------------------------
# 4. MISSATGE FINAL
# ----------------------------------------------------------

if ($Comptador -eq 0) {
    Write-Host "No s'ha reanomenat cap fitxer."
} else {
    Write-Host ""
    Write-Host "Operació completada. Fitxers reanomenats: $Comptador"
}

exit 0

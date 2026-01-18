# backup-carpeta.ps1
# --------------------
# Script de manteniment per fer una còpia de seguretat senzilla
# d'una carpeta de treball a una carpeta de backup.
#
# En concret:
#   - $Origen: carpeta amb els fitxers de treball (per exemple, DAM).
#   - $Desti:  carpeta on guardarem la còpia de seguretat.
#   - Es copien TOTS els fitxers normals (no carpetes) d'Origen a Desti.
#
# OBJECTIU DIDÀCTIC:
#   - Fer servir variables.
#   - Comprovar si una carpeta existeix (Test-Path).
#   - Crear carpetes si cal (New-Item).
#   - Recorre fitxers amb foreach.
#   - Comptar quants fitxers hem copiat.

# ----------------------------------------------------------
# 1. DEFINIR LA CARPETA D'ORIGEN I DESTÍ
# ----------------------------------------------------------
# Pots adaptar aquestes rutes a la teva màquina.
# Exemple: carpeta de treball "DAM" dins de Documents.

$Origen = Join-Path $HOME "Documents\DAM"
$Desti  = Join-Path $HOME "backup-dam"

# Comprovem que la carpeta Origen existeix.
if (-not (Test-Path -LiteralPath $Origen)) {
    Write-Error "ERROR: No s'ha trobat la carpeta d'origen: $Origen"
    Write-Host  "Revisa la variable `\$Origen dins de l'script."
    exit 1
}

# Creem la carpeta Desti si no existeix.
if (-not (Test-Path -LiteralPath $Desti)) {
    Write-Host "Creant la carpeta destí: $Desti"
    New-Item -ItemType Directory -Path $Desti -Force | Out-Null
}

Write-Host "Carpeta origen: $Origen"
Write-Host "Carpeta destí:  $Desti"
Write-Host ""

# ----------------------------------------------------------
# 2. RECÓRRER ELS FITXERS I COPIAR-LOS
# ----------------------------------------------------------

[int]$Comptador = 0  # Comptarà quants fitxers hem copiat

# Agafem només fitxers normals (no carpetes)
$Fitxers = Get-ChildItem -Path $Origen -File -ErrorAction SilentlyContinue

if (-not $Fitxers) {
    Write-Host "No hi ha fitxers normals a la carpeta d'origen. Res per copiar."
    exit 0
}

foreach ($Fitxer in $Fitxers) {
    $NomFitxer = $Fitxer.Name
    Write-Host "Copiant: $NomFitxer"
    Copy-Item -Path $Fitxer.FullName -Destination $Desti
    $Comptador++
}

# ----------------------------------------------------------
# 3. MISSATGE FINAL
# ----------------------------------------------------------

if ($Comptador -eq 0) {
    Write-Host "No s'ha copiat cap fitxer."
} else {
    Write-Host ""
    Write-Host "Còpia de seguretat completada. Fitxers copiats: $Comptador"
}

exit 0

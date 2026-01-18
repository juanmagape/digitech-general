# netejar-carpeta.ps1
# --------------------
# Script de manteniment per 1r DAM.
# Mou alguns fitxers de la carpeta de Descàrregues a una subcarpeta "Arxiu".
#
# En concret:
#   - Origen:  carpeta de Descàrregues (Downloads) de l'usuari actual.
#   - Destí:   subcarpeta "Arxiu" dins de Descàrregues.
#   - Fitxers: només els que acaben en .pdf o .zip
#
# OBJECTIU DIDÀCTIC:
#   - Fer servir variables.
#   - Comprovar si una carpeta existeix (Test-Path).
#   - Crear carpetes si cal (New-Item).
#   - Construir una llista de fitxers amb Get-ChildItem.
#   - Recorre la llista amb un foreach.
#   - Comptar quants fitxers hem mogut.

# ----------------------------------------------------------
# 1. DEFINIR LA CARPETA D'ORIGEN
# ----------------------------------------------------------
# En PowerShell tenim la variable $HOME, semblant a $HOME a Bash.
# Aquí suposem que la carpeta de Descàrregues és "Downloads" dins del perfil.

$Origen = Join-Path $HOME "Downloads"

# Comprovem que la carpeta existeix.
if (-not (Test-Path -LiteralPath $Origen)) {
    Write-Error "ERROR: No s'ha trobat la carpeta d'origen: $Origen"
    Write-Host  "Revisa la variable `\$Origen dins de l'script."
    exit 1      # Codi de sortida diferent de 0 = ha passat alguna cosa malament
}

# ----------------------------------------------------------
# 2. DEFINIR LA CARPETA DESTÍ (Arxiu dins de Descàrregues)
# ----------------------------------------------------------

$Desti = Join-Path $Origen "Arxiu"

# Si la carpeta d'Arxiu no existeix, la creem.
if (-not (Test-Path -LiteralPath $Desti)) {
    Write-Host "Creant la carpeta destí: $Desti"
    New-Item -ItemType Directory -Path $Desti -Force | Out-Null
}

Write-Host "Carpeta origen: $Origen"
Write-Host "Carpeta destí:  $Desti"
Write-Host ""

# ----------------------------------------------------------
# 3. CONSTRUIR LA LLISTA DE FITXERS QUE VOLEM TRACTAR
# ----------------------------------------------------------
# Volem només els fitxers .pdf i .zip de la carpeta Origen.
#
# Això ho podem provar primer al PowerShell:
#
#   $Origen = Join-Path $HOME "Downloads"
#   Get-ChildItem -Path (Join-Path $Origen "*") -Include *.pdf, *.zip -File
#
# Això ens dona una LLISTA D'OBJECTES "fitxer".
#
# Ara farem el mateix, però guardant aquesta llista a la variable $LlistaFitxers.

$LlistaFitxers = Get-ChildItem `
    -Path    (Join-Path $Origen "*") `
    -Include *.pdf, *.zip `
    -File `
    -ErrorAction SilentlyContinue

# Si no hi ha cap fitxer que coincideixi, $LlistaFitxers serà buit o $null.

# ----------------------------------------------------------
# 4. RECÓRRER LA LLISTA AMB UN BUCLE FOREACH
# ----------------------------------------------------------

[int]$Comptador = 0   # Comptarà quants fitxers hem mogut

# Si no hi ha cap fitxer a la llista, informem i sortim.
if (-not $LlistaFitxers) {
    Write-Host "No hi ha fitxers .pdf ni .zip a la carpeta d'origen. Res per moure."
    exit 0
}

# Recorrem tots els fitxers de la llista.
# FORMA GENERAL:
#   foreach ($element in $llista) { ... }
#
# En el nostre cas:
#   - $llista és $LlistaFitxers.
#   - $element és $Fitxer.

foreach ($Fitxer in $LlistaFitxers) {

    # Per seguretat, comprovem que no sigui una carpeta (hauria de ser només fitxers).
    if ($Fitxer.PSIsContainer) {
        continue
    }

    # Nom del fitxer (sense la ruta), per mostrar-ho bonic.
    $NomFitxer  = $Fitxer.Name

    # Ruta completa de destí per a aquest fitxer.
    $DestiFitxer = Join-Path $Desti $NomFitxer

    Write-Host "Movent: $NomFitxer"
    Move-Item -Path $Fitxer.FullName -Destination $DestiFitxer

    $Comptador++
}

# ----------------------------------------------------------
# 5. MISSATGE FINAL
# ----------------------------------------------------------

if ($Comptador -eq 0) {
    Write-Host "No s'ha mogut cap fitxer: no hi havia fitxers .pdf ni .zip a l'origen."
} else
{
    Write-Host ""
    Write-Host "Operació completada. Fitxers moguts: $Comptador"
}

# Si arribem aquí, considerem que tot ha anat bé.
exit 0

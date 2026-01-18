# informe-disc.ps1
# -----------------
# Script de manteniment per generar un petit informe d'espai de disc.
#
# L'informe inclou:
#   - Data i hora actuals.
#   - Informació dels volums de fitxers (Get-PSDrive FileSystem).
#   - Mida aproximada d'una carpeta concreta.
#
# OBJECTIU DIDÀCTIC:
#   - Treballar amb Get-Date, Get-PSDrive, Get-ChildItem, Measure-Object.
#   - Redirigir i afegir text a un fitxer (Out-File, Add-Content).
#   - Generar un informe de text.

# ----------------------------------------------------------
# 1. DEFINIR CARPETA A ANALITZAR I FITXER D'INFORME
# ----------------------------------------------------------

$CarpetaAnalitzar = Join-Path $HOME "Documents"
$Informe          = Join-Path $HOME "informe-disc.txt"

if (-not (Test-Path -LiteralPath $CarpetaAnalitzar)) {
    Write-Host "ATENCIÓ: No s'ha trobat la carpeta a analitzar: $CarpetaAnalitzar"
    Write-Host "L'informe es generarà igualment, però sense la mida d'aquesta carpeta."
    $CarpetaOK = $false
} else {
    $CarpetaOK = $true
}

# ----------------------------------------------------------
# 2. PREPARAR L'INFORME (HEADER)
# ----------------------------------------------------------

$DataHora = Get-Date -Format "yyyy-MM-dd HH:mm:ss"

"========================================" | Out-File -FilePath $Informe
" INFORME D'ESPAI DE DISC"                | Add-Content -Path $Informe
" Generat el: $DataHora"                  | Add-Content -Path $Informe
" Fitxer: $Informe"                       | Add-Content -Path $Informe
"========================================" | Add-Content -Path $Informe
""                                        | Add-Content -Path $Informe

# ----------------------------------------------------------
# 3. AFEGIR INFORMACIÓ DELS VOLUMS (Get-PSDrive)
# ----------------------------------------------------------

"== ESPAI DE DISC DELS VOLUMS (Get-PSDrive FileSystem) ==" | Add-Content -Path $Informe

# Convertim la sortida a string perquè quedi bé al fitxer.
$drivesInfo = Get-PSDrive -PSProvider FileSystem | Format-Table -AutoSize | Out-String
$drivesInfo | Add-Content -Path $Informe
""          | Add-Content -Path $Informe

# ----------------------------------------------------------
# 4. AFEGIR MIDA D'UNA CARPETA CONCRETA
# ----------------------------------------------------------

"== MIDA (aproximada) DE LA CARPETA: $CarpetaAnalitzar ==" | Add-Content -Path $Informe

if ($CarpetaOK) {

    # Sumem la mida (Length) de tots els fitxers de la carpeta (i subcarpetes)
    $midaBytes = (Get-ChildItem -Path $CarpetaAnalitzar -Recurse -File -ErrorAction SilentlyContinue |
                  Measure-Object -Property Length -Sum).Sum

    if ($midaBytes -gt 0) {
        $midaMB = [math]::Round($midaBytes / 1MB, 2)
        "Mida aproximada: $midaMB MB" | Add-Content -Path $Informe
    } else {
        "No s'ha pogut calcular (cap fitxer o accés restringit)." | Add-Content -Path $Informe
    }
} else {
    "No s'ha pogut calcular: la carpeta no existeix." | Add-Content -Path $Informe
}

""                  | Add-Content -Path $Informe
"Fi de l'informe." | Add-Content -Path $Informe

# ----------------------------------------------------------
# 5. MISSATGE FINAL PER PANTALLA
# ----------------------------------------------------------

Write-Host "Informe generat al fitxer:"
Write-Host "  $Informe"

exit 0

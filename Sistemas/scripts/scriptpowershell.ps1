#!/bin/bash

$carpetaRevisarDown = "$HOME/Downloads/"
$carpetaRevisarDocs = "$HOME/Documents/"
$carpetaRevisarDesk = "$HOME/Desktop/"
$carpetaRevisarPict = "$HOME/Pictures/"

$data = Get-Date -Format "yyyyMMdd_HHmm"


$archivo = "$data-logs-powershell.txt"
Get-Date | Out-File -FilePath $archivo


"Espacio en disco" | Add-Content $archivo
Get-PSDrive -PSProvider FileSystem | Add-Content $archivo
"" | Add-Content $archivo


"Espacio en carpetas" | Add-Content $archivo
$espacioDown = (Get-ChildItem -Recurse $carpetaRevisarDown | Measure-Object Length -Sum).Sum
$espacioDocs = (Get-ChildItem -Recurse $carpetaRevisarDocs | Measure-Object Length -Sum).Sum
$espacioPict = (Get-ChildItem -Recurse $carpetaRevisarDesk | Measure-Object Length -Sum).Sum
$espacioPict = (Get-ChildItem -Recurse $carpetaRevisarPict | Measure-Object Length -Sum).Sum 

"Downloads: $([math]::Round($espacioDown / 1MB, 2)) MB" | Add-Content $archivo
"Documents: $([math]::Round($espacioDocs / 1MB, 2)) MB" | Add-Content $archivo
"Desktop:   $([math]::Round($espacioDesk / 1MB, 2)) MB" | Add-Content $archivo
"Pictures:  $([math]::Round($espacioPict / 1MB, 2)) MB" | Add-Content $archivo
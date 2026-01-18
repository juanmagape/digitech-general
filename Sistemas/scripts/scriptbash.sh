#!/bin/bash

#Creamos variables con las carpetas que utilizaremos posteriormente para el informe de carpetas
carpetaRevisarDown="$HOME/Documents/"
carpetaRevisarDocs="$HOME/Downloads/"
carpetaRevisarDesk="$HOME/Desktop/"
carpetaRevisarPict="$HOME/Pictures/"

#Creamos las variables de fecha para el nombre de archivo, y archivo, que será el archivo que crearemos 
#y donde guardaremos toda la información
fecha=$(date +%Y%m%d_%H%M)
archivo="logs$fecha.txt"

#Creamos el archivo, llamando a la variable archivo, que nos hará de nombre.
touch $archivo

#Hacemos un echo en el archivo, para definir lo que saldrá justo debajo, en este caso el informe de espacio de disco
echo "Inicio de informe de espacio de disco" >> $archivo
#Creamos un espacio para mejor visualización
echo " " >> $archivo
#Realizamos el comando para ver el estado del disco, y sus porcentages
df -h >> $archivo
#Creamos un espacio para mejor visualización
echo " " >> $archivo
#Creamos una linea de separación para crear el otro informe
echo "---------------------------------------------------" >> $archivo
#Creamos un espacio para mejor visualización
echo " " >> $archivo
#Creamos el echo para definir que justo debajo saldrá el informe de espacio de carpetas
echo "Informe de espacio de carpetas" >> $archivo
#Creamos un espacio para mejor visualización
echo " " >> $archivo

#En cada uno de estos 4 lineas, haremos un du -sh para ver cuanto ocupan las carpetas principales.
# Lo enviamos al archivo.
du -sh $carpetaRevisarDown >> $archivo
du -sh $carpetaRevisarDocs >> $archivo
du -sh $carpetaRevisarDesk >> $archivo
du -sh $carpetaRevisarPict >> $archivo

# Una vez creado el archivo, enviamos un mensaje por la terminal conforme se ha creado correctamente
echo "Fichero creado correctamente"

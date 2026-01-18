# Respostes Procés d’arrencada amb Windows 11 (UEFI) - 0483-ae007

## Nom Alumne: Juan Manuel

## Cognom Alumne: Galán Pérez

## Respostes raonades

- Quin esquema de particions utilitza el sistema (GPT o MBR). 

El sistema Windows 11 utilitza GPT, pel fet que necessita el mode d'arrencada UEFI, i aquest funciona només amb GPT.
- Quines particions apareixen i per a què serveixen:
  - Partició EFI 
  
La partició EFI serveix perquè quan l'equip s'encén, el firmware arrenqui el sistema operatiu.
  - Partició MSR - 
  
La partició MSR és un espai que reserva Windows en instal·lar-se per a ús del sistema, en concret la gestió interna del disc.

  - Partició Windows 

La partició Windows és l'espai reservat per al sistema i que pots utilitzar per a instal·lar programes i tenir arxius.

Aquesta partició es pot dividir i tenir un altre sistema operatiu

## Taula a completar:

| Fase | Què passa | Component implicat |
|----|----|----|
| Encès | Es fa la senyal anomenada "Power Good" i s'envia un reset al processador per evitar errors d'inici y protegir el sistema d'altes tensions | Font d'alimentació |
| POST | Comprovació del maquinari, en cas de que hi hagin problemes, s'emeten xiulets, que son equivalen a codis de error | BIOS i Maquinari |
| Firmware | La BIOS/UEFI busca els controladors en la ROM i localitza el dispositiu d'arrencada | BIOS/UEFI |
| Gestor d’arrencada | Busca un arxiu .efi, que es el que carrega el sistema | Gestors Bootmgr/GRUB |
| Sistema operatiu | Es carrega el sistema operatiu | Sistema Operatiu (Windows / Linux) |

## Enllaç a les evidències

BCDEDIT > https://github.com/DAM-2025-2027/proc-s-d-arrencada-amb-windows-11-uefi-0483-ae007-juanmagape/blob/main/evidencies/bcdedit.txt

DISC PARTICIONS > https://github.com/DAM-2025-2027/proc-s-d-arrencada-amb-windows-11-uefi-0483-ae007-juanmagape/blob/main/evidencies/disc-particions.png

## Dades a omplir

- Valor inicial del `timeout` 

  El valor inicial del timeout es de 30
- Valor final 

  El valor final del timeout es de 10
- Comanda utilitzada 

  La comanda que he utilitzat es: bcdedit /timeout 10

## Reflexió tècnica

1. Per què **Windows 11 no pot funcionar en mode BIOS antic**?

Windows 11 no funciona en BIOS antigues, ja que necessita de UEFI per a utilitzar les funcions de seguretat com Secure Boot.

A més, la UEFI permet controlar dispositius de 64bits, que Windows 11 necessita, i en les bios antigues no ho suporten.


2. Quins avantatges té **UEFI + GPT** respecte BIOS + MBR?

Suporten discs més grans de 2 terabytes.
Permeten més particions al sistema, fins a 128, en lloc a la BIOS + MBR només accepta 4.
Té més seguretat i fa una copia de seguretat de les particions per si falla.
Es molt més rápid el UEFI + GPT.


3. On s’emmagatzema la configuració d’arrencada de Windows?

La configuració d'arrencada es guarda a la partició EFI, i a dins té un arxiu de configuració que es diu BCD


4. Què passaria si s’esborra la **partició EFI**?

Que no trobaria els fitxers .efi y per tant no arrancaria el sistema operatiu.


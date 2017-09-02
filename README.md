# REST-SPOED #  

![alt text](https://i.imgur.com/8uOMzYm.png "Logo Title Text 1")

__Waarom kunnen REST en SOAP eigenlijk niet met elkaar vergeleken worden, maw wat is het fundamentele verschil tussen beiden?__

_REST is een  architectuur, via een soort van interface kan je genoemde resources aan passen/weergeven, soap is een protocol, een uitgevoerde operatie die gebonden is aan een protocol.
soap verleent je toegang tot bepaalde operaties (functies) niet effectief data zoals bij REST._
---
### OPGAVE: ###
-------
De spoedgevallendienst van St Vincentius heeft een nieuw registratiesysteem nodig. 
Maak een standalone (dus niet met een servlet) REST WebService met het restlet.org framework 
die toelaat om registraties in te geven. De registraties worden weggeschreven in een bestand op schijf. 
Maak een testclient met een main methode die een tweetal registraties aanmaakt.
---
Een registratie bestaat uit :

    datum en uur interventie
    naam patiënt
    geboortedatum patiënt
    naam verpleegkundige
    diagnose
---

*registraties.txt*
```xml
<?xml version="1.0" encoding="UTF-8" standalone="no"?><registraties>
  <registratie diagnose="is aangereden geweest tegen 100km/u, twee benen gebroken." id="1" interventie="11/08/2016 14:20:02">
    <diagnose>is aangereden geweest tegen 100km/u, twee benen gebroken.</diagnose>
    <uri>registratie/1</uri>
    <patient first_name="Bart" geboortedatum="1994/02/25" id="3" last_name="De Wever" verpleegkundige="Berta"/>

  </registratie>
  <registratie diagnose="is gewoon lelijk." id="2" interventie="11/04/2008 11:40:02">

    <uri>registratie/2</uri>
    <patient first_name="felica" geboortedatum="1998/02/25" id="4" last_name="Frison" verpleegkundige="jezus"/>

  </registratie>
  
</registraties>
```
[gemaakt door Mubuntu](https://github.com/Mubuntu)

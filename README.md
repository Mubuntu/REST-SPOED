# REST-SPOED
-----
![alt text](https://i.imgur.com/8uOMzYm.png "Logo Title Text 1")

 
in deze opgave maak ik gebruik van database om de waarden in uit te lezen (via JDBC) en het restlet framework om waarden via een webservice in te geven.
---
####OPGAVE:
-------
De spoedgevallendienst van St Vincentius heeft een nieuw registratiesysteem nodig. 
Maak een standalone (dus niet met een servlet) REST WebService met het restlet.org framework 
die toelaat om registraties in te geven (5 punten). De registraties worden weggeschreven in een bestand op schijf. 
Maak een testclient met een main methode die een tweetal registraties aanmaakt (3 punten).
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
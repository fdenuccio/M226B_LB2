# Schiffeversenken
======

### PROJECT TITLE: Schiffeversenken
### PURPOSE OF PROJECT: Modul 226B 
### VERSION or DATE: 25.01.2021
### HOW TO START THIS PROJECT: project.greenfoot ausführen und Run drücken.
### AUTHORS: Vasan Sivanesan & Jenia Isler

## Ziel des Spiels
Ziel dieses Spieles ist es, alle Schiffe des Gegners zu zerstören. 
Jede Runde darf ein Spieler ein Feld des Gegners markieren, um dieses zu bombardieren.
Wird eines der Schiffe getroffen, wird dieses rot markiert. 
Wurden alle Schiffe des Gegners zerstört, ist das Spiel fertig und man hat gewonnen.


## Voraussetzung
Beide Spieler müssen sich im Selben Netzwerk befinden. 
Auch müssen beide Spieler den Inbound Port 9000 auf ihrer Firewall freigeben,
Damit der Gegner auf den Server Verbindne kann.
Wichtig ist auch, dass die IPv4 Adresse des Servers aufgeschrieben
und dem Gegner mittgeteilt wird, damit dieser weiss, auf welche IP Adresse er verbinden muss.



## How To:

1. Das Greenfoot Projekt öffnen und via Start Knopf starten.
2. Die Schiffe werden an beliebigen Stellen generiert (Selbstplatzierung nicht implementiert). Man kann so lange das Spiel reseten,
bis man zufrieden ist mit der Aufstellung des Spieles.
3. Wenn die Bootaufstellun OK ist, kann man auf den Totenkopf drucken, um das Spiel zu initialisieren.
4. Es erscheint ein Eingabefeld, in welchem man zwischen der Option Server oder Client, mit einer yes/no Eingabe wählen kann.
5. Wird yes eingegeben, so Startet der Server auf dem Port 9000 und wartet so lange, bis ein Spieler sich damit verbindet. 
Wird aber no eingegeben, dann startet der Client und man muss anschliessend eine IPv4 Adresse eingeben. (Hinweis: Falscheingaben werden nicht akzeptiert.)
6. Der Server ist als erstes and der Reihe. Der Spieler kann nun ein Feld des Gegners andrücken und anschliessen bestätigen mit dem Totenkopfknopf.
7. Die Bombe wird dem Spieler verschickt und er sieht, wo man ihn getroffen hat. Falls ein Boot getroffen wurde wird dieses rot markiert. 
Nun kann der Client bei seinem Gegnerischen Feld die Bombe legen und auch diese mit dem Totenkopfknopf bestätigen.
8. Falls der Spieler in der ersten Runde eines der Boote des Gegners getroffen hat, werden diese nun angezeigt.
Der Server kann nun seinen zweiten Zug machen.
9. Das Spiel geht so lange weiter, bis alle Boote eines Spielers getroffen wurden.

 

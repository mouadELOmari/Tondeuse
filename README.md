# Tondeuse à gazon automatique

Une application qui répond au besoin de la société MowItNow

## Stack technique

* Java 21
* Maven 3.5.1
* Junit 4.13.1

## Execution

```shell
mvn compile exec:java -Dexec.mainClass=com.mower.application.MowerApplicationMain -Dexec.args="src/resources/input.txt"
```
# Méthodologie

J'ai opté pour l'approche Domain-Driven Design afin de faire correspondre le code et 
l'architecture au domaine métier, et une conception basée sur l'architecture héxagonale.

Pour ma part, 
j'ai découvert qu'il était tout à fait envisageable de concevoir une architecture hexagonale sans recourir explicitement au terme 'port'. Dans mon cas, j'ai préféré me concentrer sur une séparation claire des responsabilités entre les différentes couches de mon application.
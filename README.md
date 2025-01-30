# Jeu de Dames


## À propos

**Ce projet est une implémentation d'un jeu de dames en Java avec une interface graphique utilisant Swing.**

Il permet aux joueurs de s'affronter selon les règles classiques du jeu de dames, avec un affichage interactif et une gestion des scores. Le jeu est conçu pour être intuitif et simple à utiliser.

### Fonctionnalités principales
- Interface graphique interactive en Java Swing.
- Déplacement des pièces selon les règles classiques des dames.
- Promotion automatique des pions en dames.
- Affichage des statistiques et du tour des joueurs.
- Plateau de jeu 10x10.

## Structure du Projet

Le projet est composé des classes suivantes :

- **`Case`** : Représente une case du plateau de jeu.
- **`CaseBouton`** : Représente un bouton graphique cliquable pour chaque case du plateau.
- **`Dame`** : Représente une pièce de type Dame avec des propriétés différentes des pions normaux.
- **`InterfaceGraphique`** : Gère l'affichage et les interactions avec l'utilisateur.
- **`Jeu`** : Gère les joueurs et initialise le jeu.
- **`Joueur`** : Représente un joueur du jeu.
- **`Piece`** : Classe abstraite qui représente une pièce du jeu.
- **`Pion`** : Représente une pièce de type Pion et vérifie si les déplacements sont valides.
- **`Plateau`** : Gère le plateau de jeu et les déplacements des pièces.
- **`StatistiquesJeu`** : Gère l'affichage des scores et du tour des joueurs.

## Installation et Exécution

### Prérequis
- Java 8 ou version ultérieure.

### Instructions
1. Clonez ce dépôt :
   ```sh
   git clone https://github.com/Ak9271/dame-java
   ```
2. Exécutez le jeu :
   ```sh
   javac Jeu.java
   java Jeu
   ```

## Compatibilité et Limitations

- Fonctionne sur Windows, macOS et Linux avec Java installé.

## Problèmes connus

- Les déplacements non valides ne sont pas toujours bloqués avec un message d'erreur.
- La gestion des prises multiples pourrait nécessiter des améliorations.


## Contributeurs

- NIHALANANTH Akchayan, Sofia SELLOUM, Alexy TRAORÉ
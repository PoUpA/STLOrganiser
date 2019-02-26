# STLOrganiser
Outil d'organisation de fichiers d'impression 3D
## Présentation 
Cet outil permet de visualiser et de saisir des informations complémentaires liées à des fichiers d'impression [STL](http://en.wikipedia.org/wiki/STL_(file_format))
Il est composés de deux panneaux, un panneau d'exploration et un panneau affichant les informations sauvées (favoris)
### Panneau Explorateur
![Panneau explorer](https://github.com/PoUpA/STLOrganiser/raw/master/explorer_panel.png)


Le panneau d'exploration permet de sélectionner un fichier depuis l'arboresence. Une fois sélectionné le fichier sera rendu dans une fenêtre de visualisation et les champs de saisie des informations supplémentaires seront accessibles afin de sauvegarder les informations.

### Panneau Favoris
Ce panneau contient une table recensant les informations complémentaires sauvegardées

## Fonctionnement et explications
### Persistance des données
Le programme utilise une base de donnée SQlite afin de sauvegarder les informations. La classe DBUtils se charge de la connexion et des accès à la base de donnée.
### Interactions
Le programme utilise le pattern MVC afin de centraliser le traitement dans le controleur PrintInformationsController. Celui-ci gère la population du modèle depuis la base de donnée ainsi que la transmission des données aux vues.
Certaines actions triviales de la vue sont directement traitées sans passer par le controlleur (par exemple le changement de racine du système de fichier)

## MVC (fichiers)
### Modèles 
- FileDriveComboModel <-- Modèle représentant les disques durs système dans le combobox
- FileTreeModel <-- Modèle représentant l'arborescence pour le tree
- PrintInformations <-- Modèle des informations à sauvegarder en base

### Vues
- STLOrganiser <-- Fenêtre principale composée de 2 panneaux
- ExplorerPanel <-- Fenêtre contenant toute la représentation pour la saisie des informations et affiche du rendu.
- FavoritesPanel <-- Fenêtre contenant l'affichage des informations saisies dans la base de donnée
### Controlleurs
- PrintInformationsController <-- gestion des relations modèles/vues/db


## Dépendances & inspirations
Ce projet n'aurait pas put être réalisé sans :
- https://github.com/ag88/stl-viewer
- http://jogamp.org/
- https://gouessej.wordpress.com/2012/08/01/java-3d-est-de-retour-java-3d-is-back
- https://github.com/hharrison/java3d-core
- https://github.com/hharrison/java3d-utils
- https://github.com/hharrison/vecmath
- http://jogamp.org/deployment/v2.3.2/fat/jogamp-fat.jar
- https://github.com/cyanobacterium/STL-Parser-for-Java
- https://github.com/cpedrinaci/STL-Loader
- https://www.reddit.com/r/javaexamples/comments/37fdet/sqlite_database_access_with_a_swing_gui/



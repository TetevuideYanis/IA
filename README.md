# Introduction à l’intelligence artificielle  
## Partie I : Optimisation bio-inspirée  

**TP 2 : Initiation à l’algorithmique génétique**   

## Exercice 1 : Représentation des solutions (codage) et définition de la fonction objectif  

1. **Quelle représentation utiliseriez-vous pour coder vos solutions ?**  
   a) **Quelles sont vos variables de décision (gènes) ?**  
    **Réponse :** 
    Les gènes représentent les bits individuels de la solution.  
   b) **Quelles sont les valeurs possibles pour chaque gène (valeur minimale, valeur maximale) ?**  
    **Réponse :** 
    Les valeurs possibles pour chaque gène sont 0 et 1.  
   c) **À quoi correspond votre chromosome ?**  
    **Réponse :** 
    Le chromosome correspond à une séquence binaire de longueur \(n\), où \(n\) est le nombre de bits.  

2. **Quelle est la taille de l’espace de recherche ?**  
   **Réponse :** 
   La taille de l’espace de recherche est \(2^n\), où \(n\) est le nombre de bits.  

3. **Définissez la fonction objectif du problème posé.**  
   **Réponse :** 
   La fonction objectif est le nombre décimal correspondant à la séquence binaire représentée par un chromosome. Par exemple, pour un chromosome \(101\), la fonction objectif retourne \(5\).  

---

## Exercice 2 : Prise en main du framework d’algorithme génétique  

Pour vos travaux pratiques un squelette d’algorithme vous est proposé. Il comprend quelques modules fournis, et d’autres à implémenter. Dans un premier temps, vous êtes invités à exécuter le programme fourni afin de comprendre son fonctionnement. Pour ce faire, vous devez exécuter le code fourni dans la classe `Main`. Si vous le souhaitez, vous pouvez modifier les valeurs des paramètres suivants (dans la classe `Algorithme_genetique`) :  
— Taille de la population ;  
— Nombre de générations ;  
— Probabilité de croisement ;  
— Probabilité de mutation.  


**Réponse :** 
Ce programme implémente un algorithme génétique pour résoudre des problèmes d'optimisation. Il génère une population initiale de solutions aléatoires, évalue leur qualité grâce à une fonction objectif, et fait évoluer cette population sur plusieurs générations. À chaque génération, des parents sont sélectionnés aléatoirement pour produire des enfants via un croisement. Les enfants remplacent ensuite les parents, et la meilleure solution est suivie au fil des itérations.

---

## Exercice 3 : Implémentation  

1. **Écrivez une classe permettant de réaliser une sélection basée sur une roulette biaisée (vous pouvez vous inspirer de la classe `Selection_aleatoire`).**  
**Réponse :**
Voir la Class Java => "Selection_roulette_biaisee" dans le dossier solution.

2. **Modifiez le choix de l’opérateur de sélection dans la classe `Algorithme_genetique` afin de tester votre roulette biaisée.**  

3. **Écrivez une classe permettant de réaliser un croisement 2-points (vous pouvez vous inspirer de la classe `Croisement_1point`).**  
**Réponse :**
Voir la Class Java => "Croisement_2point" dans le dossier croisement.

4. **Modifiez le choix de l’opérateur de croisement dans la classe `Algorithme_genetique` afin de tester votre croisement 2-points.**  

Les deux lignes concernant la solution aléatoire et de croisement 1 point à été commenté, par conséquent, les tests effectués ont été réalisé dans le cadre suivant :
    - Selection_roulette_biaisee avec Croisement_1point
    - Selection_roulette_biaisee avec Croisement_2point 

Si vous souhaitez faire d'autre tests, n'oubliez pas de décommenter les lignes solution et croisement à votre guise dans le fichier "Algorithme_genetique".
 

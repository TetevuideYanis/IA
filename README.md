# Introduction à l’intelligence artificielle  
## Partie I : Optimisation bio-inspirée  

**TP 1 : Algorithmes gloutons**  

## Exercice 1 : Réservation de salle d’examen  

1. **Comment identifier toutes les épreuves d’une liste qui sont en conflit avec une épreuve donnée ?**  
   **Réponse :** Les épreuves en conflit avec une épreuve donnée ont des plages horaires qui se chevauchent. On peut les identifier en comparant les horaires de début de l'épreuve donnée et de fin des épreuves en conflit et enlever celles qui commencent avant.  

2. **Complétez la méthode `eliminerConflits(Epreuve e)` de la classe `ListeEpreuves` qui permet de supprimer toutes les épreuves en conflit avec celle qui est fournie en paramètre.**  
   **Réponse :** Méthode implémentée dans la classe `ListeEpreuves`.  

3. **Testez votre méthode en demandant la suppression de toutes les épreuves qui sont en conflit avec l’épreuve de Physique. Affichez la liste des épreuves restantes.**  
   **Réponse :** 
#################################################
Epreuves apres suppression des conflits de l'epreuve de Physique             
#################################################
Epreuve de Anglais (10:30:00 --> 11:15:00)
Epreuve de Espagnol (11:15:00 --> 11:30:00)
Epreuve de Philosophie (10:15:00 --> 11:30:00)
Epreuve de Chinois (11:30:00 --> 11:45:00)
Epreuve de Chimie (10:15:00 --> 12:15:00)
Epreuve de Electronique (10:45:00 --> 12:30:00)

4. **Testez également votre méthode en demandant la suppression de toutes les épreuves qui sont en conflit avec l’épreuve d’Espagnol. Affichez la liste des épreuves restantes.**  
   **Réponse :**
#################################################
Epreuves apres suppression des conflits de l'epreuve de Espagnol             
#################################################
Epreuve de Chinois (11:30:00 --> 11:45:00)

5. **Dans votre classe Main, commentez les lignes qui ont servi aux tests des questions 3 et 4.**  

6. **Dans la classe Main, implémentez un algorithme glouton qui maximise le placement d’épreuves dans la salle.**  
   **Réponse :** Voir classe Main algo glouton
#################################################
             Planning des epreuves            
#################################################
Epreuve de Physique (08:00:00 --> 10:00:00)
Epreuve de Anglais (10:30:00 --> 11:15:00)
Epreuve de Espagnol (11:15:00 --> 11:30:00)
Epreuve de Chinois (11:30:00 --> 11:45:00)

7. **Modifiez votre algorithme en utilisant un autre critère (autre que la priorisation en fonction des horaires de fin les plus proches) pour placer les épreuves. Vous serez probablement amené à modifier la méthode `compareTo` de la classe `Epreuve`. Testez votre nouvelle version.**  
   **Réponse :** On change le classement par horaire de fin en horaire de début.
#################################################
             Planning des epreuves             
#################################################
Epreuve de Maths (07:30:00 --> 10:30:00)
Epreuve de Anglais (10:30:00 --> 11:15:00)
Epreuve de Espagnol (11:15:00 --> 11:30:00)
Epreuve de Chinois (11:30:00 --> 11:45:00)

---

## Exercice 2 : Bipartition  

On souhaite répartir les \(n\) éléments d’un ensemble \(E\) dans deux sous-ensembles \(E_1\) et \(E_2\) de telle sorte que la somme des éléments de \(E_1\) soit égale à la somme des éléments de \(E_2\) (ou s’en rapproche).  

1. **Implémentez les deux algorithmes proposés durant les TD (ou d’autres versions que vous ferez valider par l’enseignant).**  
   **Réponse :** Voir Méthode 1 et 2

2. **Testez votre algorithme en utilisant tour à tour :**  
   a) \(E = \{2, 10, 3, 8, 5, 7, 9, 5, 3, 2\}\)  
   b) \(E = \{771, 121, 281, 854, 885, 734, 486, 1003, 83, 62\}\)  

   **Réponse :** 
   Algo 1 : 
   Liste initiale : 62, 83, 121, 281, 486, 734, 771, 854, 885, 1003 (5280)
   Sous-liste 1 : 83, 281, 734, 854, 1003 (2955)
   Sous-liste 2 : 62, 121, 486, 771, 885 (2325)

   Algo 2 :
   Liste initiale : 62, 83, 121, 281, 486, 734, 771, 854, 885, 1003 (5280)
   Sous-liste 1 : 62, 83, 121, 281, 486, 734, 771, 854 (3392)
   Sous-liste 2 : 885, 1003 (1888)


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
 

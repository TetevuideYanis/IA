# Introduction à l’intelligence artificielle  
## Partie I : Optimisation bio-inspirée  

**TP 2 : Initiation à l’algorithmique génétique**  

**Wahabou Abdou**  
*wahabou.abdou@u-bourgogne.fr*  

**2024 - 2025**  

---

On souhaite utiliser un algorithme génétique pour trouver le plus grand nombre (décimal) que l’on peut coder sur n bits. Cet exemple est purement académique et à intérêt pédagogique, la solution optimale pouvant être facilement devinée. L’algorithme génétique devra apprendre à identifier la structure des solutions intéressantes. Dans ce cas précis, l’algorithme devra “se rendre compte” que les solutions ayant des bits de poids forts à 1 sont de bons individus.

---

## Exercice 1 : Représentation des solutions (codage) et définition de la fonction objectif  

1. **Quelle représentation utiliseriez-vous pour coder vos solutions ?**  
   a) **Quelles sont vos variables de décision (gènes) ?**  
      - Les gènes représentent les bits individuels de la solution.  
   b) **Quelles sont les valeurs possibles pour chaque gène (valeur minimale, valeur maximale) ?**  
      - Les valeurs possibles pour chaque gène sont 0 et 1.  
   c) **À quoi correspond votre chromosome ?**  
      - Le chromosome correspond à une séquence binaire de longueur \(n\), où \(n\) est le nombre de bits.  

2. **Quelle est la taille de l’espace de recherche ?**  
   - La taille de l’espace de recherche est \(2^n\), où \(n\) est le nombre de bits.  

3. **Définissez la fonction objectif du problème posé.**  
   - La fonction objectif est le nombre décimal correspondant à la séquence binaire représentée par un chromosome. Par exemple, pour un chromosome \(101\), la fonction objectif retourne \(5\).  

---

## Exercice 2 : Prise en main du framework d’algorithme génétique  

Pour vos travaux pratiques un squelette d’algorithme vous est proposé. Il comprend quelques modules fournis, et d’autres à implémenter. Dans un premier temps, vous êtes invités à exécuter le programme fourni afin de comprendre son fonctionnement. Pour ce faire, vous devez exécuter le code fourni dans la classe `Main`. Si vous le souhaitez, vous pouvez modifier les valeurs des paramètres suivants (dans la classe `Algorithme_genetique`) :  
— Taille de la population ;  
— Nombre de générations ;  
— Probabilité de croisement ;  
— Probabilité de mutation.  

**Réponse :**  
- Exécutez le programme pour observer comment l’algorithme explore l’espace de recherche.  
- Testez différentes valeurs de paramètres pour observer leur impact.  

---

## Exercice 3 : Implémentation  

1. **Écrivez une classe permettant de réaliser une sélection basée sur une roulette biaisée (vous pouvez vous inspirer de la classe `Selection_aleatoire`).**  
   - Implémentez une méthode qui attribue une probabilité proportionnelle à la valeur de la fonction objectif de chaque individu.  

2. **Modifiez le choix de l’opérateur de sélection dans la classe `Algorithme_genetique` afin de tester votre roulette biaisée.**  
   - Remplacez l’appel à `Selection_aleatoire` par votre nouvelle méthode.  

3. **Écrivez une classe permettant de réaliser un croisement 2-points (vous pouvez vous inspirer de la classe `Croisement_1point`).**  
   - Implémentez un croisement qui sélectionne deux points aléatoires pour échanger les segments intermédiaires entre deux parents.  

4. **Modifiez le choix de l’opérateur de croisement dans la classe `Algorithme_genetique` afin de tester votre croisement 2-points.**  
   - Mettez à jour l’appel à l’opérateur de croisement pour utiliser votre méthode.  

---

## Résumé des réponses  

- Les gènes sont des bits (0 ou 1).  
- Un chromosome est une séquence binaire de \(n\) bits.  
- L’espace de recherche est \(2^n\).  
- La fonction objectif est la valeur décimale du chromosome.  
- Implémentation : Utilisez des approches proportionnelles pour la sélection et ajoutez un croisement à deux points.  

---

## Notes supplémentaires  
- Le squelette de l’algorithme est fourni dans la classe `Main`.  
- Les modifications doivent être

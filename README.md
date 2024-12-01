# Introduction à l’intelligence artificielle  
## Partie I : Optimisation bio-inspirée  

**TP 1 : Algorithmes gloutons**  

## Exercice 1 : Réservation de salle d’examen  

1. **Comment identifier toutes les épreuves d’une liste qui sont en conflit avec une épreuve donnée ?**  
   **Réponse :** Les épreuves en conflit avec une épreuve donnée ont des plages horaires qui se chevauchent. On peut les identifier en comparant les horaires de début de l'épreuve donnée et de fin des épreuves en conflit et enlever celles qui commencent avant.  

2. **Complétez la méthode `eliminerConflits(Epreuve e)` de la classe `ListeEpreuves` qui permet de supprimer toutes les épreuves en conflit avec celle qui est fournie en paramètre.**  
   **Réponse :** \
   public void eliminerConflits(Epreuve e) {

   		for(int i = 0; i < liste.size(); i++){
			if(liste.get(i).getDebut().before(e.getFin())){
				this.liste.remove(i);
				i--;
			}
		}
   }

   On parcours la liste des épreuves, si une épreuve commence avant la fin de l'épreuve donnée, alors on l'enlêve. Puisqu'on a retiré une épreuve, on décrémente de 1.

4. **Testez votre méthode en demandant la suppression de toutes les épreuves qui sont en conflit avec l’épreuve de Physique. Affichez la liste des épreuves restantes.**  
   **Réponse :**
################################################# \
Epreuves apres suppression des conflits de l'epreuve de Physique         
################################################# \
Epreuve de Anglais (10:30:00 --> 11:15:00) \
Epreuve de Espagnol (11:15:00 --> 11:30:00) \
Epreuve de Philosophie (10:15:00 --> 11:30:00)       
Epreuve de Chinois (11:30:00 --> 11:45:00)  \
Epreuve de Chimie (10:15:00 --> 12:15:00) \
Epreuve de Electronique (10:45:00 --> 12:30:00)

On peut voir que toutes les épreuves qui commençaient avant la fin de celle de physique (10:00) ont disparues.

4. **Testez également votre méthode en demandant la suppression de toutes les épreuves qui sont en conflit avec l’épreuve d’Espagnol. Affichez la liste des épreuves restantes.**  
   **Réponse :** 
################################################# \
Epreuves apres suppression des conflits de l'epreuve de Espagnol          
################################################# \
Epreuve de Chinois (11:30:00 --> 11:45:00) 

Cette fois il ne reste que le chinois qui commence après 11:30.

5. **Dans votre classe Main, commentez les lignes qui ont servi aux tests des questions 3 et 4.**  

6. **Dans la classe Main, implémentez un algorithme glouton qui maximise le placement d’épreuves dans la salle.**  
   **Réponse :** Pour maximiser le nombre d'épreuve, on prend celle qui fini le plus tôt à chaque fois et on élimine les conflits. 

   while (listeEpreuves.getListe().size() != 0){
   
			Epreuve epreuve = listeEpreuves.get(0); 
			planning.add(epreuve); 
			listeEpreuves.eliminerConflits(epreuve); 
		} 
   
   On parcours la liste des épreuves triées par date de fin croissante, on prends la première et on élimine celle qui sont en conflits avec elle. Ensuite, on prend la suivante qui fini le plus tôt et on recommence. Il s'agit d'un algo glouton car à chaque étape, on choisi la meilleure option visible, ici l'épreuve qui fini le plus tôt.

################################################# \
             Planning des epreuves  \
################################################# \
Epreuve de Physique (08:00:00 --> 10:00:00) \
Epreuve de Anglais (10:30:00 --> 11:15:00) \
Epreuve de Espagnol (11:15:00 --> 11:30:00) \
Epreuve de Chinois (11:30:00 --> 11:45:00) 

On obtient un planning ou aucune épreuve n'est en conflit avec une autre et qui permet de mettre 4 épreuves dans une matinée.

7. **Modifiez votre algorithme en utilisant un autre critère (autre que la priorisation en fonction des horaires de fin les plus proches) pour placer les épreuves. Vous serez probablement amené à modifier la méthode `compareTo` de la classe `Epreuve`. Testez votre nouvelle version.**  
   **Réponse :** On peut faire l'inverse et changer le classement par horaire de fin en horaire de début. 

public int compareTo(Object o) {

        Epreuve e = (Epreuve) o;
        
    	if (this.debut.before(e.debut))
    		return -1; 
    	else 
    		return 0;
        }

################################################# \
             Planning des epreuves  \
################################################# \
Epreuve de Maths (07:30:00 --> 10:30:00) \
Epreuve de Anglais (10:30:00 --> 11:15:00) \
Epreuve de Espagnol (11:15:00 --> 11:30:00) \
Epreuve de Chinois (11:30:00 --> 11:45:00) 


Le résultat semble similaire mais cette fois on commence par Math qui débute plus tôt car le tri à changé.
---

## Exercice 2 : Bipartition  

On souhaite répartir les \(n\) éléments d’un ensemble \(E\) dans deux sous-ensembles \(E_1\) et \(E_2\) de telle sorte que la somme des éléments de \(E_1\) soit égale à la somme des éléments de \(E_2\) (ou s’en rapproche).  

1. **Implémentez les deux algorithmes proposés durant les TD (ou d’autres versions que vous ferez valider par l’enseignant).**  
   **Réponse :** 

   public static void completerSousEnsembleLePulsPetit(ArrayList<Integer> liste) {
   
		for(int i = 0; i < liste.size(); i++){
			int sommeL1 = somme(sListe1);
			int sommeL2 = somme(sListe2);
			if(sommeL1 < sommeL2){
				sListe1.add(liste.get(i));
			}
			else{
				sListe2.add(liste.get(i));
			}
		}
}

   La première méthode consiste à comparer la somme des valeurs des deux sous ensemble et d'ajouter l'élément au sous ensemble dont la somme est la plus petite. Cet algo est glouton car à chaque itération, on fait le choix le plus appriorier pour garder la somme des sous ensembles équivalente.

   public static void utiliserMotieSommeCommeRepere(ArrayList<Integer> liste) { 
   
		int moitieSomme = somme(liste) / 2;
		for (int i = 0; i < liste.size(); i++) {
			if(somme(sListe1) < moitieSomme){
				sListe1.add(liste.get(i));
			}
			else{
				sListe2.add(liste.get(i));
			}
		}
	}

   La deuxième méthode consiste à faire la division de la somme des valeurs des éléments de la liste par 2. Ensuite on rempli le 1er sous ensemble jusqu'a dépasser cette somme/2. Tout le reste va dans le 2eme sous ensemble. Cet algo est glouton car une fois encore on prends la meilleure décision à l'instant T et on ne revient pas en arrière.

3. **Testez votre algorithme en utilisant tour à tour :**  
   a) \(E = \{2, 10, 3, 8, 5, 7, 9, 5, 3, 2\}\)  
   b) \(E = \{771, 121, 281, 854, 885, 734, 486, 1003, 83, 62\}\)  

   **Réponse :** \ 
   Algo 1 : \
   Liste initiale : 62, 83, 121, 281, 486, 734, 771, 854, 885, 1003 (5280) \
   Sous-liste 1 : 83, 281, 734, 854, 1003 (2955) \
   Sous-liste 2 : 62, 121, 486, 771, 885 (2325) 

   Les deux sous ensembles sont assez similaire, l'aglo fonctionne bien.

   Algo 2 : \
   Liste initiale : 62, 83, 121, 281, 486, 734, 771, 854, 885, 1003 (5280) \
   Sous-liste 1 : 62, 83, 121, 281, 486, 734, 771, 854 (3392) \
   Sous-liste 2 : 885, 1003 (1888) 

   Ici on a une grande différence de somme car les listes triées contenait des valeurs à une échelles différentes. Ainsi, lorsqu'on à dépassé le seuil, les grandes valeurs ont fini dans le deuxième sous ensemble, ce qui cause l'écart. Il faut donc faire attention aux types de listes que nous utilisons pour ces algo.


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
public Solution selectionner() {
        
        double sommeScores = 0;
        for (Solution s : population) {
            sommeScores += s.getF(); 
        }

        double seuil = Math.random() * sommeScores;

        double cumul = 0;
        for (Solution s : population) {
            cumul += s.getF();
            if (cumul >= seuil) {
                return s; 
            }
        }
        
        return population.get(population.size() - 1);
    }

On commence par calculer la somme des valeurs de fitness 'sommeScores'. On tire un nombre aléatoire, multiplié par sommeScores pour rester dans la même échelle, qui sera notre seuil de sélection. Le premier élément dont la valeur de fitness ajoutée dépassera ce seuil sera sélectionné. S'il y a un problème, on retourne le dernier élément.

2. **Modifiez le choix de l’opérateur de sélection dans la classe `Algorithme_genetique` afin de tester votre roulette biaisée.**  

Resultat: 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 (65534.0)\
La sélection a l'air de bien fonctionner.

3. **Écrivez une classe permettant de réaliser un croisement 2-points (vous pouvez vous inspirer de la classe `Croisement_1point`).**  
**Réponse :**

public void croiser() {

        int nb_variables_decision = parent1.getNb_variables_decision();

        enfant1 = new Solution(parent1);
        enfant2 = new Solution(parent2);

        double aleatoire = Math.random();

        int point1 = -1;
        int point2 = -1;

        if (aleatoire <= proba) {

            point1 = (int)(Math.random() * nb_variables_decision);
            point2 = (int)(Math.random() * nb_variables_decision);

            if (point1 > point2) {
                int temp = point1;
                point1 = point2;
                point2 = temp;
            }
            
            for (int i = 0; i < point1; i++) {
                enfant1.setVariable(i, parent1.getDoubleVariable(i));
                enfant2.setVariable(i, parent2.getDoubleVariable(i));
            }

            for (int i = point1; i < point2; i++) {
                enfant1.setVariable(i, parent2.getDoubleVariable(i));
                enfant2.setVariable(i, parent1.getDoubleVariable(i));
            }

            for (int i = point2; i < nb_variables_decision; i++) {
                enfant1.setVariable(i, parent1.getDoubleVariable(i));
                enfant2.setVariable(i, parent2.getDoubleVariable(i));
            }
        }
    }

Deux positions aléatoires sont choisies pour diviser les chromosomes des parents en trois segments. Les variables avant le premier point sont copiées directement des parents aux enfants. Les variables entre les deux points sont échangées entre les parents pour créer de la diversité. Enfin, les variables après le second point sont de nouveau copiées directement des parents respectifs. Cela génère deux nouvelles solutions en combinant les caractéristiques des deux parents.

4. **Modifiez le choix de l’opérateur de croisement dans la classe `Algorithme_genetique` afin de tester votre croisement 2-points.**  

**Réponse :**
Resultat: 1 1 1 1 1 1 1 1 1 1 1 1 0 0 1 1 (65523.0)\
L'algo fonctionne.
 
**TP 3 : Initiation à l’algorithmique génétique**   

## Exercice 1 : Opérateurs Génétiques

**Implémentez et testez les opérateurs suivants :**
1. **une séldction basée sur un tournoi de taille k.**

public Solution selectionner() {

        ArrayList<Solution> participants = new ArrayList<Solution>(taille);

        for (int i = 0; i < taille; i++) {
            int participant = (int) (Math.random() * population.size());
            participants.add(population.get(participant));
        }

        Solution s = participants.get(0);
        for (int i = 1; i < participants.size(); i++) {
            if(participants.get(i).getF() > s.getF()){
                s = participants.get(i);
            }
        }

        return s;
    }

Un sous-ensemble aléatoire de solutions est extrait de la population, avec une taille prédéfinie. Parmi ces solutions, celle qui possède la meilleure valeur de fitness est sélectionnée et retournée comme résultat. Cette méthode favorise les solutions de meilleure qualité tout en introduisant une part d'aléatoire pour maintenir la diversité.

2. **Un croisement k-points (vous pouvez vous inspirer de votre code de croisement 2-points) ?**

public void croiser() {

        int nb_variables_decision = parent1.getNb_variables_decision();
        
        enfant1 = new Solution(parent1);
        enfant2 = new Solution(parent2);

        double aleatoire = Math.random(); 

        if (aleatoire <= proba) {
            ArrayList<Integer> pointsCroisement = new ArrayList<>();
            for (int i = 0; i < kPoints; i++) {
                int point = (int)(Math.random() * nb_variables_decision);
                if (!pointsCroisement.contains(point)) {
                    pointsCroisement.add(point);
                } else {
                    i--;
                }
            }
            Collections.sort(pointsCroisement);

            boolean prendreDeParent1 = true; 

            for (int i = 0; i < nb_variables_decision; i++) {
                if (pointsCroisement.contains(i)) {
                    prendreDeParent1 = !prendreDeParent1; 
                }

                if (prendreDeParent1) {
                    enfant1.setVariable(i, parent1.getDoubleVariable(i));
                    enfant2.setVariable(i, parent2.getDoubleVariable(i));
                } else {
                    enfant1.setVariable(i, parent2.getDoubleVariable(i));
                    enfant2.setVariable(i, parent1.getDoubleVariable(i));
                }
            }
        }
    }

Un certain nombre de points de croisement aléatoires sont déterminés (spécifié par la variable kPoints). Ces points divisent le chromosome en segments alternés entre les deux parents. Les variables des enfants sont copiées alternativement de l'un ou l'autre parent en changeant de source à chaque point de croisement. Cela crée deux nouveaux chromosomes en combinant les gènes des deux parents de manière structurée mais diversifiée.
package tp1_vEtudiants.exercice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import tp1_vEtudiants.exercice1.Epreuve;

public class Bipartition {


	// Vous pouvez utiliser d'autres structures de donnees, notamment les List
	static ArrayList<Integer> E = new ArrayList<Integer>( Arrays.asList(2, 10, 3, 8, 5, 7, 9, 5, 3, 2) );

	static ArrayList<Integer> F = new ArrayList<Integer>(
			Arrays.asList(771, 121, 281, 854, 885, 734, 486, 1003, 83, 62)
			);
	static ArrayList<Integer> sListe1 = new ArrayList<Integer>();
	static ArrayList<Integer> sListe2 = new ArrayList<Integer>();


	public static void main(String[] args) {

		ArrayList<Integer> liste = F; 

		System.out.print("Liste initiale : ");
		Collections.sort((List<Integer>) liste);
		afficher(liste);

		completerSousEnsembleLePulsPetit(liste);

		System.out.print("Sous-liste 1 : ");
		afficher(sListe1);

		System.out.print("Sous-liste 2 : ");
		afficher(sListe2);
	}

	// Methode 1 : 
	//			Trier l'ensemble par ordre décroissant
	//			Parcourir l'ensemble trié et ajouter chaque élément au sous-ensemble dont le somme est la plus petite.
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


	// Methode 2 : 
	//			Calculer la somme des elements de la liste initiale
	//			Diviser cette somme par 2 pour avoir un reprere 
	//			Trier ma liste initiale par ordre decroissant
	//			Remplir la premiere sous-liste avec des elements de la liste principale, en veillant a ne pas depasser somme/2
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

	public static int somme(ArrayList<Integer> liste) {

		int n = 0 ; 

		if (!liste.isEmpty()) {
			for (int i : liste) {
				n += i; 
			}
		}

		return n;

	}
	
	public static void afficher(ArrayList<Integer> liste) {

		for (int i = 0; i < liste.size(); i++) {
			System.out.print(liste.get(i)); 
			if (i != liste.size()-1)
				System.out.print(", ");
		}
		System.out.println(" (" + somme(liste) + ")");

	}


}

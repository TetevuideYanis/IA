package tp1_vEtudiants.exercice1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		String fichierEpreuves = "TP1\\Code_source\\tp1_vEtudiants\\Epreuves.txt";
		
		ListeEpreuves listeEpreuves = new ListeEpreuves(fichierEpreuves);

		System.out.println("#################################################");
		System.out.println("# Toutes les epreuves inscrites dans le fichier #");
		System.out.println("#################################################");
		
		System.out.println(listeEpreuves);
		System.out.println();
		
		listeEpreuves.triParHeureFin();
		
		System.out.println("#################################################");
		System.out.println("# Epreuves triees par horaires de fin croissant #");
		System.out.println("#################################################");
		
		System.out.println(listeEpreuves);
		System.out.println();
		
		/*
		Epreuve e = listeEpreuves.get(4);
		listeEpreuves.eliminerConflits(e);
		
		System.out.println("#################################################");
		System.out.println("#  Epreuves apres suppression des conflits de   #");
		System.out.println("#           l'epreuve de " +  e.getIntitule() + "             #");
		System.out.println("#################################################");
		
		
		System.out.println(listeEpreuves);
		System.out.println();
		*/
		
		 		
		ArrayList<Epreuve> planning = new ArrayList<Epreuve>();
		
		//Algo glouton
		while (listeEpreuves.getListe().size() != 0){
			Epreuve epreuve = listeEpreuves.get(0);
			planning.add(epreuve);
			listeEpreuves.eliminerConflits(epreuve);
		}
		
		Collections.sort((List<Epreuve>) planning);
		
		System.out.println("#################################################");
		System.out.println("#             Planning des epreuves             #");
		System.out.println("#################################################");
		
		for (int i = 0; i < planning.size(); i++) {
			System.out.println(planning.get(i));
		}

	}


}

package operateurs.selection;

import java.util.ArrayList;

import representation.Solution;

public class Selection_tournoi_k extends Selection {
    private int taille;

    public Selection_tournoi_k(ArrayList<Solution> population, int k) {
        super(population);
        taille = k;
    }

    @Override
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
}

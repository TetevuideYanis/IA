package operateurs.selection;

import java.util.ArrayList;
import representation.Solution;

public class Selection_roulette_biaisee extends Selection {

    public Selection_roulette_biaisee(ArrayList<Solution> population) {
        super(population);
    }

    @Override
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
}


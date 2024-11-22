package operateurs.croisement;

import representation.Solution;
import java.util.ArrayList;
import java.util.Collections;

public class Croisement_kpoint extends Croisement {

    private int kPoints; 

    public Croisement_kpoint(Solution parent1, Solution parent2, double proba, int kPoints) {
        super(parent1, parent2, proba);
        this.kPoints = kPoints;
    }

    @Override
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
}

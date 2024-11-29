package problemes;

import representation.Solution;

public class GestionTempsRevision extends Probleme {

    private static final int TEMPS_MAX = 1500; 
    private static final int[] COEFFICIENTS = {3, 1, 3, 5, 1}; 

    public GestionTempsRevision(String type, int nb_variables_decision, boolean minimisation) {
        super(type, nb_variables_decision, minimisation);
    }

    public GestionTempsRevision(int nb_variables_decision, boolean minimisation) {
        super("Int", nb_variables_decision, minimisation);
    }

    public GestionTempsRevision(int nb_variables_decision) {
        super("Int", nb_variables_decision, false);
    }

    @Override
    public void definirBornes() {
        for (int i = 0; i < nb_variables_decision; i++) {
            min[i] = 0;
            max[i] = TEMPS_MAX;
        }
    }

    @Override
    public void evaluer(Solution solution) {
        int[] tempsRevision = new int[nb_variables_decision];
        int scoreGlobal = 0;
        int tempsTotal = 0;

        for (int i = 0; i < nb_variables_decision; i++) {
            tempsRevision[i] = solution.getIntVariable(i);
            tempsTotal += tempsRevision[i];
        }

        if (tempsTotal > TEMPS_MAX) {
            solution.setF(0);
            return;
        }

        for (int i = 0; i < nb_variables_decision; i++) {
            int note;
            switch (i) {
                case 0: // Cours 1
                    note = 3 * tempsRevision[i];
                    break;
                case 1: // Cours 2
                    note = tempsRevision[i] * tempsRevision[i] + 100;
                    break;
                case 2: // Cours 3
                    note = tempsRevision[i] + 100;
                    break;
                case 3: // Cours 4
                    note = 5 * tempsRevision[i];
                    break;
                case 4: // Cours 5
                    note = tempsRevision[i] * (tempsRevision[i] - 10);
                    break;
                default:
                    note = 0;
            }

            if (note < 200) {
                solution.setF(0);
                return;
            }

            scoreGlobal += note * COEFFICIENTS[i];
        }
        
        solution.setF(scoreGlobal);
    }
}

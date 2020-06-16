package trabajo.fin.grado.diversityActionSelection;


import java.util.List;
import java.util.Random;

import trabajo.fin.grado.TestCase;
import trabajo.fin.grado.inagraph.actions.Action;

public class RandomActionSelection implements ActionSelection {
    private Random random;

    @Override
    public Action selectAction(List<TestCase> testCases, List<Action> testCaseActions, List<Action> availableActions) {
        return availableActions.get(getRandom().nextInt(availableActions.size()));
    }

    @Override
    public Random getRandom() {
        if(random == null){
            random = new Random();
        }
        return random;
    }

    @Override
    public void setRandom(Random random) {
        this.random = random;
    }
}

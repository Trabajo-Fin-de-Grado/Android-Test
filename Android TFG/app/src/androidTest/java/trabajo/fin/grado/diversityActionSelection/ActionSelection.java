package trabajo.fin.grado.diversityActionSelection;

import java.util.List;
import java.util.Random;

import trabajo.fin.grado.TestCase;
import trabajo.fin.grado.inagraph.actions.Action;

public interface ActionSelection {
    public Action selectAction(List<TestCase> testCases, List<Action> testCaseActions, List<Action> availableActions);
    public Random getRandom();
    public void setRandom(Random random);
}

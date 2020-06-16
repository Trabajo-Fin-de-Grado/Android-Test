package trabajo.fin.grado.objectivefunctions.dynamic;

import trabajo.fin.grado.inagraph.actions.Action;

public interface DynamicObjectiveFunction {
    public double evaluate(Action action, String appPackage);
}

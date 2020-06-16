package trabajo.fin.grado.objectivefunctions;

import trabajo.fin.grado.TestCase;

public interface ObjectiveFunction {
    /**
     *
     * @param testcase test case to evaluate
     * @param appPackage package of the app to evaluate
     * @return If the solution is infeasible, the evaluation should be null
     */
    public Double evaluate(TestCase testcase, String appPackage);
}

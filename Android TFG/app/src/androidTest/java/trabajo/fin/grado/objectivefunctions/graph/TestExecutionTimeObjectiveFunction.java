package trabajo.fin.grado.objectivefunctions.graph;

import trabajo.fin.grado.TestCase;
import trabajo.fin.grado.objectivefunctions.ObjectiveFunction;

public class TestExecutionTimeObjectiveFunction implements ObjectiveFunction {

    @Override
    public Double evaluate(TestCase testcase, String appPackage) {
        long duration=-1;
        try{
            testcase.executeBefore();
            long start= System.currentTimeMillis();
            testcase.executeTest();
            duration= System.currentTimeMillis()-start;
            testcase.executeAfter();
        }catch(Exception e){

        }
        return new Double(duration);
    }
}

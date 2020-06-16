package trabajo.fin.grado.objectivefunctions;

import java.util.ArrayList;
import java.util.List;

import trabajo.fin.grado.BrokenTestCaseException;
import trabajo.fin.grado.TestCase;
import trabajo.fin.grado.inagraph.actions.Action;

public class PredicateMeetingObjectiveFunctionWithReparison extends PredicateMeetingObjectiveFunction {

    protected Double brokenTestHandling(BrokenTestCaseException ex){
        return tryRepair(ex);
    }

    public Double tryRepair(BrokenTestCaseException ex) {
        Double result=null;
        TestCase testcase=ex.getBrokenTestCase();
        try {
            result = new Double(testcase.getPredicate().nClausesMeet(testcase));
            if (result == testcase.getPredicate().getNClauses()) {
                repair(testcase, (int)ex.getBreakingIndex());
            } else
                result = null;
        }catch(Exception exc){}
        return result;
    }

    public void repair(TestCase test,int index) {
        List<Action> testActions=new ArrayList<>(index);
        for(int i=0;i<index;i++) {
            testActions.add(test.getTestActions().get(i));
        }
        test.setTestActions(testActions);
    }

}

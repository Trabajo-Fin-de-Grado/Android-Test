package trabajo.fin.grado.tests;

import android.util.Log;

import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObjectNotFoundException;

import org.junit.Test;

import trabajo.fin.grado.TestCase;
import trabajo.fin.grado.algorithms.RandomSearch;
import trabajo.fin.grado.inagraph.INAGraph;
import trabajo.fin.grado.inagraph.INAGraphBuilder;
import trabajo.fin.grado.objectivefunctions.ObjectiveFunction;
import trabajo.fin.grado.objectivefunctions.graph.ApplicationCrashObjectiveFunction;
import trabajo.fin.grado.objectivefunctions.graph.TestExecutionTimeObjectiveFunction;

import static androidx.test.InstrumentationRegistry.getInstrumentation;

public class RandomSearchTests {

    //Template for test RandomSearch algorithm
    private void randomSearchTestTemplate(String appPackageName, ObjectiveFunction objective, Integer iterations, Integer actionsLength) throws UiObjectNotFoundException {
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        INAGraph graph= INAGraphBuilder.getInstance().build(mDevice,appPackageName);
        RandomSearch algorithm=new RandomSearch(objective,iterations,actionsLength);
        TestCase testCase=algorithm.run(graph,appPackageName);
        Log.d("TFG","Test case found: "+testCase);
        Log.d("TFG","Runnig it...");
        testCase.executeBefore();
        testCase.executeTest();
        testCase.executeAfter();
        Log.d("TFG","Done!");
    }

    //This test use RandomSearch algorithm with ApplicationCrashObjetiveFunction into ButtomApp 1
    @Test
    public void testButtomApp1Crash() throws UiObjectNotFoundException {
        String appPackageName = "com.example.testingandroid";
        ObjectiveFunction objective=new ApplicationCrashObjectiveFunction();
        Integer iterations = 10;
        Integer actionLength = 2;
        randomSearchTestTemplate(appPackageName, objective, iterations, actionLength);
    }

    //This test use RandomSearch algorithm with MaxExecutionTimeObjetiveFunction into ButtomApp 1
    @Test
    public void testButtomApp1MaxExecutionTime() throws UiObjectNotFoundException {
        String appPackageName = "com.example.testingandroid";
        ObjectiveFunction objective=new TestExecutionTimeObjectiveFunction();
        Integer iterations = 10;
        Integer actionLength = 2;
        randomSearchTestTemplate(appPackageName, objective, iterations, actionLength);
    }

    //This test use RandomSearch algorithm with ApplicationCrashObjetiveFunction into ButtomApp 2
    @Test
    public void testButtomApp2Crash() throws UiObjectNotFoundException {
        String appPackageName = "com.example.testingandroid2";
        ObjectiveFunction objective=new ApplicationCrashObjectiveFunction();
        Integer iterations = 10;
        Integer actionLength = 2;
        randomSearchTestTemplate(appPackageName, objective, iterations, actionLength);
    }

    //This test use RandomSearch algorithm with MaxExecutionTimeObjetiveFunction into ButtomApp 2
    @Test
    public void testButtomApp2MaxExecutionTime() throws UiObjectNotFoundException {
        String appPackageName = "com.example.testingandroid2";
        ObjectiveFunction objective=new TestExecutionTimeObjectiveFunction();
        Integer iterations = 10;
        Integer actionLength = 2;
        randomSearchTestTemplate(appPackageName, objective, iterations, actionLength);
    }

    //This test use RandomSearch algorithm with ApplicationCrashObjetiveFunction into TextInputApp
    @Test
    public void testTextInputAppCrash() throws UiObjectNotFoundException {
        String appPackageName = "esadrcanfer.us.alumno.textinputapp";
        ObjectiveFunction objective=new ApplicationCrashObjectiveFunction();
        Integer iterations = 10;
        Integer actionLength = 2;
        randomSearchTestTemplate(appPackageName, objective, iterations, actionLength);
    }

    //This test use RandomSearch algorithm with MaxExecutionTimeObjetiveFunction into TextInputApp
    @Test
    public void testTextInputAppMaxExecutionTime() throws UiObjectNotFoundException {
        String appPackageName = "esadrcanfer.us.alumno.textinputapp";
        ObjectiveFunction objective=new TestExecutionTimeObjectiveFunction();
        Integer iterations = 10;
        Integer actionLength = 2;
        randomSearchTestTemplate(appPackageName, objective, iterations, actionLength);
    }

    //This test use RandomSearch algorithm with ApplicationCrashObjetiveFunction into WidgetApp
    @Test
    public void testWidgetAppCrash() throws UiObjectNotFoundException {
        String appPackageName = "esadrcanfer.us.alumno";
        ObjectiveFunction objective=new ApplicationCrashObjectiveFunction();
        Integer iterations = 10;
        Integer actionLength = 2;
        randomSearchTestTemplate(appPackageName, objective, iterations, actionLength);
    }

    //This test use RandomSearch algorithm with MaxExecutionTimeObjetiveFunction into WidgetApp
    @Test
    public void testWidgetAppMaxExecutionTime() throws UiObjectNotFoundException {
        String appPackageName = "esadrcanfer.us.alumno";
        ObjectiveFunction objective=new TestExecutionTimeObjectiveFunction();
        Integer iterations = 10;
        Integer actionLength = 2;
        randomSearchTestTemplate(appPackageName, objective, iterations, actionLength);
    }

    //This test use RandomSearch algorithm with ApplicationCrashObjetiveFunction into DiversityApp
    @Test
    public void testDiversityAppCrash() throws UiObjectNotFoundException {
        String appPackageName = "esadrcanfer.us.diversityapp";
        ObjectiveFunction objective=new ApplicationCrashObjectiveFunction();
        Integer iterations = 10;
        Integer actionLength = 2;
        randomSearchTestTemplate(appPackageName, objective, iterations, actionLength);
    }

    //This test use RandomSearch algorithm with MaxExecutionTimeObjetiveFunction into DiversityApp
    @Test
    public void testDiversityMaxExecutionTime() throws UiObjectNotFoundException {
        String appPackageName = "esadrcanfer.us.diversityapp";
        ObjectiveFunction objective=new TestExecutionTimeObjectiveFunction();
        Integer iterations = 10;
        Integer actionLength = 2;
        randomSearchTestTemplate(appPackageName, objective, iterations, actionLength);
    }


}

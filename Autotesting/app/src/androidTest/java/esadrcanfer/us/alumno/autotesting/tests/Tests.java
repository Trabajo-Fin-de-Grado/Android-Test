package esadrcanfer.us.alumno.autotesting.tests;

import android.util.Log;

import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObjectNotFoundException;

import org.junit.Test;

import java.util.List;

import esadrcanfer.us.alumno.autotesting.BrokenTestCaseException;
import esadrcanfer.us.alumno.autotesting.TestCase;
import esadrcanfer.us.alumno.autotesting.algorithms.RandomReparation;
import esadrcanfer.us.alumno.autotesting.algorithms.RecycleReparation;
import esadrcanfer.us.alumno.autotesting.util.ReadUtil;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static esadrcanfer.us.alumno.autotesting.tests.AutomaticRepairTests.labelsDetection;

public class Tests {

    @Test
    public void testRandomReparation() throws UiObjectNotFoundException {

        UiDevice device = UiDevice.getInstance(getInstrumentation());
        String path = "Download/Test YouTube/TestChangeQuality.txt";
        long iterations = 5;
        ReadUtil readUtil = new ReadUtil("Download/Test YouTube/TestChangeQuality.txt", false);
        TestCase testCase = readUtil.generateTestCase();
        Log.d("ISA", "Loadded test case from file!");
        Log.d("ISA", "Executing it...");
        try {
            testCase.executeBefore();
            List<String> initialState = labelsDetection();
            testCase.executeTest();
            List<String> finalState = labelsDetection();
            testCase.setInitialState(initialState);
            testCase.setFinalState(finalState);
            Boolean eval = testCase.evaluate();
            Log.d("ISA", "Initial evaluation: " + eval.toString());
            testCase.executeAfter();
        } catch (BrokenTestCaseException ex) {
            RandomReparation randomReparation = new RandomReparation(iterations, testCase, testCase.getAppPackage());
            testCase = randomReparation.run(device, testCase.getAppPackage());
        }
        Log.d("ISA", "TestCase found: " + testCase);
    }

    @Test
    public void testRecycleReparation() throws UiObjectNotFoundException {
        UiDevice device = UiDevice.getInstance(getInstrumentation());
        String path = "Download/CreationTestNote.txt";
        long iterations = 5;
        ReadUtil readUtil = new ReadUtil("Download/CreationTestNote.txt", true);
        TestCase testCase = readUtil.generateTestCase();
        Log.d("ISA", "Loadded test case from file!");
        Log.d("ISA", "Executing it...");
        try {
            testCase.executeBefore();
            List<String> initialState = labelsDetection();
            testCase.executeTest();
            List<String> finalState = labelsDetection();
            testCase.setInitialState(initialState);
            testCase.setFinalState(finalState);
            Boolean eval = testCase.evaluate();
            Log.d("ISA", "Initial evaluation: " + eval.toString());
            testCase.executeAfter();
        } catch (BrokenTestCaseException ex) {
            testCase.executeAfter();
            RecycleReparation recycleReparation = new RecycleReparation(iterations, testCase, (int) ex.getBreakingIndex());
            testCase = recycleReparation.run(device);
        }
        Log.d("ISA", "TestCase found: " + testCase);
    }
}
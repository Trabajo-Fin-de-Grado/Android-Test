package trabajo.fin.grado.algorithms;

import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObjectNotFoundException;
import trabajo.fin.grado.TestCase;

public interface ReparationAlgorithm {
    public TestCase repair(UiDevice device, TestCase buggyTestCase, int breakingPoint) throws UiObjectNotFoundException;
}
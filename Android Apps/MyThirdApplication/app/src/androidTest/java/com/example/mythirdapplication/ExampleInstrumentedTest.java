package com.example.mythirdapplication;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = getInstrumentation().getTargetContext();

        assertEquals("com.example.mythirdapplication", appContext.getPackageName());
    }

    @Test
    public void testQuizPro() throws UiObjectNotFoundException {
        UiDevice mDevice;
        mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("QuizPro"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("QuizPro"));
        testingApp.clickAndWaitForNewWindow();

        UiObject option1 = mDevice.findObject(new UiSelector().resourceId("com.example.quizpro:id/answer3"));
        option1.click();

        UiObject button1 = mDevice.findObject(new UiSelector().resourceId("com.example.quizpro:id/btn_check"));
        button1.click();

        UiObject option2 = mDevice.findObject(new UiSelector().resourceId("com.example.quizpro:id/answer2"));
        option2.click();

        UiObject button2 = mDevice.findObject(new UiSelector().resourceId("com.example.quizpro:id/btn_check"));
        button2.click();

        UiObject option3 = mDevice.findObject(new UiSelector().resourceId("com.example.quizpro:id/answer2"));
        option3.click();

        UiObject button3 = mDevice.findObject(new UiSelector().resourceId("com.example.quizpro:id/btn_check"));
        button3.click();

        UiObject button4 = mDevice.findObject(new UiSelector().resourceId("android:id/button1"));
        button4.click();
    }
}

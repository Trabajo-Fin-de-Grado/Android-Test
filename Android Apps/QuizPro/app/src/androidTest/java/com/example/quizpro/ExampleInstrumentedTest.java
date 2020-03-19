package com.example.quizpro;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.InstrumentationRegistry.getContext;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String BASIC_SAMPLE_PACKAGE = "My First Application";
    private UiDevice mDevice;

    @Before
    public void startMainActivityFromHomeScreen() {

        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(getInstrumentation());

        // Start from the home screen
        mDevice.pressHome();

        // Wait for launcher
        final String launcherPackage = getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)), LAUNCH_TIMEOUT);
    }

    private String getLauncherPackageName() {
        // Create launcher Intent
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        // Use PackageManager to get the launcher package name
        PackageManager pm = getContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }

    @Test
    public void checkPreconditions() {
        assertThat(mDevice, notNullValue());
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = getInstrumentation().getTargetContext();

        assertEquals("com.example.quizpro", appContext.getPackageName());
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
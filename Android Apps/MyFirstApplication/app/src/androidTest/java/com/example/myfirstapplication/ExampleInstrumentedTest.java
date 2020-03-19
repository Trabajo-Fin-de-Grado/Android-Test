package com.example.myfirstapplication;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
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

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String BASIC_SAMPLE_PACKAGE = "My First Application";
    private UiDevice mDevice;

    @Before
    public void startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        mDevice.pressHome();

        // Wait for launcher
        final String launcherPackage = mDevice.getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)), LAUNCH_TIMEOUT);
    }

    @Test
    public void checkPreconditions() {
        assertThat(mDevice, notNullValue());
    }

    @Test
    public void test1() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
        appViews.scrollIntoView(new UiSelector().text("My First Application"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("My First Application"));
        testingApp.clickAndWaitForNewWindow();

        UiObject escribir = mDevice.findObject(new UiSelector().text("Enter a message"));
        escribir.setText("UI Automator");

        UiObject enviar = mDevice.findObject(new UiSelector().text("SEND"));
        enviar.clickAndWaitForNewWindow();

    }

    @Test
    public void test2() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
        appViews.scrollIntoView(new UiSelector().text("My First Application"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("My First Application"));
        testingApp.clickAndWaitForNewWindow();

        UiObject escribirText = mDevice.findObject(new UiSelector().resourceId("com.example.myfirstapplication:id/editText"));
        escribirText.setText("UI Automator");

        UiObject enviar = mDevice.findObject(new UiSelector().text("SEND"));
        enviar.clickAndWaitForNewWindow();

        UiObject changedText = mDevice.findObject(new UiSelector().resourceId("com.example.myfirstapplication:id/textView"));
        assertThat(changedText.getText(), is(equalTo("UI Automator")));

        }

    @Test
    public void test() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Aplicaciones"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("Play Música"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Play Música"));
        testingApp.clickAndWaitForNewWindow();

        UiObject play = mDevice.findObject(new UiSelector().description("Reproducir"));
        play.click();

        play.waitUntilGone(20000);

        play.click();

    }

    }

package com.example.testingandroid;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class TestGoogleSlides {

    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String BASIC_SAMPLE_PACKAGE = "Slides";
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
    public void testCreateGoogleSlide() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        // UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        // appViews.scrollIntoView(new UiSelector().text("Slides"));

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
        appViews.scrollForward();

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Slides"));
        testingApp.clickAndWaitForNewWindow();

        UiObject button = mDevice.findObject(new UiSelector().description("New presentation menu"));
        button.click();

        UiObject document = mDevice.findObject(new UiSelector().description("New presentation"));
        document.clickAndWaitForNewWindow();

        //UiObject text = mDevice.findObject(new UiSelector().description("Subtitle"));
        //text.click();
        //text.setText("UI Automator");

        UiObject close = mDevice.findObject(new UiSelector().description("Navigate up"));
        close.click();

    }

    @Test
    public void testRenameGoogleSlide() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        // UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        // appViews.scrollIntoView(new UiSelector().text("Slides"));

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
        appViews.scrollForward();

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Slides"));
        testingApp.clickAndWaitForNewWindow();

        UiObject document = mDevice.findObject(new UiSelector().description("More actions for Untitled presentation"));
        document.click();

        UiScrollable options = new UiScrollable(new UiSelector().scrollable(false));
        options.scrollToEnd(10);

        UiObject rename = mDevice.findObject(new UiSelector().text("Rename"));
        rename.clickAndWaitForNewWindow();

        UiObject name = mDevice.findObject(new UiSelector().resourceId("com.google.android.apps.docs.editors.slides:id/edit_text"));
        name.setText("UI Automator");

        UiObject button = mDevice.findObject(new UiSelector().resourceId("com.google.android.apps.docs.editors.slides:id/positive_button"));
        button.clickAndWaitForNewWindow();

    }

    @Test
    public void testRemoveGoogleSlide() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        // UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        // appViews.scrollIntoView(new UiSelector().text("Slides"));

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
        appViews.scrollForward();

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Slides"));
        testingApp.clickAndWaitForNewWindow();

        UiObject document = mDevice.findObject(new UiSelector().description("More actions for Untitled presentation"));
        document.click();

        UiScrollable options = new UiScrollable(new UiSelector().scrollable(false));
        options.scrollToEnd(10);

        UiObject remove = mDevice.findObject(new UiSelector().text("Remove"));
        remove.clickAndWaitForNewWindow();

    }
}
package com.example.testingandroid;

import android.content.Context;
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class TestGoogleEarth {

    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String BASIC_SAMPLE_PACKAGE = "Earth";
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
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = getInstrumentation().getTargetContext();

        assertEquals("com.example.earth", appContext.getPackageName());
    }

    // UiObject voyager = mDevice.findObject(new UiSelector().description("Voyager"));
    // UiObject lucky   = mDevice.findObject(new UiSelector().description("I'm Feeling Lucky"));
    // UiObject measure = mDevice.findObject(new UiSelector().description("Measure"));
    // UiObject options = mDevice.findObject(new UiSelector().description("More options"));
    // UiObject search  = mDevice.findObject(new UiSelector().description("Search"));
    // UiObject menu    = mDevice.findObject(new UiSelector().description("Open navigation drawer"));

    @Test
    public void testSearchLocation() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("Earth"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Earth"));
        testingApp.clickAndWaitForNewWindow();

        UiObject button = mDevice.findObject(new UiSelector().description("Search"));
        button.clickAndWaitForNewWindow();

        UiObject location = mDevice.findObject(new UiSelector().text("Search Google Earth"));
        location.setText("Avenida Reina Mercedes");

        UiObject option = mDevice.findObject(new UiSelector().text("Avenida Reina Mercedes, Seville, Spain"));
        option.clickAndWaitForNewWindow();

        UiObject select = mDevice.findObject(new UiSelector().description("Fly here"));
        select.clickAndWaitForNewWindow();
    }

    // UiObject editor = mDevice.findObject(new UiSelector().text("Editor's Picks"));
    // UiObject games  = mDevice.findObject(new UiSelector().text("Games"));
    // UiObject layers = mDevice.findObject(new UiSelector().text("Layers"));
    // UiObject nature = mDevice.findObject(new UiSelector().text("Nature"));
    // UiObject street = mDevice.findObject(new UiSelector().text("Street View"));

    // UiObject park1 = mDevice.findObject(new UiSelector().text("Visit Zion National Park"));
    // UiObject park2 = mDevice.findObject(new UiSelector().text("Visit Yosemite National Park"));
    // UiObject park3 = mDevice.findObject(new UiSelector().text("Visit Yellowstone National Park"));
    // UiObject park4 = mDevice.findObject(new UiSelector().text("Visit Sequoia National Park"));

    @Test
    public void testVoyager() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("Earth"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Earth"));
        testingApp.clickAndWaitForNewWindow();

        UiObject button = mDevice.findObject(new UiSelector().description("Voyager"));
        button.click();

        UiObject option = mDevice.findObject(new UiSelector().text("Nature"));
        option.clickAndWaitForNewWindow();

        UiScrollable scroll = new UiScrollable(new UiSelector().scrollable(false));
        scroll.scrollIntoView(new UiSelector().text("Visit Yellowstone National Park"));

        UiObject select = mDevice.findObject(new UiSelector().text("Visit Yellowstone National Park"));
        select.clickAndWaitForNewWindow();

    }

}

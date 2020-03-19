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
public class TestPlayStore {

    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String BASIC_SAMPLE_PACKAGE = "Play Store";
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
    public void testUpdateApplication() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
        appViews.scrollForward();

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Play Store"));
        testingApp.clickAndWaitForNewWindow();

        UiObject button = mDevice.findObject(new UiSelector().resourceId("com.android.vending:id/main_nav_item"));
        button.click();

        UiObject option = mDevice.findObject(new UiSelector().text("My apps & games"));
        option.click();

        UiObject application = mDevice.findObject(new UiSelector().resourceId("com.android.vending:id/content_container"));
        application.click();

        UiObject update = mDevice.findObject(new UiSelector().resourceId("com.android.vending:id/left_button"));
        update.clickAndWaitForNewWindow();

    }

    @Test
    public void testInstallApplication() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("Play Store"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Play Store"));
        testingApp.clickAndWaitForNewWindow();

        UiObject button = mDevice.findObject(new UiSelector().resourceId("com.android.vending:id/main_nav_item"));
        button.click();

        UiObject option = mDevice.findObject(new UiSelector().text("My apps & games"));
        option.click();

        UiObject select = mDevice.findObject(new UiSelector().className("android.widget.TextView").index(2));
        select.click();

        UiObject application = mDevice.findObject(new UiSelector().resourceId("com.android.vending:id/content_container"));
        application.click();

        UiObject update = mDevice.findObject(new UiSelector().resourceId("com.android.vending:id/right_button"));
        update.clickAndWaitForNewWindow();

    }

    @Test
    public void testUninstallApplication() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("Play Store"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("Play Store"));
        testingApp.clickAndWaitForNewWindow();

        UiObject button = mDevice.findObject(new UiSelector().resourceId("com.android.vending:id/main_nav_item"));
        button.click();

        UiObject option = mDevice.findObject(new UiSelector().text("My apps & games"));
        option.click();

        UiObject select = mDevice.findObject(new UiSelector().className("android.widget.TextView").index(1));
        select.click();

        UiObject application = mDevice.findObject(new UiSelector().resourceId("com.android.vending:id/sort_button"));
        application.click();

        UiObject checked = mDevice.findObject(new UiSelector().className("android.widget.CheckedTextView").index(1));
        checked.click();

        UiObject app = mDevice.findObject(new UiSelector().resourceId("com.android.vending:id/content_container"));
        app.click();

        UiObject update = mDevice.findObject(new UiSelector().resourceId("com.android.vending:id/left_button"));
        update.clickAndWaitForNewWindow();

        UiObject press = mDevice.findObject(new UiSelector().resourceId("android:id/button1"));
        press.clickAndWaitForNewWindow();

    }

}

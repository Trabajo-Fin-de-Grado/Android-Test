package com.example.myshoppinglist;

import android.content.Context;

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

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String BASIC_SAMPLE_PACKAGE = "ShoppingList";
    private UiDevice mDevice;

    @Before
    public void startMainActivityFromHomeScreen() {

        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(getInstrumentation());

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

        assertEquals("com.example.myshoppinglist", appContext.getPackageName());
    }

    @Test
    public void testShoppingListAdd() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("ShoppingList"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("ShoppingList"));
        testingApp.clickAndWaitForNewWindow();

        UiObject product = mDevice.findObject(new UiSelector().resourceId("com.example.myshoppinglist:id/edit_item"));
        product.setText("UI Automator");

        UiObject send = mDevice.findObject(new UiSelector().resourceId("com.example.myshoppinglist:id/btn_add"));
        send.click();
    }

    @Test
    public void testShoppingListDelete() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(false));
        appViews.scrollIntoView(new UiSelector().text("ShoppingList"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("ShoppingList"));
        testingApp.clickAndWaitForNewWindow();

        UiObject product = mDevice.findObject(new UiSelector().text("UI Automator"));
        product.click();

        UiObject button = mDevice.findObject(new UiSelector().className("android.widget.ImageView"));
        button.click();

        UiObject send = mDevice.findObject(new UiSelector().text("Clear checked items"));
        send.click();
    }
}

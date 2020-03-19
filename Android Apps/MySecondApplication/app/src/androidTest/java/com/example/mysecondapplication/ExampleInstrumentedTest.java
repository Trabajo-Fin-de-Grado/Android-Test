package com.example.mysecondapplication;

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
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String BASIC_SAMPLE_PACKAGE = "My Second Application";
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

        assertEquals("com.example.mysecondapplication", appContext.getPackageName());
    }

    @Test
    public void test1() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
        appViews.scrollIntoView(new UiSelector().text("My Second Application"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("My Second Application"));
        testingApp.clickAndWaitForNewWindow();

        UiObject escribir1 = mDevice.findObject(new UiSelector().text("Name"));
        escribir1.setText("UI Automator");

        UiObject escribir2 = mDevice.findObject(new UiSelector().text("••••••••"));
        escribir2.setText("PasswordMuyVerySafe");

        UiObject escribir3 = mDevice.findObject(new UiSelector().text("Email"));
        escribir3.setText("automator@gmail.com");

        UiObject escribir4 = mDevice.findObject(new UiSelector().text("Phone"));
        escribir4.setText("685423987");

        UiObject escribir5 = mDevice.findObject(new UiSelector().text("Address"));
        escribir5.setText("Avenida Reina Mercedes nº 4");

        UiObject escribir6 = mDevice.findObject(new UiSelector().text("Date"));
        escribir6.setText("15/10/2020");

        UiObject enviar = mDevice.findObject(new UiSelector().text("SEND"));
        enviar.clickAndWaitForNewWindow();

    }

    @Test
    public void test2() throws UiObjectNotFoundException {

        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps list"));
        allAppsButton.click();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
        appViews.scrollIntoView(new UiSelector().text("My Second Application"));

        UiObject testingApp = mDevice.findObject(new UiSelector().text("My Second Application"));
        testingApp.clickAndWaitForNewWindow();

        UiObject escribirName = mDevice.findObject(new UiSelector().resourceId("com.example.mysecondapplication:id/editName"));
        escribirName.setText("UI Automator");

        UiObject escribirPassword = mDevice.findObject(new UiSelector().resourceId("com.example.mysecondapplication:id/editPassword"));
        escribirPassword.setText("PasswordMuyVerySafe");

        UiObject escribirEmail = mDevice.findObject(new UiSelector().resourceId("com.example.mysecondapplication:id/editEmail"));
        escribirEmail.setText("automator@gmail.com");

        UiObject escribirPhone = mDevice.findObject(new UiSelector().resourceId("com.example.mysecondapplication:id/editPhone"));
        escribirPhone.setText("685423987");

        UiObject escribirAddress = mDevice.findObject(new UiSelector().resourceId("com.example.mysecondapplication:id/editPostalAddress"));
        escribirAddress.setText("Avenida Reina Mercedes nº 4");

        UiObject escribirDate = mDevice.findObject(new UiSelector().resourceId("com.example.mysecondapplication:id/editDate"));
        escribirDate.setText("15/10/2020");

        UiObject enviar = mDevice.findObject(new UiSelector().resourceId("com.example.mysecondapplication:id/button"));
        enviar.clickAndWaitForNewWindow();

        UiObject changedName     = mDevice.findObject(new UiSelector().resourceId("com.example.mysecondapplication:id/textView3"));
        UiObject changedPassword = mDevice.findObject(new UiSelector().resourceId("com.example.mysecondapplication:id/textView6"));
        UiObject changedEmail    = mDevice.findObject(new UiSelector().resourceId("com.example.mysecondapplication:id/textView7"));
        UiObject changedPhone    = mDevice.findObject(new UiSelector().resourceId("com.example.mysecondapplication:id/textView8"));
        UiObject changedAddress  = mDevice.findObject(new UiSelector().resourceId("com.example.mysecondapplication:id/textView9"));
        UiObject changedDate     = mDevice.findObject(new UiSelector().resourceId("com.example.mysecondapplication:id/textView10"));

        assertThat(changedName.getText(), is(equalTo("UI Automator")));
        assertThat(changedPassword.getText(), is(equalTo("PasswordMuyVerySafe")));
        assertThat(changedEmail.getText(), is(equalTo("automator@gmail.com")));
        assertThat(changedPhone.getText(), is(equalTo("685423987")));
        assertThat(changedAddress.getText(), is(equalTo("Avenida Reina Mercedes nº 4")));
        assertThat(changedDate.getText(), is(equalTo("15/10/2020")));

    }

}

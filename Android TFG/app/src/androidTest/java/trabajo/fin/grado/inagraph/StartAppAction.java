package trabajo.fin.grado.inagraph;

import android.content.Context;
import android.content.Intent;
import androidx.test.InstrumentationRegistry;

import androidx.test.uiautomator.UiObjectNotFoundException;

import trabajo.fin.grado.inagraph.actions.Action;

public class StartAppAction extends Action {

    String appPackage;

    public StartAppAction(String appPackage) {
        super(null, ActionType.START);
        this.appPackage=appPackage;
    }

    @Override
    public void perform() throws UiObjectNotFoundException {
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(appPackage);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
    }

    @Override
    public String toString() {
        return "Start App "+this.appPackage;
    }
}

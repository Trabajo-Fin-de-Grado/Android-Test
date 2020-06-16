package trabajo.fin.grado.inagraph;

import androidx.test.uiautomator.UiDevice;

import java.io.IOException;

import trabajo.fin.grado.inagraph.actions.Action;

public class CloseAppAction extends Action {
    String appPackageName;
    public CloseAppAction(String appPackageName) {
        super(null, ActionType.STOP);
        this.appPackageName=appPackageName;

    }

    @Override
    public void perform() {
        try {
            UiDevice mDevice = UiDevice.getInstance();
            mDevice.pressHome();
            Runtime.getRuntime().exec(new String[] {"am", "force-stop", appPackageName});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Close App "+this.appPackageName;
    }
}

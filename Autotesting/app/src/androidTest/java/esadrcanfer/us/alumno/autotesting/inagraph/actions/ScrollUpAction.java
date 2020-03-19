package esadrcanfer.us.alumno.autotesting.inagraph.actions;


import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;

public class ScrollUpAction extends Action {

    public ScrollUpAction(UiObject target) {
        super(target, ActionType.SCROLL_UP);
    }

    @Override
    public void perform() throws UiObjectNotFoundException {
        UiScrollable appViews = (UiScrollable)target;
        appViews.scrollIntoView(new UiSelector().text(value));
    }
}

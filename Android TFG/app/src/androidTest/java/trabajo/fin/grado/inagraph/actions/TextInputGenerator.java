package trabajo.fin.grado.inagraph.actions;

import android.util.Log;

import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;

import net.sf.extjwnl.JWNLException;

import trabajo.fin.grado.dictionary.DictionaryBasedValueGenerator;

public class TextInputGenerator extends InputGenerator {

    Integer seed;

    public TextInputGenerator(Integer seed){
        this.seed = seed;
    }

    public String generateInput(UiObject object) throws UiObjectNotFoundException {
        String value = null;

        DictionaryBasedValueGenerator dictionary = new DictionaryBasedValueGenerator(1, seed);
        try {
            if(seed>0)
                value = dictionary.generate().toString();
            Log.d("TFG", value);
            object.setText(value);
        } catch (JWNLException e) {
            e.printStackTrace();
        }


        return value;
    }



}

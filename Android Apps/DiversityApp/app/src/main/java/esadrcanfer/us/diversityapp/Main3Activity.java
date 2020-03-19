package esadrcanfer.us.diversityapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void send(View view) {
        CheckBox checkBox = findViewById(R.id.checkBox);
        TextView textView = findViewById(R.id.textView4);
        if (checkBox.isChecked()) {
            textView.setText("Ha marcado el checkbox y pulsado el botón");
        }

    }
}

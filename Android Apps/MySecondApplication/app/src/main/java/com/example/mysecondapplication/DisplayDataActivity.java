package com.example.mysecondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message1 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE1);
        String message2 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
        String message3 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE3);
        String message4 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE4);
        String message5 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE5);
        String message6 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE6);

        // Capture the layout's TextView and set the string as its text
        TextView textName = findViewById(R.id.textView3);
        TextView textPassword = findViewById(R.id.textView6);
        TextView textEmail = findViewById(R.id.textView7);
        TextView textPhone = findViewById(R.id.textView8);
        TextView textAddress = findViewById(R.id.textView9);
        TextView textDate = findViewById(R.id.textView10);

        textName.setText(message1);
        textPassword.setText(message2);
        textEmail.setText(message3);
        textPhone.setText(message4);
        textAddress.setText(message5);
        textDate.setText(message6);
    }
}

package com.example.mysecondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE1 = "com.example.mysecondapp.MESSAGE1";
    public static final String EXTRA_MESSAGE2 = "com.example.mysecondapp.MESSAGE2";
    public static final String EXTRA_MESSAGE3 = "com.example.mysecondapp.MESSAGE3";
    public static final String EXTRA_MESSAGE4 = "com.example.mysecondapp.MESSAGE4";
    public static final String EXTRA_MESSAGE5 = "com.example.mysecondapp.MESSAGE5";
    public static final String EXTRA_MESSAGE6 = "com.example.mysecondapp.MESSAGE6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendData(View view) {

        Intent intent = new Intent(this, DisplayDataActivity.class);

        EditText editName = findViewById(R.id.editName);
        EditText editPassword = findViewById(R.id.editPassword);
        EditText editEmail = findViewById(R.id.editEmail);
        EditText editPhone = findViewById(R.id.editPhone);
        EditText editPostalAddress = findViewById(R.id.editPostalAddress);
        EditText editDate = findViewById(R.id.editDate);

        String name = editName.getText().toString();
        String password = editPassword.getText().toString();
        String email = editEmail.getText().toString();
        String phone = editPhone.getText().toString();
        String postalAddress = editPostalAddress.getText().toString();
        String date = editDate.getText().toString();

        intent.putExtra(EXTRA_MESSAGE1, name);
        intent.putExtra(EXTRA_MESSAGE2, password);
        intent.putExtra(EXTRA_MESSAGE3, email);
        intent.putExtra(EXTRA_MESSAGE4, phone);
        intent.putExtra(EXTRA_MESSAGE5, postalAddress);
        intent.putExtra(EXTRA_MESSAGE6, date);

        startActivity(intent);
    }
}

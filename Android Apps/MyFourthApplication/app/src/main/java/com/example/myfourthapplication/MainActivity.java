package com.example.myfourthapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView Resultado   = findViewById(R.id.Etiqueta);
        final Button btnPunto      =  findViewById(R.id.Punto);

        Button btnUno        = findViewById(R.id.Uno);
        Button btnDos        = findViewById(R.id.Dos);
        Button btnTres       = findViewById(R.id.Tres);
        Button btnCuatro     = findViewById(R.id.Cuatro);
        Button btnCinco      = findViewById(R.id.Cinco);
        Button btnSeis       = findViewById(R.id.Seis);
        Button btnSiete      = findViewById(R.id.Siete);
        Button btnOcho       = findViewById(R.id.Ocho);
        Button btnNueve      = findViewById(R.id.Nueve);
        Button btnSuma       = findViewById(R.id.Suma);
        Button btnResta      = findViewById(R.id.Resta);
        final Button btnMultiplica = findViewById(R.id.Multiplica);
        Button btnDivide     =  findViewById(R.id.Divide);
        Button btnBorrar     =  findViewById(R.id.Borrar);
        Button btnClean      =  findViewById(R.id.Clean);
        Button btnIgual      =  findViewById(R.id.Igual);

        btnUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mostrar = Resultado.getText().toString();
                mostrar = mostrar + "1";
                Resultado.setText(mostrar);
            }
        });

        btnDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mostrar = Resultado.getText().toString();
                mostrar = mostrar + "2";
                Resultado.setText(mostrar);
            }
        });

        btnTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mostrar = Resultado.getText().toString();
                mostrar = mostrar + "3";
                Resultado.setText(mostrar);
            }
        });

        btnCuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mostrar = Resultado.getText().toString();
                mostrar = mostrar + "4";
                Resultado.setText(mostrar);
            }
        });

        btnCinco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String mostrar = Resultado.getText().toString();
                mostrar = mostrar + "5";
                Resultado.setText(mostrar);
            }
        });

        btnSeis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String mostrar = Resultado.getText().toString();
                mostrar = mostrar + "6";
                Resultado.setText(mostrar);
            }
        });

        btnSiete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String mostrar = Resultado.getText().toString();
                mostrar = mostrar + "7";
                Resultado.setText(mostrar);
            }
        });

        btnOcho.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String mostrar = Resultado.getText().toString();
                mostrar = mostrar + "8";
                Resultado.setText(mostrar);
            }
        });

        btnNueve.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String mostrar = Resultado.getText().toString();
                mostrar = mostrar + "9";
                Resultado.setText(mostrar);
            }
        });

        btnSuma.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String reserva = Resultado.getText().toString();
                String operador = "+";
                Resultado.setText("");
            }
        });

        btnResta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String reserva = Resultado.getText().toString();
                String operador = "-";
                Resultado.setText("");
            }
        });

        btnMultiplica.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String reserva = Resultado.getText().toString();
                String operador = "*";
                Resultado.setText("");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String reserva = Resultado.getText().toString();
                String operador = "/";
                Resultado.setText("");
            }
        });

        btnPunto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String mostrar = Resultado.getText().toString();
                mostrar = mostrar + ".";
                Resultado.setText(mostrar);
            }
        });

        btnClean.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String mostrar = "";
                Resultado.setText(mostrar);
                String reserva = "";
                String operador = "";
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String mostrar = Resultado.getText().toString();
                mostrar = mostrar.substring(0, mostrar.length() - 1);
                Resultado.setText(mostrar);
            }
        });

        btnIgual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String mostrar = Resultado.getText().toString();
                mostrar = mostrar + "1";
                String reserva  = null;
                String operador = null;
                if (operador.equals("-")) {
                    Double resultado = Double.parseDouble(reserva) - Double.parseDouble(Resultado.getText().toString());
                    Resultado.setText(String.valueOf(resultado));
                }
                if (operador.equals("+")) {
                    Double resultado = Double.parseDouble(reserva) + Double.parseDouble(Resultado.getText().toString());
                    Resultado.setText(String.valueOf(resultado));
                }
                if (operador.equals("/")) {
                    Double resultado = Double.parseDouble(reserva) / Double.parseDouble(Resultado.getText().toString());
                    Resultado.setText(String.valueOf(resultado));
                }
                if (operador.equals("*")) {
                    Double resultado = Double.parseDouble(reserva) * Double.parseDouble(Resultado.getText().toString());
                    Resultado.setText(String.valueOf(resultado));
                }
            }
        });

    }
}

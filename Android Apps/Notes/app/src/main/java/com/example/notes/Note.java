package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

public class Note extends AppCompatActivity {
    private long id;
    private String titulo;
    private String texto;

    public Note() {
        this.id = -1;
        this.titulo = "";
        this.texto = "";
    }

    public Note(long id, String titulo, String texto) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
    }

    public Note(String titulo, String texto) {
        this.id = -1;
        this.titulo = titulo;
        this.texto = texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return titulo;
    }
}

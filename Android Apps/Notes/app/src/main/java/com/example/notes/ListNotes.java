package com.example.notes;


import java.util.ArrayList;

public class ListNotes {
    private static ArrayList<Note> notes;

    public static ArrayList<Note> get() {
        if (notes == null) {
            notes = NotesDataBase.loadNotas();
        }
        return notes;
    }

    public static Note getNota(int pos) {
        return notes.get(pos);
    }

    public static void nueva(String titulo, String texto) {
        Note note = NotesDataBase.nueva(titulo, texto);
        notes.add(note);
    }

    public static void modifica(int pos, String titulo, String texto) {
        Note note = notes.get(pos);
        note.setTitulo(titulo);
        note.setTexto(texto);
        NotesDataBase.actualiza(note);
    }

    public static void borra(int pos) {
        Note note = notes.get(pos);
        NotesDataBase.borra(note);
        notes.remove(pos);
    }

}


package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class NotesDataBase extends AppCompatActivity {

    private static Context context;

    public static void setContext(Context context) {
        NotesDataBase.context = context;
    }

    static class NotasDbHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "notas.db";
        private static final int DATABASE_VERSION = 1;

        private static final String SQL_CREATE_TABLA_NOTAS =
                "CREATE TABLE Notas (" +
                        "id INTEGER PRIMARY KEY," +
                        "titulo TEXT," +
                        "texto TEXT" +
                        ")";

        public NotasDbHelper() {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_TABLA_NOTAS);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            // No hay que hacer nada aquí de momento...
        }
    }

    private static NotasDbHelper helper;

    public static NotasDbHelper getHelper() {
        if (helper == null) {
            helper = new NotasDbHelper();
        }
        return helper;
    }

    public static ArrayList<Note> loadNotas() {
        ArrayList<Note> resultado = new ArrayList<>();

        SQLiteDatabase db = getHelper().getReadableDatabase();

        String[] columnas = { "id", "titulo", "texto" };

        Cursor c = db.query("Notas", columnas, null, null, null, null, null);
        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                long id = c.getLong(c.getColumnIndexOrThrow("id"));
                String titulo = c.getString(c.getColumnIndexOrThrow("titulo"));
                String texto  = c.getString(c.getColumnIndexOrThrow("texto"));
                resultado.add(new Note(id, titulo, texto));
            }
        }
        if (c != null) {
            c.close();
        }
        db.close();

        return resultado;
    }

    public static Note nueva(String titulo, String texto) {
        Note resultado = new Note(titulo, texto);

        SQLiteDatabase db = getHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("titulo", titulo);
        values.put("texto", texto);
        long id = db.insert("Notas", null, values);
        db.close();

        resultado.setId(id);
        return resultado;
    }

    public static void actualiza(Note note) {
        SQLiteDatabase db = getHelper().getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("titulo", note.getTitulo());
        values.put("texto", note.getTexto());

        String where = "id = ?";
        String[] args = { Long.toString(note.getId()) };

        db.update("Notas", values, where, args);
        db.close();
    }

    public static void borra(Note note) {
        SQLiteDatabase db = getHelper().getWritableDatabase();

        String where = "id = ?";
        String[] args = { Long.toString(note.getId()) };

        db.delete("Notes", where, args);
        db.close();
    }

}

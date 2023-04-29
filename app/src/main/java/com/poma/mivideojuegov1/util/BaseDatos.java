package com.poma.mivideojuegov1.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {

    public BaseDatos(Context context){
        super(context, "Libreria.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE categoria (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " nombre TEXT NOT NULL);" ;
        db.execSQL(query);

        query = "CREATE TABLE libro (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " id_categoria INTEGER NOT NULL, nombre TEXT NOT NULL, " +
                " autor TEXT NOT NULL, anio INTEGER NOT NULL);" ;
        db.execSQL(query);

        query = "INSERT INTO categoria values(NULL, 'Matematicas')";
        db.execSQL(query);

        query = "INSERT INTO categoria values(NULL, 'Lenguaje')";
        db.execSQL(query);

        query = "INSERT INTO categoria values(NULL, 'Programacion')";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

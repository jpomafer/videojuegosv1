package com.poma.mivideojuegov1.modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.poma.mivideojuegov1.entidad.Categoria;
import com.poma.mivideojuegov1.util.BaseDatos;

import java.util.ArrayList;
import java.util.List;

public class DAOLibro {
    BaseDatos bd;
    SQLiteDatabase sqldb;
    Context context;

    public DAOLibro(Context context){
        bd = new BaseDatos(context);
        this.context = context;

    }
    public void abrirBD(){
        sqldb=bd.getWritableDatabase();

    }
    public List<Categoria> obtenerCategorias(){
        List<Categoria>lstcategoria = new ArrayList<>();
        try {
            Cursor c = sqldb.rawQuery("SELECT * FROM categoria", null);
            while (c.moveToNext()){
                lstcategoria.add(new Categoria(c.getInt(0),c.getString(1)));
            }
        }
        catch (Exception e){
            Log.d("==>", e.toString());
        }
        return lstcategoria;
    }
}

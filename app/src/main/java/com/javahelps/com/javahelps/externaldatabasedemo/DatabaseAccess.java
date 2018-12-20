package com.javahelps.com.javahelps.externaldatabasedemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    public DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public ArrayList<Pokemon> getTodosDatos() {
        ArrayList<Pokemon> pokelist = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM Pokedex", null);

        while(cursor.moveToNext()) {
            String numero = cursor.getString(0);   //0 is the number of id column in your database table, it could be different in your database table
            String nombre = cursor.getString(1);
            String primario = cursor.getString(2);
            String secundario = cursor.getString(3);
            byte[] imagen = cursor.getBlob(4);

            Bitmap bm = BitmapFactory.decodeByteArray(imagen, 0 ,imagen.length);

            Pokemon nuevo_pokemon = new Pokemon(numero, nombre, bm, primario, secundario);
            pokelist.add(nuevo_pokemon);
        }
        return pokelist;
    }

    public ArrayList<Pokemon> filtrar(String newText) {
        ArrayList<Pokemon> puchamonlist = new ArrayList<>();

        Cursor cursor1 = database.rawQuery("SELECT * FROM Pokedex WHERE Nombre LIKE '%" + newText + "%'", null);

        if(newText != null && newText.length() > 0)
        {
            while(cursor1.moveToNext()) {
                String numero1 = cursor1.getString(0);   //0 is the number of id column in your database table, it could be different in your database table
                String nombre1 = cursor1.getString(1);
                String primario1 = cursor1.getString(2);
                String secundario1 = cursor1.getString(3);
                byte[] imagen1 = cursor1.getBlob(4);

                Bitmap bm1 = BitmapFactory.decodeByteArray(imagen1, 0 ,imagen1.length);

                Pokemon nuevo_pokemon1 = new Pokemon(numero1, nombre1, bm1, primario1, secundario1);
                puchamonlist.add(nuevo_pokemon1);
            }
            return puchamonlist;
        }
        return puchamonlist;
    }

    public ArrayList<Informacion> DatosPuchamonTodos(String newDato) {
        ArrayList<Informacion> informacionlist = new ArrayList<>();

        Cursor cursor2 = database.rawQuery("SELECT * FROM Pokedex WHERE Numero LIKE '%" + newDato + "%'", null);

        if(newDato != null && newDato.length() > 0)
        {
            while(cursor2.moveToNext()) {
                String numero2 = cursor2.getString(0);   //0 is the number of id column in your database table, it could be different in your database table
                String nombre2 = cursor2.getString(1);
                String primario2 = cursor2.getString(2);
                String secundario2 = cursor2.getString(3);
                byte[] imagen2 = cursor2.getBlob(5);
                byte[] imagen3 = cursor2.getBlob(6);
                String pulgadas2 = cursor2.getString(7);
                String metros2 = cursor2.getString(8);
                String lbs2 = cursor2.getString(9);
                String kg2 = cursor2.getString(10);
                String especie2 = cursor2.getString(11);
                String macho2 = cursor2.getString(12);
                String hembra2 = cursor2.getString(13);
                String habilidadP2 = cursor2.getString(14);
                String habilidadS2 = cursor2.getString(15);
                String habilidadO2 = cursor2.getString(16);
                String huevoP2 = cursor2.getString(17);
                String huevoS2 = cursor2.getString(18);
                String captura2 = cursor2.getString(19);
                String evsP2 = cursor2.getString(20);
                String evsS2 = cursor2.getString(21);
                String evsT2 = cursor2.getString(22);
                String pasos2 = cursor2.getString(23);
                String felicidad2 = cursor2.getString(24);
                String exp2 = cursor2.getString(25);


                Bitmap bm2 = BitmapFactory.decodeByteArray(imagen2, 0 ,imagen2.length);
                Bitmap bm3 = BitmapFactory.decodeByteArray(imagen3, 0 ,imagen3.length);

                Informacion nuevo_informacion = new Informacion(numero2, nombre2, primario2, secundario2, bm2, bm3, pulgadas2, metros2,
                lbs2, kg2, especie2, macho2, hembra2, habilidadP2, habilidadS2, habilidadO2, huevoP2, huevoS2, captura2, evsP2, evsS2,
                        evsT2, pasos2, felicidad2, exp2);
                informacionlist.add(nuevo_informacion);
            }
            return informacionlist;
        }
        return informacionlist;
    }
}
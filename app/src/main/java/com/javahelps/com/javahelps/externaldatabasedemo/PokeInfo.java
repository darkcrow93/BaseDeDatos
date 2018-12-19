package com.javahelps.com.javahelps.externaldatabasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class PokeInfo extends AppCompatActivity {

    public ArrayList<Informacion> infolist1;
    DatabaseAccess databaseAccessInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_info);

        Intent intent = getIntent(); //Obtengo los datos del intent
        Bundle extras = intent.getExtras(); //los datos obtenidos se guardan en extra
        databaseAccessInfo = DatabaseAccess.getInstance(this);


        if(extras != null)
        {
            String dato = extras.getString("DATO");
            databaseAccessInfo.open();
            infolist1 = databaseAccessInfo.DatosPuchamonTodos(dato);
            databaseAccessInfo.close();
            new DatabaseAdapterInformation(infolist1, this);
        }

    }
}
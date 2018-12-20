package com.javahelps.com.javahelps.externaldatabasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, AdapterView.OnItemClickListener {

    public SearchView Buscador;
    public ListView listview;
    public ArrayList<Pokemon> pokelist1;
    DatabaseAdapter adaptador;
    DatabaseAccess databaseAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.Lista);
        Buscador = (SearchView) findViewById(R.id.Buscador);

        databaseAccess = DatabaseAccess.getInstance(this);

        databaseAccess.open();
        pokelist1 = databaseAccess.getTodosDatos();
        databaseAccess.close();

        adaptador = new DatabaseAdapter(pokelist1, this);
        listview.setAdapter(adaptador);

        listview.setOnItemClickListener(this);
        Buscador.setOnQueryTextListener(this);

        Buscador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Buscador.setIconified(false); //Se pone en falso el iconofied
            }
        });
    }

    ////////    SE ACTIVA CUANDO LE DOY ENTER/BUSCAR AL BUSCADOR    ///////////
    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    ////////    SE ACTIVA CUANDO ESCRIBO UNA PALABRA    //////////
    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText.length() > 0) {
            pokelist1.clear();

            databaseAccess.open();
            pokelist1 = databaseAccess.filtrar(newText);
            databaseAccess.close();

            adaptador = new DatabaseAdapter(pokelist1, this);
            listview.setAdapter(adaptador);
        } else {
            databaseAccess.open();

            pokelist1 = databaseAccess.getTodosDatos();

            databaseAccess.close();

            adaptador = new DatabaseAdapter(pokelist1, this);
            listview.setAdapter(adaptador);
        }
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Pokemon datos = (Pokemon)parent.getItemAtPosition(position);
        String numero = datos.getNumero();

        Intent intent = new Intent(MainActivity.this, PokeInfo.class); //Una Intent es un objeto de acción que puedes usar para solicitar una acción de otro componente de la aplicación.
        intent.putExtra("DATO", numero); //Pone al intent ademas de lo declarado, algo mas
        startActivity(intent); //empieza la activity
        //finish();
    }
}

package com.javahelps.com.javahelps.externaldatabasedemo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;
import static android.widget.Toast.LENGTH_SHORT;
import static com.javahelps.com.javahelps.externaldatabasedemo.R.*;

public class DatabaseAdapter extends BaseAdapter {

    private ArrayList<Pokemon> PokeList;
    private Context context;
    private ViewHolder holder;
    GradientDrawable colorDraw;
    String[] tipos = {"Bug", "Dark", "Dragon", "Electric", "Fairy", "Fighting", "Fire", "Flying", "Ghost", "Grass", "Ground", "Ice", "Normal", "Poison", "Psychic", "Rock", "Steel", "Water", " "};

    public DatabaseAdapter(ArrayList<Pokemon> lista, Context context1){
        this.PokeList = lista;
        this.context = context1;
    }

    @Override
    public int getCount() {
        return this.PokeList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.PokeList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        holder = null;

        if(view == null)
        {
            LayoutInflater inf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inf.inflate(layout.otra, null);

            holder = new ViewHolder();

            holder.numeroP = (TextView)view.findViewById(id.NumeroPkmn1);
            holder.nombreP = (TextView)view.findViewById(id.NombrePkmn1);
            holder.imagenP = (ImageView)view.findViewById(id.Image_Pkmn1);
            holder.botonP = (Button)view.findViewById(id.Tipo1PPkmn);
            holder.botonS = (Button)view.findViewById(id.Tipo2PPkmn);

            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder)view.getTag();
        }

        final Pokemon datos = PokeList.get(position);

        holder.numeroP.setText(datos.getNumero());
        holder.nombreP.setText(datos.getNombre());
        holder.imagenP.setImageBitmap(datos.getImagen());
        holder.botonP.setText(datos.getTipoP());
        holder.botonS.setText(datos.getTipoS());

        holder.botonP.setTextColor(Color.rgb(255,255,255));
        holder.botonS.setTextColor(Color.rgb(255,255,255));
        holder.botonP.setEnabled(false);
        holder.botonS.setEnabled(false);

        colorP();
        colorS();

        return view;
    }

    public static class ViewHolder{
        public TextView numeroP;
        public TextView nombreP;
        public ImageView imagenP;
        public Button botonP;
        public Button botonS;
    }

    public void colorP()
    {
        ////////////////////////////    COLORES PRIMARIOS   /////////////////////////////////////
        holder.botonP.setBackgroundResource(drawable.types);
        colorDraw = (GradientDrawable)holder.botonP.getBackground().getCurrent();

        if(holder.botonP.getText().equals(tipos[0])) //BUG
        {
            colorDraw.setColor(Color.rgb(168, 184,32));
        }
        else if(holder.botonP.getText().equals(tipos[1]))    //DARK
        {
            colorDraw.setColor(Color.rgb(112, 88,72));
        }
        else if(holder.botonP.getText().equals(tipos[2]))    //DRAGON
        {
            colorDraw.setColor(Color.rgb(112, 56,248));
        }
        else if(holder.botonP.getText().equals(tipos[3]))    //ELECTRIC
        {
            colorDraw.setColor(Color.rgb(248, 208,48));
        }
        else if(holder.botonP.getText().equals(tipos[4]))    //FAIRY
        {
            colorDraw.setColor(Color.rgb(238, 153,172));
        }
        else if(holder.botonP.getText().equals(tipos[5]))    //FIGHTNING
        {
            colorDraw.setColor(Color.rgb(192, 48,40));
        }
        else if(holder.botonP.getText().equals(tipos[6]))    //FIRE
        {
            colorDraw.setColor(Color.rgb(240, 128,48));
        }
        else if(holder.botonP.getText().equals(tipos[7]))    //FLYING
        {
            colorDraw.setColor(Color.rgb(168, 144,240));
        }
        else if(holder.botonP.getText().equals(tipos[8]))    //GHOST
        {
            colorDraw.setColor(Color.rgb(112, 88,152));
        }
        else if(holder.botonP.getText().equals(tipos[9]))    //GRASS
        {
            colorDraw.setColor(Color.rgb(120, 200,80));
        }
        else if(holder.botonP.getText().equals(tipos[10]))    //GROUND
        {
            colorDraw.setColor(Color.rgb(224, 192,104));
        }
        else if(holder.botonP.getText().equals(tipos[11]))   //ICE
        {
            colorDraw.setColor(Color.rgb(152, 216,216));
        }
        else if(holder.botonP.getText().equals(tipos[12]))    //NORMAL
        {
            colorDraw.setColor(Color.rgb(168, 168,120));
        }
        else if(holder.botonP.getText().equals(tipos[13]))    //POISON
        {
            colorDraw.setColor(Color.rgb(160, 64,160));
        }
        else if(holder.botonP.getText().equals(tipos[14]))    //PSYCHIC
        {
            colorDraw.setColor(Color.rgb(248, 88,136));
        }
        else if(holder.botonP.getText().equals(tipos[15]))    //ROCK
        {
            colorDraw.setColor(Color.rgb(184, 160,56));
        }
        else if(holder.botonP.getText().equals(tipos[16]))    //STEEL
        {
            colorDraw.setColor(Color.rgb(184, 184,208));
        }
        else if(holder.botonP.getText().equals(tipos[17]))    //WATER
        {
            colorDraw.setColor(Color.rgb(104, 144,240));
        }
    }

    public void colorS()
    {
        //////////      COLOR SECUNDARIO    //////////////////////
        holder.botonS.setVisibility(View.VISIBLE);
        holder.botonS.setBackgroundResource(drawable.types);
        colorDraw = (GradientDrawable)holder.botonS.getBackground().getCurrent();

        if(holder.botonS.getText().equals(tipos[0])) //BUG
        {
            colorDraw.setColor(Color.rgb(168, 184,32));
        }
        else if(holder.botonS.getText().equals(tipos[1]))    //DARK
        {
            colorDraw.setColor(Color.rgb(112, 88,72));
        }
        else if(holder.botonS.getText().equals(tipos[2]))    //DRAGON
        {
            colorDraw.setColor(Color.rgb(112, 56,248));
        }
        else if(holder.botonS.getText().equals(tipos[3]))    //ELECTRIC
        {
            colorDraw.setColor(Color.rgb(248, 208,48));
        }
        else if(holder.botonS.getText().equals(tipos[4]))    //FAIRY
        {
            colorDraw.setColor(Color.rgb(238, 153,172));
        }
        else if(holder.botonS.getText().equals(tipos[5]))    //FIGHTNING
        {
            colorDraw.setColor(Color.rgb(192, 48,40));
        }
        else if(holder.botonS.getText().equals(tipos[6]))    //FIRE
        {
            colorDraw.setColor(Color.rgb(240, 128,48));
        }
        else if(holder.botonS.getText().equals(tipos[7]))    //FLYING
        {
            colorDraw.setColor(Color.rgb(168, 144,240));
        }
        else if(holder.botonS.getText().equals(tipos[8]))    //GHOST
        {
            colorDraw.setColor(Color.rgb(112, 88,152));
        }
        else if(holder.botonS.getText().equals(tipos[9]))    //GRASS
        {
            colorDraw.setColor(Color.rgb(120, 200,80));
        }
        else if(holder.botonS.getText().equals(tipos[10]))    //GROUND
        {
            colorDraw.setColor(Color.rgb(224, 192,104));
        }
        else if(holder.botonS.getText().equals(tipos[11]))   //ICE
        {
            colorDraw.setColor(Color.rgb(152, 216,216));
        }
        else if(holder.botonS.getText().equals(tipos[12]))    //NORMAL
        {
            colorDraw.setColor(Color.rgb(168, 168,120));
        }
        else if(holder.botonS.getText().equals(tipos[13]))    //POISON
        {
            colorDraw.setColor(Color.rgb(160, 64,160));
        }
        else if(holder.botonS.getText().equals(tipos[14]))    //PSYCHIC
        {
            colorDraw.setColor(Color.rgb(248, 88,136));
        }
        else if(holder.botonS.getText().equals(tipos[15]))    //ROCK
        {
            colorDraw.setColor(Color.rgb(184, 160,56));
        }
        else if(holder.botonS.getText().equals(tipos[16]))    //STEEL
        {
            colorDraw.setColor(Color.rgb(184, 184,208));
        }
        else if(holder.botonS.getText().equals(tipos[17]))    //WATER
        {
            colorDraw.setColor(Color.rgb(104, 144,240));
        }
        else if(holder.botonS.getText().equals(tipos[18]))
        {
            holder.botonS.setVisibility(View.INVISIBLE);
        }
    }
}

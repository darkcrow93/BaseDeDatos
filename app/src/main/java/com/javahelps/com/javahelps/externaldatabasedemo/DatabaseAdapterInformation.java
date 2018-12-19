package com.javahelps.com.javahelps.externaldatabasedemo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DatabaseAdapterInformation extends BaseAdapter {

    private ArrayList<Informacion> listaInformacion1;
    private Context context1;
    private ViewHolder holder1;
    GradientDrawable colorDraw;
    String[] tipos = {"Bug", "Dark", "Dragon", "Electric", "Fairy", "Fighting", "Fire", "Flying", "Ghost", "Grass", "Ground", "Ice", "Normal", "Poison", "Psychic", "Rock", "Steel", "Water", " "};

    public DatabaseAdapterInformation(ArrayList<Informacion> listaInformacionPuchamon, Context contexto){
        this.listaInformacion1 = listaInformacionPuchamon;
        this.context1 = contexto;
    }

    @Override
    public int getCount() {
        return this.listaInformacion1.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listaInformacion1.get(position);
    }

    @Override
    public long getItemId(int ID) {
        return ID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        holder1 = null;

        if(convertView == null)
        {
            LayoutInflater info = (LayoutInflater)context1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = info.inflate(R.layout.activity_poke_info, null);

            holder1 = new ViewHolder();

            holder1.pokemonNumero = (TextView)convertView.findViewById(R.id.PokemonNumero);
            holder1.pokemonNombre = (TextView)convertView.findViewById(R.id.PokemonNombre);
            holder1.tipoPrimario = (Button)convertView.findViewById(R.id.TipoPrimario);
            holder1.tipoSecundario = (Button)convertView.findViewById(R.id.TipoSecundario);
            holder1.pokemonNormal = (ImageView)convertView.findViewById(R.id.PokemonNormal);
            holder1.pokemonShiny = (ImageView)convertView.findViewById(R.id.PokemonShiny);
            holder1.alturaPulgadas = (TextView)convertView.findViewById(R.id.AlturaPulgadas);
            holder1.alturaMetros = (TextView)convertView.findViewById(R.id.AlturaMetros);
            holder1.pesoLibras = (TextView)convertView.findViewById(R.id.PesoLibras);
            holder1.pesoKg = (TextView)convertView.findViewById(R.id.PesoKg);
            holder1.especie = (TextView)convertView.findViewById(R.id.Especie);
            holder1.macho = (TextView)convertView.findViewById(R.id.Macho);
            holder1.hembra = (TextView)convertView.findViewById(R.id.Hembra);
            holder1.habilidad1 = (TextView)convertView.findViewById(R.id.Habilidad1);
            holder1.habilidad2 = (TextView)convertView.findViewById(R.id.Habilidad2);
            holder1.habilidadOculta = (TextView)convertView.findViewById(R.id.HabilidadOculta);
            holder1.huevo1 = (TextView)convertView.findViewById(R.id.Huevo1);
            holder1.huevo2 = (TextView)convertView.findViewById(R.id.Huevo2);
            holder1.captura = (TextView)convertView.findViewById(R.id.Captura);
            holder1.esfuerzo1 = (TextView)convertView.findViewById(R.id.Esfuerzo1);
            holder1.esfuerzo2 = (TextView)convertView.findViewById(R.id.Esfuerzo2);
            holder1.esfuerzo3 = (TextView)convertView.findViewById(R.id.Esfuerzo3);
            holder1.pasos = (TextView)convertView.findViewById(R.id.Pasos);
            holder1.felicidad = (TextView)convertView.findViewById(R.id.Felicidad);
            holder1.puntosExp = (TextView)convertView.findViewById(R.id.PuntosExp);
            holder1.rapidezExp = (TextView)convertView.findViewById(R.id.RapidezExp);

            convertView.setTag(holder1);
        }
        else
        {
            holder1 = (ViewHolder)convertView.getTag();
        }

        final Informacion datosInfo = listaInformacion1.get(position);

        holder1.pokemonNumero.setText(datosInfo.getNumeroInfo());
        holder1.pokemonNombre.setText(datosInfo.getNombreInfo());
        holder1.tipoPrimario.setText(datosInfo.getPrimarioInfo());
        holder1.tipoSecundario.setText(datosInfo.getSecundarioInfo());
        holder1.pokemonNormal.setImageBitmap(datosInfo.getImagenInfo());
        holder1.pokemonShiny.setImageBitmap(datosInfo.getImagenInfoShiny());
        holder1.alturaPulgadas.setText(datosInfo.getAlturaPulgadas());
        holder1.alturaMetros.setText(datosInfo.getAlturaMetros());
        holder1.pesoLibras.setText(datosInfo.getPesoLbs());
        holder1.pesoKg.setText(datosInfo.getPesoKg());
        holder1.especie.setText(datosInfo.getEspecie());
        holder1.macho.setText(datosInfo.getMasculino());
        holder1.hembra.setText(datosInfo.getFemenino());
        holder1.habilidad1.setText(datosInfo.getHabilidadPrimario());
        holder1.habilidad2.setText(datosInfo.getHabilidadSecundario());
        holder1.habilidadOculta.setText(datosInfo.getHabilidadOculta());
        holder1.huevo1.setText(datosInfo.getGrupoHuevoPrimario());
        holder1.huevo2.setText(datosInfo.getGrupoHuevoSecundario());
        holder1.captura.setText(datosInfo.getCaptura());
        holder1.esfuerzo1.setText(datosInfo.getPuntosEsfuerzoP());
        holder1.esfuerzo2.setText(datosInfo.getPuntosEsfuerzoS());
        holder1.esfuerzo3.setText(datosInfo.getPuntosEsfuerzoT());
        holder1.pasos.setText(datosInfo.getPasos());
        holder1.felicidad.setText(datosInfo.getFelicidad());
        holder1.puntosExp.setText(datosInfo.getExperiencia());

        holder1.tipoPrimario.setTextColor(Color.rgb(255,255,255));
        holder1.tipoSecundario.setTextColor(Color.rgb(255,255,255));
        holder1.tipoPrimario.setEnabled(false);
        holder1.tipoSecundario.setEnabled(false);
        holder1.rapidezExp.setText("Medium Slow");

        return convertView;
    }

    public static class ViewHolder{
        public TextView pokemonNumero;
        public TextView pokemonNombre;
        public Button tipoPrimario;
        public Button tipoSecundario;
        public ImageView pokemonNormal;
        public ImageView pokemonShiny;
        public TextView alturaPulgadas;
        public TextView alturaMetros;
        public TextView pesoLibras;
        public TextView pesoKg;
        public TextView especie;
        public TextView macho;
        public TextView hembra;
        public TextView habilidad1;
        public TextView habilidad2;
        public TextView habilidadOculta;
        public TextView huevo1;
        public TextView huevo2;
        public TextView captura;
        public TextView esfuerzo1;
        public TextView esfuerzo2;
        public TextView esfuerzo3;
        public TextView pasos;
        public TextView felicidad;
        public TextView puntosExp;
        public TextView rapidezExp;
    }
}

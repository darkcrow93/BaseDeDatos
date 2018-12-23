package com.javahelps.com.javahelps.externaldatabasedemo;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.PaintDrawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.javahelps.com.javahelps.externaldatabasedemo.custom.RadarMarkerView;

import java.util.ArrayList;

public class PokeInfo extends AppCompatActivity {

    public ArrayList<Informacion> infolist1;
    DatabaseAccess databaseAccessInfo;
    public String dato;
    public Informacion datosInfo;

    private RadarChart chart;
    protected Typeface tfLight;

    TextView NumeroInfo;
    TextView NombreInfo;
    TextView AlturaPulgadasInfo;
    TextView AlturaMetrosInfo;
    TextView PesoLibrasInfo;
    TextView PesoKgInfo;
    TextView EspecieInfo;
    TextView MachoInfo;
    TextView HembraInfo;
    TextView Habilidad1Info;
    TextView Habilidad2Info;
    TextView HabilidadOcultaInfo;
    TextView Huevo1Info;
    TextView Huevo2Info;
    TextView CapturaInfo;
    TextView Esfuerzo1Info;
    TextView Esfuerzo2Info;
    TextView Esfuerzo3Info;
    TextView PasosInfo;
    TextView FelicidadInfo;
    TextView PuntosExpInfo;
    TextView RapidezExpInfo;
    TextView HabilidadOcultaMarcadorInfo;
    TextView BugDamageInfo;
    TextView DarkDamageInfo;
    TextView DragonDamageInfo;
    TextView ElectricDamageInfo;
    TextView FairyDamageInfo;
    TextView FightingDamageInfo;
    TextView FireDamageInfo;
    TextView FlyingDamageInfo;
    TextView GhostDamageInfo;
    TextView GrassDamageInfo;
    TextView GroundDamageInfo;
    TextView IceDamageInfo;
    TextView NormalDamageInfo;
    TextView PoisonDamageInfo;
    TextView PsychicDamageInfo;
    TextView RockDamageInfo;
    TextView SteelDamageInfo;
    TextView WaterDamageInfo;
    ImageView PokemonNormalInfo;
    ImageView PokemonShinyInfo;
    Button TipoPrimarioInfo;
    Button TipoSecundarioInfo;
    Button BugInfo;
    Button DarkInfo;
    Button DragonInfo;
    Button ElectricInfo;
    Button FairyInfo;
    Button FightingInfo;
    Button FireInfo;
    Button FlyingInfo;
    Button GhostInfo;
    Button GrassInfo;
    Button GroundInfo;
    Button IceInfo;
    Button NormalInfo;
    Button PoisonInfo;
    Button PsychicInfo;
    Button RockInfo;
    Button SteelInfo;
    Button WaterInfo;

    GradientDrawable colorDraw;
    Drawable colorButton;

    //#a8b820, #705848, #7038f8, #f8d030, #ee99ac, #c03028, #f08030, #a890f0, #705898, #78c850, #e0c068, #98d8d8, #a8a878, #a040a0, #f85888, #b8a038, #b8b8d0, #6890f0
    double[] TotalDamage = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    String[] tipos = {"Bug", "Dark", "Dragon", "Electric", "Fairy", "Fighting", "Fire", "Flying", "Ghost", "Grass", "Ground", "Ice", "Normal", "Poison", "Psychic", "Rock", "Steel", "Water", " "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_info);

        chart = findViewById(R.id.chart);
        chart.setBackgroundColor(Color.rgb(255, 255, 255));
        tfLight = Typeface.createFromAsset(getAssets(), "OpenSans-Light.ttf");

        chart.getDescription().setEnabled(false);

        chart.setWebLineWidth(1f);
        chart.setWebColor(Color.LTGRAY);
        chart.setWebLineWidthInner(1f);
        chart.setWebColorInner(Color.LTGRAY);
        chart.setWebAlpha(100);

        // create a custom MarkerView (extend MarkerView) and specify the layout
        // to use for it
        MarkerView mv = new RadarMarkerView(this, R.layout.radar_markerview);
        mv.setChartView(chart); // For bounds control
        chart.setMarker(mv); // Set the marker to the chart

        setData();

        chart.animateXY(1400, 1400, Easing.EaseInOutQuad);


        XAxis xAxis = chart.getXAxis();
        xAxis.setTypeface(tfLight);
        xAxis.setTextSize(9f);
        xAxis.setYOffset(0f);
        xAxis.setXOffset(0f);
        xAxis.setValueFormatter(new ValueFormatter() {

            private final String[] mActivities = new String[]{"HP", "ATK", "DEF", "SPEED", "ATK.ESP", "DEF.ESP"};

            @Override
            public String getFormattedValue(float value) {
                return mActivities[(int) value % mActivities.length];
            }
        });
        xAxis.setTextColor(Color.RED);

        YAxis yAxis = chart.getYAxis();
        yAxis.setTypeface(tfLight);
        yAxis.setLabelCount(5, false);
        yAxis.setTextSize(9f);
        yAxis.setAxisMinimum(0f);
        yAxis.setAxisMaximum(80f);
        yAxis.setDrawLabels(false);

        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setTypeface(tfLight);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(5f);
        l.setTextColor(Color.RED);

        for (IDataSet<?> set : chart.getData().getDataSets())
            set.setDrawValues(!set.isDrawValuesEnabled());



        if (chart.isRotationEnabled())
            chart.setRotationEnabled(false);

        chart.invalidate();


        parametros();
        //



        Intent intent = getIntent(); //Obtengo los datos del intent
        Bundle extras = intent.getExtras(); //los datos obtenidos se guardan en extra
        databaseAccessInfo = DatabaseAccess.getInstance(this);


        if(extras != null)
        {
            dato = extras.getString("DATO");
            databaseAccessInfo.open();
            infolist1 = databaseAccessInfo.DatosPuchamonTodos(dato);
            databaseAccessInfo.close();

            datosInfo = infolist1.get(0);

            Datos();
            Estilo();
        }
    }

    private void setData() {

        float mul = 80;
        float min = 20;
        int cnt = 6;

        ArrayList<RadarEntry> entries1 = new ArrayList<>();
        ArrayList<RadarEntry> entries2 = new ArrayList<>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < cnt; i++) {
            float val1 = (float) (Math.random() * mul) + min;
            entries1.add(new RadarEntry(val1));

            float val2 = (float) (Math.random() * mul) + min;
            entries2.add(new RadarEntry(val2));
        }

        RadarDataSet set1 = new RadarDataSet(entries1, "Last Week");
        set1.setColor(Color.rgb(0, 204, 0));
        set1.setFillColor(Color.rgb(51, 153, 255));
        set1.setDrawFilled(true);
        set1.setFillAlpha(180);
        set1.setLineWidth(2f);
        set1.setDrawHighlightCircleEnabled(true);
        set1.setDrawHighlightIndicators(false);

        RadarDataSet set2 = new RadarDataSet(entries2, "This Week");
        set2.setColor(Color.rgb(0, 204, 0));
        set2.setFillColor(Color.rgb(51, 153, 255));
        set2.setDrawFilled(true);
        set2.setFillAlpha(180);
        set2.setLineWidth(2f);
        set2.setDrawHighlightCircleEnabled(true);
        set2.setDrawHighlightIndicators(false);

        ArrayList<IRadarDataSet> sets = new ArrayList<>();
        sets.add(set1);
        sets.add(set2);

        RadarData data = new RadarData(sets);
        //data.setValueTypeface(tfLight);
        data.setValueTextSize(8f);
        data.setDrawValues(false);
        data.setValueTextColor(Color.WHITE);

        chart.setData(data);
        chart.invalidate();
    }

    public void parametros()
    {
        NumeroInfo = (TextView)findViewById(R.id.PokemonNumero);
        NombreInfo = (TextView)findViewById(R.id.PokemonNombre);
        AlturaPulgadasInfo = (TextView)findViewById(R.id.AlturaPulgadas);
        AlturaMetrosInfo = (TextView)findViewById(R.id.AlturaMetros);
        PesoLibrasInfo = (TextView)findViewById(R.id.PesoLibras);
        PesoKgInfo = (TextView)findViewById(R.id.PesoKg);
        EspecieInfo = (TextView)findViewById(R.id.Especie);
        MachoInfo = (TextView)findViewById(R.id.Macho);
        HembraInfo = (TextView)findViewById(R.id.Hembra);
        Habilidad1Info = (TextView)findViewById(R.id.Habilidad1);
        Habilidad2Info = (TextView)findViewById(R.id.Habilidad2);
        HabilidadOcultaInfo = (TextView)findViewById(R.id.HabilidadOculta);
        Huevo1Info = (TextView)findViewById(R.id.Huevo1);
        Huevo2Info = (TextView)findViewById(R.id.Huevo2);
        CapturaInfo = (TextView)findViewById(R.id.Captura);
        Esfuerzo1Info = (TextView)findViewById(R.id.Esfuerzo1);
        Esfuerzo2Info = (TextView)findViewById(R.id.Esfuerzo2);
        Esfuerzo3Info = (TextView)findViewById(R.id.Esfuerzo3);
        PasosInfo = (TextView)findViewById(R.id.Pasos);
        FelicidadInfo = (TextView)findViewById(R.id.Felicidad);
        PuntosExpInfo = (TextView)findViewById(R.id.PuntosExp);
        RapidezExpInfo = (TextView)findViewById(R.id.RapidezExp);
        HabilidadOcultaMarcadorInfo = (TextView)findViewById(R.id.HabilidadOcultaMarcador);
        PokemonNormalInfo = (ImageView)findViewById(R.id.PokemonNormal);
        PokemonShinyInfo = (ImageView)findViewById(R.id.PokemonShiny);
        TipoPrimarioInfo = (Button)findViewById(R.id.TipoPrimario);
        TipoSecundarioInfo = (Button)findViewById(R.id.TipoSecundario);
        BugInfo = (Button)findViewById(R.id.Bug);
        DarkInfo = (Button)findViewById(R.id.Dark);
        DragonInfo = (Button)findViewById(R.id.Dragon);
        ElectricInfo = (Button)findViewById(R.id.Electric);
        FairyInfo = (Button)findViewById(R.id.Fairy);
        FightingInfo = (Button)findViewById(R.id.Fighting);
        FireInfo = (Button)findViewById(R.id.Fire);
        FlyingInfo = (Button)findViewById(R.id.Flying);
        GhostInfo = (Button)findViewById(R.id.Ghost);
        GrassInfo = (Button)findViewById(R.id.Grass);
        GroundInfo = (Button)findViewById(R.id.Ground);
        IceInfo = (Button)findViewById(R.id.Ice);
        NormalInfo = (Button)findViewById(R.id.Normal);
        PoisonInfo = (Button)findViewById(R.id.Poison);
        PsychicInfo = (Button)findViewById(R.id.Psychic);
        RockInfo = (Button)findViewById(R.id.Rock);
        SteelInfo = (Button)findViewById(R.id.Steel);
        WaterInfo = (Button)findViewById(R.id.Water);
        BugDamageInfo = (TextView) findViewById(R.id.BugDamage);
        DarkDamageInfo = (TextView)findViewById(R.id.DarkDamage);
        DragonDamageInfo = (TextView)findViewById(R.id.DragonDamage);
        ElectricDamageInfo = (TextView)findViewById(R.id.ElectricDamage);
        FairyDamageInfo = (TextView)findViewById(R.id.FairyDamage);
        FightingDamageInfo = (TextView)findViewById(R.id.FightingDamage);
        FireDamageInfo = (TextView)findViewById(R.id.FireDamage);
        FlyingDamageInfo = (TextView)findViewById(R.id.FlyingDamage);
        GhostDamageInfo = (TextView)findViewById(R.id.GhostDamage);
        GrassDamageInfo = (TextView)findViewById(R.id.GrassDamage);
        GroundDamageInfo = (TextView)findViewById(R.id.GroundDamage);
        IceDamageInfo = (TextView)findViewById(R.id.IceDamage);
        NormalDamageInfo = (TextView)findViewById(R.id.NormalDamage);
        PoisonDamageInfo = (TextView)findViewById(R.id.PoisonDamage);
        PsychicDamageInfo = (TextView)findViewById(R.id.PsychicDamage);
        RockDamageInfo = (TextView)findViewById(R.id.RockDamage);
        SteelDamageInfo = (TextView)findViewById(R.id.SteelDamage);
        WaterDamageInfo = (TextView)findViewById(R.id.WaterDamage);
    }

    public void Datos()
    {
        NumeroInfo.setText(datosInfo.getNumeroInfo());
        NombreInfo.setText(datosInfo.getNombreInfo());
        AlturaPulgadasInfo.setText(datosInfo.getAlturaPulgadas());
        AlturaMetrosInfo.setText(datosInfo.getAlturaMetros());
        PesoLibrasInfo.setText(datosInfo.getPesoLbs());
        PesoKgInfo.setText(datosInfo.getPesoKg());
        EspecieInfo.setText(datosInfo.getEspecie());
        MachoInfo.setText(datosInfo.getMasculino());
        HembraInfo.setText(datosInfo.getFemenino());
        Habilidad1Info.setText(datosInfo.getHabilidadPrimario());
        Habilidad2Info.setText(datosInfo.getHabilidadSecundario());
        HabilidadOcultaInfo.setText(datosInfo.getHabilidadOculta());
        Huevo1Info.setText(datosInfo.getGrupoHuevoPrimario());
        Huevo2Info.setText(datosInfo.getGrupoHuevoSecundario());
        CapturaInfo.setText(datosInfo.getCaptura());
        Esfuerzo1Info.setText(datosInfo.getPuntosEsfuerzoP());
        Esfuerzo2Info.setText(datosInfo.getPuntosEsfuerzoS());
        Esfuerzo3Info.setText(datosInfo.getPuntosEsfuerzoT());
        PasosInfo.setText(datosInfo.getPasos());
        FelicidadInfo.setText(datosInfo.getFelicidad());
        PuntosExpInfo.setText(datosInfo.getExperiencia());

        TipoPrimarioInfo.setText(datosInfo.getPrimarioInfo());
        TipoSecundarioInfo.setText(datosInfo.getSecundarioInfo());

        PokemonNormalInfo.setImageBitmap(datosInfo.getImagenInfo());
        PokemonShinyInfo.setImageBitmap(datosInfo.getImagenInfoShiny());
    }

    public void Estilo()
    {
        TipoPrimarioInfo.setTextColor(Color.rgb(255,255,255));
        TipoSecundarioInfo.setTextColor(Color.rgb(255,255,255));

        TipoPrimarioInfo.setEnabled(false);
        TipoSecundarioInfo.setEnabled(false);

        ColorTP();
        ColorTS();
        Ocultar();
        PuntajeExperiencia();
        Tabla();
    }

    public void ColorTP()
    {
        //////////  COLOR TIPO PRIMARIO   //////////
        TipoPrimarioInfo.setBackgroundResource(R.drawable.types);
        colorDraw = (GradientDrawable)TipoPrimarioInfo.getBackground().getCurrent();

        //if(TipoPrimarioInfo.getText().equals(tipos[0]))
        //{
        //    colorButton = TipoPrimarioInfo.getBackground();
        //    colorButton = DrawableCompat.wrap(colorButton);
        //    DrawableCompat.setTint(colorButton, Color.rgb(168, 184,32));
        //}
        if(TipoPrimarioInfo.getText().equals(tipos[0]))          //BUG
        {

            colorDraw.setStroke(2, Color.rgb(109,120,21));
            colorDraw.setColor(Color.rgb(168, 184,32));
            TotalDamage = new double[]{TotalDamage[0] * 1, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 1,
                    TotalDamage[4] * 1, TotalDamage[5] * 0.5, TotalDamage[6] * 2, TotalDamage[7] * 2, TotalDamage[8] * 1,
                    TotalDamage[9] * 0.5, TotalDamage[10] * 0.5, TotalDamage[11] * 1, TotalDamage[12] * 1, TotalDamage[13] * 1,
                    TotalDamage[14] * 1, TotalDamage[15] * 2, TotalDamage[16] * 1, TotalDamage[17] * 1};
        }
        else if(TipoPrimarioInfo.getText().equals(tipos[1]))    //DARK
        {
            colorDraw.setStroke(2, Color.rgb(73,57,47));
            colorDraw.setColor(Color.rgb(112, 88,72));
            TotalDamage = new double[]{TotalDamage[0] * 2, TotalDamage[1] * 0.5, TotalDamage[2] * 1, TotalDamage[3] * 1,
                    TotalDamage[4] * 2, TotalDamage[5] * 2, TotalDamage[6] * 1, TotalDamage[7] * 1, TotalDamage[8] * 0.5,
                    TotalDamage[9] * 1, TotalDamage[10] * 1, TotalDamage[11] * 1, TotalDamage[12] * 1, TotalDamage[13] * 1,
                    TotalDamage[14] * 0, TotalDamage[15] * 1, TotalDamage[16] * 1, TotalDamage[17] * 1};
        }
        else if(TipoPrimarioInfo.getText().equals(tipos[2]))    //DRAGON
        {
            colorDraw.setStroke(2, Color.rgb(73,36,161));
            colorDraw.setColor(Color.rgb(112, 56,248));
            TotalDamage = new double[]{TotalDamage[0] * 1, TotalDamage[1] * 1, TotalDamage[2] * 2, TotalDamage[3] * 0.5,
                    TotalDamage[4] * 2, TotalDamage[5] * 1, TotalDamage[6] * 0.5, TotalDamage[7] * 1, TotalDamage[8] * 1,
                    TotalDamage[9] * 0.5, TotalDamage[10] * 1, TotalDamage[11] * 2, TotalDamage[12] * 1, TotalDamage[13] * 1,
                    TotalDamage[14] * 1, TotalDamage[15] * 1, TotalDamage[16] * 1, TotalDamage[17] * 0.5};
        }
        else if(TipoPrimarioInfo.getText().equals(tipos[3]))    //ELECTRIC
        {
            colorDraw.setStroke(2, Color.rgb(161,135,31));
            colorDraw.setColor(Color.rgb(248, 208,48));
            TotalDamage = new double[]{TotalDamage[0] * 1, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 0.5,
                    TotalDamage[4] * 1, TotalDamage[5] * 1, TotalDamage[6] * 1, TotalDamage[7] * 0.5, TotalDamage[8] * 1,
                    TotalDamage[9] * 1, TotalDamage[10] * 2, TotalDamage[11] * 1, TotalDamage[12] * 1, TotalDamage[13] * 1,
                    TotalDamage[14] * 1, TotalDamage[15] * 1, TotalDamage[16] * 0.5, TotalDamage[17] * 1};
        }
        else if(TipoPrimarioInfo.getText().equals(tipos[4]))    //FAIRY
        {
            colorDraw.setStroke(2, Color.rgb(155,100,112));
            colorDraw.setColor(Color.rgb(238, 153,172));
            TotalDamage = new double[]{TotalDamage[0] * 0.5, TotalDamage[1] * 0.5, TotalDamage[2] * 0, TotalDamage[3] * 1,
                    TotalDamage[4] * 1, TotalDamage[5] * 0.5, TotalDamage[6] * 1, TotalDamage[7] * 1, TotalDamage[8] * 1,
                    TotalDamage[9] * 1, TotalDamage[10] * 1, TotalDamage[11] * 1, TotalDamage[12] * 1, TotalDamage[13] * 2,
                    TotalDamage[14] * 1, TotalDamage[15] * 1, TotalDamage[16] * 2, TotalDamage[17] * 1};
        }
        else if(TipoPrimarioInfo.getText().equals(tipos[5]))    //FIGHTNING
        {
            colorDraw.setStroke(2, Color.rgb(125,31,26));
            colorDraw.setColor(Color.rgb(192, 48,40));
            TotalDamage = new double[]{TotalDamage[0] * 0.5, TotalDamage[1] * 0.5, TotalDamage[2] * 1, TotalDamage[3] * 1,
                    TotalDamage[4] * 2, TotalDamage[5] * 1, TotalDamage[6] * 1, TotalDamage[7] * 2, TotalDamage[8] * 1,
                    TotalDamage[9] * 1, TotalDamage[10] * 1, TotalDamage[11] * 1, TotalDamage[12] * 1, TotalDamage[13] * 1,
                    TotalDamage[14] * 2, TotalDamage[15] * 0.5, TotalDamage[16] * 1, TotalDamage[17] * 1};
        }
        else if(TipoPrimarioInfo.getText().equals(tipos[6]))    //FIRE
        {
            colorDraw.setStroke(2, Color.rgb(156,83,31));
            colorDraw.setColor(Color.rgb(240, 128,48));
            TotalDamage = new double[]{TotalDamage[0] * 0.5, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 1,
                    TotalDamage[4] * 0.5, TotalDamage[5] * 1, TotalDamage[6] * 0.5, TotalDamage[7] * 1, TotalDamage[8] * 1,
                    TotalDamage[9] * 0.5, TotalDamage[10] * 2, TotalDamage[11] * 0.5, TotalDamage[12] * 1, TotalDamage[13] * 1,
                    TotalDamage[14] * 1, TotalDamage[15] * 2, TotalDamage[16] * 0.5, TotalDamage[17] * 2};
        }
        else if(TipoPrimarioInfo.getText().equals(tipos[7]))    //FLYING
        {
            colorDraw.setStroke(2, Color.rgb(109,94,156));
            colorDraw.setColor(Color.rgb(168, 144,240));
            TotalDamage = new double[]{TotalDamage[0] * 0.5, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 2,
                    TotalDamage[4] * 1, TotalDamage[5] * 0.5, TotalDamage[6] * 1, TotalDamage[7] * 1, TotalDamage[8] * 1,
                    TotalDamage[9] * 0.5, TotalDamage[10] * 0, TotalDamage[11] * 2, TotalDamage[12] * 1, TotalDamage[13] * 1,
                    TotalDamage[14] * 1, TotalDamage[15] * 2, TotalDamage[16] * 1, TotalDamage[17] * 1};
        }
        else if(TipoPrimarioInfo.getText().equals(tipos[8]))    //GHOST
        {
            colorDraw.setStroke(2, Color.rgb(73,57,99));
            colorDraw.setColor(Color.rgb(112, 88,152));
            TotalDamage = new double[]{TotalDamage[0] * 0.5, TotalDamage[1] * 2, TotalDamage[2] * 1, TotalDamage[3] * 1,
                    TotalDamage[4] * 1, TotalDamage[5] * 0, TotalDamage[6] * 1, TotalDamage[7] * 1, TotalDamage[8] * 2,
                    TotalDamage[9] * 1, TotalDamage[10] * 1, TotalDamage[11] * 1, TotalDamage[12] * 0, TotalDamage[13] * 0.5,
                    TotalDamage[14] * 1, TotalDamage[15] * 1, TotalDamage[16] * 1, TotalDamage[17] * 1};
        }
        else if(TipoPrimarioInfo.getText().equals(tipos[9]))    //GRASS
        {
            colorDraw.setStroke(2, Color.rgb(78,130,52));
            colorDraw.setColor(Color.rgb(120, 200,80));
            TotalDamage = new double[]{TotalDamage[0] * 2, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 0.5,
                    TotalDamage[4] * 1, TotalDamage[5] * 1, TotalDamage[6] * 2, TotalDamage[7] * 2, TotalDamage[8] * 1,
                    TotalDamage[9] * 0.5, TotalDamage[10] * 0.5, TotalDamage[11] * 2, TotalDamage[12] * 1, TotalDamage[13] * 2,
                    TotalDamage[14] * 1, TotalDamage[15] * 1, TotalDamage[16] * 1, TotalDamage[17] * 0.5};
        }
        else if(TipoPrimarioInfo.getText().equals(tipos[10]))    //GROUND
        {
            colorDraw.setStroke(2, Color.rgb(146,125,68));
            colorDraw.setColor(Color.rgb(224, 192,104));
            TotalDamage = new double[]{TotalDamage[0] * 1, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 0,
                    TotalDamage[4] * 1, TotalDamage[5] * 1, TotalDamage[6] * 1, TotalDamage[7] * 1, TotalDamage[8] * 1,
                    TotalDamage[9] * 2, TotalDamage[10] * 1, TotalDamage[11] * 2, TotalDamage[12] * 1, TotalDamage[13] * 0.5,
                    TotalDamage[14] * 1, TotalDamage[15] * 0.5, TotalDamage[16] * 1, TotalDamage[17] * 2};
        }
        else if(TipoPrimarioInfo.getText().equals(tipos[11]))   //ICE
        {
            colorDraw.setStroke(2, Color.rgb(99,141,141));
            colorDraw.setColor(Color.rgb(152, 216,216));
            TotalDamage = new double[]{TotalDamage[0] * 1, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 1,
                    TotalDamage[4] * 1, TotalDamage[5] * 2, TotalDamage[6] * 2, TotalDamage[7] * 1, TotalDamage[8] * 1,
                    TotalDamage[9] * 1, TotalDamage[10] * 1, TotalDamage[11] * 0.5, TotalDamage[12] * 1, TotalDamage[13] * 1,
                    TotalDamage[14] * 1, TotalDamage[15] * 2, TotalDamage[16] * 2, TotalDamage[17] * 1};
        }
        else if(TipoPrimarioInfo.getText().equals(tipos[12]))    //NORMAL
        {
            colorDraw.setStroke(2, Color.rgb(109,109,78));
            colorDraw.setColor(Color.rgb(168, 168,120));
            TotalDamage = new double[]{TotalDamage[0] * 1, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 1,
                    TotalDamage[4] * 1, TotalDamage[5] * 2, TotalDamage[6] * 1, TotalDamage[7] * 1, TotalDamage[8] * 0,
                    TotalDamage[9] * 1, TotalDamage[10] * 1, TotalDamage[11] * 1, TotalDamage[12] * 1, TotalDamage[13] * 1,
                    TotalDamage[14] * 1, TotalDamage[15] * 1, TotalDamage[16] * 1, TotalDamage[17] * 1};
        }
        else if(TipoPrimarioInfo.getText().equals(tipos[13]))    //POISON
        {
            colorDraw.setStroke(2, Color.rgb(104,42,104));
            colorDraw.setColor(Color.rgb(160, 64,160));
            TotalDamage = new double[]{TotalDamage[0] * 0.5, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 1,
                    TotalDamage[4] * 0.5, TotalDamage[5] * 0.5, TotalDamage[6] * 1, TotalDamage[7] * 1, TotalDamage[8] * 1,
                    TotalDamage[9] * 0.5, TotalDamage[10] * 2, TotalDamage[11] * 1, TotalDamage[12] * 1, TotalDamage[13] * 0.5,
                    TotalDamage[14] * 2, TotalDamage[15] * 1, TotalDamage[16] * 1, TotalDamage[17] * 1};
        }
        else if(TipoPrimarioInfo.getText().equals(tipos[14]))    //PSYCHIC
        {
            colorDraw.setStroke(2, Color.rgb(161,57,89));
            colorDraw.setColor(Color.rgb(248, 88,136));
            TotalDamage = new double[]{TotalDamage[0] * 2, TotalDamage[1] * 2, TotalDamage[2] * 1, TotalDamage[3] * 1,
                    TotalDamage[4] * 1, TotalDamage[5] * 0.5, TotalDamage[6] * 1, TotalDamage[7] * 1, TotalDamage[8] * 2,
                    TotalDamage[9] * 1, TotalDamage[10] * 1, TotalDamage[11] * 1, TotalDamage[12] * 1, TotalDamage[13] * 1,
                    TotalDamage[14] * 0.5, TotalDamage[15] * 1, TotalDamage[16] * 1, TotalDamage[17] * 1};
        }
        else if(TipoPrimarioInfo.getText().equals(tipos[15]))    //ROCK
        {
            colorDraw.setStroke(2, Color.rgb(120,104,36));
            colorDraw.setColor(Color.rgb(184, 160,56));
            TotalDamage = new double[]{TotalDamage[0] * 1, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 1,
                    TotalDamage[4] * 1, TotalDamage[5] * 2, TotalDamage[6] * 0.5, TotalDamage[7] * 0.5, TotalDamage[8] * 1,
                    TotalDamage[9] * 2, TotalDamage[10] * 2, TotalDamage[11] * 1, TotalDamage[12] * 1, TotalDamage[13] * 0.5,
                    TotalDamage[14] * 1, TotalDamage[15] * 1, TotalDamage[16] * 2, TotalDamage[17] * 2};
        }
        else if(TipoPrimarioInfo.getText().equals(tipos[16]))    //STEEL
        {
            colorDraw.setStroke(2, Color.rgb(120,120,135));
            colorDraw.setColor(Color.rgb(184, 184,208));
            TotalDamage = new double[]{TotalDamage[0] * 0.5, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 1,
                    TotalDamage[4] * 0.5, TotalDamage[5] * 2, TotalDamage[6] * 1, TotalDamage[7] * 0.5, TotalDamage[8] * 1,
                    TotalDamage[9] * 0.5, TotalDamage[10] * 2, TotalDamage[11] * 1, TotalDamage[12] * 0.5, TotalDamage[13] * 0,
                    TotalDamage[14] * 0.5, TotalDamage[15] * 0.5, TotalDamage[16] * 0.5, TotalDamage[17] * 1};
        }
        else if(TipoPrimarioInfo.getText().equals(tipos[17]))    //WATER
        {
            colorDraw.setStroke(2, Color.rgb(73,57,99));
            colorDraw.setColor(Color.rgb(104, 144,240));
            TotalDamage = new double[]{TotalDamage[0] * 1, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 2,
                    TotalDamage[4] * 1, TotalDamage[5] * 1, TotalDamage[6] * 0.5, TotalDamage[7] *  1, TotalDamage[8] * 1,
                    TotalDamage[9] * 2, TotalDamage[10] * 1, TotalDamage[11] * 0.5, TotalDamage[12] * 1, TotalDamage[13] * 1,
                    TotalDamage[14] * 1, TotalDamage[15] * 1, TotalDamage[16] * 0.5, TotalDamage[17] * 0.5};
        }
    }

    public void ColorTS()
    {
        //////////  COLOR TIPO SECUNDARIO   //////////
        TipoSecundarioInfo.setVisibility(View.VISIBLE);
        TipoSecundarioInfo.setBackgroundResource(R.drawable.types);
        colorDraw = (GradientDrawable)TipoSecundarioInfo.getBackground().getCurrent();

        if(TipoSecundarioInfo.getText().equals(tipos[0]))          //BUG
        {
            colorDraw.setStroke(2, Color.rgb(109,120,21));
            colorDraw.setColor(Color.rgb(168, 184,32));
            TotalDamage = new double[]{TotalDamage[0] * 1, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 1,
                    TotalDamage[4] * 1, TotalDamage[5] * 0.5, TotalDamage[6] * 2, TotalDamage[7] * 2, TotalDamage[8] * 1,
                    TotalDamage[9] * 0.5, TotalDamage[10] * 0.5, TotalDamage[11] * 1, TotalDamage[12] * 1, TotalDamage[13] * 1,
                    TotalDamage[14] * 1, TotalDamage[15] * 2, TotalDamage[16] * 1, TotalDamage[17] * 1};
        }
        else if(TipoSecundarioInfo.getText().equals(tipos[1]))    //DARK
        {
            colorDraw.setStroke(2, Color.rgb(73,57,47));
            colorDraw.setColor(Color.rgb(112, 88,72));
            TotalDamage = new double[]{TotalDamage[0] * 2, TotalDamage[1] * 0.5, TotalDamage[2] * 1, TotalDamage[3] * 1,
                    TotalDamage[4] * 2, TotalDamage[5] * 2, TotalDamage[6] * 1, TotalDamage[7] * 1, TotalDamage[8] * 0.5,
                    TotalDamage[9] * 1, TotalDamage[10] * 1, TotalDamage[11] * 1, TotalDamage[12] * 1, TotalDamage[13] * 1,
                    TotalDamage[14] * 0, TotalDamage[15] * 1, TotalDamage[16] * 1, TotalDamage[17] * 1};
        }
        else if(TipoSecundarioInfo.getText().equals(tipos[2]))    //DRAGON
        {
            colorDraw.setStroke(2, Color.rgb(73,36,161));
            colorDraw.setColor(Color.rgb(112, 56,248));
            TotalDamage = new double[]{TotalDamage[0] * 1, TotalDamage[1] * 1, TotalDamage[2] * 2, TotalDamage[3] * 0.5,
                    TotalDamage[4] * 2, TotalDamage[5] * 1, TotalDamage[6] * 0.5, TotalDamage[7] * 1, TotalDamage[8] * 1,
                    TotalDamage[9] * 0.5, TotalDamage[10] * 1, TotalDamage[11] * 2, TotalDamage[12] * 1, TotalDamage[13] * 1,
                    TotalDamage[14] * 1, TotalDamage[15] * 1, TotalDamage[16] * 1, TotalDamage[17] * 0.5};
        }
        else if(TipoSecundarioInfo.getText().equals(tipos[3]))    //ELECTRIC
        {
            colorDraw.setStroke(2, Color.rgb(161,135,31));
            colorDraw.setColor(Color.rgb(248, 208,48));
            TotalDamage = new double[]{TotalDamage[0] * 1, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 0.5,
                    TotalDamage[4] * 1, TotalDamage[5] * 1, TotalDamage[6] * 1, TotalDamage[7] * 0.5, TotalDamage[8] * 1,
                    TotalDamage[9] * 1, TotalDamage[10] * 2, TotalDamage[11] * 1, TotalDamage[12] * 1, TotalDamage[13] * 1,
                    TotalDamage[14] * 1, TotalDamage[15] * 1, TotalDamage[16] * 0.5, TotalDamage[17] * 1};
        }
        else if(TipoSecundarioInfo.getText().equals(tipos[4]))    //FAIRY
        {
            colorDraw.setStroke(2, Color.rgb(155,100,112));
            colorDraw.setColor(Color.rgb(238, 153,172));
            TotalDamage = new double[]{TotalDamage[0] * 0.5, TotalDamage[1] * 0.5, TotalDamage[2] * 0, TotalDamage[3] * 1,
                    TotalDamage[4] * 1, TotalDamage[5] * 0.5, TotalDamage[6] * 1, TotalDamage[7] * 1, TotalDamage[8] * 1,
                    TotalDamage[9] * 1, TotalDamage[10] * 1, TotalDamage[11] * 1, TotalDamage[12] * 1, TotalDamage[13] * 2,
                    TotalDamage[14] * 1, TotalDamage[15] * 1, TotalDamage[16] * 2, TotalDamage[17] * 1};
        }
        else if(TipoSecundarioInfo.getText().equals(tipos[5]))    //FIGHTNING
        {
            colorDraw.setStroke(2, Color.rgb(125,31,26));
            colorDraw.setColor(Color.rgb(192, 48,40));
            TotalDamage = new double[]{TotalDamage[0] * 0.5, TotalDamage[1] * 0.5, TotalDamage[2] * 1, TotalDamage[3] * 1,
                    TotalDamage[4] * 2, TotalDamage[5] * 1, TotalDamage[6] * 1, TotalDamage[7] * 2, TotalDamage[8] * 1,
                    TotalDamage[9] * 1, TotalDamage[10] * 1, TotalDamage[11] * 1, TotalDamage[12] * 1, TotalDamage[13] * 1,
                    TotalDamage[14] * 2, TotalDamage[15] * 0.5, TotalDamage[16] * 1, TotalDamage[17] * 1};
        }
        else if(TipoSecundarioInfo.getText().equals(tipos[6]))    //FIRE
        {
            colorDraw.setStroke(2, Color.rgb(156,83,31));
            colorDraw.setColor(Color.rgb(240, 128,48));
            TotalDamage = new double[]{TotalDamage[0] * 0.5, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 1,
                    TotalDamage[4] * 0.5, TotalDamage[5] * 1, TotalDamage[6] * 0.5, TotalDamage[7] * 1, TotalDamage[8] * 1,
                    TotalDamage[9] * 0.5, TotalDamage[10] * 2, TotalDamage[11] * 0.5, TotalDamage[12] * 1, TotalDamage[13] * 1,
                    TotalDamage[14] * 1, TotalDamage[15] * 2, TotalDamage[16] * 0.5, TotalDamage[17] * 2};
        }
        else if(TipoSecundarioInfo.getText().equals(tipos[7]))    //FLYING
        {
            colorDraw.setStroke(2, Color.rgb(109,94,156));
            colorDraw.setColor(Color.rgb(168, 144,240));
            TotalDamage = new double[]{TotalDamage[0] * 0.5, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 2,
                    TotalDamage[4] * 1, TotalDamage[5] * 0.5, TotalDamage[6] * 1, TotalDamage[7] * 1, TotalDamage[8] * 1,
                    TotalDamage[9] * 0.5, TotalDamage[10] * 0, TotalDamage[11] * 2, TotalDamage[12] * 1, TotalDamage[13] * 1,
                    TotalDamage[14] * 1, TotalDamage[15] * 2, TotalDamage[16] * 1, TotalDamage[17] * 1};
        }
        else if(TipoSecundarioInfo.getText().equals(tipos[8]))    //GHOST
        {
            colorDraw.setStroke(2, Color.rgb(73,57,99));
            colorDraw.setColor(Color.rgb(112, 88,152));
            TotalDamage = new double[]{TotalDamage[0] * 0.5, TotalDamage[1] * 2, TotalDamage[2] * 1, TotalDamage[3] * 1,
                    TotalDamage[4] * 1, TotalDamage[5] * 0, TotalDamage[6] * 1, TotalDamage[7] * 1, TotalDamage[8] * 2,
                    TotalDamage[9] * 1, TotalDamage[10] * 1, TotalDamage[11] * 1, TotalDamage[12] * 0, TotalDamage[13] * 0.5,
                    TotalDamage[14] * 1, TotalDamage[15] * 1, TotalDamage[16] * 1, TotalDamage[17] * 1};
        }
        else if(TipoSecundarioInfo.getText().equals(tipos[9]))    //GRASS
        {
            colorDraw.setStroke(2, Color.rgb(78,130,52));
            colorDraw.setColor(Color.rgb(120, 200,80));
            TotalDamage = new double[]{TotalDamage[0] * 2, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 0.5,
                    TotalDamage[4] * 1, TotalDamage[5] * 1, TotalDamage[6] * 2, TotalDamage[7] * 2, TotalDamage[8] * 1,
                    TotalDamage[9] * 0.5, TotalDamage[10] * 0.5, TotalDamage[11] * 2, TotalDamage[12] * 1, TotalDamage[13] * 2,
                    TotalDamage[14] * 1, TotalDamage[15] * 1, TotalDamage[16] * 1, TotalDamage[17] * 0.5};
        }
        else if(TipoSecundarioInfo.getText().equals(tipos[10]))    //GROUND
        {
            colorDraw.setStroke(2, Color.rgb(146,125,68));
            colorDraw.setColor(Color.rgb(224, 192,104));
            TotalDamage = new double[]{TotalDamage[0] * 1, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 0,
                    TotalDamage[4] * 1, TotalDamage[5] * 1, TotalDamage[6] * 1, TotalDamage[7] * 1, TotalDamage[8] * 1,
                    TotalDamage[9] * 2, TotalDamage[10] * 1, TotalDamage[11] * 2, TotalDamage[12] * 1, TotalDamage[13] * 0.5,
                    TotalDamage[14] * 1, TotalDamage[15] * 0.5, TotalDamage[16] * 1, TotalDamage[17] * 2};
        }
        else if(TipoSecundarioInfo.getText().equals(tipos[11]))   //ICE
        {
            colorDraw.setStroke(2, Color.rgb(99,141,141));
            colorDraw.setColor(Color.rgb(152, 216,216));
            TotalDamage = new double[]{TotalDamage[0] * 1, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 1,
                    TotalDamage[4] * 1, TotalDamage[5] * 2, TotalDamage[6] * 2, TotalDamage[7] * 1, TotalDamage[8] * 1,
                    TotalDamage[9] * 1, TotalDamage[10] * 1, TotalDamage[11] * 0.5, TotalDamage[12] * 1, TotalDamage[13] * 1,
                    TotalDamage[14] * 1, TotalDamage[15] * 2, TotalDamage[16] * 2, TotalDamage[17] * 1};
        }
        else if(TipoSecundarioInfo.getText().equals(tipos[12]))    //NORMAL
        {
            colorDraw.setStroke(2, Color.rgb(109,109,78));
            colorDraw.setColor(Color.rgb(168, 168,120));
            TotalDamage = new double[]{TotalDamage[0] * 1, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 1,
                    TotalDamage[4] * 1, TotalDamage[5] * 2, TotalDamage[6] * 1, TotalDamage[7] * 1, TotalDamage[8] * 0,
                    TotalDamage[9] * 1, TotalDamage[10] * 1, TotalDamage[11] * 1, TotalDamage[12] * 1, TotalDamage[13] * 1,
                    TotalDamage[14] * 1, TotalDamage[15] * 1, TotalDamage[16] * 1, TotalDamage[17] * 1};
        }
        else if(TipoSecundarioInfo.getText().equals(tipos[13]))    //POISON
        {
            colorDraw.setStroke(2, Color.rgb(104,42,104));
            colorDraw.setColor(Color.rgb(160, 64,160));
            TotalDamage = new double[]{TotalDamage[0] * 0.5, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 1,
                    TotalDamage[4] * 0.5, TotalDamage[5] * 0.5, TotalDamage[6] * 1, TotalDamage[7] * 1, TotalDamage[8] * 1,
                    TotalDamage[9] * 0.5, TotalDamage[10] * 2, TotalDamage[11] * 1, TotalDamage[12] * 1, TotalDamage[13] * 0.5,
                    TotalDamage[14] * 2, TotalDamage[15] * 1, TotalDamage[16] * 1, TotalDamage[17]* 1};
        }
        else if(TipoSecundarioInfo.getText().equals(tipos[14]))    //PSYCHIC
        {
            colorDraw.setStroke(2, Color.rgb(161,57,89));
            colorDraw.setColor(Color.rgb(248, 88,136));
            TotalDamage = new double[]{TotalDamage[0] * 2, TotalDamage[1] * 2, TotalDamage[2] * 1, TotalDamage[3] * 1,
                    TotalDamage[4] * 1, TotalDamage[5] * 0.5, TotalDamage[6] * 1, TotalDamage[7] * 1, TotalDamage[8] * 2,
                    TotalDamage[9] * 1, TotalDamage[10] * 1, TotalDamage[11] * 1, TotalDamage[12] * 1, TotalDamage[13] * 1,
                    TotalDamage[14] * 0.5, TotalDamage[15] * 1, TotalDamage[16] * 1, TotalDamage[17] * 1};
        }
        else if(TipoSecundarioInfo.getText().equals(tipos[15]))    //ROCK
        {
            colorDraw.setStroke(2, Color.rgb(120,104,36));
            colorDraw.setColor(Color.rgb(184, 160,56));
            TotalDamage = new double[]{TotalDamage[0] * 1, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 1,
                    TotalDamage[4] * 1, TotalDamage[5] * 2, TotalDamage[6] * 0.5, TotalDamage[7] * 0.5, TotalDamage[8] * 1,
                    TotalDamage[9] * 2, TotalDamage[10] * 2, TotalDamage[11] * 1, TotalDamage[12] * 1, TotalDamage[13] * 0.5,
                    TotalDamage[14] * 1, TotalDamage[15] * 1, TotalDamage[16] * 2, TotalDamage[17] * 2};
        }
        else if(TipoSecundarioInfo.getText().equals(tipos[16]))    //STEEL
        {
            colorDraw.setStroke(2, Color.rgb(120,120,135));
            colorDraw.setColor(Color.rgb(184, 184,208));
            TotalDamage = new double[]{TotalDamage[0] * 0.5, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 1,
                    TotalDamage[4] * 0.5, TotalDamage[5] * 2, TotalDamage[6] * 1, TotalDamage[7] * 0.5, TotalDamage[8] * 1,
                    TotalDamage[9] * 0.5, TotalDamage[10] * 2, TotalDamage[11] * 1, TotalDamage[12] * 0.5, TotalDamage[13] * 0,
                    TotalDamage[14] * 0.5, TotalDamage[15] * 0.5, TotalDamage[16] * 0.5, TotalDamage[17] * 1};
        }
        else if(TipoSecundarioInfo.getText().equals(tipos[17]))    //WATER
        {
            colorDraw.setStroke(2, Color.rgb(73,57,99));
            colorDraw.setColor(Color.rgb(104, 144,240));
            TotalDamage = new double[]{TotalDamage[0] * 1, TotalDamage[1] * 1, TotalDamage[2] * 1, TotalDamage[3] * 2,
                    TotalDamage[4] * 1, TotalDamage[5] * 1, TotalDamage[6] * 0.5, TotalDamage[7] *  1, TotalDamage[8] * 1,
                    TotalDamage[9] * 2, TotalDamage[10] * 1, TotalDamage[11] * 0.5, TotalDamage[12] * 1, TotalDamage[13] * 1,
                    TotalDamage[14] * 1, TotalDamage[15] * 1, TotalDamage[16] * 0.5, TotalDamage[17] * 0.5};
        }
        else if(TipoSecundarioInfo.getText().equals(tipos[18]))
        {
            TipoSecundarioInfo.setVisibility(View.INVISIBLE);
            TipoSecundarioInfo.getLayoutParams().width = 0;
            TipoSecundarioInfo.getLayoutParams().height = 0;
        }
    }

    public void Ocultar()
    {
        if(Habilidad2Info.getText().equals(" "))
        {
            Habilidad2Info.setVisibility(View.INVISIBLE);
            Habilidad2Info.getLayoutParams().width = 0;
            Habilidad2Info.getLayoutParams().height = 0;
        }

        if(HabilidadOcultaInfo.getText().equals(" "))
        {
            HabilidadOcultaInfo.setVisibility(View.INVISIBLE);
            HabilidadOcultaInfo.getLayoutParams().width = 0;
            HabilidadOcultaInfo.getLayoutParams().height = 0;

            HabilidadOcultaMarcadorInfo.setVisibility(View.INVISIBLE);
            HabilidadOcultaMarcadorInfo.getLayoutParams().width = 0;
            HabilidadOcultaMarcadorInfo.getLayoutParams().height = 0;
        }

        if (Huevo2Info.getText().equals(" "))
        {
            Huevo2Info.setVisibility(View.INVISIBLE);
            Huevo2Info.getLayoutParams().width = 0;
            Huevo2Info.getLayoutParams().height = 0;
        }

        if(Esfuerzo2Info.getText().equals(" "))
        {
            Esfuerzo2Info.setVisibility(View.INVISIBLE);
            Esfuerzo2Info.getLayoutParams().width = 0;
            Esfuerzo2Info.getLayoutParams().height = 0;
        }

        if(Esfuerzo3Info.getText().equals(" "))
        {
            Esfuerzo3Info.setVisibility(View.INVISIBLE);
            Esfuerzo3Info.getLayoutParams().width = 0;
            Esfuerzo3Info.getLayoutParams().height = 0;
        }
    }

    public void PuntajeExperiencia()
    {
        if(PuntosExpInfo.getText().equals("800,000 Points"))
        {
            RapidezExpInfo.setText("Fast");
        }
        else if(PuntosExpInfo.getText().equals("1,000,000 Points"))
        {
            RapidezExpInfo.setText("Medium Fast");
        }
        else if(PuntosExpInfo.getText().equals("1,059,860 Points"))
        {
            RapidezExpInfo.setText("Medium Slow");
        }
        else if(PuntosExpInfo.getText().equals("1,250,000 Points"))
        {
            RapidezExpInfo.setText("Slow");
        }
    }

    public void Tabla()
    {
        BugInfo.setEnabled(false);
        BugInfo.setTextColor(Color.rgb(255,255,255));
        colorButton = BugInfo.getBackground();
        colorButton = DrawableCompat.wrap(colorButton);
        DrawableCompat.setTint(colorButton, Color.rgb(168, 184,32));


        DarkInfo.setEnabled(false);
        DarkInfo.setTextColor(Color.rgb(255,255,255));
        colorButton = DarkInfo.getBackground();
        colorButton = DrawableCompat.wrap(colorButton);
        DrawableCompat.setTint(colorButton, Color.rgb(112, 88,72));

        DragonInfo.setEnabled(false);
        DragonInfo.setTextColor(Color.rgb(255,255,255));
        colorButton = DragonInfo.getBackground();
        colorButton = DrawableCompat.wrap(colorButton);
        DrawableCompat.setTint(colorButton, Color.rgb(112, 56,248));

        ElectricInfo.setEnabled(false);
        ElectricInfo.setTextColor(Color.rgb(255,255,255));
        colorButton = ElectricInfo.getBackground();
        colorButton = DrawableCompat.wrap(colorButton);
        DrawableCompat.setTint(colorButton, Color.rgb(248, 208,48));

        FairyInfo.setEnabled(false);
        FairyInfo.setTextColor(Color.rgb(255,255,255));
        colorButton = FairyInfo.getBackground();
        colorButton = DrawableCompat.wrap(colorButton);
        DrawableCompat.setTint(colorButton, Color.rgb(238, 153,172));

        FightingInfo.setEnabled(false);
        FightingInfo.setTextColor(Color.rgb(255,255,255));
        colorButton = FightingInfo.getBackground();
        colorButton = DrawableCompat.wrap(colorButton);
        DrawableCompat.setTint(colorButton, Color.rgb(192, 48,40));

        FireInfo.setEnabled(false);
        FireInfo.setTextColor(Color.rgb(255,255,255));
        colorButton = FireInfo.getBackground();
        colorButton = DrawableCompat.wrap(colorButton);
        DrawableCompat.setTint(colorButton, Color.rgb(240, 128,48));

        FlyingInfo.setEnabled(false);
        FlyingInfo.setTextColor(Color.rgb(255,255,255));
        colorButton = FlyingInfo.getBackground();
        colorButton = DrawableCompat.wrap(colorButton);
        DrawableCompat.setTint(colorButton, Color.rgb(168, 144,240));

        GhostInfo.setEnabled(false);
        GhostInfo.setTextColor(Color.rgb(255,255,255));
        colorButton = GhostInfo.getBackground();
        colorButton = DrawableCompat.wrap(colorButton);
        DrawableCompat.setTint(colorButton, Color.rgb(112, 88,152));

        GrassInfo.setEnabled(false);
        GrassInfo.setTextColor(Color.rgb(255,255,255));
        colorButton = GrassInfo.getBackground();
        colorButton = DrawableCompat.wrap(colorButton);
        DrawableCompat.setTint(colorButton, Color.rgb(120, 200,80));

        GroundInfo.setEnabled(false);
        GroundInfo.setTextColor(Color.rgb(255,255,255));
        colorButton = GroundInfo.getBackground();
        colorButton = DrawableCompat.wrap(colorButton);
        DrawableCompat.setTint(colorButton, Color.rgb(224, 192,104));

        IceInfo.setEnabled(false);
        IceInfo.setTextColor(Color.rgb(255,255,255));
        colorButton = IceInfo.getBackground();
        colorButton = DrawableCompat.wrap(colorButton);
        DrawableCompat.setTint(colorButton, Color.rgb(152, 216,216));

        NormalInfo.setEnabled(false);
        NormalInfo.setTextColor(Color.rgb(255,255,255));
        colorButton = NormalInfo.getBackground();
        colorButton = DrawableCompat.wrap(colorButton);
        DrawableCompat.setTint(colorButton, Color.rgb(168, 168,120));

        PoisonInfo.setEnabled(false);
        PoisonInfo.setTextColor(Color.rgb(255,255,255));
        colorButton = PoisonInfo.getBackground();
        colorButton = DrawableCompat.wrap(colorButton);
        DrawableCompat.setTint(colorButton, Color.rgb(160, 64,160));

        PsychicInfo.setEnabled(false);
        PsychicInfo.setTextColor(Color.rgb(255,255,255));
        colorButton = PsychicInfo.getBackground();
        colorButton = DrawableCompat.wrap(colorButton);
        DrawableCompat.setTint(colorButton, Color.rgb(248, 88,136));

        RockInfo.setEnabled(false);
        RockInfo.setTextColor(Color.rgb(255,255,255));
        colorButton = RockInfo.getBackground();
        colorButton = DrawableCompat.wrap(colorButton);
        DrawableCompat.setTint(colorButton, Color.rgb(184, 160,56));

        SteelInfo.setEnabled(false);
        SteelInfo.setTextColor(Color.rgb(255,255,255));
        colorButton = SteelInfo.getBackground();
        colorButton = DrawableCompat.wrap(colorButton);
        DrawableCompat.setTint(colorButton, Color.rgb(184, 184,208));

        WaterInfo.setEnabled(false);
        WaterInfo.setTextColor(Color.rgb(255,255,255));
        colorButton = WaterInfo.getBackground();
        colorButton = DrawableCompat.wrap(colorButton);
        DrawableCompat.setTint(colorButton, Color.rgb(104, 144,240));

        BugDamageInfo.setText("x" + Double.toString(TotalDamage[0]));
        DarkDamageInfo.setText("x" + Double.toString(TotalDamage[1]));
        DragonDamageInfo.setText("x" + Double.toString(TotalDamage[2]));
        ElectricDamageInfo.setText("x" + Double.toString(TotalDamage[3]));
        FairyDamageInfo.setText("x" + Double.toString(TotalDamage[4]));
        FightingDamageInfo.setText("x" + Double.toString(TotalDamage[5]));
        FireDamageInfo.setText("x" + Double.toString(TotalDamage[6]));
        FlyingDamageInfo.setText("x" + Double.toString(TotalDamage[7]));
        GhostDamageInfo.setText("x" + Double.toString(TotalDamage[8]));
        GrassDamageInfo.setText("x" + Double.toString(TotalDamage[9]));
        GroundDamageInfo.setText("x" + Double.toString(TotalDamage[10]));
        IceDamageInfo.setText("x" + Double.toString(TotalDamage[11]));
        NormalDamageInfo.setText("x" + Double.toString(TotalDamage[12]));
        PoisonDamageInfo.setText("x" + Double.toString(TotalDamage[13]));
        PsychicDamageInfo.setText("x" + Double.toString(TotalDamage[14]));
        RockDamageInfo.setText("x" + Double.toString(TotalDamage[15]));
        SteelDamageInfo.setText("x" + Double.toString(TotalDamage[16]));
        WaterDamageInfo.setText("x" + Double.toString(TotalDamage[17]));
    }
}

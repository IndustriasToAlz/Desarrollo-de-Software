package com.example.user.miprimeraapplicacion;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SensorEventListener{

    TextView campo_texto;
    EditText et;
    ImageView imagen;
    TextView ver_texto;
    EditText ingresarTexto;
    Button boton;
    Button botonN;
    Button boton3;
    Button boton4;
    EditText intentText;
    LinearLayout ln;
    SensorManager sm;
    Sensor sensor;
    TextView tv;
    ListView listView;
    ListView lv;

    String[] valores = {"Colombia","Chile","USA","India","Mexico","China","Uruguay","Argentina","Panama","Peru","Brazil"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campo_texto = (TextView) findViewById(R.id.texto);
        campo_texto.setText("CarlosToAlz");
        /////////////////////////////////////////
        et = (EditText) findViewById(R.id.edittext);
        et.setText("Cambiamos Texto");
        /////////////////////////////////////////
        imagen = (ImageView) findViewById(R.id.imagen);
        /////////////////////////////////////////
        ver_texto = (TextView) findViewById(R.id.texto2);
        ingresarTexto = (EditText) findViewById(R.id.editar);
        boton = (Button) findViewById(R.id.boton);
        botonN = (Button) findViewById(R.id.botonN);

        boton.setOnClickListener(this);
        botonN.setOnClickListener(this);
        /////////////////////////////////////////
        boton3 = (Button) findViewById(R.id.boton3);
        boton3.setOnClickListener(this);
        /////////////////////////////////////////
        boton4 = (Button) findViewById(R.id.boton4);
        boton4.setOnClickListener(this);
        intentText = (EditText) findViewById(R.id.intent);
        /////////////////////////////////////////
        ln = (LinearLayout) findViewById(R.id.linear);
        tv = (TextView) findViewById(R.id.textoSensor);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        /////////////////////////////////////////
        listView = (ListView) findViewById(R.id.Lista);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,valores);
        listView.setAdapter(adapter);
        setListViewHeightBasedOnChildren(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Posicion " + position,Toast.LENGTH_SHORT).show();
            }
        });
        /////////////////////////////////////////
        bandas bandas_data[] = new bandas[]{
                new bandas(R.mipmap.ic_launcher,"Coldplay"),
                new bandas(R.mipmap.ic_launcher,"Foo Fighter"),
                new bandas(R.mipmap.ic_launcher,"Kuday"),
                new bandas(R.mipmap.ic_launcher,"Wisin & Yandel"),
                new bandas(R.mipmap.ic_launcher,"Led Zeppelyn"),
                new bandas(R.mipmap.ic_launcher,"Asian Kun Fu Generation"),
                new bandas(R.mipmap.ic_launcher,"Kids Alive"),
                new bandas(R.mipmap.ic_launcher,"Ekimosis"),
                new bandas(R.mipmap.ic_launcher,"Zion & Lennox"),
                new bandas(R.mipmap.ic_launcher,"Ozuna"),
                new bandas(R.mipmap.ic_launcher,"Natty Natasha"),
                new bandas(R.mipmap.ic_launcher,"Karol G"),
                new bandas(R.mipmap.ic_launcher,"Europe"),
                new bandas(R.mipmap.ic_launcher,"Village People"),
                new bandas(R.mipmap.ic_launcher,"Air Supply")

        };

        bandasAdapter adapter1 = new bandasAdapter(this,R.layout.listview_item_row,bandas_data);
        lv = (ListView) findViewById(R.id.lv);
        View header = (View) getLayoutInflater().inflate(R.layout.list_header_row,null);
        lv.addHeaderView(header);
        lv.setAdapter(adapter1);
        setListViewHeightBasedOnChildren2(lv);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView v = (TextView) view.findViewById(R.id.tv);
                Toast.makeText(getApplicationContext(),v.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.boton:
                String dato = ingresarTexto.getText().toString();
                ver_texto.setText(dato);
                break;

            case  R.id.botonN:
                ver_texto.setText("Marica");
                break;

            case R.id.boton3:
                Toast.makeText(getApplicationContext(),"Esto es un toast",Toast.LENGTH_SHORT).show();
                break;

            case R.id.boton4:
                String dato2 = intentText.getText().toString();
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("DATO",dato2);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        String texto = String.valueOf(event.values[0]);
        tv.setText(texto);

        float valor = Float.parseFloat(texto);

        if (valor == 0){
            ln.setBackgroundColor(Color.BLUE);
        }else{
            ln.setBackgroundColor(Color.YELLOW);
        }

        tv.setText(texto);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public static void setListViewHeightBasedOnChildren(ListView listView) { //ListView Dentro de ScrollView no personalizado
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null){
            return;
        }

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth,  ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    public static void setListViewHeightBasedOnChildren2(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}

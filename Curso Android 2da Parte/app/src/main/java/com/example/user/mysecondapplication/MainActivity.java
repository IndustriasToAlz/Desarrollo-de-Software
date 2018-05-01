package com.example.user.mysecondapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView texto;
    CheckBox c1,c2;
    RadioButton d1,d2;
    Button boton,botonCardView;
    RadioGroup radioGroup;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    List<Persona> personaList = new ArrayList<>();
    PersonaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();

        WebView webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl("http://www.google.com.co/");
        webView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverriceUrlLoading(WebView view, String url){
                return false;
            }
        });

        texto = (TextView) findViewById(R.id.texto);
        c1 = (CheckBox) findViewById(R.id.c1);
        c2 = (CheckBox) findViewById(R.id.c2);
        d1 = (RadioButton) findViewById(R.id.d1);
        d2 = (RadioButton) findViewById(R.id.d2);
        boton = (Button) findViewById(R.id.boton);
        botonCardView = (Button) findViewById(R.id.botonCardView);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c1.isChecked()){
                    texto.setText("Hola Señor");
                }

                if (c2.isChecked()){
                    texto.setText("Hola Señora");
                }

                if (radioGroup.getCheckedRadioButtonId() == R.id.d1){
                    Toast.makeText(getApplicationContext(),"Es Masculino",Toast.LENGTH_SHORT).show();
                }

                if (radioGroup.getCheckedRadioButtonId() == R.id.d2){
                    Toast.makeText(getApplicationContext(),"Es Femenino",Toast.LENGTH_SHORT).show();
                }
            }
        });

        botonCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,activity_Card_View.class);
                startActivity(intent);
            }
        });

        //////////////////////////////////////////////////////////
        recyclerView = (RecyclerView) findViewById(R.id.recycledview);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new PersonaAdapter(this,personaList);
        recyclerView.setAdapter(adapter);
    }

    public void loadData(){
        personaList.add(new Persona("Carlos Andres","Tobon Alzate"));
        personaList.add(new Persona("Ana Maria","Tobon Alzate"));
        personaList.add(new Persona("Aledis","Muñoz Caselles"));
        personaList.add(new Persona("Piedad Cecilia","Alzate Mesa"));
        personaList.add(new Persona("Nicolas","Tobon Muñoz"));
        personaList.add(new Persona("Mariangel","Tobon Muñoz"));
        personaList.add(new Persona("Juan David","Alvarez Maluenga"));
        personaList.add(new Persona("Jose Edgar","Arboleda Londoño"));
        personaList.add(new Persona("Carlos Andres","Tobon Alzate"));
        personaList.add(new Persona("Ana Maria","Tobon Alzate"));
        personaList.add(new Persona("Aledis","Muñoz Caselles"));
        personaList.add(new Persona("Piedad Cecilia","Alzate Mesa"));
        personaList.add(new Persona("Nicolas","Tobon Muñoz"));
        personaList.add(new Persona("Mariangel","Tobon Muñoz"));
        personaList.add(new Persona("Juan David","Alvarez Maluenga"));
        personaList.add(new Persona("Jose Edgar","Arboleda Londoño"));
        personaList.add(new Persona("Carlos Andres","Tobon Alzate"));
        personaList.add(new Persona("Ana Maria","Tobon Alzate"));
        personaList.add(new Persona("Aledis","Muñoz Caselles"));
        personaList.add(new Persona("Piedad Cecilia","Alzate Mesa"));
        personaList.add(new Persona("Nicolas","Tobon Muñoz"));
        personaList.add(new Persona("Mariangel","Tobon Muñoz"));
        personaList.add(new Persona("Juan David","Alvarez Maluenga"));
        personaList.add(new Persona("Jose Edgar","Arboleda Londoño"));
    }
}

package com.example.user.clasecesar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class segunda extends AppCompatActivity {

    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        texto = (TextView) findViewById(R.id.texto);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null || extras.get("DATA").toString().trim() != ""){
            texto.setText(extras.get("DATA").toString());
        }else{
            texto.setText("No llego Nada");
        }
    }
}

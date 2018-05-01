package com.example.user.miprimeraapplicacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seconda_ctivity);

        label = (TextView) findViewById(R.id.label);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null){
            label.setText(extras.get("DATO").toString());
        } else {
            label.setText("No llego Nada");
        }
    }
}

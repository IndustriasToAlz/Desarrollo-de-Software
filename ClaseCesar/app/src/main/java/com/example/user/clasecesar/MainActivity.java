package com.example.user.clasecesar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView texto,lblGeneros;
    EditText editar,enviar;
    Button boton,boton2,boton3,boton4;
    CheckBox c1,c2;
    RadioGroup radioGroup;
    RadioButton d1,d2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (TextView) findViewById(R.id.texto);
        lblGeneros = (TextView) findViewById(R.id.lblGeneros);
        editar = (EditText) findViewById(R.id.editar);
        enviar = (EditText) findViewById(R.id.enviar);
        boton = (Button) findViewById(R.id.boton);
        boton2 = (Button) findViewById(R.id.boton2);
        boton3 = (Button) findViewById(R.id.boton3);
        boton4 = (Button) findViewById(R.id.boton4);
        c1 = (CheckBox) findViewById(R.id.c1);
        c2 = (CheckBox) findViewById(R.id.c2);
        radioGroup = (RadioGroup) findViewById(R.id.radio);
        d1 = (RadioButton) findViewById(R.id.d1);
        d2 = (RadioButton) findViewById(R.id.d2);

        boton.setOnClickListener(this);
        boton2.setOnClickListener(this);
        boton3.setOnClickListener(this);
        boton4.setOnClickListener(this);

        texto.setText("Hola Carlos Andres Tobon Alzate");

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.boton:
                texto.setText(editar.getText().toString());
                Toast.makeText(getApplicationContext(),editar.getText().toString(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.boton2:
                String resultado = "";

                if (c1.isChecked()){
                    resultado = resultado + " Es hombre";
                }

                if (c2.isChecked()){
                    resultado = resultado + " Es Mujer";
                }

                lblGeneros.setText(resultado);

                if (radioGroup.getCheckedRadioButtonId() == R.id.d1){
                    Toast.makeText(getApplicationContext(),"Tiene pene",Toast.LENGTH_SHORT).show();
                }

                if (radioGroup.getCheckedRadioButtonId() == R.id.d2){
                    Toast.makeText(getApplicationContext(),"Tiene Vagina",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.boton3:
                String dato = enviar.getText().toString();
                Intent intent = new Intent(MainActivity.this,segunda.class);
                intent.putExtra("DATA",dato);
                startActivity(intent);
                break;
            case R.id.boton4:
                Intent intent1 = new Intent(MainActivity.this,WebViewActivity.class);
                startActivity(intent1);
                break;
        }


    }
}

package com.example.user.traerimagenes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import org.fosforito.exception.RemoteException;
import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    ImageView imagen;
    TextView cat_dsproducto,cat_dscategoria,cat_dsmarca,cat_vrprecio;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ProductoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycledview);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        try {
            adapter = new ProductoAdapter(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        recyclerView.setAdapter(adapter);
    }
}


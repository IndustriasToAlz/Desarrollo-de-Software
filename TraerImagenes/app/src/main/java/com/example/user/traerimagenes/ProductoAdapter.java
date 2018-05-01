package com.example.user.traerimagenes;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import org.fosforito.exception.RemoteException;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.List;

/**
 * Created by user on 22/02/2018.
 */

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder>{
    Context context;
    CargarInformacion cargar = new CargarInformacion();
    List<ProductoList> productoLists;
    JSONArray jsonArray = new JSONArray();
    DowloadImages descargarImagen;
    ImageView image;

    public ProductoAdapter(Context context) throws RemoteException, JSONException {
        this.context = context;
        this.productoLists = cargar.getDatosProducto();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProductoAdapter.ViewHolder holder, int position) {
        String str = new String(productoLists.get(position).getSrc());
        holder.cat_dsproducto.setText(productoLists.get(position).getCat_dsproduct());
        holder.cat_dscategoria.setText(productoLists.get(position).getCat_dscategoria());
        holder.cat_dsmarca.setText(productoLists.get(position).getCat_dsmarca());
        holder.cat_vrprecio.setText(productoLists.get(position).getCat_vrprecio());
        descargarImagen = new DowloadImages(context,holder);
        descargarImagen.execute(str.replace("http://","https://"));

    }

    @Override
    public int getItemCount(){
        return productoLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView cat_dsproducto,cat_dscategoria,cat_dsmarca,cat_vrprecio;
        ImageView image;

        public ViewHolder(View item){
            super(item);
            cardView = (CardView) item.findViewById(R.id.cardView);
            cat_dsproducto = (TextView)  item.findViewById(R.id.cat_dsproducto);
            cat_dscategoria = (TextView)  item.findViewById(R.id.cat_dscategoria);
            cat_dsmarca = (TextView)  item.findViewById(R.id.cat_dsmarca);
            cat_vrprecio = (TextView)  item.findViewById(R.id.cat_vrprecio);
            image =  (ImageView) item.findViewById(R.id.imagen);
        }
    }
}

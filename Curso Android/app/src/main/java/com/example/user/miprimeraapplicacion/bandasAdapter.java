package com.example.user.miprimeraapplicacion;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 19/02/2018.
 */

public class bandasAdapter extends ArrayAdapter<bandas> {
    Context context;
    int layoutResorceid;
    bandas data[] = null;


    public bandasAdapter(Context context, int layoutResourceId, bandas[] data){
        super(context,layoutResourceId,data);

        this.context = context;
        this.layoutResorceid = layoutResourceId;
        this.data = data;
    }

    public View getView(int position, View contentView, ViewGroup parent){
        View row = contentView;
        bandasHolder holder = null;

        if(row == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResorceid,parent,false);

            holder = new bandasHolder();
            holder.imagen = (ImageView) row.findViewById(R.id.imagen2);
            holder.texto = (TextView) row.findViewById(R.id.tv);
            row.setTag(holder);
        }else{
            holder = (bandasHolder) row.getTag();
        }

        bandas bandas = data[position];
        holder.texto.setText(bandas.titulo);
        holder.imagen.setImageResource(bandas.icon);

        return row;
    }

    static class bandasHolder{
        ImageView imagen;
        TextView texto;
    }

}

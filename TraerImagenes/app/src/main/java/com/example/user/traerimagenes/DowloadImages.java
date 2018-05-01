package com.example.user.traerimagenes;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by user on 26/02/2018.
 */

public class DowloadImages extends AsyncTask<String,Void,Bitmap> {


    Context context;
    ProgressDialog pDialog;
    ProductoAdapter.ViewHolder viewHolder;


    public  DowloadImages(Context context, ProductoAdapter.ViewHolder viewHolder){
        this.context = context;
        this.viewHolder = viewHolder;
    }

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();

        pDialog = new ProgressDialog(this.context);
        pDialog.setMessage("Cargando Imagen");
        pDialog.setCancelable(true);
        pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pDialog.show();

    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Log.i("doInBackground" , "Entra en doInBackground");
        String url = params[0];
        Bitmap imagen = descargarImagen(url);
        return imagen;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
        pDialog.dismiss();
        viewHolder.image.setImageBitmap(result);
    }

    private Bitmap descargarImagen (String imageHttpAddres){
        String[] parts = imageHttpAddres.split("/");

        URL imageUrl = null;
        Bitmap imagen = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        ContextWrapper cw = new ContextWrapper(context);

        try {
            File dirImages = cw.getDir("Imagenes",Context.MODE_PRIVATE);
            File myPath = new File(dirImages,parts[6]);

            imageUrl = new URL(imageHttpAddres);
            HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
            //conn.setRequestProperty("content-type", "image/jpeg");
            conn.connect();
            inputStream = conn.getInputStream();
            outputStream = new FileOutputStream(myPath);
            imagen = BitmapFactory.decodeStream(inputStream);

            byte[] buffer = new byte[2048];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                // Writing data
                outputStream.write(buffer, 0, length);
            }

            guardarImagen(parts[6],imagen);

        }catch (IOException ex){
            ex.printStackTrace();
        }

        return imagen;
    }

    public String guardarImagen(String nombre, Bitmap imagen){
        ContextWrapper cw = new ContextWrapper(context);
        File dirImages = cw.getDir("Imagenes",Context.MODE_PRIVATE);
        File myPath = new File(dirImages,nombre);

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(myPath);
            imagen.compress(Bitmap.CompressFormat.JPEG,10,fos);
            fos.flush();
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }

        return  myPath.getAbsolutePath();
    }
}

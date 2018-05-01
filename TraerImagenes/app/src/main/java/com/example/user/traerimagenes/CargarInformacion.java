package com.example.user.traerimagenes;

import org.fosforito.exception.RemoteException;
import org.fosforito.remote.RemoteServices;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 22/02/2018.
 */

public class CargarInformacion {

    public List<ProductoList> getDatosProducto() throws RemoteException,JSONException{
        JSONObject jsonRespuesta = new JSONObject();
        JSONArray datos = new JSONArray();
        List<ProductoList> productoLists = new ArrayList<>();

        try {
            Producto producto = new Producto();
            producto.setRemote("org.daniel.productos.dto.Productos");
            producto.put("cat_cdcomponente", "03");
            producto.put("cat_cdrecursos", "01");
            producto.put("nmregistros", "4");
            producto.put("cat_nmcategoria", "0");
            producto.put("cat_nmsubcategoria", "0");

            RemoteServices remoteServices = new RemoteServices("http://54.235.64.70:8080/DanielServices", "org.daniel.services.productos.ServicesProductos", "listaGodola1XSubcategoria");
            StringBuffer data = remoteServices.invoke(producto);
            jsonRespuesta = new JSONObject(data.toString());
            datos.put(jsonRespuesta.getJSONObject("msg").getJSONArray("Data"));

            for(int i=0;i < datos.getJSONArray(0).length(); i++){

                productoLists.add(new ProductoList(
                        datos.getJSONArray(0).getJSONObject(i).get("cat_vrprecioant_n" ).toString(),
                        datos.getJSONArray(0).getJSONObject(i).get("src").toString(),
                        datos.getJSONArray(0).getJSONObject(i).get("cat_nmcategoria").toString(),
                        datos.getJSONArray(0).getJSONObject(i).get("cat_vrprecio").toString(),
                        datos.getJSONArray(0).getJSONObject(i).get("nmsubcategoria").toString(),
                        datos.getJSONArray(0).getJSONObject(i).get("cat_dscategoria").toString(),
                        datos.getJSONArray(0).getJSONObject(i).get("cat_nmproducto").toString(),
                        datos.getJSONArray(0).getJSONObject(i).get("cat_dsmarca").toString(),
                        datos.getJSONArray(0).getJSONObject(i).get("cat_dsmsgpubli").toString(),
                        datos.getJSONArray(0).getJSONObject(i).get("cat_vrprecioant").toString(),
                        datos.getJSONArray(0).getJSONObject(i).get("cat_dsproducto").toString(),
                        datos.getJSONArray(0).getJSONObject(i).get("cat_vrprecio_n").toString(),
                        datos.getJSONArray(0).getJSONObject(i).get("cat_dssubcategoria").toString(),
                        datos.getJSONArray(0).getJSONObject(i).get("cat_cdreferencia").toString(),
                        datos.getJSONArray(0).getJSONObject(i).get("cat_dsobsrvacion").toString()
                ));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }catch (org.fosforito.exception.RemoteException e){
            e.printStackTrace();
        }
        return productoLists;
    }
}

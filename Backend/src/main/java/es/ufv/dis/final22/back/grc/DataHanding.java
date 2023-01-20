package es.ufv.dis.final22.back.grc;

import java.text.ParseException;
import java.util.ArrayList;

public class DataHanding {
    public ArrayList<Producto> AnadirObjeto1(Producto objeto1, String ruta){
        //En esta funcion se añaden los nuevos elementos enviados desde el front a un ArrayList para posteriormente actualizar la BBDD
        LeerJson reader = new LeerJson();
        ArrayList<Producto> listaAux = reader.LeerFicheroJson1(ruta);
        listaAux.add(objeto1);
        return listaAux;
    }



}

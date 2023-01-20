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

    public boolean CompararObjetos(Producto Obj1, Producto Obj2){
        //En esta funcion se comparan dos objetos entre sí para saber si son iguales o no, se comparan todos sus atributos
        if(Obj1.getNombre().equals(Obj2.getNombre())){
            if(Obj1.getCategoria().equals((Obj2.getCategoria()))){
                if(Obj1.getPrecio() == Obj2.getPrecio()){
                    if(Obj1.getEAN13().equals((Obj2.getEAN13()))){
                        return true;
                    }
                }
            }
        }

        return false;
    }



}

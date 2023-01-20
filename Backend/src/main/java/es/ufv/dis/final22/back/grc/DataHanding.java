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

    public boolean CompararObjetos(ZonaBasicaSaludMayores60 Obj1, ZonaBasicaSaludMayores60 Obj2){
        //En esta funcion se comparan dos objetos entre sí para saber si son iguales o no, se comparan todos sus atributos
        if(Obj1.getCodigo_geometria().equals(Obj2.getCodigo_geometria())){
            if(Obj1.getZona_basica_salud().equals((Obj2.getZona_basica_salud()))){
                if(Obj1.getCasos_confirmados_P60mas_ultimos_14dias() == Obj2.getCasos_confirmados_P60mas_ultimos_14dias()){
                    if(Obj1.getTasa_incidencia_acumulada_P60mas_ultimos_14dias() == Obj2.getTasa_incidencia_acumulada_P60mas_ultimos_14dias()){
                        if(Obj1.getFecha_informe().equals(Obj2.getFecha_informe())){
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }



}

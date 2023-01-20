package es.ufv.dis.final22.back.grc;

import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;

@RestController
public class Controller {

    @GetMapping("/Productos")
    public ArrayList<Producto> listaObjeto1(){
        LeerJson reader = new LeerJson();
        //Leemos el reason e introducimos los elementos en un arraylist
        ArrayList<Producto> lista = reader.LeerFicheroJson1("template.json");
        //Mostramos los elementos leidos
        return lista;
    }
    @PostMapping("/Productos")
    public ArrayList<Producto> create(@RequestBody Producto objeto1){
        DataHanding dataHanding = new DataHanding();
        ArrayList<Producto> lista;
        lista = dataHanding.AnadirObjeto1(objeto1,"template.json");
        EscribirJson escribirJSON = new EscribirJson();
        escribirJSON.escribirObjeto1(lista);
        return lista;
    }


}

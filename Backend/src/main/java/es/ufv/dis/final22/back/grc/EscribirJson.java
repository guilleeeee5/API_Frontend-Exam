package es.ufv.dis.final22.back.grc;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class EscribirJson {
    public void escribirObjeto1(ArrayList<Producto> lista){
        try {
            // Creamos una nueva clase Json
            Gson gson = new Gson();

            //Creamos la clase que permite escribir en el fichero Json
            Writer writer = new FileWriter("template.json");
            try {
                gson.toJson(lista, writer);
                writer.close();
            } catch (JsonIOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

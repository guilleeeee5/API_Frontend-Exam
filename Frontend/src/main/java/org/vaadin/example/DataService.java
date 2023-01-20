package org.vaadin.example;

import com.google.gson.Gson;
import com.googlecode.gentyref.TypeToken;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DataService {
    private static final String urlPrefix = "http://localhost:8082/Productos";

    public static ArrayList<Producto> getProductos(ArrayList<Producto> listaProductos) throws URISyntaxException {

        HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI(urlPrefix)).GET().build();
        Gson gson = new Gson();
        String resultado = null;
        HttpResponse<String> respuesta = null;

        try {
            respuesta = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());
            resultado = respuesta.body();
            listaProductos = gson.fromJson(resultado, new TypeToken<ArrayList<Producto>>(){}.getType());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return listaProductos;
    }

    public static ArrayList<Producto> aniadirDatosLista(Producto productoNuevo, ArrayList<Producto> listaProductos){
        Gson g = new Gson();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String datospasar = productoNuevo.mostrarJson();
        StringEntity entidad = null;
        try {
            entidad = new StringEntity(datospasar);
            HttpPost requestpuesta = new HttpPost(urlPrefix);
            requestpuesta.setHeader("Content-Type", "application/json");
            requestpuesta.setHeader("Accept", "application/json");
            requestpuesta.setEntity(entidad);
            CloseableHttpResponse response = null;
            response = httpClient.execute(requestpuesta);
            String respuestaActual = new BasicResponseHandler().handleResponse(response);
            listaProductos = g.fromJson(respuestaActual, new TypeToken<ArrayList<Producto>>(){}.getType());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (HttpResponseException e) {
            throw new RuntimeException(e);
        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return listaProductos;
    }



}

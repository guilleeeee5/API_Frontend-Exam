package org.vaadin.example;

public class Producto {
    private String nombre;
    private String categoria;
    private float precio;
    private String ean13;

    public Producto(String nombre, String categoria, float precio, String ean13) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.ean13 = ean13;
    }

    public Producto(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getean13() {
        return ean13;
    }

    public void setean13(String EAN13) {
        this.ean13 = EAN13;
    }

    public String mostrarJson() {
        return "{\n" +
                "\"nombre\": " + "\"" + nombre + "\"," + "\n" +
                "\"categoria\": " + "\"" + categoria  + "\"," + "\n" +
                "\"precio\": " + precio  +  ",\n" +
                "\"ean13\": " + ean13 + "\n" +
                "}";
    }
}

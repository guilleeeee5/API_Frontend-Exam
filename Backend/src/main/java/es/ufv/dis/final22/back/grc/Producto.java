package es.ufv.dis.final22.back.grc;

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

    public String getEAN13() {
        return ean13;
    }

    public void setEAN13(String ean13) {
        this.ean13 = ean13;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                ", ean13='" + ean13 + '\'' +
                '}';
    }
}

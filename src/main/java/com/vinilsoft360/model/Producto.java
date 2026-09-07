package com.vinilsoft360.model;

/**
 * Clase que representa un producto de la empresa Vinilsoft360.
 * Contiene la información de los pisos vinílicos disponibles para la venta.
 *
 * @author Dayson Mazo Villa
 */
public class Producto {

    // Atributos de la clase (alineados con la tabla real 'producto')
    private int idProducto;
    private String nombre;
    private String categoria;
    private String descripcion;
    private double precio;
    private int stock;
    private String estado;

    public Producto() {
    }

    public Producto(int idProducto, String nombre, String categoria,
                     String descripcion, double precio, int stock, String estado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}